package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

public class ZipFile
{
  static final int BYTE_SHIFT = 8;
  private static final int CFD_LOCATOR_OFFSET = 16;
  private static final int CFH_LEN = 42;
  private static final long CFH_SIG = ZipLong.getValue(ZipOutputStream.CFH_SIG);
  private static final int HASH_SIZE = 509;
  private static final long LFH_OFFSET_FOR_FILENAME_LENGTH = 26L;
  private static final int MAX_EOCD_SIZE = 65557;
  private static final int MIN_EOCD_SIZE = 22;
  static final int NIBLET_MASK = 15;
  private static final int POS_0 = 0;
  private static final int POS_1 = 1;
  private static final int POS_2 = 2;
  private static final int POS_3 = 3;
  private static final int ZIP64_EOCDL_LENGTH = 20;
  private static final int ZIP64_EOCDL_LOCATOR_OFFSET = 8;
  private static final int ZIP64_EOCD_CFD_LOCATOR_OFFSET = 48;
  private final byte[] CFH_BUF = new byte[42];
  private final byte[] DWORD_BUF = new byte[8];
  private final Comparator<ZipEntry> OFFSET_COMPARATOR = new ZipFile.2(this);
  private final byte[] SHORT_BUF = new byte[2];
  private final byte[] WORD_BUF = new byte[4];
  private final RandomAccessFile archive;
  private final String archiveName;
  private boolean closed;
  private final String encoding;
  private final Map<ZipEntry, ZipFile.OffsetEntry> entries = new LinkedHashMap(509);
  private final Map<String, ZipEntry> nameMap = new HashMap(509);
  private final boolean useUnicodeExtraFields;
  private final ZipEncoding zipEncoding;
  
  public ZipFile(File paramFile)
  {
    this(paramFile, null);
  }
  
  public ZipFile(File paramFile, String paramString)
  {
    this(paramFile, paramString, true);
  }
  
  public ZipFile(File paramFile, String paramString, boolean paramBoolean)
  {
    this.archiveName = paramFile.getAbsolutePath();
    this.encoding = paramString;
    this.zipEncoding = ZipEncodingHelper.getZipEncoding(paramString);
    this.useUnicodeExtraFields = paramBoolean;
    this.archive = new RandomAccessFile(paramFile, "r");
    try
    {
      resolveLocalFileHeaderData(populateFromCentralDirectory());
      return;
    }
    finally {}
    try
    {
      this.closed = true;
      this.archive.close();
      label136:
      throw paramFile;
    }
    catch (IOException paramString)
    {
      break label136;
    }
  }
  
  public ZipFile(String paramString)
  {
    this(new File(paramString), null);
  }
  
  public ZipFile(String paramString1, String paramString2)
  {
    this(new File(paramString1), paramString2, true);
  }
  
  public static void closeQuietly(ZipFile paramZipFile)
  {
    if (paramZipFile != null) {}
    try
    {
      paramZipFile.close();
      return;
    }
    catch (IOException paramZipFile) {}
  }
  
  private Map<ZipEntry, ZipFile.NameAndComment> populateFromCentralDirectory()
  {
    HashMap localHashMap = new HashMap();
    positionAtCentralDirectory();
    this.archive.readFully(this.WORD_BUF);
    long l2 = ZipLong.getValue(this.WORD_BUF);
    long l1 = l2;
    if (l2 != CFH_SIG) {
      if (!startsWithLocalFileHeader()) {
        l1 = l2;
      } else {
        throw new IOException("central directory is empty, can't expand corrupt archive.");
      }
    }
    while (l1 == CFH_SIG)
    {
      readCentralDirectoryEntry(localHashMap);
      this.archive.readFully(this.WORD_BUF);
      l1 = ZipLong.getValue(this.WORD_BUF);
    }
    return localHashMap;
  }
  
  private void positionAtCentralDirectory()
  {
    positionAtEndOfCentralDirectoryRecord();
    long l = this.archive.getFilePointer();
    boolean bool = false;
    int i;
    if (l > 20L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      RandomAccessFile localRandomAccessFile = this.archive;
      localRandomAccessFile.seek(localRandomAccessFile.getFilePointer() - 20L);
      this.archive.readFully(this.WORD_BUF);
      bool = Arrays.equals(ZipOutputStream.ZIP64_EOCD_LOC_SIG, this.WORD_BUF);
    }
    if (!bool)
    {
      if (i != 0) {
        skipBytes(16);
      }
      positionAtCentralDirectory32();
      return;
    }
    positionAtCentralDirectory64();
  }
  
  private void positionAtCentralDirectory32()
  {
    skipBytes(16);
    this.archive.readFully(this.WORD_BUF);
    this.archive.seek(ZipLong.getValue(this.WORD_BUF));
  }
  
  private void positionAtCentralDirectory64()
  {
    skipBytes(4);
    this.archive.readFully(this.DWORD_BUF);
    this.archive.seek(ZipEightByteInteger.getLongValue(this.DWORD_BUF));
    this.archive.readFully(this.WORD_BUF);
    if (Arrays.equals(this.WORD_BUF, ZipOutputStream.ZIP64_EOCD_SIG))
    {
      skipBytes(44);
      this.archive.readFully(this.DWORD_BUF);
      this.archive.seek(ZipEightByteInteger.getLongValue(this.DWORD_BUF));
      return;
    }
    throw new ZipException("archive's ZIP64 end of central directory locator is corrupt.");
  }
  
  private void positionAtEndOfCentralDirectoryRecord()
  {
    if (tryToLocateSignature(22L, 65557L, ZipOutputStream.EOCD_SIG)) {
      return;
    }
    throw new ZipException("archive is not a ZIP archive");
  }
  
  private void readCentralDirectoryEntry(Map<ZipEntry, ZipFile.NameAndComment> paramMap)
  {
    this.archive.readFully(this.CFH_BUF);
    ZipEntry localZipEntry = new ZipEntry();
    localZipEntry.setPlatform(ZipShort.getValue(this.CFH_BUF, 0) >> 8 & 0xF);
    Object localObject1 = GeneralPurposeBit.parse(this.CFH_BUF, 4);
    boolean bool = ((GeneralPurposeBit)localObject1).usesUTF8ForNames();
    ZipEncoding localZipEncoding;
    if (bool) {
      localZipEncoding = ZipEncodingHelper.UTF8_ZIP_ENCODING;
    } else {
      localZipEncoding = this.zipEncoding;
    }
    localZipEntry.setGeneralPurposeBit((GeneralPurposeBit)localObject1);
    localZipEntry.setMethod(ZipShort.getValue(this.CFH_BUF, 6));
    localZipEntry.setTime(ZipUtil.dosToJavaTime(ZipLong.getValue(this.CFH_BUF, 8)));
    localZipEntry.setCrc(ZipLong.getValue(this.CFH_BUF, 12));
    localZipEntry.setCompressedSize(ZipLong.getValue(this.CFH_BUF, 16));
    localZipEntry.setSize(ZipLong.getValue(this.CFH_BUF, 20));
    int i = ZipShort.getValue(this.CFH_BUF, 24);
    int j = ZipShort.getValue(this.CFH_BUF, 26);
    int k = ZipShort.getValue(this.CFH_BUF, 28);
    int m = ZipShort.getValue(this.CFH_BUF, 30);
    localZipEntry.setInternalAttributes(ZipShort.getValue(this.CFH_BUF, 32));
    localZipEntry.setExternalAttributes(ZipLong.getValue(this.CFH_BUF, 34));
    localObject1 = new byte[i];
    this.archive.readFully((byte[])localObject1);
    localZipEntry.setName(localZipEncoding.decode((byte[])localObject1), (byte[])localObject1);
    Object localObject2 = new ZipFile.OffsetEntry(null);
    ZipFile.OffsetEntry.access$202((ZipFile.OffsetEntry)localObject2, ZipLong.getValue(this.CFH_BUF, 38));
    this.entries.put(localZipEntry, localObject2);
    this.nameMap.put(localZipEntry.getName(), localZipEntry);
    byte[] arrayOfByte = new byte[j];
    this.archive.readFully(arrayOfByte);
    localZipEntry.setCentralDirectoryExtra(arrayOfByte);
    setSizesAndOffsetFromZip64Extra(localZipEntry, (ZipFile.OffsetEntry)localObject2, m);
    localObject2 = new byte[k];
    this.archive.readFully((byte[])localObject2);
    localZipEntry.setComment(localZipEncoding.decode((byte[])localObject2));
    if ((!bool) && (this.useUnicodeExtraFields)) {
      paramMap.put(localZipEntry, new ZipFile.NameAndComment((byte[])localObject1, (byte[])localObject2, null));
    }
  }
  
  private void resolveLocalFileHeaderData(Map<ZipEntry, ZipFile.NameAndComment> paramMap)
  {
    Object localObject1 = new LinkedHashMap(this.entries);
    this.entries.clear();
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      ZipEntry localZipEntry = (ZipEntry)((Map.Entry)localObject2).getKey();
      localObject2 = (ZipFile.OffsetEntry)((Map.Entry)localObject2).getValue();
      long l = ZipFile.OffsetEntry.access$200((ZipFile.OffsetEntry)localObject2);
      Object localObject3 = this.archive;
      l += 26L;
      ((RandomAccessFile)localObject3).seek(l);
      this.archive.readFully(this.SHORT_BUF);
      int j = ZipShort.getValue(this.SHORT_BUF);
      this.archive.readFully(this.SHORT_BUF);
      int k = ZipShort.getValue(this.SHORT_BUF);
      int i = j;
      while (i > 0)
      {
        int m = this.archive.skipBytes(i);
        if (m > 0) {
          i -= m;
        } else {
          throw new IOException("failed to skip file name in local file header");
        }
      }
      localObject3 = new byte[k];
      this.archive.readFully((byte[])localObject3);
      localZipEntry.setExtra((byte[])localObject3);
      ZipFile.OffsetEntry.access$002((ZipFile.OffsetEntry)localObject2, l + 2L + 2L + j + k);
      if (paramMap.containsKey(localZipEntry))
      {
        localObject3 = localZipEntry.getName();
        ZipFile.NameAndComment localNameAndComment = (ZipFile.NameAndComment)paramMap.get(localZipEntry);
        ZipUtil.setNameAndCommentFromExtraFields(localZipEntry, ZipFile.NameAndComment.access$400(localNameAndComment), ZipFile.NameAndComment.access$500(localNameAndComment));
        if (!((String)localObject3).equals(localZipEntry.getName()))
        {
          this.nameMap.remove(localObject3);
          this.nameMap.put(localZipEntry.getName(), localZipEntry);
        }
      }
      this.entries.put(localZipEntry, localObject2);
    }
  }
  
  private void setSizesAndOffsetFromZip64Extra(ZipEntry paramZipEntry, ZipFile.OffsetEntry paramOffsetEntry, int paramInt)
  {
    Zip64ExtendedInformationExtraField localZip64ExtendedInformationExtraField = (Zip64ExtendedInformationExtraField)paramZipEntry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
    if (localZip64ExtendedInformationExtraField != null)
    {
      long l = paramZipEntry.getSize();
      boolean bool4 = true;
      boolean bool1;
      if (l == 4294967295L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (paramZipEntry.getCompressedSize() == 4294967295L) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool3;
      if (ZipFile.OffsetEntry.access$200(paramOffsetEntry) == 4294967295L) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      if (paramInt != 65535) {
        bool4 = false;
      }
      localZip64ExtendedInformationExtraField.reparseCentralDirectoryData(bool1, bool2, bool3, bool4);
      if (bool1) {
        paramZipEntry.setSize(localZip64ExtendedInformationExtraField.getSize().getLongValue());
      } else if (bool2) {
        localZip64ExtendedInformationExtraField.setSize(new ZipEightByteInteger(paramZipEntry.getSize()));
      }
      if (bool2) {
        paramZipEntry.setCompressedSize(localZip64ExtendedInformationExtraField.getCompressedSize().getLongValue());
      } else if (bool1) {
        localZip64ExtendedInformationExtraField.setCompressedSize(new ZipEightByteInteger(paramZipEntry.getCompressedSize()));
      }
      if (bool3) {
        ZipFile.OffsetEntry.access$202(paramOffsetEntry, localZip64ExtendedInformationExtraField.getRelativeHeaderOffset().getLongValue());
      }
    }
  }
  
  private void skipBytes(int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = this.archive.skipBytes(paramInt - i);
      if (j > 0) {
        i += j;
      } else {
        throw new EOFException();
      }
    }
  }
  
  private boolean startsWithLocalFileHeader()
  {
    this.archive.seek(0L);
    this.archive.readFully(this.WORD_BUF);
    return Arrays.equals(this.WORD_BUF, ZipOutputStream.LFH_SIG);
  }
  
  private boolean tryToLocateSignature(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    paramLong1 = this.archive.length() - paramLong1;
    long l = Math.max(0L, this.archive.length() - paramLong2);
    boolean bool2 = false;
    paramLong2 = paramLong1;
    boolean bool1 = bool2;
    if (paramLong1 >= 0L) {
      for (;;)
      {
        paramLong2 = paramLong1;
        bool1 = bool2;
        if (paramLong1 < l) {
          break;
        }
        this.archive.seek(paramLong1);
        int i = this.archive.read();
        if (i == -1)
        {
          paramLong2 = paramLong1;
          bool1 = bool2;
          break;
        }
        if ((i == paramArrayOfByte[0]) && (this.archive.read() == paramArrayOfByte[1]) && (this.archive.read() == paramArrayOfByte[2]) && (this.archive.read() == paramArrayOfByte[3]))
        {
          bool1 = true;
          paramLong2 = paramLong1;
          break;
        }
        paramLong1 -= 1L;
      }
    }
    if (bool1) {
      this.archive.seek(paramLong2);
    }
    return bool1;
  }
  
  public boolean canReadEntryData(ZipEntry paramZipEntry)
  {
    return ZipUtil.canHandleEntryData(paramZipEntry);
  }
  
  public void close()
  {
    this.closed = true;
    this.archive.close();
  }
  
  protected void finalize()
  {
    try
    {
      if (!this.closed)
      {
        PrintStream localPrintStream = System.err;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cleaning up unclosed ZipFile for archive ");
        localStringBuilder.append(this.archiveName);
        localPrintStream.println(localStringBuilder.toString());
        close();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public String getEncoding()
  {
    return this.encoding;
  }
  
  public Enumeration<ZipEntry> getEntries()
  {
    return Collections.enumeration(this.entries.keySet());
  }
  
  public Enumeration<ZipEntry> getEntriesInPhysicalOrder()
  {
    ZipEntry[] arrayOfZipEntry = (ZipEntry[])this.entries.keySet().toArray(new ZipEntry[0]);
    Arrays.sort(arrayOfZipEntry, this.OFFSET_COMPARATOR);
    return Collections.enumeration(Arrays.asList(arrayOfZipEntry));
  }
  
  public ZipEntry getEntry(String paramString)
  {
    return (ZipEntry)this.nameMap.get(paramString);
  }
  
  public InputStream getInputStream(ZipEntry paramZipEntry)
  {
    Object localObject = (ZipFile.OffsetEntry)this.entries.get(paramZipEntry);
    if (localObject == null) {
      return null;
    }
    ZipUtil.checkRequestedFeatures(paramZipEntry);
    localObject = new ZipFile.BoundedInputStream(this, ZipFile.OffsetEntry.access$000((ZipFile.OffsetEntry)localObject), paramZipEntry.getCompressedSize());
    int i = paramZipEntry.getMethod();
    if (i != 0)
    {
      if (i == 8)
      {
        ((ZipFile.BoundedInputStream)localObject).addDummy();
        paramZipEntry = new Inflater(true);
        return new ZipFile.1(this, (InputStream)localObject, paramZipEntry, paramZipEntry);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Found unsupported compression method ");
      ((StringBuilder)localObject).append(paramZipEntry.getMethod());
      throw new ZipException(((StringBuilder)localObject).toString());
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipFile
 * JD-Core Version:    0.7.0.1
 */
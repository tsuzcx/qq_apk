package com.tencent.commonsdk.soload;

import com.tencent.commonsdk.zip.QZipIOException;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

class MyZipFile
  implements MyZipConstants
{
  static final int GPBF_DATA_DESCRIPTOR_FLAG = 8;
  static final int GPBF_UTF8_FLAG = 2048;
  public static final int OPEN_DELETE = 4;
  public static final int OPEN_READ = 1;
  private MyZipEntry desentry = null;
  private final String fileName;
  private File fileToDeleteOnClose;
  private String libname;
  private final LinkedHashMap<String, MyZipEntry> mEntries = new LinkedHashMap();
  private RandomAccessFile mRaf;
  
  public MyZipFile(File paramFile, int paramInt, String paramString)
  {
    this.libname = paramString;
    this.fileName = paramFile.getPath();
    if ((paramInt != 1) && (paramInt != 5)) {
      throw new IllegalArgumentException();
    }
    if ((paramInt & 0x4) != 0) {}
    for (this.fileToDeleteOnClose = paramFile;; this.fileToDeleteOnClose = null)
    {
      this.mRaf = new RandomAccessFile(this.fileName, "r");
      readCentralDir();
      return;
    }
  }
  
  public MyZipFile(File paramFile, String paramString)
  {
    this(paramFile, 1, paramString);
  }
  
  public MyZipFile(String paramString1, String paramString2)
  {
    this(new File(paramString1), 1, paramString2);
  }
  
  private void checkNotClosed()
  {
    if (this.mRaf == null) {
      throw new IllegalStateException("Zip file closed");
    }
  }
  
  private void readCentralDir()
  {
    long l1 = 0L;
    long l2 = this.mRaf.length() - 22L;
    if (l2 < 0L) {
      throw new ZipException("too short to be Zip");
    }
    long l3 = l2 - 65536L;
    if (l3 < 0L) {}
    for (;;)
    {
      this.mRaf.seek(l2);
      int j;
      int n;
      if (Integer.reverseBytes(this.mRaf.readInt()) == 101010256)
      {
        localObject = new byte[18];
        this.mRaf.readFully((byte[])localObject);
        localObject = HeapBufferIterator.iterator((byte[])localObject, 0, localObject.length, ByteOrder.LITTLE_ENDIAN);
        i = ((BufferIterator)localObject).readShort();
        int k = ((BufferIterator)localObject).readShort();
        j = ((BufferIterator)localObject).readShort();
        int m = ((BufferIterator)localObject).readShort();
        ((BufferIterator)localObject).skip(4);
        n = ((BufferIterator)localObject).readInt();
        if ((j != m) || (i != 0) || (k != 0)) {
          throw new ZipException("spanned archives not supported");
        }
      }
      else
      {
        l3 = l2 - 1L;
        l2 = l3;
        if (l3 >= l1) {
          continue;
        }
        throw new ZipException("EOCD not found; not a Zip archive?");
      }
      Object localObject = new BufferedInputStream(new MyZipFile.RAFStream(this.mRaf, n), 4096);
      byte[] arrayOfByte = new byte[46];
      int i = 0;
      for (;;)
      {
        MyZipEntry localMyZipEntry;
        if (i < j)
        {
          localMyZipEntry = new MyZipEntry(arrayOfByte, (InputStream)localObject);
          this.mEntries.put(localMyZipEntry.getName(), localMyZipEntry);
          if (localMyZipEntry.getName().equals(this.libname)) {
            this.desentry = localMyZipEntry;
          }
        }
        else
        {
          return;
        }
        if (!localMyZipEntry.getName().contains("lib")) {}
        i += 1;
      }
      l1 = l3;
    }
  }
  
  public MyZipEntry getDesEntry()
  {
    return this.desentry;
  }
  
  public MyZipEntry getEntry(String paramString)
  {
    checkNotClosed();
    if (paramString == null) {
      throw new NullPointerException();
    }
    MyZipEntry localMyZipEntry2 = (MyZipEntry)this.mEntries.get(paramString);
    MyZipEntry localMyZipEntry1 = localMyZipEntry2;
    if (localMyZipEntry2 == null) {
      localMyZipEntry1 = (MyZipEntry)this.mEntries.get(paramString + "/");
    }
    return localMyZipEntry1;
  }
  
  public InputStream getInputStream(MyZipEntry arg1)
  {
    Object localObject1 = getEntry(???.getName());
    if (localObject1 == null) {
      return null;
    }
    ??? = ((MyZipEntry)localObject1).getName();
    if ((??? != null) && ((???.contains("../")) || (???.contains("..\\")))) {
      throw new QZipIOException();
    }
    MyZipFile.RAFStream localRAFStream;
    synchronized (this.mRaf)
    {
      localRAFStream = new MyZipFile.RAFStream(???, ((MyZipEntry)localObject1).mLocalHeaderRelOffset + 28L);
      DataInputStream localDataInputStream = new DataInputStream(localRAFStream);
      int i = Short.reverseBytes(localDataInputStream.readShort());
      localDataInputStream.close();
      localRAFStream.skip(((MyZipEntry)localObject1).nameLength + i);
      localRAFStream.mLength = (localRAFStream.mOffset + ((MyZipEntry)localObject1).compressedSize);
      if (((MyZipEntry)localObject1).compressionMethod == 8)
      {
        i = Math.max(1024, (int)Math.min(((MyZipEntry)localObject1).getSize(), 65535L));
        localObject1 = new MyZipFile.ZipInflaterInputStream(localRAFStream, new Inflater(true), i, (MyZipEntry)localObject1);
        return localObject1;
      }
    }
    return localRAFStream;
  }
  
  public String getName()
  {
    return this.fileName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.soload.MyZipFile
 * JD-Core Version:    0.7.0.1
 */
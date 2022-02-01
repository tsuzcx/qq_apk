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
    if ((paramInt & 0x4) != 0) {
      this.fileToDeleteOnClose = paramFile;
    } else {
      this.fileToDeleteOnClose = null;
    }
    this.mRaf = new RandomAccessFile(this.fileName, "r");
    readCentralDir();
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
    if (this.mRaf != null) {
      return;
    }
    throw new IllegalStateException("Zip file closed");
  }
  
  private void readCentralDir()
  {
    long l2 = this.mRaf.length() - 22L;
    long l1 = 0L;
    if (l2 >= 0L)
    {
      long l3 = l2 - 65536L;
      if (l3 >= 0L) {
        l1 = l3;
      }
      do
      {
        this.mRaf.seek(l2);
        if (Integer.reverseBytes(this.mRaf.readInt()) == 101010256)
        {
          localObject1 = new byte[18];
          this.mRaf.readFully((byte[])localObject1);
          int j = localObject1.length;
          Object localObject2 = ByteOrder.LITTLE_ENDIAN;
          int i = 0;
          localObject1 = HeapBufferIterator.iterator((byte[])localObject1, 0, j, (ByteOrder)localObject2);
          int k = ((BufferIterator)localObject1).readShort();
          int m = ((BufferIterator)localObject1).readShort();
          j = ((BufferIterator)localObject1).readShort();
          int n = ((BufferIterator)localObject1).readShort();
          ((BufferIterator)localObject1).skip(4);
          int i1 = ((BufferIterator)localObject1).readInt();
          if ((j == n) && (k == 0) && (m == 0))
          {
            localObject1 = new BufferedInputStream(new MyZipFile.RAFStream(this.mRaf, i1), 4096);
            localObject2 = new byte[46];
            while (i < j)
            {
              MyZipEntry localMyZipEntry = new MyZipEntry((byte[])localObject2, (InputStream)localObject1);
              this.mEntries.put(localMyZipEntry.getName(), localMyZipEntry);
              if (localMyZipEntry.getName().equals(this.libname))
              {
                this.desentry = localMyZipEntry;
                return;
              }
              localMyZipEntry.getName().contains("lib");
              i += 1;
            }
            return;
          }
          throw new ZipException("spanned archives not supported");
        }
        l2 -= 1L;
      } while (l2 >= l1);
      throw new ZipException("EOCD not found; not a Zip archive?");
    }
    Object localObject1 = new ZipException("too short to be Zip");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public MyZipEntry getDesEntry()
  {
    return this.desentry;
  }
  
  public MyZipEntry getEntry(String paramString)
  {
    checkNotClosed();
    if (paramString != null)
    {
      Object localObject2 = (MyZipEntry)this.mEntries.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = this.mEntries;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("/");
        localObject1 = (MyZipEntry)((LinkedHashMap)localObject1).get(((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    throw new NullPointerException();
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
    synchronized (this.mRaf)
    {
      MyZipFile.RAFStream localRAFStream = new MyZipFile.RAFStream(???, ((MyZipEntry)localObject1).mLocalHeaderRelOffset + 28L);
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
      return localRAFStream;
    }
  }
  
  public String getName()
  {
    return this.fileName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.soload.MyZipFile
 * JD-Core Version:    0.7.0.1
 */
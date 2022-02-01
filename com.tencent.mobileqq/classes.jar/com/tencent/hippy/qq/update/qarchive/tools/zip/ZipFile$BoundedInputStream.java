package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.io.InputStream;
import java.io.RandomAccessFile;

class ZipFile$BoundedInputStream
  extends InputStream
{
  private boolean addDummyByte = false;
  private long loc;
  private long remaining;
  
  ZipFile$BoundedInputStream(ZipFile paramZipFile, long paramLong1, long paramLong2)
  {
    this.remaining = paramLong2;
    this.loc = paramLong1;
  }
  
  void addDummy()
  {
    this.addDummyByte = true;
  }
  
  public int read()
  {
    long l = this.remaining;
    this.remaining = (l - 1L);
    if (l <= 0L)
    {
      if (this.addDummyByte)
      {
        this.addDummyByte = false;
        return 0;
      }
      return -1;
    }
    synchronized (ZipFile.access$600(this.this$0))
    {
      RandomAccessFile localRandomAccessFile2 = ZipFile.access$600(this.this$0);
      l = this.loc;
      this.loc = (1L + l);
      localRandomAccessFile2.seek(l);
      int i = ZipFile.access$600(this.this$0).read();
      return i;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = this.remaining;
    if (l1 <= 0L)
    {
      if (this.addDummyByte)
      {
        this.addDummyByte = false;
        paramArrayOfByte[paramInt1] = 0;
        return 1;
      }
      return -1;
    }
    if (paramInt2 <= 0) {
      return 0;
    }
    int i = paramInt2;
    if (paramInt2 > l1) {
      i = (int)l1;
    }
    synchronized (ZipFile.access$600(this.this$0))
    {
      ZipFile.access$600(this.this$0).seek(this.loc);
      paramInt1 = ZipFile.access$600(this.this$0).read(paramArrayOfByte, paramInt1, i);
      if (paramInt1 > 0)
      {
        l1 = this.loc;
        long l2 = paramInt1;
        this.loc = (l1 + l2);
        this.remaining -= l2;
      }
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipFile.BoundedInputStream
 * JD-Core Version:    0.7.0.1
 */
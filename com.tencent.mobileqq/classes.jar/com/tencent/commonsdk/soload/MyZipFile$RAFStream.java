package com.tencent.commonsdk.soload;

import java.io.InputStream;
import java.io.RandomAccessFile;

class MyZipFile$RAFStream
  extends InputStream
{
  long mLength;
  long mOffset;
  RandomAccessFile mSharedRaf;
  
  public MyZipFile$RAFStream(RandomAccessFile paramRandomAccessFile, long paramLong)
  {
    this.mSharedRaf = paramRandomAccessFile;
    this.mOffset = paramLong;
    this.mLength = paramRandomAccessFile.length();
  }
  
  public int available()
  {
    if (this.mOffset < this.mLength) {
      return 1;
    }
    return 0;
  }
  
  public int read()
  {
    return Streams.readSingleByte(this);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    synchronized (this.mSharedRaf)
    {
      this.mSharedRaf.seek(this.mOffset);
      int i = paramInt2;
      if (paramInt2 > this.mLength - this.mOffset) {
        i = (int)(this.mLength - this.mOffset);
      }
      paramInt1 = this.mSharedRaf.read(paramArrayOfByte, paramInt1, i);
      if (paramInt1 > 0)
      {
        this.mOffset += paramInt1;
        return paramInt1;
      }
      return -1;
    }
  }
  
  public long skip(long paramLong)
  {
    long l2 = this.mLength;
    long l3 = this.mOffset;
    long l1 = paramLong;
    if (paramLong > l2 - l3) {
      l1 = l2 - l3;
    }
    this.mOffset += l1;
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.soload.MyZipFile.RAFStream
 * JD-Core Version:    0.7.0.1
 */
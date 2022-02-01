package com.nostra13.universalimageloader.core.assist;

import java.io.InputStream;

public class ContentLengthInputStream
  extends InputStream
{
  private final int length;
  private final InputStream stream;
  
  public ContentLengthInputStream(InputStream paramInputStream, int paramInt)
  {
    this.stream = paramInputStream;
    this.length = paramInt;
  }
  
  public int available()
  {
    return this.length;
  }
  
  public void close()
  {
    this.stream.close();
  }
  
  public void mark(int paramInt)
  {
    this.stream.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.stream.markSupported();
  }
  
  public int read()
  {
    return this.stream.read();
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return this.stream.read(paramArrayOfByte);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.stream.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void reset()
  {
    this.stream.reset();
  }
  
  public long skip(long paramLong)
  {
    return this.stream.skip(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.ContentLengthInputStream
 * JD-Core Version:    0.7.0.1
 */
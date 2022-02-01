package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

class ByteBufferUtil$ByteBufferStream
  extends InputStream
{
  @NonNull
  private final ByteBuffer a;
  private int b = -1;
  
  ByteBufferUtil$ByteBufferStream(@NonNull ByteBuffer paramByteBuffer)
  {
    this.a = paramByteBuffer;
  }
  
  public int available()
  {
    return this.a.remaining();
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.b = this.a.position();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    if (!this.a.hasRemaining()) {
      return -1;
    }
    return this.a.get();
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.a.hasRemaining()) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, available());
    this.a.get(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  public void reset()
  {
    try
    {
      if (this.b != -1)
      {
        this.a.position(this.b);
        return;
      }
      throw new IOException("Cannot reset to unset mark position");
    }
    finally {}
  }
  
  public long skip(long paramLong)
  {
    if (!this.a.hasRemaining()) {
      return -1L;
    }
    paramLong = Math.min(paramLong, available());
    ByteBuffer localByteBuffer = this.a;
    localByteBuffer.position((int)(localByteBuffer.position() + paramLong));
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.ByteBufferUtil.ByteBufferStream
 * JD-Core Version:    0.7.0.1
 */
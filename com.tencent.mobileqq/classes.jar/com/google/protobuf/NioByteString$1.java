package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

class NioByteString$1
  extends InputStream
{
  private final ByteBuffer b = NioByteString.access$000(this.a).slice();
  
  NioByteString$1(NioByteString paramNioByteString) {}
  
  public int available()
  {
    return this.b.remaining();
  }
  
  public void mark(int paramInt)
  {
    this.b.mark();
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    if (!this.b.hasRemaining()) {
      return -1;
    }
    return this.b.get() & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.b.hasRemaining()) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, this.b.remaining());
    this.b.get(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  public void reset()
  {
    try
    {
      this.b.reset();
      return;
    }
    catch (InvalidMarkException localInvalidMarkException)
    {
      throw new IOException(localInvalidMarkException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.NioByteString.1
 * JD-Core Version:    0.7.0.1
 */
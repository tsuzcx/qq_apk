package com.tencent.TMG.mediacodec;

import java.nio.ByteBuffer;

public class AndroidCodec$InputBufferData
{
  public ByteBuffer buffer;
  public int index;
  public boolean processing = false;
  
  public AndroidCodec$InputBufferData(ByteBuffer paramByteBuffer, int paramInt)
  {
    this.buffer = paramByteBuffer;
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.mediacodec.AndroidCodec.InputBufferData
 * JD-Core Version:    0.7.0.1
 */
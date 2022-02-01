package com.tencent.avcore.jni.codec;

import java.nio.ByteBuffer;

public class InputBufferData
{
  public ByteBuffer buffer;
  public int index;
  public boolean processing = false;
  
  public InputBufferData(ByteBuffer paramByteBuffer, int paramInt)
  {
    this.buffer = paramByteBuffer;
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.codec.InputBufferData
 * JD-Core Version:    0.7.0.1
 */
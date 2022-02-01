package com.android.dex.util;

public final class ByteArrayByteInput
  implements ByteInput
{
  private final byte[] bytes;
  private int position;
  
  public ByteArrayByteInput(byte... paramVarArgs)
  {
    this.bytes = paramVarArgs;
  }
  
  public byte readByte()
  {
    byte[] arrayOfByte = this.bytes;
    int i = this.position;
    this.position = (i + 1);
    return arrayOfByte[i];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.util.ByteArrayByteInput
 * JD-Core Version:    0.7.0.1
 */
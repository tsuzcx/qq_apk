package com.bumptech.glide.load.engine.bitmap_recycle;

public final class ByteArrayAdapter
  implements ArrayAdapterInterface<byte[]>
{
  public int a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte.length;
  }
  
  public String a()
  {
    return "ByteArrayPool";
  }
  
  public int b()
  {
    return 1;
  }
  
  public byte[] b(int paramInt)
  {
    return new byte[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.ByteArrayAdapter
 * JD-Core Version:    0.7.0.1
 */
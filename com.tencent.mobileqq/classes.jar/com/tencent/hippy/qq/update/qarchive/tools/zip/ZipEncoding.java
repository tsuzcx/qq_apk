package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.nio.ByteBuffer;

public abstract interface ZipEncoding
{
  public abstract boolean canEncode(String paramString);
  
  public abstract String decode(byte[] paramArrayOfByte);
  
  public abstract ByteBuffer encode(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEncoding
 * JD-Core Version:    0.7.0.1
 */
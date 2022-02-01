package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.nio.ByteBuffer;

class FallbackZipEncoding
  implements ZipEncoding
{
  private final String charset;
  
  public FallbackZipEncoding()
  {
    this.charset = null;
  }
  
  public FallbackZipEncoding(String paramString)
  {
    this.charset = paramString;
  }
  
  public boolean canEncode(String paramString)
  {
    return true;
  }
  
  public String decode(byte[] paramArrayOfByte)
  {
    String str = this.charset;
    if (str == null) {
      return new String(paramArrayOfByte);
    }
    return new String(paramArrayOfByte, str);
  }
  
  public ByteBuffer encode(String paramString)
  {
    String str = this.charset;
    if (str == null) {
      return ByteBuffer.wrap(paramString.getBytes());
    }
    return ByteBuffer.wrap(paramString.getBytes(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.FallbackZipEncoding
 * JD-Core Version:    0.7.0.1
 */
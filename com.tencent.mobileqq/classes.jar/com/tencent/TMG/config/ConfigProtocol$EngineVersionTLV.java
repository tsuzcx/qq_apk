package com.tencent.TMG.config;

import java.io.UnsupportedEncodingException;

public class ConfigProtocol$EngineVersionTLV
  extends ConfigProtocol.TLVBase
{
  private String engienVersion;
  
  public ConfigProtocol$EngineVersionTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)4, paramShort);
  }
  
  public byte[] Pack()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.WriteString(this.engienVersion);
    return localByteBuffer.Data();
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    return true;
  }
  
  public void setEngienVersion(String paramString)
  {
    this.engienVersion = paramString;
    short s = (short)paramString.length();
    try
    {
      int i = this.engienVersion.getBytes("GBK").length;
      s = (short)i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    setLength(s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.EngineVersionTLV
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.TMG.config;

import java.io.UnsupportedEncodingException;

public class ConfigProtocol$ClientDevNameTLV
  extends ConfigProtocol.TLVBase
{
  private String devNameInfo;
  
  public ConfigProtocol$ClientDevNameTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)5, (short)0);
  }
  
  public byte[] Pack()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.WriteString(this.devNameInfo);
    return localByteBuffer.Data();
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    return true;
  }
  
  public void setDevNameInfo(String paramString)
  {
    this.devNameInfo = paramString;
    short s = (short)paramString.length();
    try
    {
      int i = this.devNameInfo.getBytes("GBK").length;
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
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.ClientDevNameTLV
 * JD-Core Version:    0.7.0.1
 */
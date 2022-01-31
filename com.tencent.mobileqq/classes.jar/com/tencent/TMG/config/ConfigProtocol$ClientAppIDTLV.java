package com.tencent.TMG.config;

import java.io.UnsupportedEncodingException;

public class ConfigProtocol$ClientAppIDTLV
  extends ConfigProtocol.TLVBase
{
  private String appID;
  
  public ConfigProtocol$ClientAppIDTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)3, paramShort);
  }
  
  public byte[] Pack()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.WriteString(this.appID);
    return localByteBuffer.Data();
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    return true;
  }
  
  public void setAppID(String paramString)
  {
    this.appID = paramString;
    short s = (short)paramString.length();
    try
    {
      int i = paramString.getBytes("GBK").length;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.ClientAppIDTLV
 * JD-Core Version:    0.7.0.1
 */
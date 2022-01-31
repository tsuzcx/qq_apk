package com.tencent.TMG.config;

import java.io.UnsupportedEncodingException;

public class ConfigProtocol$ClientRomInfoTLV
  extends ConfigProtocol.TLVBase
{
  private String m_RomInfo;
  
  public ConfigProtocol$ClientRomInfoTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)8, (short)0);
  }
  
  public byte[] Pack()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.WriteString(this.m_RomInfo);
    return localByteBuffer.Data();
  }
  
  public void SetRomInfo(String paramString)
  {
    this.m_RomInfo = paramString;
    short s = (short)paramString.length();
    try
    {
      int i = this.m_RomInfo.getBytes("GBK").length;
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
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.ClientRomInfoTLV
 * JD-Core Version:    0.7.0.1
 */
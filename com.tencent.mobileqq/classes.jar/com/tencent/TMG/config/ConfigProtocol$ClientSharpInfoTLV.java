package com.tencent.TMG.config;

public class ConfigProtocol$ClientSharpInfoTLV
  extends ConfigProtocol.TLVBase
{
  private int m_opensl = 0;
  
  public ConfigProtocol$ClientSharpInfoTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)9, (short)4);
  }
  
  public byte[] Pack()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.WriteUInt32(this.m_opensl);
    return localByteBuffer.Data();
  }
  
  void SetOpenslInfo(int paramInt)
  {
    this.m_opensl = paramInt;
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.ClientSharpInfoTLV
 * JD-Core Version:    0.7.0.1
 */
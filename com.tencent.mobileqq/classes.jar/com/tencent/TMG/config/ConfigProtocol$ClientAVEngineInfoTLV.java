package com.tencent.TMG.config;

public class ConfigProtocol$ClientAVEngineInfoTLV
  extends ConfigProtocol.TLVBase
{
  private short m_DispHeight;
  private short m_DispWidth;
  private byte m_maxDecFPS;
  private byte m_maxEncFPS;
  
  public ConfigProtocol$ClientAVEngineInfoTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)7, (short)6);
  }
  
  public byte[] Pack()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.WriteUInt8(this.m_maxEncFPS);
    localByteBuffer.WriteUInt8(this.m_maxDecFPS);
    localByteBuffer.WriteUInt16(this.m_DispWidth);
    localByteBuffer.WriteUInt16(this.m_DispHeight);
    return localByteBuffer.Data();
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    return true;
  }
  
  void setAVEngineInfo(byte paramByte1, byte paramByte2, short paramShort1, short paramShort2)
  {
    this.m_maxEncFPS = paramByte1;
    this.m_maxDecFPS = paramByte2;
    this.m_DispWidth = paramShort1;
    this.m_DispHeight = paramShort2;
    setLength((short)6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.ClientAVEngineInfoTLV
 * JD-Core Version:    0.7.0.1
 */
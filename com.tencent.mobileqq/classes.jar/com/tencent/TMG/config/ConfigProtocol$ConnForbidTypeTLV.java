package com.tencent.TMG.config;

public class ConfigProtocol$ConnForbidTypeTLV
  extends ConfigProtocol.TLVBase
{
  private short m_ConnType = 0;
  
  public ConfigProtocol$ConnForbidTypeTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)5, (short)2);
  }
  
  public byte[] Pack()
  {
    return null;
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    if ((paramByteBuffer != null) && (paramByteBuffer.length() >= 2))
    {
      this.m_ConnType = paramByteBuffer.ReadUInt16();
      return true;
    }
    return false;
  }
  
  public short getConnForbidType()
  {
    return this.m_ConnType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.ConnForbidTypeTLV
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.TMG.config;

public class ConfigProtocol$WriteLocalLogTLV
  extends ConfigProtocol.TLVBase
{
  private short m_bIsWrite = 0;
  
  public ConfigProtocol$WriteLocalLogTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)1, (short)2);
  }
  
  public byte[] Pack()
  {
    return null;
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    if ((paramByteBuffer != null) && (paramByteBuffer.length() >= 2))
    {
      this.m_bIsWrite = paramByteBuffer.ReadUInt16();
      return true;
    }
    return false;
  }
  
  public short getIsWriteLog()
  {
    return this.m_bIsWrite;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.WriteLocalLogTLV
 * JD-Core Version:    0.7.0.1
 */
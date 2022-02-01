package com.tencent.TMG.config;

public class ConfigProtocol$ConnPriorityInfoTLV
  extends ConfigProtocol.TLVBase
{
  private byte m_LocalDirectConnPri;
  private byte m_RelayConnPri;
  private byte m_StunDirectConnPri;
  private short m_length;
  private byte m_param1;
  
  public ConfigProtocol$ConnPriorityInfoTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)9, (short)4);
    this.m_length = paramShort;
    this.m_LocalDirectConnPri = 0;
    this.m_RelayConnPri = 0;
    this.m_StunDirectConnPri = 0;
    this.m_param1 = 0;
  }
  
  public byte GetLocalDirectConnPri()
  {
    return this.m_LocalDirectConnPri;
  }
  
  public byte GetParam1()
  {
    return this.m_param1;
  }
  
  public byte GetRelayConnPri()
  {
    return this.m_RelayConnPri;
  }
  
  public byte GetStunDirectConnPri()
  {
    return this.m_StunDirectConnPri;
  }
  
  public byte[] Pack()
  {
    return null;
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    if ((this.m_length == getLength()) && (paramByteBuffer.length() >= this.m_length))
    {
      this.m_LocalDirectConnPri = paramByteBuffer.ReadUInt8();
      this.m_RelayConnPri = paramByteBuffer.ReadUInt8();
      this.m_StunDirectConnPri = paramByteBuffer.ReadUInt8();
      this.m_param1 = paramByteBuffer.ReadUInt8();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.ConnPriorityInfoTLV
 * JD-Core Version:    0.7.0.1
 */
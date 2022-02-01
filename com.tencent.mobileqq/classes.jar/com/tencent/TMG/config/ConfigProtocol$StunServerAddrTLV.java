package com.tencent.TMG.config;

import java.util.ArrayList;

public class ConfigProtocol$StunServerAddrTLV
  extends ConfigProtocol.TLVBase
{
  private ArrayList<ConfigProtocol.stNetAddress> addrList = new ArrayList();
  
  public ConfigProtocol$StunServerAddrTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)4, paramShort);
  }
  
  public ConfigProtocol.stNetAddress GetStunSvrAddrByIndex(int paramInt)
  {
    if ((paramInt < this.addrList.size()) && (paramInt >= 0)) {
      return (ConfigProtocol.stNetAddress)this.addrList.get(paramInt);
    }
    return null;
  }
  
  public int GetStunSvrAddrCount()
  {
    return this.addrList.size();
  }
  
  public byte[] Pack()
  {
    return null;
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    int i = 0;
    if (paramByteBuffer == null) {
      return false;
    }
    if (getLength() < 2) {
      return false;
    }
    int j = paramByteBuffer.ReadUInt16();
    if (j != (getLength() - 2) / 6) {
      return false;
    }
    while (i < j)
    {
      int k = paramByteBuffer.ReadUInt32();
      short s = paramByteBuffer.ReadUInt16();
      ConfigProtocol.stNetAddress localstNetAddress = new ConfigProtocol.stNetAddress(this.this$0);
      localstNetAddress.m_ip = k;
      localstNetAddress.m_port = s;
      this.addrList.add(localstNetAddress);
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.StunServerAddrTLV
 * JD-Core Version:    0.7.0.1
 */
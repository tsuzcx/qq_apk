package com.tencent.TMG.config;

import java.util.ArrayList;

public class ConfigProtocol$RelaySvrUDPCheckTLV
  extends ConfigProtocol.TLVBase
{
  private ArrayList<ConfigProtocol.stNetAddress> addrList = new ArrayList();
  
  public ConfigProtocol$RelaySvrUDPCheckTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)3, paramShort);
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
    int k = getLength();
    if (k < 2) {
      return false;
    }
    int j = paramByteBuffer.ReadUInt16();
    if (j != (k - 2) / 6) {
      return false;
    }
    while (i < j)
    {
      k = paramByteBuffer.ReadUInt32();
      short s = paramByteBuffer.ReadUInt16();
      ConfigProtocol.stNetAddress localstNetAddress = new ConfigProtocol.stNetAddress(this.this$0);
      localstNetAddress.m_ip = k;
      localstNetAddress.m_port = s;
      this.addrList.add(localstNetAddress);
      i += 1;
    }
    return true;
  }
  
  public ConfigProtocol.stNetAddress getRelaySvrAddrByIndex(int paramInt)
  {
    if ((paramInt < this.addrList.size()) && (paramInt >= 0)) {
      return (ConfigProtocol.stNetAddress)this.addrList.get(paramInt);
    }
    return null;
  }
  
  public int getRelaySvrAddrCount()
  {
    return this.addrList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.RelaySvrUDPCheckTLV
 * JD-Core Version:    0.7.0.1
 */
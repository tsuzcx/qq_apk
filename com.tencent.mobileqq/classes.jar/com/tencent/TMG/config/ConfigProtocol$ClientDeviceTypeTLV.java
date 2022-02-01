package com.tencent.TMG.config;

public class ConfigProtocol$ClientDeviceTypeTLV
  extends ConfigProtocol.TLVBase
{
  private short clientType = 0;
  
  public ConfigProtocol$ClientDeviceTypeTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)1, (short)2);
  }
  
  public byte[] Pack()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.WriteUInt16(this.clientType);
    return localByteBuffer.Data();
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    return true;
  }
  
  public void setClientType(short paramShort)
  {
    this.clientType = paramShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.ClientDeviceTypeTLV
 * JD-Core Version:    0.7.0.1
 */
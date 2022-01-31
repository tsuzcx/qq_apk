package com.tencent.TMG.config;

public class ConfigProtocol$ClientOSTypeTLV
  extends ConfigProtocol.TLVBase
{
  private short clientOSType;
  
  public ConfigProtocol$ClientOSTypeTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)2, (short)2);
    setClientOSType((short)0);
  }
  
  public byte[] Pack()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.WriteUInt16(this.clientOSType);
    return localByteBuffer.Data();
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    return true;
  }
  
  public void setClientOSType(short paramShort)
  {
    this.clientOSType = paramShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.ClientOSTypeTLV
 * JD-Core Version:    0.7.0.1
 */
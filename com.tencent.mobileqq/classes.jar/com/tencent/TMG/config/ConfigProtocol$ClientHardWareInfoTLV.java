package com.tencent.TMG.config;

public class ConfigProtocol$ClientHardWareInfoTLV
  extends ConfigProtocol.TLVBase
{
  private short angleForCamera;
  private short cpuChipArch;
  private int cpuFreq;
  private short numOfCore;
  
  public ConfigProtocol$ClientHardWareInfoTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)6, (short)10);
  }
  
  public byte[] Pack()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.WriteUInt16(this.cpuChipArch);
    localByteBuffer.WriteUInt16(this.numOfCore);
    localByteBuffer.WriteUInt32(this.cpuFreq);
    localByteBuffer.WriteUInt16(this.angleForCamera);
    return localByteBuffer.Data();
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    return true;
  }
  
  public void setHardWareInfo(short paramShort1, short paramShort2, int paramInt, short paramShort3)
  {
    this.cpuChipArch = paramShort1;
    this.numOfCore = paramShort2;
    this.cpuFreq = paramInt;
    this.angleForCamera = paramShort3;
    setLength((short)10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.ClientHardWareInfoTLV
 * JD-Core Version:    0.7.0.1
 */
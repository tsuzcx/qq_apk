package com.tencent.TMG.config;

public class ConfigProtocol$SharpConfigVersionTLV
  extends ConfigProtocol.TLVBase
{
  private int m_sharpConfigVersion;
  
  public ConfigProtocol$SharpConfigVersionTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)10, (short)4);
  }
  
  public byte[] Pack()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.WriteUInt32(this.m_sharpConfigVersion);
    return localByteBuffer.Data();
  }
  
  public void SetSharpConfigVersion(int paramInt)
  {
    this.m_sharpConfigVersion = paramInt;
    setLength((short)4);
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.SharpConfigVersionTLV
 * JD-Core Version:    0.7.0.1
 */
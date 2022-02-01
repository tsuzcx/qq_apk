package com.tencent.TMG.config;

public class ConfigProtocol$SharpConfigPayloadTLV
  extends ConfigProtocol.TLVBase
{
  private String m_sharpConfigPayload;
  
  public ConfigProtocol$SharpConfigPayloadTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)14, paramShort);
  }
  
  public byte[] Pack()
  {
    return null;
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    if ((paramByteBuffer == null) || (paramByteBuffer.length() < getLength())) {
      return false;
    }
    this.m_sharpConfigPayload = paramByteBuffer.ReadString(getLength());
    return true;
  }
  
  public String getSharpConfigPayload()
  {
    return this.m_sharpConfigPayload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.SharpConfigPayloadTLV
 * JD-Core Version:    0.7.0.1
 */
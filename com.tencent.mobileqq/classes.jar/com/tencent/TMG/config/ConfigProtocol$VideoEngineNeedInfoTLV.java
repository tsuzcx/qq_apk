package com.tencent.TMG.config;

public class ConfigProtocol$VideoEngineNeedInfoTLV
  extends ConfigProtocol.TLVBase
{
  private short m_BackAngleForCamera;
  private short m_CPUArch;
  private short m_FrontAngleForCamera;
  private short m_dispHeight;
  private short m_dispWidth;
  private short m_length;
  private byte m_maxDecFPS;
  private byte m_maxEncFPS;
  private short m_param2;
  
  public ConfigProtocol$VideoEngineNeedInfoTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)6, (short)14);
    this.m_length = paramShort;
    this.m_CPUArch = 0;
    this.m_maxEncFPS = 0;
    this.m_maxDecFPS = 0;
    this.m_FrontAngleForCamera = 0;
    this.m_dispHeight = 0;
    this.m_dispWidth = 0;
    this.m_BackAngleForCamera = 0;
  }
  
  public short GetBackAngleForCamera()
  {
    return this.m_BackAngleForCamera;
  }
  
  public short GetCPUArch()
  {
    return this.m_CPUArch;
  }
  
  public short GetDispHeight()
  {
    return this.m_dispHeight;
  }
  
  public short GetDispWidth()
  {
    return this.m_dispWidth;
  }
  
  public short GetFrontAngleForCamera()
  {
    return this.m_FrontAngleForCamera;
  }
  
  public byte GetMaxDecFPS()
  {
    return this.m_maxDecFPS;
  }
  
  public byte GetMaxEncFPS()
  {
    return this.m_maxEncFPS;
  }
  
  public short GetParam2()
  {
    return this.m_param2;
  }
  
  public byte[] Pack()
  {
    return null;
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    if ((this.m_length != getLength()) || (paramByteBuffer.length() < this.m_length)) {
      return false;
    }
    this.m_CPUArch = paramByteBuffer.ReadUInt16();
    this.m_FrontAngleForCamera = paramByteBuffer.ReadUInt16();
    this.m_maxEncFPS = paramByteBuffer.ReadUInt8();
    this.m_maxDecFPS = paramByteBuffer.ReadUInt8();
    this.m_dispWidth = paramByteBuffer.ReadUInt16();
    this.m_dispHeight = paramByteBuffer.ReadUInt16();
    this.m_BackAngleForCamera = paramByteBuffer.ReadUInt16();
    this.m_param2 = paramByteBuffer.ReadUInt16();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.VideoEngineNeedInfoTLV
 * JD-Core Version:    0.7.0.1
 */
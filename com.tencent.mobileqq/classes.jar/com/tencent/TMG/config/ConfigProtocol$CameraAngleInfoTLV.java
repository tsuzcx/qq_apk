package com.tencent.TMG.config;

class ConfigProtocol$CameraAngleInfoTLV
  extends ConfigProtocol.TLVBase
{
  private byte m_BackCameraAngleForLocalPreview;
  private byte m_BackCameraAngleForRemote_0;
  private byte m_BackCameraAngleForRemote_180;
  private byte m_BackCameraAngleForRemote_270;
  private byte m_BackCameraAngleForRemote_90;
  private byte m_BackCameraFormat;
  private byte m_FrontCameraAngleForLocalPreview;
  private byte m_FrontCameraAngleForRemote_0;
  private byte m_FrontCameraAngleForRemote_180;
  private byte m_FrontCameraAngleForRemote_270;
  private byte m_FrontCameraAngleForRemote_90;
  private byte m_FrontCameraFormat;
  private short m_length;
  private byte m_param3;
  private byte m_param4;
  private byte m_param5;
  private byte m_param6;
  
  public ConfigProtocol$CameraAngleInfoTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)8, (short)16);
    this.m_length = paramShort;
    this.m_FrontCameraAngleForLocalPreview = 0;
    this.m_BackCameraAngleForLocalPreview = 0;
    this.m_FrontCameraAngleForRemote_0 = 0;
    this.m_BackCameraAngleForRemote_0 = 0;
    this.m_FrontCameraAngleForRemote_90 = 0;
    this.m_BackCameraAngleForRemote_90 = 0;
    this.m_FrontCameraAngleForRemote_180 = 0;
    this.m_BackCameraAngleForRemote_180 = 0;
    this.m_FrontCameraAngleForRemote_270 = 0;
    this.m_BackCameraAngleForRemote_270 = 0;
    this.m_FrontCameraFormat = 0;
    this.m_BackCameraFormat = 0;
    this.m_param3 = 0;
    this.m_param4 = 0;
    this.m_param5 = 0;
    this.m_param6 = 0;
  }
  
  public byte GetBackCameraAngleForLocalPreview()
  {
    return this.m_BackCameraAngleForLocalPreview;
  }
  
  public byte GetBackCameraAngleForRemote_0()
  {
    return this.m_BackCameraAngleForRemote_0;
  }
  
  public byte GetBackCameraAngleForRemote_180()
  {
    return this.m_BackCameraAngleForRemote_180;
  }
  
  public byte GetBackCameraAngleForRemote_270()
  {
    return this.m_BackCameraAngleForRemote_270;
  }
  
  public byte GetBackCameraAngleForRemote_90()
  {
    return this.m_BackCameraAngleForRemote_90;
  }
  
  public byte GetBackCameraFormat()
  {
    return this.m_BackCameraFormat;
  }
  
  public byte GetFrontCameraAngleForLocalPreview()
  {
    return this.m_FrontCameraAngleForLocalPreview;
  }
  
  public byte GetFrontCameraAngleForRemote_0()
  {
    return this.m_FrontCameraAngleForRemote_0;
  }
  
  public byte GetFrontCameraAngleForRemote_180()
  {
    return this.m_FrontCameraAngleForRemote_180;
  }
  
  public byte GetFrontCameraAngleForRemote_270()
  {
    return this.m_FrontCameraAngleForRemote_270;
  }
  
  public byte GetFrontCameraAngleForRemote_90()
  {
    return this.m_FrontCameraAngleForRemote_90;
  }
  
  public byte GetFrontCameraFormat()
  {
    return this.m_FrontCameraFormat;
  }
  
  public byte GetParam3()
  {
    return this.m_param3;
  }
  
  public byte GetParam4()
  {
    return this.m_param4;
  }
  
  public byte GetParam5()
  {
    return this.m_param5;
  }
  
  public byte GetParam6()
  {
    return this.m_param6;
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
    this.m_FrontCameraAngleForLocalPreview = paramByteBuffer.ReadUInt8();
    this.m_BackCameraAngleForLocalPreview = paramByteBuffer.ReadUInt8();
    this.m_FrontCameraAngleForRemote_0 = paramByteBuffer.ReadUInt8();
    this.m_BackCameraAngleForRemote_0 = paramByteBuffer.ReadUInt8();
    this.m_FrontCameraAngleForRemote_90 = paramByteBuffer.ReadUInt8();
    this.m_BackCameraAngleForRemote_90 = paramByteBuffer.ReadUInt8();
    this.m_FrontCameraAngleForRemote_180 = paramByteBuffer.ReadUInt8();
    this.m_BackCameraAngleForRemote_180 = paramByteBuffer.ReadUInt8();
    this.m_FrontCameraAngleForRemote_270 = paramByteBuffer.ReadUInt8();
    this.m_BackCameraAngleForRemote_270 = paramByteBuffer.ReadUInt8();
    this.m_FrontCameraFormat = paramByteBuffer.ReadUInt8();
    this.m_BackCameraFormat = paramByteBuffer.ReadUInt8();
    this.m_param3 = paramByteBuffer.ReadUInt8();
    this.m_param4 = paramByteBuffer.ReadUInt8();
    this.m_param5 = paramByteBuffer.ReadUInt8();
    this.m_param6 = paramByteBuffer.ReadUInt8();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.CameraAngleInfoTLV
 * JD-Core Version:    0.7.0.1
 */
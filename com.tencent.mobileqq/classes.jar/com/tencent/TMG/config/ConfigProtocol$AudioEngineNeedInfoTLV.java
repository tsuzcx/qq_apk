package com.tencent.TMG.config;

public class ConfigProtocol$AudioEngineNeedInfoTLV
  extends ConfigProtocol.TLVBase
{
  private byte m_OutputVolumeGain;
  private byte m_WorkModel;
  private int m_length;
  private byte m_param1;
  private byte m_preProcessModel;
  
  public ConfigProtocol$AudioEngineNeedInfoTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)7, (short)4);
    this.m_length = paramShort;
    this.m_WorkModel = 0;
    this.m_preProcessModel = 0;
    this.m_OutputVolumeGain = 0;
    this.m_param1 = 0;
  }
  
  public byte GetOutputVolumeGain()
  {
    return this.m_OutputVolumeGain;
  }
  
  public byte GetParam1()
  {
    return this.m_param1;
  }
  
  public byte GetPreProcessModel()
  {
    return this.m_preProcessModel;
  }
  
  public byte GetWorkModel()
  {
    return this.m_WorkModel;
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
    this.m_WorkModel = paramByteBuffer.ReadUInt8();
    this.m_preProcessModel = paramByteBuffer.ReadUInt8();
    this.m_OutputVolumeGain = paramByteBuffer.ReadUInt8();
    this.m_param1 = paramByteBuffer.ReadUInt8();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.AudioEngineNeedInfoTLV
 * JD-Core Version:    0.7.0.1
 */
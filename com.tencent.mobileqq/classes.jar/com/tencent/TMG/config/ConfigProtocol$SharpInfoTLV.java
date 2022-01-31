package com.tencent.TMG.config;

import com.tencent.TMG.utils.QLog;

public class ConfigProtocol$SharpInfoTLV
  extends ConfigProtocol.TLVBase
{
  private byte m_ARM_Version;
  private short m_CPU_Frequence;
  private byte m_TRAE_Interface;
  private byte m_TRAE_Mode;
  private byte m_TRAE_Source;
  private byte m_TRAE_Stream_Type;
  private byte m_TRAE_Volume;
  private short m_length;
  
  public ConfigProtocol$SharpInfoTLV(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)10, (short)16);
    this.m_length = paramShort;
    this.m_TRAE_Source = 0;
    this.m_TRAE_Interface = 0;
    this.m_TRAE_Stream_Type = 0;
    this.m_TRAE_Volume = 0;
    this.m_TRAE_Mode = 0;
    this.m_ARM_Version = 0;
    this.m_CPU_Frequence = 0;
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
    this.m_TRAE_Source = paramByteBuffer.ReadUInt8();
    this.m_TRAE_Interface = paramByteBuffer.ReadUInt8();
    this.m_TRAE_Stream_Type = paramByteBuffer.ReadUInt8();
    this.m_TRAE_Volume = paramByteBuffer.ReadUInt8();
    this.m_TRAE_Mode = paramByteBuffer.ReadUInt8();
    this.m_ARM_Version = paramByteBuffer.ReadUInt8();
    this.m_CPU_Frequence = paramByteBuffer.ReadUInt16();
    paramByteBuffer.ReadUInt32();
    paramByteBuffer.ReadUInt32();
    if (QLog.isColorLevel()) {
      QLog.d("sevenzhu", 0, "SharpInfo " + this.m_TRAE_Source + " " + this.m_TRAE_Interface + " " + this.m_TRAE_Stream_Type + " " + this.m_TRAE_Volume + " " + this.m_TRAE_Mode + " " + this.m_ARM_Version + " " + this.m_CPU_Frequence);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.SharpInfoTLV
 * JD-Core Version:    0.7.0.1
 */
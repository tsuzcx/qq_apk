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
    if (this.m_length == getLength())
    {
      if (paramByteBuffer.length() < this.m_length) {
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
      if (QLog.isColorLevel())
      {
        paramByteBuffer = new StringBuilder();
        paramByteBuffer.append("SharpInfo ");
        paramByteBuffer.append(this.m_TRAE_Source);
        paramByteBuffer.append(" ");
        paramByteBuffer.append(this.m_TRAE_Interface);
        paramByteBuffer.append(" ");
        paramByteBuffer.append(this.m_TRAE_Stream_Type);
        paramByteBuffer.append(" ");
        paramByteBuffer.append(this.m_TRAE_Volume);
        paramByteBuffer.append(" ");
        paramByteBuffer.append(this.m_TRAE_Mode);
        paramByteBuffer.append(" ");
        paramByteBuffer.append(this.m_ARM_Version);
        paramByteBuffer.append(" ");
        paramByteBuffer.append(this.m_CPU_Frequence);
        QLog.d("sevenzhu", 0, paramByteBuffer.toString());
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.SharpInfoTLV
 * JD-Core Version:    0.7.0.1
 */
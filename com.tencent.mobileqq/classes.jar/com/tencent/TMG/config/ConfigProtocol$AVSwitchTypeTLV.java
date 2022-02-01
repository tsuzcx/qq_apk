package com.tencent.TMG.config;

import com.tencent.TMG.utils.QLog;

public class ConfigProtocol$AVSwitchTypeTLV
  extends ConfigProtocol.TLVBase
{
  private byte m_bIsAuidoEnable = 1;
  private byte m_bIsOpenMaxEnable = 0;
  
  public ConfigProtocol$AVSwitchTypeTLV(ConfigProtocol paramConfigProtocol)
  {
    super(paramConfigProtocol, (short)11, (short)1);
  }
  
  public byte[] Pack()
  {
    return null;
  }
  
  public boolean Unpack(ByteBuffer paramByteBuffer)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramByteBuffer != null)
    {
      bool1 = bool2;
      if (paramByteBuffer.length() > 0)
      {
        int i = paramByteBuffer.ReadUInt8();
        bool1 = bool2;
        if (i >= 0)
        {
          this.m_bIsAuidoEnable = ((byte)(i & 0x1));
          this.m_bIsOpenMaxEnable = ((byte)(i >> 1 & 0x1));
          if (QLog.isColorLevel()) {
            QLog.d("simonchwang", 0, "m_bIsAuidoEnable:" + this.m_bIsAuidoEnable + "m_bIsOpenMaxEnable:" + this.m_bIsOpenMaxEnable);
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public byte getM_bIsAuidoEnable()
  {
    return this.m_bIsAuidoEnable;
  }
  
  public byte getM_bIsOpenMaxEnable()
  {
    return this.m_bIsOpenMaxEnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.AVSwitchTypeTLV
 * JD-Core Version:    0.7.0.1
 */
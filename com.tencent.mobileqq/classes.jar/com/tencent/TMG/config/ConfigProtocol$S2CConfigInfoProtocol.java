package com.tencent.TMG.config;

import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;

public class ConfigProtocol$S2CConfigInfoProtocol
{
  private ArrayList<ConfigProtocol.TLVBase> attrs = new ArrayList();
  private short lengthOfTLV = 0;
  private String md5;
  private short numOfTLV = 0;
  private short tag = 0;
  
  public ConfigProtocol$S2CConfigInfoProtocol(ConfigProtocol paramConfigProtocol) {}
  
  public void AddTLV(ConfigProtocol.TLVBase paramTLVBase) {}
  
  public ConfigProtocol.TLVBase GetTLVByIndex(int paramInt)
  {
    if (paramInt >= this.attrs.size()) {
      return null;
    }
    return (ConfigProtocol.TLVBase)this.attrs.get(paramInt);
  }
  
  public boolean Pack(ByteBuffer paramByteBuffer)
  {
    return true;
  }
  
  public boolean UnPack(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer != null)
    {
      if (paramByteBuffer.length() < 39) {
        return false;
      }
      this.md5 = paramByteBuffer.ReadString(33);
      this.tag = paramByteBuffer.ReadUInt16();
      this.numOfTLV = paramByteBuffer.ReadUInt16();
      this.lengthOfTLV = paramByteBuffer.ReadUInt16Length();
      this.attrs.clear();
      int i = 0;
      while (paramByteBuffer.length() > 0)
      {
        short s1 = paramByteBuffer.ReadUInt16();
        short s2 = paramByteBuffer.ReadUInt16Length();
        ConfigProtocol.TLVBase localTLVBase = this.this$0.CreateS2CTLV(s1, s2);
        if (localTLVBase == null)
        {
          if (!paramByteBuffer.Consume(s2))
          {
            if (QLog.isColorLevel())
            {
              paramByteBuffer = new StringBuilder();
              paramByteBuffer.append("[S2CConfigInfoProtocol::UnPack] Consume failed");
              paramByteBuffer.append(i);
              QLog.d("simonchwang", 0, paramByteBuffer.toString());
            }
            return false;
          }
        }
        else
        {
          if (!localTLVBase.Unpack(paramByteBuffer))
          {
            if (QLog.isColorLevel())
            {
              paramByteBuffer = new StringBuilder();
              paramByteBuffer.append("[S2CConfigInfoProtocol::UnPack] Unpack failed");
              paramByteBuffer.append(i);
              QLog.d("simonchwang", 0, paramByteBuffer.toString());
            }
            return false;
          }
          this.attrs.add(localTLVBase);
        }
        i += 1;
      }
      paramByteBuffer = this.attrs;
      if (paramByteBuffer != null) {
        this.numOfTLV = ((short)paramByteBuffer.size());
      }
      return true;
    }
    return false;
  }
  
  public short getLengthOfTLV()
  {
    return this.lengthOfTLV;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public short getNumOfTLV()
  {
    return this.numOfTLV;
  }
  
  public short getTag()
  {
    return this.tag;
  }
  
  public void setLengthOfTLV(short paramShort)
  {
    this.lengthOfTLV = paramShort;
  }
  
  public void setNumOfTLV(short paramShort)
  {
    this.numOfTLV = paramShort;
  }
  
  public void setTag(short paramShort)
  {
    this.tag = paramShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.S2CConfigInfoProtocol
 * JD-Core Version:    0.7.0.1
 */
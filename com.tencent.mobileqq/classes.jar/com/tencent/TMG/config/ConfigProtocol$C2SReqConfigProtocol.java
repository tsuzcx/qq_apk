package com.tencent.TMG.config;

import java.util.ArrayList;

public class ConfigProtocol$C2SReqConfigProtocol
{
  private ArrayList<ConfigProtocol.TLVBase> attrs = new ArrayList();
  private short lengthOfTLV = 0;
  private short numOfTLV = 0;
  private short tag = 1;
  
  public ConfigProtocol$C2SReqConfigProtocol(ConfigProtocol paramConfigProtocol) {}
  
  public void AddTLV(ConfigProtocol.TLVBase paramTLVBase)
  {
    if (this.attrs == null) {
      return;
    }
    this.attrs.add(paramTLVBase);
    this.lengthOfTLV = ((short)(this.lengthOfTLV + 4));
    this.lengthOfTLV = ((short)(this.lengthOfTLV + paramTLVBase.getLength()));
    this.numOfTLV = ((short)(this.numOfTLV + 1));
  }
  
  public ConfigProtocol.TLVBase GetTLVByIndex(int paramInt)
  {
    if (paramInt >= this.attrs.size()) {
      return null;
    }
    return (ConfigProtocol.TLVBase)this.attrs.get(paramInt);
  }
  
  public ByteBuffer Pack()
  {
    ByteBuffer localByteBuffer = new ByteBuffer();
    localByteBuffer.WriteUInt16(this.tag);
    localByteBuffer.WriteUInt16(this.numOfTLV);
    localByteBuffer.WriteUInt16(this.lengthOfTLV);
    int i = 0;
    while (i < this.attrs.size())
    {
      localByteBuffer.WriteUInt16(((ConfigProtocol.TLVBase)this.attrs.get(i)).getType());
      localByteBuffer.WriteUInt16(((ConfigProtocol.TLVBase)this.attrs.get(i)).getLength());
      localByteBuffer.WriteByteBuffer(((ConfigProtocol.TLVBase)this.attrs.get(i)).Pack());
      i += 1;
    }
    return localByteBuffer;
  }
  
  public boolean UnPack(ByteBuffer paramByteBuffer)
  {
    this.tag = paramByteBuffer.ReadUInt16();
    this.numOfTLV = paramByteBuffer.ReadUInt16();
    this.lengthOfTLV = paramByteBuffer.ReadUInt16();
    return this.lengthOfTLV == paramByteBuffer.length();
  }
  
  public short getLengthOfTLV()
  {
    return this.lengthOfTLV;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.C2SReqConfigProtocol
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.TMG.config;

public abstract class ConfigProtocol$TLVBase
{
  private short length;
  private short type;
  
  public ConfigProtocol$TLVBase(ConfigProtocol paramConfigProtocol, short paramShort1, short paramShort2)
  {
    this.type = paramShort1;
    this.length = paramShort2;
  }
  
  public abstract byte[] Pack();
  
  public abstract boolean Unpack(ByteBuffer paramByteBuffer);
  
  public short getLength()
  {
    return this.length;
  }
  
  public short getType()
  {
    return this.type;
  }
  
  public void setLength(short paramShort)
  {
    this.length = paramShort;
  }
  
  public void setType(short paramShort)
  {
    this.type = paramShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol.TLVBase
 * JD-Core Version:    0.7.0.1
 */
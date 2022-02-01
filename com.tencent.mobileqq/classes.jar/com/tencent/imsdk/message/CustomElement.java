package com.tencent.imsdk.message;

public class CustomElement
  extends MessageBaseElement
{
  private byte[] data;
  private String description;
  private byte[] extension;
  private byte[] sound;
  
  public CustomElement()
  {
    setElementType(2);
  }
  
  public byte[] getData()
  {
    return this.data;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public byte[] getExtension()
  {
    return this.extension;
  }
  
  public byte[] getSound()
  {
    return this.sound;
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setExtension(byte[] paramArrayOfByte)
  {
    this.extension = paramArrayOfByte;
  }
  
  public void setSound(byte[] paramArrayOfByte)
  {
    this.sound = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.CustomElement
 * JD-Core Version:    0.7.0.1
 */
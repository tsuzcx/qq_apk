package com.tencent.imsdk.message;

public class DraftMessage
{
  private long editTime;
  private Message message;
  private byte[] userDefinedData;
  
  public long getEditTime()
  {
    return this.editTime;
  }
  
  public byte[] getUserDefinedData()
  {
    return this.userDefinedData;
  }
  
  public void setMessage(Message paramMessage)
  {
    this.message = paramMessage;
  }
  
  public void setUserDefinedData(byte[] paramArrayOfByte)
  {
    this.userDefinedData = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.DraftMessage
 * JD-Core Version:    0.7.0.1
 */
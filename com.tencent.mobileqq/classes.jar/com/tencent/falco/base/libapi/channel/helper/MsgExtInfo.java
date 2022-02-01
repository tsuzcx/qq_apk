package com.tencent.falco.base.libapi.channel.helper;

public class MsgExtInfo
{
  public MsgSpeed msgSpeed;
  public int msgType;
  public long msgUid;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgExtInfo{msgType=");
    localStringBuilder.append(this.msgType);
    localStringBuilder.append(", msgUid=");
    localStringBuilder.append(this.msgUid);
    localStringBuilder.append(", msgSpeed=");
    localStringBuilder.append(this.msgSpeed);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.channel.helper.MsgExtInfo
 * JD-Core Version:    0.7.0.1
 */
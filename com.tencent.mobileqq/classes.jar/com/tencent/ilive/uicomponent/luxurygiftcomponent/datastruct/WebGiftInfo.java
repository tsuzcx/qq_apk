package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct;

public class WebGiftInfo
{
  public String anchorName;
  public long anchorUin;
  public String comment;
  public String effectId;
  public String effectNum;
  public String giftBigIcon;
  public String giftName;
  public String giftSmallIcon;
  public long giftTimestamp;
  public String linkMicGiftComment;
  public String senderHeadKey;
  public String senderHeadUrl;
  public String senderName;
  public long uin;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("【WebGiftInfo】");
    localStringBuffer.append("senderName : ");
    localStringBuffer.append(this.senderName);
    localStringBuffer.append(" | senderHeadKey : ");
    localStringBuffer.append(this.senderHeadKey);
    localStringBuffer.append(" | senderHeadUrl : ");
    localStringBuffer.append(this.senderHeadUrl);
    localStringBuffer.append(" | effectId : ");
    localStringBuffer.append(this.effectId);
    localStringBuffer.append(" | giftName : ");
    localStringBuffer.append(this.giftName);
    localStringBuffer.append(" | effectNum : ");
    localStringBuffer.append(this.effectNum);
    localStringBuffer.append(" | linkMicGiftComment : ");
    localStringBuffer.append(this.linkMicGiftComment);
    localStringBuffer.append(" | anchorName : ");
    localStringBuffer.append(this.anchorName);
    localStringBuffer.append(" | anchorUin : ");
    localStringBuffer.append(this.anchorUin);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.WebGiftInfo
 * JD-Core Version:    0.7.0.1
 */
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
    localStringBuffer.append("【WebGiftInfo】").append("senderName : ").append(this.senderName).append(" | senderHeadKey : ").append(this.senderHeadKey).append(" | senderHeadUrl : ").append(this.senderHeadUrl).append(" | effectId : ").append(this.effectId).append(" | giftName : ").append(this.giftName).append(" | effectNum : ").append(this.effectNum).append(" | linkMicGiftComment : ").append(this.linkMicGiftComment).append(" | anchorName : ").append(this.anchorName).append(" | anchorUin : ").append(this.anchorUin);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.WebGiftInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.gprosdk;

public final class GProNoticeAction
{
  final String mActionId;
  final int mStyle;
  final String mTitle;
  
  public GProNoticeAction(int paramInt, String paramString1, String paramString2)
  {
    this.mStyle = paramInt;
    this.mTitle = paramString1;
    this.mActionId = paramString2;
  }
  
  public String getActionId()
  {
    return this.mActionId;
  }
  
  public int getStyle()
  {
    return this.mStyle;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProNoticeAction{mStyle=");
    localStringBuilder.append(this.mStyle);
    localStringBuilder.append(",mTitle=");
    localStringBuilder.append(this.mTitle);
    localStringBuilder.append(",mActionId=");
    localStringBuilder.append(this.mActionId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProNoticeAction
 * JD-Core Version:    0.7.0.1
 */
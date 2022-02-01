package com.tencent.gprosdk;

public final class GProPopupConfig
{
  final String mPicUrl;
  final String mWording1;
  final String mWording2;
  
  public GProPopupConfig(String paramString1, String paramString2, String paramString3)
  {
    this.mWording1 = paramString1;
    this.mWording2 = paramString2;
    this.mPicUrl = paramString3;
  }
  
  public String getPicUrl()
  {
    return this.mPicUrl;
  }
  
  public String getWording1()
  {
    return this.mWording1;
  }
  
  public String getWording2()
  {
    return this.mWording2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProPopupConfig{mWording1=");
    localStringBuilder.append(this.mWording1);
    localStringBuilder.append(",mWording2=");
    localStringBuilder.append(this.mWording2);
    localStringBuilder.append(",mPicUrl=");
    localStringBuilder.append(this.mPicUrl);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProPopupConfig
 * JD-Core Version:    0.7.0.1
 */
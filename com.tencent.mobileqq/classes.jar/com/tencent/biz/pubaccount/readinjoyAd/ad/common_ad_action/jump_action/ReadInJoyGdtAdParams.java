package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action;

import org.jetbrains.annotations.NotNull;

public class ReadInJoyGdtAdParams
{
  public int a = 2;
  public boolean b = true;
  public boolean c = false;
  public long d = 0L;
  public boolean e = true;
  public int f = 0;
  public boolean g;
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jumpType = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("reportForClick = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("autoDownload = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("videoStartPositionMillis = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("isAutoPlaying = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("filterVideoCeiling = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("position = ");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyGdtAdParams
 * JD-Core Version:    0.7.0.1
 */
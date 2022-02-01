package com.tencent.mobileqq.activity.aio;

import android.support.annotation.NonNull;
import android.text.TextUtils;

public class ExtSnsRelationChainChangePushInfo$MutualMarkPushGrayTipInfo
{
  public String a;
  public long b;
  public String c;
  public int d;
  
  public boolean a()
  {
    return TextUtils.isEmpty(this.a) ^ true;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkPushGrayTipInfo{");
    localStringBuilder.append("notifyTime:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("grayTipTemplate:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("grayTipType:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo
 * JD-Core Version:    0.7.0.1
 */
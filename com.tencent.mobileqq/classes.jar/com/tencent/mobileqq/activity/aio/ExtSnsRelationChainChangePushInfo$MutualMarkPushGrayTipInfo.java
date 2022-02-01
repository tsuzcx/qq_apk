package com.tencent.mobileqq.activity.aio;

import android.support.annotation.NonNull;
import android.text.TextUtils;

public class ExtSnsRelationChainChangePushInfo$MutualMarkPushGrayTipInfo
{
  public int a;
  public long a;
  public String a;
  public String b;
  
  public boolean a()
  {
    return TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString) ^ true;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkPushGrayTipInfo{");
    localStringBuilder.append("notifyTime:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", ");
    localStringBuilder.append("grayTipTemplate:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("grayTipType:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.featuretoggle.hltxkg;

import android.content.Context;
import android.text.TextUtils;

public final class HalleyInitParam
{
  public static final String CommonBeaconAppKey = "0M100WJ33N1CQ08O";
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = false;
  private String c = "0M100WJ33N1CQ08O";
  public boolean maskDeviceInfo = false;
  
  public HalleyInitParam(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public final int getAppid()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final String getBeaconAppKey()
  {
    return this.c;
  }
  
  public final String getChannelid()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final Context getContext()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public final int getTestAppid()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public final String getUuid()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final boolean isSDKMode()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final boolean isTestMode()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public final void setBeaconAppKey(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.c = paramString;
    }
  }
  
  public final void setTestMode(int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    StringBuilder localStringBuilder2 = new StringBuilder("appid:");
    localStringBuilder2.append(this.jdField_a_of_type_Int);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",uuid:");
    localStringBuilder2.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",channelid:");
    localStringBuilder2.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",isSDKMode:");
    localStringBuilder2.append(this.jdField_a_of_type_Boolean);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",isTest:");
    localStringBuilder2.append(this.jdField_b_of_type_Boolean);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",testAppid:");
    localStringBuilder2.append(this.jdField_b_of_type_Int);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",maskDeviceInfo:");
    localStringBuilder2.append(this.maskDeviceInfo);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.HalleyInitParam
 * JD-Core Version:    0.7.0.1
 */
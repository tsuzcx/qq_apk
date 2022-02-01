package com.tencent.comic.api.plugin;

import android.app.Application;
import android.content.SharedPreferences;

public class PreloadServerParam
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  
  public PreloadServerParam(Application paramApplication, int paramInt, String paramString)
  {
    paramApplication = paramApplication.getSharedPreferences("ppp_profile", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("preload_switch");
    localStringBuilder.append(paramString);
    this.jdField_a_of_type_Int = paramApplication.getInt(localStringBuilder.toString(), -1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("preload");
    localStringBuilder.append(paramString);
    this.jdField_a_of_type_Boolean = paramApplication.getBoolean(localStringBuilder.toString(), false);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("preload_data");
    localStringBuilder.append(paramString);
    this.jdField_b_of_type_Boolean = paramApplication.getBoolean(localStringBuilder.toString(), false);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("mem_limit");
    localStringBuilder.append(paramString);
    this.jdField_b_of_type_Int = paramApplication.getInt(localStringBuilder.toString(), 256);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("ext1");
    localStringBuilder.append(paramString);
    this.jdField_a_of_type_JavaLangString = paramApplication.getString(localStringBuilder.toString(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.comic.api.plugin.PreloadServerParam
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.funchat;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.AVLog;
import com.tencent.qphone.base.util.BaseApplication;

public abstract class AVConfigManagerBase
{
  static String jdField_a_of_type_JavaLangString = "AVConfigManagerBase";
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private String b;
  
  public AVConfigManagerBase(String paramString)
  {
    this.b = paramString;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("av_config_file", 0);
  }
  
  public int a()
  {
    return a("0");
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(this.b + "_version_code_" + paramString, 0);
  }
  
  public String a()
  {
    return b("0");
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.b + "_res_hash_" + paramString, null);
  }
  
  public void a(int paramInt)
  {
    a("0", paramInt);
  }
  
  public void a(String paramString)
  {
    b("0", paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    AVLog.d(jdField_a_of_type_JavaLangString, String.format("saveConfigVersionCode|uin = %s, version = %s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(this.b + "_version_code_" + paramString, paramInt).commit();
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(this.b + "_res_hash_" + paramString1, paramString2).commit();
  }
  
  public String b(String paramString)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.b + "_info_" + paramString, null);
  }
  
  public abstract void b(String paramString);
  
  public void b(String paramString1, String paramString2)
  {
    AVLog.d(jdField_a_of_type_JavaLangString, String.format("saveConfig|uin = %s, context = %s", new Object[] { paramString1, paramString2 }));
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(this.b + "_info_" + paramString1, paramString2).commit();
    b(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.funchat.AVConfigManagerBase
 * JD-Core Version:    0.7.0.1
 */
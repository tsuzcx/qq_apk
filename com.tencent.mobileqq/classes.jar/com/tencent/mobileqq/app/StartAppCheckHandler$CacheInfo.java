package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;

class StartAppCheckHandler$CacheInfo
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  long jdField_c_of_type_Long;
  String jdField_c_of_type_JavaLangString;
  String d;
  String e;
  String f;
  String g;
  String h;
  
  StartAppCheckHandler$CacheInfo(StartAppCheckHandler paramStartAppCheckHandler, String paramString)
  {
    this.h = paramString;
    a();
  }
  
  public void a()
  {
    if (this.h == null) {
      return;
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("AppStartedObserver", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_timeToWait");
    this.jdField_a_of_type_Long = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_lastReportTime");
    this.jdField_b_of_type_Long = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_lastUpdateTime");
    this.jdField_c_of_type_Long = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_sigHash");
    this.jdField_a_of_type_JavaLangString = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_md5");
    this.jdField_b_of_type_JavaLangString = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_serverResult");
    this.jdField_a_of_type_Int = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_dlgTitle");
    this.jdField_c_of_type_JavaLangString = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_dlgContent");
    this.d = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_dlgLButton");
    this.e = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_dlgRButoon");
    this.f = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_dlgUrl");
    this.g = localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  public void b()
  {
    if (this.h == null) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("AppStartedObserver", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_timeToWait");
    localEditor.putLong(localStringBuilder.toString(), this.jdField_a_of_type_Long);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_lastReportTime");
    localEditor.putLong(localStringBuilder.toString(), this.jdField_b_of_type_Long);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_lastUpdateTime");
    localEditor.putLong(localStringBuilder.toString(), this.jdField_c_of_type_Long);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_sigHash");
    localEditor.putString(localStringBuilder.toString(), this.jdField_a_of_type_JavaLangString);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_md5");
    localEditor.putString(localStringBuilder.toString(), this.jdField_b_of_type_JavaLangString);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_serverResult");
    localEditor.putInt(localStringBuilder.toString(), this.jdField_a_of_type_Int);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_dlgTitle");
    localEditor.putString(localStringBuilder.toString(), this.jdField_c_of_type_JavaLangString);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_dlgContent");
    localEditor.putString(localStringBuilder.toString(), this.d);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_dlgLButton");
    localEditor.putString(localStringBuilder.toString(), this.e);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_dlgRButoon");
    localEditor.putString(localStringBuilder.toString(), this.f);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("_dlgUrl");
    localEditor.putString(localStringBuilder.toString(), this.g);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.StartAppCheckHandler.CacheInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;

class StartAppCheckHandler$CacheInfo
{
  long a;
  long b;
  long c;
  String d;
  String e;
  int f;
  String g;
  String h;
  String i;
  String j;
  String k;
  String l;
  
  StartAppCheckHandler$CacheInfo(StartAppCheckHandler paramStartAppCheckHandler, String paramString)
  {
    this.l = paramString;
    a();
  }
  
  public void a()
  {
    if (this.l == null) {
      return;
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("AppStartedObserver", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_timeToWait");
    this.a = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_lastReportTime");
    this.b = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_lastUpdateTime");
    this.c = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_sigHash");
    this.d = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_md5");
    this.e = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_serverResult");
    this.f = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_dlgTitle");
    this.g = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_dlgContent");
    this.h = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_dlgLButton");
    this.i = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_dlgRButoon");
    this.j = localSharedPreferences.getString(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_dlgUrl");
    this.k = localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  public void b()
  {
    if (this.l == null) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("AppStartedObserver", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_timeToWait");
    localEditor.putLong(localStringBuilder.toString(), this.a);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_lastReportTime");
    localEditor.putLong(localStringBuilder.toString(), this.b);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_lastUpdateTime");
    localEditor.putLong(localStringBuilder.toString(), this.c);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_sigHash");
    localEditor.putString(localStringBuilder.toString(), this.d);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_md5");
    localEditor.putString(localStringBuilder.toString(), this.e);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_serverResult");
    localEditor.putInt(localStringBuilder.toString(), this.f);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_dlgTitle");
    localEditor.putString(localStringBuilder.toString(), this.g);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_dlgContent");
    localEditor.putString(localStringBuilder.toString(), this.h);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_dlgLButton");
    localEditor.putString(localStringBuilder.toString(), this.i);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_dlgRButoon");
    localEditor.putString(localStringBuilder.toString(), this.j);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("_dlgUrl");
    localEditor.putString(localStringBuilder.toString(), this.k);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.StartAppCheckHandler.CacheInfo
 * JD-Core Version:    0.7.0.1
 */
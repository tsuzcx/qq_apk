package com.tencent.mobileqq.app.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;

abstract class DiySecureFileHelper$BaseFileHelper
{
  protected final SharedPreferences a = BaseApplication.getContext().getSharedPreferences("StepUpdate", 0);
  
  protected abstract String a();
  
  protected boolean b()
  {
    return this.a.contains(a()) ^ true;
  }
  
  protected void c()
  {
    this.a.edit().putBoolean(a(), true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.DiySecureFileHelper.BaseFileHelper
 * JD-Core Version:    0.7.0.1
 */
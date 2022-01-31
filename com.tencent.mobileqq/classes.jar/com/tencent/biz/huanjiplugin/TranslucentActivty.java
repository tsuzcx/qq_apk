package com.tencent.biz.huanjiplugin;

import alpo;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import bimg;
import bimp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qhuanji.QHuanjiPluginProxyActivity;
import nff;

public class TranslucentActivty
  extends Activity
{
  private void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "begin startPlugin.......");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (((bimg)localQQAppInterface.getManager(27)).isPlugininstalled("qhuanji_plugin.apk"))
    {
      nff.a().a(4, 5, 100);
      paramIntent.putExtra("userQqResources", 2);
      bimp localbimp = new bimp(0);
      localbimp.jdField_b_of_type_JavaLangString = "qhuanji_plugin.apk";
      localbimp.d = alpo.a(2131715450);
      localbimp.jdField_a_of_type_JavaLangString = localQQAppInterface.c();
      localbimp.e = "com.tencent.huanji.activity.SwitchPhoneActivity";
      localbimp.jdField_a_of_type_JavaLangClass = QHuanjiPluginProxyActivity.class;
      localbimp.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localbimp.jdField_b_of_type_Int = -1;
      localbimp.c = 10000;
      localbimp.f = null;
      bimg.a(this, localbimp);
      nff.a().a(4, 6, 100);
      finish();
      return;
    }
    finish();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(super.getIntent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.huanjiplugin.TranslucentActivty
 * JD-Core Version:    0.7.0.1
 */
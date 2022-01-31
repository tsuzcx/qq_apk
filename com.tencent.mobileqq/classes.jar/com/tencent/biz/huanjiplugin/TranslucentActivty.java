package com.tencent.biz.huanjiplugin;

import ajya;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import bglh;
import bglq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qhuanji.QHuanjiPluginProxyActivity;
import ncj;

public class TranslucentActivty
  extends Activity
{
  private void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "begin startPlugin.......");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (((bglh)localQQAppInterface.getManager(27)).isPlugininstalled("qhuanji_plugin.apk"))
    {
      ncj.a().a(4, 5, 100);
      paramIntent.putExtra("userQqResources", 2);
      bglq localbglq = new bglq(0);
      localbglq.jdField_b_of_type_JavaLangString = "qhuanji_plugin.apk";
      localbglq.d = ajya.a(2131715078);
      localbglq.jdField_a_of_type_JavaLangString = localQQAppInterface.c();
      localbglq.e = "com.tencent.huanji.activity.SwitchPhoneActivity";
      localbglq.jdField_a_of_type_JavaLangClass = QHuanjiPluginProxyActivity.class;
      localbglq.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localbglq.jdField_b_of_type_Int = -1;
      localbglq.c = 10000;
      localbglq.f = null;
      bglh.a(this, localbglq);
      ncj.a().a(4, 6, 100);
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
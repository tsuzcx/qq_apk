package com.tencent.biz.huanjiplugin;

import ajyc;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import bgkq;
import bgkz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qhuanji.QHuanjiPluginProxyActivity;
import ncm;

public class TranslucentActivty
  extends Activity
{
  private void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "begin startPlugin.......");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (((bgkq)localQQAppInterface.getManager(27)).isPlugininstalled("qhuanji_plugin.apk"))
    {
      ncm.a().a(4, 5, 100);
      paramIntent.putExtra("userQqResources", 2);
      bgkz localbgkz = new bgkz(0);
      localbgkz.jdField_b_of_type_JavaLangString = "qhuanji_plugin.apk";
      localbgkz.d = ajyc.a(2131715067);
      localbgkz.jdField_a_of_type_JavaLangString = localQQAppInterface.c();
      localbgkz.e = "com.tencent.huanji.activity.SwitchPhoneActivity";
      localbgkz.jdField_a_of_type_JavaLangClass = QHuanjiPluginProxyActivity.class;
      localbgkz.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localbgkz.jdField_b_of_type_Int = -1;
      localbgkz.c = 10000;
      localbgkz.f = null;
      bgkq.a(this, localbgkz);
      ncm.a().a(4, 6, 100);
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
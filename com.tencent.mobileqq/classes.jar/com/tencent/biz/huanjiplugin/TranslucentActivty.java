package com.tencent.biz.huanjiplugin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qhuanji.QHuanjiPluginProxyActivity;

public class TranslucentActivty
  extends Activity
{
  private void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "begin startPlugin.......");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (((IPluginManager)localQQAppInterface.getManager(26)).isPlugininstalled("qhuanji_plugin.apk"))
    {
      HuanjiPluginProxy.a().a(4, 5, 100);
      paramIntent.putExtra("userQqResources", 2);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
      localPluginParams.jdField_b_of_type_JavaLangString = "qhuanji_plugin.apk";
      localPluginParams.d = "闪电换机";
      localPluginParams.jdField_a_of_type_JavaLangString = localQQAppInterface.c();
      localPluginParams.e = "com.tencent.huanji.activity.SwitchPhoneActivity";
      localPluginParams.jdField_a_of_type_JavaLangClass = QHuanjiPluginProxyActivity.class;
      localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localPluginParams.jdField_b_of_type_Int = -1;
      localPluginParams.c = 10000;
      localPluginParams.f = null;
      IPluginManager.a(this, localPluginParams);
      HuanjiPluginProxy.a().a(4, 6, 100);
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
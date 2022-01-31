package com.tencent.biz.huanjiplugin;

import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import bfcz;
import bfdi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qhuanji.QHuanjiPluginProxyActivity;
import mrl;

public class TranslucentActivty
  extends Activity
{
  private void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "begin startPlugin.......");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (((bfcz)localQQAppInterface.getManager(27)).isPlugininstalled("qhuanji_plugin.apk"))
    {
      mrl.a().a(4, 5, 100);
      paramIntent.putExtra("userQqResources", 2);
      bfdi localbfdi = new bfdi(0);
      localbfdi.jdField_b_of_type_JavaLangString = "qhuanji_plugin.apk";
      localbfdi.d = ajjy.a(2131649278);
      localbfdi.jdField_a_of_type_JavaLangString = localQQAppInterface.c();
      localbfdi.e = "com.tencent.huanji.activity.SwitchPhoneActivity";
      localbfdi.jdField_a_of_type_JavaLangClass = QHuanjiPluginProxyActivity.class;
      localbfdi.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localbfdi.jdField_b_of_type_Int = -1;
      localbfdi.c = 10000;
      localbfdi.f = null;
      bfcz.a(this, localbfdi);
      mrl.a().a(4, 6, 100);
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
package com.tencent.biz.huanjiplugin;

import alud;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import biqn;
import biqw;
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
    if (((biqn)localQQAppInterface.getManager(27)).isPlugininstalled("qhuanji_plugin.apk"))
    {
      nff.a().a(4, 5, 100);
      paramIntent.putExtra("userQqResources", 2);
      biqw localbiqw = new biqw(0);
      localbiqw.jdField_b_of_type_JavaLangString = "qhuanji_plugin.apk";
      localbiqw.d = alud.a(2131715462);
      localbiqw.jdField_a_of_type_JavaLangString = localQQAppInterface.c();
      localbiqw.e = "com.tencent.huanji.activity.SwitchPhoneActivity";
      localbiqw.jdField_a_of_type_JavaLangClass = QHuanjiPluginProxyActivity.class;
      localbiqw.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localbiqw.jdField_b_of_type_Int = -1;
      localbiqw.c = 10000;
      localbiqw.f = null;
      biqn.a(this, localbiqw);
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
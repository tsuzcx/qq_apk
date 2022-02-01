package com.tencent.biz.pubaccount.util;

import android.content.Context;
import android.content.IntentFilter;
import apwe;
import bhod;
import com.tencent.biz.pubaccount.readinjoy.config.beans.AchillesParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import oat;
import org.json.JSONObject;

public class AchillesFragmentUtils
{
  private static AchillesFragmentUtils.InstallBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountUtilAchillesFragmentUtils$InstallBroadcastReceiver;
  private static String jdField_a_of_type_JavaLangString;
  private static WeakReference<bhod> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static void a(String paramString1, String paramString2, String paramString3, AchillesParams paramAchillesParams)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAchillesParams != null) {}
    try
    {
      localJSONObject.put(paramAchillesParams.getPackageName(), paramAchillesParams.toString());
      label27:
      oat.a(null, "", "0X8009ECD", "0X8009ECD", 0, 0, paramString1, paramString2, paramString3, localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramAchillesParams)
    {
      break label27;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, bhod parambhod)
  {
    boolean bool3 = false;
    bool1 = false;
    bool2 = bool3;
    try
    {
      jdField_a_of_type_JavaLangString = paramString1;
      bool2 = bool3;
      paramString1 = Achilles.a(paramString2);
      bool2 = bool3;
      QLog.d("AchillesFragmentUtils", 1, "[installIfDownloaded] downloadInfo: " + paramString1);
      if (paramString1 != null)
      {
        bool2 = bool3;
        bool1 = apwe.b(paramString1);
      }
      bool2 = bool1;
      if (jdField_a_of_type_ComTencentBizPubaccountUtilAchillesFragmentUtils$InstallBroadcastReceiver == null)
      {
        bool2 = bool1;
        paramString1 = new IntentFilter();
        bool2 = bool1;
        paramString1.addAction("android.intent.action.PACKAGE_ADDED");
        bool2 = bool1;
        paramString1.addAction("android.intent.action.PACKAGE_INSTALL");
        bool2 = bool1;
        paramString1.addAction("android.intent.action.UNINSTALL_PACKAGE");
        bool2 = bool1;
        paramString1.addDataScheme("package");
        bool2 = bool1;
        jdField_a_of_type_ComTencentBizPubaccountUtilAchillesFragmentUtils$InstallBroadcastReceiver = new AchillesFragmentUtils.InstallBroadcastReceiver();
        bool2 = bool1;
        BaseApplication.getContext().registerReceiver(jdField_a_of_type_ComTencentBizPubaccountUtilAchillesFragmentUtils$InstallBroadcastReceiver, paramString1);
      }
      bool2 = bool1;
      jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambhod);
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    QLog.i("AchillesFragmentUtils", 1, "installFile:" + paramString2 + " installSuccess:" + bool1);
    if (bool1) {}
    for (paramString1 = "1";; paramString1 = "0")
    {
      a("install", paramString1, paramString2, null);
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.AchillesFragmentUtils
 * JD-Core Version:    0.7.0.1
 */
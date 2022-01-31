package com.tencent.mfsdk.tools;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.MD5;

public class PhoneUtil
{
  private static int jdField_a_of_type_Int = -1;
  private static String jdField_a_of_type_JavaLangString = "";
  
  public static String a(Application paramApplication)
  {
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      return jdField_a_of_type_JavaLangString;
    }
    String str1 = "";
    Context localContext = paramApplication.getApplicationContext();
    Object localObject = str1;
    if (a(paramApplication))
    {
      paramApplication = (TelephonyManager)localContext.getSystemService("phone");
      String str2 = paramApplication.getDeviceId();
      localObject = str1;
      if (!TextUtils.isEmpty(str2)) {
        localObject = "" + str2;
      }
      str1 = paramApplication.getSubscriberId();
      if (TextUtils.isEmpty(str1)) {
        break label170;
      }
      paramApplication = (String)localObject + str1;
    }
    for (;;)
    {
      localObject = paramApplication;
      if (TextUtils.isEmpty(paramApplication))
      {
        localObject = paramApplication;
        if (Build.VERSION.SDK_INT >= 23) {
          localObject = Build.SERIAL;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramApplication = (Application)localObject;
        if (!((String)localObject).startsWith("012345678912345")) {}
      }
      else
      {
        paramApplication = Settings.Secure.getString(localContext.getContentResolver(), "android_id");
      }
      jdField_a_of_type_JavaLangString = MD5.toMD5(paramApplication);
      return jdField_a_of_type_JavaLangString;
      label170:
      str1 = paramApplication.getSimOperator();
      paramApplication = (Application)localObject;
      if (!TextUtils.isEmpty(str1)) {
        paramApplication = (String)localObject + str1;
      }
    }
  }
  
  private static boolean a(Application paramApplication)
  {
    boolean bool = true;
    if (jdField_a_of_type_Int == -1)
    {
      bool = a(paramApplication, "android.permission.READ_PHONE_STATE");
      if (bool) {
        jdField_a_of_type_Int = 1;
      }
    }
    while (jdField_a_of_type_Int > 0) {
      for (;;)
      {
        return bool;
        jdField_a_of_type_Int = 0;
      }
    }
    return false;
  }
  
  private static boolean a(Application paramApplication, String paramString)
  {
    if (paramApplication == null) {}
    PackageManager localPackageManager;
    do
    {
      return false;
      localPackageManager = paramApplication.getPackageManager();
    } while ((localPackageManager == null) || (localPackageManager.checkPermission(paramString, paramApplication.getPackageName()) != 0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mfsdk.tools.PhoneUtil
 * JD-Core Version:    0.7.0.1
 */
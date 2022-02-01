package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.support.log.HMSLog;

public abstract class c
{
  public static String a(Context paramContext, String paramString)
  {
    Object localObject = "";
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localObject;
      try
      {
        paramContext = PushEncrypter.decrypter(paramContext, new q(paramContext, paramString).b("token_info_v2"));
        localObject = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          continue;
        }
        HMSLog.d("PushDataEncrypterManager", "getSecureData not exist");
        return paramContext;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          HMSLog.e("PushDataEncrypterManager", "getSecureData" + paramContext.getMessage());
          paramContext = (Context)localObject;
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    try
    {
      paramString2 = PushEncrypter.encrypter(paramContext, paramString2);
      boolean bool = new q(paramContext, paramString1).a("token_info_v2", paramString2);
      return bool;
    }
    catch (Exception paramContext)
    {
      HMSLog.e("PushDataEncrypterManager", "saveSecureData" + paramContext.getMessage());
    }
    return false;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      new q(paramContext, paramString).e("token_info_v2");
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.e("PushDataEncrypterManager", "removeSecureData" + paramContext.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.c
 * JD-Core Version:    0.7.0.1
 */
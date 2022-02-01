package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.support.log.HMSLog;

public abstract class y
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
        paramContext = PushEncrypter.decrypter(paramContext, new ac(paramContext, paramString).b("token_info_v2"));
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
      boolean bool = new ac(paramContext, paramString1).a("token_info_v2", paramString2);
      return bool;
    }
    catch (Exception paramContext)
    {
      HMSLog.e("PushDataEncrypterManager", "saveSecureData" + paramContext.getMessage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.y
 * JD-Core Version:    0.7.0.1
 */
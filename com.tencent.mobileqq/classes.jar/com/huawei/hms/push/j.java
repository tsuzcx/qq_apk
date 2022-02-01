package com.huawei.hms.push;

import android.content.Context;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.support.log.HMSLog;

public class j
{
  public static a a(Context paramContext)
  {
    if (!b(paramContext))
    {
      if (AutoInitHelper.isAutoInitEnabled(paramContext))
      {
        HMSLog.e("TokenUtil", "Token not exist, try auto init");
        AutoInitHelper.doAutoInit(paramContext);
        return a.ar;
      }
      HMSLog.e("TokenUtil", "Token not exist");
      return a.b;
    }
    return a.a;
  }
  
  private static boolean b(Context paramContext)
  {
    return new ac(paramContext, "push_client_self_info").c("token_info_v2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.j
 * JD-Core Version:    0.7.0.1
 */
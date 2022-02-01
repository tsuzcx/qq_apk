package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.c.a.a;
import java.util.List;

public final class a
{
  private static boolean a = false;
  private static AuthInfo b;
  
  public static AuthInfo a()
  {
    if (a) {
      return b;
    }
    throw new RuntimeException("please init sdk before use it. Wb.install()");
  }
  
  public static void a(Context paramContext, AuthInfo paramAuthInfo)
  {
    if (!a)
    {
      if (paramAuthInfo != null)
      {
        b = paramAuthInfo;
        paramAuthInfo = paramAuthInfo.getAppKey();
        com.sina.weibo.sdk.a.a.b().b(paramContext, paramAuthInfo);
        a = true;
        return;
      }
      throw new RuntimeException("authInfo must not be null.");
    }
  }
  
  public static boolean a(Context paramContext)
  {
    Intent localIntent = new Intent("com.sina.weibo.action.sdkidentity");
    localIntent.addCategory("android.intent.category.DEFAULT");
    if (paramContext != null)
    {
      paramContext = paramContext.getPackageManager().queryIntentServices(localIntent, 0);
      if ((paramContext != null) && (!paramContext.isEmpty())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    if (a(paramContext))
    {
      paramContext = com.sina.weibo.sdk.c.a.c(paramContext);
      if ((paramContext != null) && (paramContext.an >= 10772)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.a
 * JD-Core Version:    0.7.0.1
 */
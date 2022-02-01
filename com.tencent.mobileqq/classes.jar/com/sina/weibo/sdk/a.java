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
    if (!a) {
      throw new RuntimeException("please init sdk before use it. Wb.install()");
    }
    return b;
  }
  
  public static void a(Context paramContext, AuthInfo paramAuthInfo)
  {
    if (!a)
    {
      if (paramAuthInfo == null) {
        throw new RuntimeException("authInfo must not be null.");
      }
      b = paramAuthInfo;
      paramAuthInfo = paramAuthInfo.getAppKey();
      com.sina.weibo.sdk.a.a.b().b(paramContext, paramAuthInfo);
      a = true;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    Intent localIntent = new Intent("com.sina.weibo.action.sdkidentity");
    localIntent.addCategory("android.intent.category.DEFAULT");
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      paramContext = paramContext.getPackageManager().queryIntentServices(localIntent, 0);
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (!paramContext.isEmpty()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a(paramContext))
    {
      paramContext = com.sina.weibo.sdk.c.a.c(paramContext);
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.an >= 10772) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.a
 * JD-Core Version:    0.7.0.1
 */
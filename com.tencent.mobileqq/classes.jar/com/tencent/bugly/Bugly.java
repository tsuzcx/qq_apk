package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.Map;

public class Bugly
{
  public static final String SDK_IS_DEV = "false";
  private static boolean a = false;
  public static Context applicationContext;
  private static String[] b = { "BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule" };
  private static String[] c = { "BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule" };
  public static boolean enable = true;
  public static Boolean isDev;
  
  public static String getAppChannel()
  {
    try
    {
      Object localObject1 = a.b();
      if (localObject1 == null) {
        return null;
      }
      if (TextUtils.isEmpty(((a)localObject1).o))
      {
        Object localObject3 = p.a();
        if (localObject3 == null)
        {
          localObject1 = ((a)localObject1).o;
          return localObject1;
        }
        localObject3 = ((p)localObject3).a(556, null, true);
        if (localObject3 != null)
        {
          localObject3 = (byte[])((Map)localObject3).get("app_channel");
          if (localObject3 != null)
          {
            localObject1 = new String((byte[])localObject3);
            return localObject1;
          }
        }
      }
      localObject1 = ((a)localObject1).o;
      return localObject1;
    }
    finally {}
  }
  
  public static void init(Context paramContext, String paramString, boolean paramBoolean)
  {
    init(paramContext, paramString, paramBoolean, null);
  }
  
  public static void init(Context paramContext, String paramString, boolean paramBoolean, BuglyStrategy paramBuglyStrategy)
  {
    try
    {
      boolean bool = a;
      if (bool) {
        return;
      }
      a = true;
      paramContext = z.a(paramContext);
      applicationContext = paramContext;
      if (paramContext == null)
      {
        Log.e(x.b, "init arg 'context' should not be null!");
        return;
      }
      if (isDev()) {
        b = c;
      }
      paramContext = b;
      j = paramContext.length;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int j;
        int i;
        Object localObject;
        for (;;)
        {
          throw paramContext;
        }
        label166:
        i += 1;
      }
    }
    if (i < j)
    {
      localObject = paramContext[i];
      try
      {
        if ((localObject.equals("BuglyCrashModule")) || (localObject.equals("BuglyBetaModule")) || (localObject.equals("BuglyRqdModule"))) {
          break label166;
        }
        localObject.equals("BuglyFeedbackModule");
      }
      catch (Throwable localThrowable)
      {
        x.b(localThrowable);
      }
    }
    else
    {
      b.a = enable;
      b.a(applicationContext, paramString, paramBoolean, paramBuglyStrategy);
      return;
    }
  }
  
  public static boolean isDev()
  {
    if (isDev == null) {
      isDev = Boolean.valueOf(Boolean.parseBoolean("false".replace("@", "")));
    }
    return isDev.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.Bugly
 * JD-Core Version:    0.7.0.1
 */
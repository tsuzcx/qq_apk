package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b
{
  public static boolean a = true;
  public static List<a> b = new ArrayList();
  public static boolean c;
  private static p d;
  private static boolean e;
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, BuglyStrategy paramBuglyStrategy)
  {
    try
    {
      if (e)
      {
        x.d("[init] initial Multi-times, ignore this.", new Object[0]);
        return;
      }
      if (paramContext == null)
      {
        Log.w(x.b, "[init] context is null, check it.");
        return;
      }
      if (paramString == null)
      {
        Log.e(x.b, "init arg 'crashReportAppID' should not be null!");
        return;
      }
      e = true;
      if (paramBoolean)
      {
        c = true;
        x.c = true;
        x.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
        x.e("--------------------------------------------------------------------------------------------", new Object[0]);
        x.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
        x.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
        x.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
        x.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
        x.e("--------------------------------------------------------------------------------------------", new Object[0]);
        x.b("[init] Open debug mode of Bugly.", new Object[0]);
      }
      x.a(" crash report start initializing...", new Object[0]);
      x.b("[init] Bugly start initializing...", new Object[0]);
      x.a("[init] Bugly complete version: v%s", new Object[] { "3.2.4" });
      localContext = z.a(paramContext);
      locala1 = com.tencent.bugly.crashreport.common.info.a.a(localContext);
      locala1.r();
      y.a(localContext);
      d = p.a(localContext, b);
      u.a(localContext);
      locala = com.tencent.bugly.crashreport.common.strategy.a.a(localContext, b);
      localn = n.a(localContext);
      paramContext = locala1.r;
      locala1.getClass();
      if ((paramContext == null) || (!paramContext.contains("bugly"))) {
        break label869;
      }
      i = 1;
    }
    finally
    {
      for (;;)
      {
        Context localContext;
        com.tencent.bugly.crashreport.common.info.a locala1;
        com.tencent.bugly.crashreport.common.strategy.a locala;
        n localn;
        int j;
        for (;;)
        {
          throw paramContext;
        }
        label869:
        int i = 0;
        continue;
        label875:
        i = 0;
        continue;
        label881:
        i += 1;
        continue;
        label890:
        long l = 0L;
      }
    }
    if (i != 0)
    {
      a = false;
      return;
    }
    locala1.a(paramString);
    x.a("[param] Set APP ID:%s", new Object[] { paramString });
    if (paramBuglyStrategy != null)
    {
      paramString = paramBuglyStrategy.getAppVersion();
      if (!TextUtils.isEmpty(paramString))
      {
        paramContext = paramString;
        if (paramString.length() > 100)
        {
          paramContext = paramString.substring(0, 100);
          x.d("appVersion %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), paramContext });
        }
        locala1.m = paramContext;
        x.a("[param] Set App version: %s", new Object[] { paramBuglyStrategy.getAppVersion() });
      }
      try
      {
        if (paramBuglyStrategy.isReplaceOldChannel())
        {
          paramString = paramBuglyStrategy.getAppChannel();
          if (!TextUtils.isEmpty(paramString))
          {
            paramContext = paramString;
            if (paramString.length() > 100)
            {
              paramContext = paramString.substring(0, 100);
              x.d("appChannel %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), paramContext });
            }
            d.a(556, "app_channel", paramContext.getBytes(), null, false);
            locala1.o = paramContext;
          }
        }
        else
        {
          paramContext = d.a(556, null, true);
          if (paramContext != null)
          {
            paramContext = (byte[])paramContext.get("app_channel");
            if (paramContext != null) {
              locala1.o = new String(paramContext);
            }
          }
        }
        x.a("[param] Set App channel: %s", new Object[] { locala1.o });
      }
      catch (Exception paramContext)
      {
        if (c) {
          paramContext.printStackTrace();
        }
      }
      paramString = paramBuglyStrategy.getAppPackageName();
      if (!TextUtils.isEmpty(paramString))
      {
        paramContext = paramString;
        if (paramString.length() > 100)
        {
          paramContext = paramString.substring(0, 100);
          x.d("appPackageName %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), paramContext });
        }
        locala1.c = paramContext;
        x.a("[param] Set App package: %s", new Object[] { paramBuglyStrategy.getAppPackageName() });
      }
      paramString = paramBuglyStrategy.getDeviceID();
      if (paramString != null)
      {
        paramContext = paramString;
        if (paramString.length() > 100)
        {
          paramContext = paramString.substring(0, 100);
          x.d("deviceId %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), paramContext });
        }
        locala1.c(paramContext);
        x.a("[param] Set device ID: %s", new Object[] { paramContext });
      }
      locala1.f = paramBuglyStrategy.isUploadProcess();
      y.a = paramBuglyStrategy.isBuglyLogUpload();
      break label875;
      j = b.size();
      if (i < j)
      {
        try
        {
          if (!localn.a(((a)b.get(i)).id)) {
            break label881;
          }
          ((a)b.get(i)).init(localContext, paramBoolean, paramBuglyStrategy);
        }
        catch (Throwable paramContext)
        {
          if (x.a(paramContext)) {
            break label881;
          }
        }
        paramContext.printStackTrace();
        break label881;
      }
      com.tencent.bugly.crashreport.biz.b.a(localContext, paramBuglyStrategy);
      if (paramBuglyStrategy == null) {
        break label890;
      }
      l = paramBuglyStrategy.getAppReportDelay();
      locala.a(l);
      x.b("[init] Bugly initialization finished.", new Object[0]);
      return;
    }
  }
  
  public static void a(a parama)
  {
    try
    {
      if (!b.contains(parama)) {
        b.add(parama);
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.b
 * JD-Core Version:    0.7.0.1
 */
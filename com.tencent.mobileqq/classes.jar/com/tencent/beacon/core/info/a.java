package com.tencent.beacon.core.info;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.beacon.core.a.f;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.e.j;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static String a;
  private static String b;
  private static Boolean c;
  public static int d = 0;
  public static String e = "";
  public static boolean f;
  private static boolean g;
  
  public static String a()
  {
    if (!"".equals(e)) {
      return e;
    }
    try
    {
      if (d == 0) {
        d = Process.myPid();
      }
      StringBuilder localStringBuilder = new StringBuilder().append(e).append(d);
      e = "_";
      e += new Date().getTime();
    }
    catch (Exception localException)
    {
      label91:
      break label91;
    }
    return e;
  }
  
  public static String a(Context paramContext)
  {
    if (a == null) {
      a = e(paramContext);
    }
    return a;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {
      return false;
    }
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      int i;
      if (paramContext != null)
      {
        i = paramContext.size();
        if (i != 0) {}
      }
      else
      {
        d.i("[core] no running proc", new Object[0]);
        return false;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        Object localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).importance == 100)
        {
          localObject = ((ActivityManager.RunningAppProcessInfo)localObject).pkgList;
          int j = localObject.length;
          i = 0;
          while (i < j)
          {
            boolean bool = paramString.equals(localObject[i]);
            if (bool) {
              return true;
            }
            i += 1;
          }
        }
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      d.a(paramContext);
      d.b("[core] Failed to judge [%s]", new Object[] { paramContext.getLocalizedMessage() });
    }
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      if (d == 0) {
        d = Process.myPid();
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == d)
        {
          int i = localRunningAppProcessInfo.importance;
          return i;
        }
      }
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool3 = true;
    boolean bool1;
    boolean bool2;
    if ((paramContext != null) && (paramString != null)) {
      if (paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0)
      {
        bool1 = true;
        bool2 = bool1;
        if (bool1) {}
      }
    }
    label156:
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
        if (paramContext == null) {
          break label156;
        }
        int j = paramContext.length;
        int i = 0;
        if (i >= j) {
          break label156;
        }
        bool2 = paramString.equals(paramContext[i]);
        if (bool2)
        {
          bool1 = bool3;
          d.a("[core] end", new Object[0]);
          bool2 = bool1;
          return bool2;
          bool1 = false;
          break;
        }
        i += 1;
        continue;
      }
      catch (Throwable paramContext)
      {
        d.a(paramContext);
        return bool1;
      }
      finally
      {
        d.a("[core] end", new Object[0]);
      }
      return false;
    }
  }
  
  public static String c(Context paramContext)
  {
    Object localObject = b;
    if (localObject != null) {
      return localObject;
    }
    try
    {
      if (d == 0) {
        d = Process.myPid();
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).pid == d)
        {
          b = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
          paramContext = b;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      d.a(paramContext);
    }
    return "";
  }
  
  public static String d(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = null;
    }
    String str;
    do
    {
      return paramContext;
      str = paramContext.getPackageName();
      paramContext = str;
    } while (!j.b(str));
    return "";
  }
  
  protected static String e(Context paramContext)
  {
    int j = 0;
    label78:
    try
    {
      localObject = d(paramContext);
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
        localObject = paramContext.versionName;
        m = paramContext.versionCode;
        if ((localObject != null) && (((String)localObject).trim().length() > 0)) {
          break label78;
        }
        paramContext = new StringBuilder();
        paramContext = "" + m;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          int m;
          int i;
          d.a(paramContext);
          d.b(paramContext.toString(), new Object[0]);
          paramContext = "";
        }
      }
      return paramContext;
    }
    finally {}
    paramContext = ((String)localObject).trim().replace('\n', ' ').replace('\r', ' ');
    paramContext = paramContext.replace("|", "%7C");
    Object localObject = paramContext.toCharArray();
    i = 0;
    while (i < localObject.length)
    {
      int n = localObject[i];
      int k = j;
      if (n == 46) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    if (j < 3)
    {
      d.a("[core] add versionCode: %s", new Object[] { Integer.valueOf(m) });
      paramContext = new StringBuilder().append(paramContext);
      paramContext = "." + m;
    }
    for (;;)
    {
      d.a("[core] final Version: %s", new Object[] { paramContext });
      break;
    }
  }
  
  public static void f(Context paramContext)
  {
    try
    {
      f localf = f.a(paramContext);
      String str = localf.a("last_app_version", "");
      paramContext = a(paramContext);
      if ((!j.b(str)) && (paramContext.equals(str)))
      {
        g = false;
        return;
      }
      g = true;
      localf = localf.b();
      localf.a("last_app_version", paramContext).a();
      return;
    }
    catch (Exception paramContext)
    {
      d.b("[core] app version check fail!", new Object[0]);
      d.a(paramContext);
    }
  }
  
  public static boolean g(Context paramContext)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        d.b("[core] context is null", new Object[0]);
        return bool2;
      }
      finally {}
      boolean bool1 = bool3;
      try
      {
        f localf = f.a(paramContext);
        bool1 = bool3;
        String str = localf.a("APPVER_DENGTA", null);
        bool1 = bool3;
        paramContext = a(paramContext);
        if (str != null)
        {
          bool1 = bool3;
          if (str.equals(paramContext)) {}
        }
        else
        {
          bool3 = true;
          bool2 = true;
          bool1 = bool3;
          localf = localf.b();
          bool1 = bool3;
          localf.a("APPVER_DENGTA", paramContext).a();
        }
      }
      catch (Exception paramContext)
      {
        d.b("[core] updateLocalAPPVER fail!", new Object[0]);
        d.a(paramContext);
        bool2 = bool1;
      }
    }
  }
  
  public static boolean h(Context paramContext)
  {
    return a(paramContext, paramContext.getPackageName());
  }
  
  public static boolean i(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = Boolean.valueOf(b(paramContext, "android.permission.READ_PHONE_STATE"));
      }
      d.a("[core] Read phone state permission: " + c, new Object[0]);
      boolean bool = c.booleanValue();
      return bool;
    }
    finally {}
  }
  
  public static boolean j(Context paramContext)
  {
    bool2 = false;
    bool1 = false;
    if (paramContext == null) {}
    for (;;)
    {
      f localf;
      String str3;
      String str2;
      String str1;
      try
      {
        d.b("[core] context is null", new Object[0]);
        return bool1;
      }
      finally {}
      try
      {
        localf = f.a(paramContext);
        str3 = localf.a("APPKEY_DENGTA", null);
        str2 = b.b;
        str1 = str2;
        if (j.b(str2)) {
          str1 = b.a(paramContext);
        }
        if (str3 != null)
        {
          boolean bool3 = str3.equals(str1);
          if (bool3) {
            continue;
          }
        }
        bool2 = true;
        bool1 = true;
        try
        {
          paramContext = localf.b();
          paramContext.a("APPKEY_DENGTA", str1).a();
        }
        catch (Exception paramContext)
        {
          bool1 = bool2;
        }
      }
      catch (Exception paramContext)
      {
        bool1 = bool2;
        continue;
      }
      d.b("[core] updateLocalAPPKEY fail!", new Object[0]);
      d.a(paramContext);
    }
  }
  
  public static boolean k(Context paramContext)
  {
    return g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.info.a
 * JD-Core Version:    0.7.0.1
 */
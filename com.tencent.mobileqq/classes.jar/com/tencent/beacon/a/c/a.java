package com.tencent.beacon.a.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.beacon.a.a.c;
import com.tencent.beacon.event.UserAction;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static boolean a = false;
  private static String b = null;
  private static String c = null;
  private static Boolean d = null;
  private static int e = 0;
  private static String f = "";
  
  public static String a()
  {
    if (!"".equals(f)) {
      return f;
    }
    try
    {
      if (e == 0) {
        e = Process.myPid();
      }
      f = f + e + "_";
      f += new Date().getTime();
    }
    catch (Exception localException)
    {
      label89:
      break label89;
    }
    return f;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        com.tencent.beacon.a.g.a.d("[core] context is null", new Object[0]);
        return bool2;
      }
      finally {}
      boolean bool1 = bool3;
      try
      {
        paramContext = c.a(paramContext);
        bool1 = bool3;
        String str1 = paramContext.a("APPKEY_DENGTA", null);
        bool1 = bool3;
        String str2 = b.a(UserAction.mContext).a();
        if (str1 != null)
        {
          bool1 = bool3;
          if (str1.equals(str2)) {}
        }
        else
        {
          bool1 = true;
          bool2 = true;
          paramContext.a().a("APPKEY_DENGTA", str2).b();
        }
      }
      catch (Exception paramContext)
      {
        com.tencent.beacon.a.g.a.d("[core] updateLocalAPPKEY fail!", new Object[0]);
        com.tencent.beacon.a.g.a.a(paramContext);
        bool2 = bool1;
      }
    }
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    int i = 0;
    boolean bool1;
    if (paramContext != null)
    {
      if (paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0) {
        bool1 = true;
      }
      for (;;)
      {
        if (bool1) {
          break label112;
        }
        try
        {
          paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
          if (paramContext != null)
          {
            int j = paramContext.length;
            for (;;)
            {
              if (i >= j) {
                break label87;
              }
              boolean bool2 = paramString.equals(paramContext[i]);
              if (bool2)
              {
                return true;
                bool1 = false;
                break;
              }
              i += 1;
            }
          }
          label87:
          return bool1;
        }
        catch (Throwable paramContext)
        {
          paramContext = paramContext;
          com.tencent.beacon.a.g.a.a(paramContext);
          return bool1;
        }
        finally {}
      }
    }
    com.tencent.beacon.a.g.a.d("[core] context or permission is null.", new Object[0]);
    return false;
    label112:
    return bool1;
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      com.tencent.beacon.a.g.a.d("[core] context is null", new Object[0]);
    }
    for (;;)
    {
      return false;
      try
      {
        paramContext = c.a(paramContext);
        String str1 = paramContext.a("APPVER_DENGTA", null);
        String str2 = b.a(UserAction.mContext).c();
        if (str1 != null)
        {
          bool = str1.equals(str2);
          if (bool) {}
        }
        else
        {
          bool = true;
          com.tencent.beacon.a.g.a.d("[core] updateLocalAPPKEY fail!", new Object[0]);
        }
      }
      catch (Exception paramContext)
      {
        try
        {
          paramContext.a().a("APPVER_DENGTA", str2).b();
          return true;
        }
        catch (Exception paramContext)
        {
          boolean bool;
          break;
        }
        paramContext = paramContext;
        bool = false;
      }
    }
    com.tencent.beacon.a.g.a.a(paramContext);
    return bool;
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {
      return false;
    }
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        com.tencent.beacon.a.g.a.c("[core] no running proc", new Object[0]);
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
          int i = 0;
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
      com.tencent.beacon.a.g.a.a(paramContext);
      com.tencent.beacon.a.g.a.d("[core] Failed to judge [%s]", new Object[] { paramContext.getLocalizedMessage() });
    }
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      paramContext = paramContext.getPackageName();
      if ((paramContext == null) || (paramContext.equals(""))) {}
      for (int i = 1; i != 0; i = 0) {
        return "";
      }
    }
  }
  
  public static String d(Context paramContext)
  {
    if (b == null) {
      b = e(paramContext);
    }
    return b;
  }
  
  protected static String e(Context paramContext)
  {
    int j = 0;
    label61:
    try
    {
      localObject = c(paramContext);
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
        localObject = paramContext.versionName;
        m = paramContext.versionCode;
        if ((localObject != null) && (((String)localObject).trim().length() > 0)) {
          break label61;
        }
        paramContext = String.valueOf(m);
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          int m;
          com.tencent.beacon.a.g.a.a(paramContext);
          com.tencent.beacon.a.g.a.d(paramContext.toString(), new Object[0]);
          paramContext = "";
        }
      }
      return paramContext;
    }
    finally {}
    paramContext = ((String)localObject).trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
    Object localObject = paramContext.toCharArray();
    int i = 0;
    for (;;)
    {
      int k;
      if (i < localObject.length)
      {
        k = j;
        if (localObject[i] == '.') {
          k = j + 1;
        }
      }
      else
      {
        if (j < 3)
        {
          paramContext = paramContext + "." + m;
          break;
        }
        break;
      }
      i += 1;
      j = k;
    }
  }
  
  public static boolean f(Context paramContext)
  {
    try
    {
      if (d == null) {
        d = Boolean.valueOf(a(paramContext, "android.permission.READ_PHONE_STATE"));
      }
      boolean bool = d.booleanValue();
      return bool;
    }
    finally {}
  }
  
  public static boolean g(Context paramContext)
  {
    return b(paramContext, paramContext.getPackageName());
  }
  
  public static int h(Context paramContext)
  {
    try
    {
      if (e == 0) {
        e = Process.myPid();
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == e)
        {
          int i = localRunningAppProcessInfo.importance;
          return i;
        }
      }
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static String i(Context paramContext)
  {
    if (c != null) {
      return c;
    }
    try
    {
      if (e == 0) {
        e = Process.myPid();
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == e)
        {
          paramContext = localRunningAppProcessInfo.processName;
          c = paramContext;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.a.g.a.a(paramContext);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.c.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.qz;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.luggage.wxa.rz.e;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public final class r
{
  private static Context a;
  private static String b = "package.unknown";
  private static String c = "";
  private static volatile Resources d;
  private static ActivityManager e;
  private static r.a f;
  
  public static Context a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    a = paramContext;
    b = paramContext.getPackageName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setup application context for package: ");
    localStringBuilder.append(b);
    o.e("MicroMsg.MMApplicationContext", localStringBuilder.toString());
    e.a(paramContext, new ae());
  }
  
  public static void a(Resources paramResources)
  {
    d = paramResources;
  }
  
  public static void a(r.a parama)
  {
    f = parama;
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = a;
    if (localObject != null)
    {
      if (b == null) {
        return false;
      }
      if (e == null) {
        e = (ActivityManager)((Context)localObject).getSystemService("activity");
      }
      try
      {
        localObject = e.getRunningAppProcesses().iterator();
        while (((Iterator)localObject).hasNext())
        {
          boolean bool = ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals(paramString);
          if (bool) {
            return true;
          }
        }
        return false;
      }
      catch (Error paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isMMProcessExist Error: ");
        ((StringBuilder)localObject).append(paramString.toString());
        o.b("MicroMsg.MMApplicationContext", ((StringBuilder)localObject).toString());
        return false;
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isMMProcessExist Exception: ");
        ((StringBuilder)localObject).append(paramString.toString());
        o.b("MicroMsg.MMApplicationContext", ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  public static String b()
  {
    return b;
  }
  
  public static String b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return Application.getProcessName();
    }
    try
    {
      String str = j();
      return str;
    }
    catch (Exception localException)
    {
      label18:
      break label18;
    }
    return af.b(paramContext, Process.myPid());
  }
  
  public static String c()
  {
    String str = c;
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    str = b(a);
    c = str;
    return str;
  }
  
  public static Resources d()
  {
    return d;
  }
  
  public static AssetManager e()
  {
    AssetManager localAssetManager = a.getAssets();
    r.a locala = f;
    if (locala == null) {
      return localAssetManager;
    }
    return locala.a(localAssetManager);
  }
  
  public static String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("_preferences");
    return localStringBuilder.toString();
  }
  
  public static SharedPreferences g()
  {
    Context localContext = a;
    if (localContext != null) {
      return localContext.getSharedPreferences(f(), 0);
    }
    return null;
  }
  
  public static boolean h()
  {
    String str = c();
    if (str == null) {
      return true;
    }
    return (!str.contains(":")) && (str.startsWith(b));
  }
  
  public static String i()
  {
    return b;
  }
  
  @SuppressLint({"PrivateApi"})
  private static String j()
  {
    Object localObject = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
    ((Method)localObject).setAccessible(true);
    String str = null;
    localObject = ((Method)localObject).invoke(null, new Object[0]);
    if ((localObject instanceof String)) {
      str = (String)localObject;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.r
 * JD-Core Version:    0.7.0.1
 */
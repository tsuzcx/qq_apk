package com.tencent.beacon.module;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.beacon.a.a.d;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.c.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AuditModule
  implements d, BeaconModule
{
  private boolean a = true;
  private boolean b = true;
  private String c;
  private Set<String> d;
  private int e = 2;
  private Context f;
  
  public static String a()
  {
    ArrayList localArrayList = com.tencent.beacon.base.util.b.a(new String[] { "/system/bin/sh", "-c", "getprop ro.build.fingerprint" });
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  private String a(String paramString)
  {
    if (paramString != null)
    {
      String str = paramString.replace("=", "%3D").replace("/", "%2F").replace("+", "%2B");
      paramString = str;
      if (str.length() > 1024)
      {
        paramString = new StringBuilder();
        paramString.append(str);
        paramString.append(";");
        return paramString.toString();
      }
    }
    else
    {
      paramString = "";
    }
    return paramString;
  }
  
  @SuppressLint({"NewApi"})
  public static String b(Context paramContext)
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      if (i < 9)
      {
        com.tencent.beacon.base.util.c.b("[audit] Api level < 9,return null!", new Object[0]);
        return "";
      }
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[audit] get app_first_installed_time:");
      localStringBuilder.append(String.valueOf(paramContext.firstInstallTime));
      com.tencent.beacon.base.util.c.a(localStringBuilder.toString(), new Object[0]);
      long l = paramContext.firstInstallTime;
      return String.valueOf(l);
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.base.util.c.a(paramContext);
    }
    return "";
  }
  
  private String c()
  {
    if (com.tencent.beacon.e.b.a() != null)
    {
      String str = this.c;
      if (str != null) {
        return str;
      }
    }
    return "";
  }
  
  private Activity d()
  {
    if (Integer.valueOf(Build.VERSION.SDK).intValue() < 16) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        str = e();
        if (str == null) {
          return null;
        }
        localSparseArray = com.tencent.beacon.d.a.c.a();
        if (localSparseArray != null) {
          break label121;
        }
        return null;
      }
      catch (Exception localException)
      {
        String str;
        SparseArray localSparseArray;
        Object localObject;
        boolean bool;
        com.tencent.beacon.base.util.c.a(localException);
      }
      if (i < localSparseArray.size())
      {
        localObject = (WeakReference)localSparseArray.get(localSparseArray.keyAt(i));
        if ((localObject != null) && (((WeakReference)localObject).get() != null))
        {
          localObject = (Activity)((WeakReference)localObject).get();
          bool = localObject.getClass().getName().equals(str);
          if (bool) {
            return localObject;
          }
        }
        i += 1;
      }
      else
      {
        return null;
        label121:
        i = 0;
      }
    }
  }
  
  private String e()
  {
    Intent localIntent = this.f.getPackageManager().getLaunchIntentForPackage(this.f.getPackageName());
    if (localIntent != null) {
      return localIntent.getComponent().getClassName();
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    this.f = paramContext;
    com.tencent.beacon.a.a.b.a().a(2, this);
    com.tencent.beacon.a.a.b.a().a(10, this);
  }
  
  public void b()
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    if (!com.tencent.beacon.a.c.b.g((Context)localObject)) {
      return;
    }
    com.tencent.beacon.base.util.c.a("[audit] start upload ac event", new Object[0]);
    f localf = f.p();
    HashMap localHashMap = new HashMap();
    localHashMap.put("A19", localf.w());
    localHashMap.put("A133", localf.d());
    boolean bool = localf.q();
    String str = "Y";
    if (bool) {
      localObject = "Y";
    } else {
      localObject = "N";
    }
    localHashMap.put("A58", localObject);
    localHashMap.put("A82", a());
    if (com.tencent.beacon.a.c.b.d) {
      localObject = str;
    } else {
      localObject = "N";
    }
    localHashMap.put("A85", localObject);
    localHashMap.put("A88", b(this.f));
    localHashMap.put("A89", localf.a(this.f));
    localHashMap.put("A90", "");
    localHashMap.put("A91", "");
    localHashMap.put("A92", "");
    localHashMap.put("B13", a(a.a(this.f, Integer.valueOf(Build.VERSION.SDK).intValue(), d(), c(), this.e)));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(localf.v());
    localHashMap.put("A31", ((StringBuilder)localObject).toString());
    ((StatModule)com.tencent.beacon.a.c.c.d().a(ModuleName.STAT)).a(localHashMap);
  }
  
  public void onEvent(com.tencent.beacon.a.a.c paramc)
  {
    int i = paramc.a;
    boolean bool3 = false;
    if (i != 2)
    {
      if (i != 10) {
        return;
      }
      com.tencent.beacon.base.util.c.d("[module] native audit module > %s", new Object[] { Boolean.valueOf(this.b) });
      if ((this.b) && (com.tencent.beacon.e.b.a().e())) {
        b();
      }
    }
    else
    {
      paramc = (Map)paramc.b.get("d_m");
      if (paramc == null) {
        return;
      }
      this.a = com.tencent.beacon.base.util.b.a((String)paramc.get("upAc"), this.a);
      this.e = com.tencent.beacon.base.util.b.a((String)paramc.get("deleteSoCrashTime"), this.e, 1, 10);
      this.c = ((String)paramc.get("appendXMeths"));
      paramc = (String)paramc.get("auditIgnore");
      if (!TextUtils.isEmpty(paramc)) {
        this.d = new HashSet(Arrays.asList(paramc.split(",")));
      }
      boolean bool1;
      if (this.d != null)
      {
        paramc = new StringBuilder();
        paramc.append(Build.MODEL);
        paramc.append("_");
        paramc.append(Build.VERSION.SDK);
        paramc = paramc.toString();
        bool1 = this.d.contains(paramc.replaceAll(" ", "")) ^ true;
      }
      else
      {
        bool1 = true;
      }
      boolean bool2 = bool3;
      if (this.a)
      {
        bool2 = bool3;
        if (bool1) {
          bool2 = true;
        }
      }
      this.b = bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.module.AuditModule
 * JD-Core Version:    0.7.0.1
 */
package com.sixgod.pluginsdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Instrumentation;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.Window;
import com.sixgod.pluginsdk.apkmanager.c;
import com.sixgod.pluginsdk.component.ContainerActivity;
import com.sixgod.pluginsdk.exception.SixGodException;
import com.sixgod.pluginsdk.log.SGLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e
{
  protected ClassLoader a;
  protected Context b;
  protected ClassLoader c;
  protected PluginLoadParams d;
  protected com.sixgod.pluginsdk.apkmanager.a e;
  protected com.sixgod.pluginsdk.a.a f;
  protected com.sixgod.pluginsdk.component.a g;
  protected Map h = new HashMap();
  protected Map i = new HashMap();
  protected ArrayList j = new ArrayList();
  protected ArrayList k = new ArrayList();
  protected Map l = new HashMap();
  protected Map m = new HashMap();
  protected boolean n = false;
  public String o = "";
  public b p;
  protected Object q = new Object();
  protected Object r = new Object();
  protected BroadcastReceiver s;
  protected Handler t = new g(this, Looper.getMainLooper());
  
  private void b(Context paramContext, PluginLoadParams paramPluginLoadParams)
  {
    int i1 = 0;
    Object localObject2;
    for (;;)
    {
      try
      {
        this.d = paramPluginLoadParams;
        this.b = paramContext;
        int i2 = Process.myPid();
        ??? = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
        if (((Iterator)???).hasNext())
        {
          localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)???).next();
          if (((ActivityManager.RunningAppProcessInfo)localObject2).pid == i2)
          {
            ??? = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
            this.o = ((String)???);
            this.p = new b(paramContext, paramPluginLoadParams, this.o);
            if (!paramPluginLoadParams.useBootClassLoader) {
              break;
            }
            this.a = paramContext.getClassLoader().getParent();
            if (this.a.getParent() == null) {
              break label162;
            }
            this.a = this.a.getParent();
          }
        }
        else
        {
          ??? = "";
        }
      }
      finally {}
    }
    this.a = paramContext.getClassLoader();
    label162:
    if ((paramPluginLoadParams.libList != null) && (paramPluginLoadParams.libList.size() != 0)) {
      ??? = new StringBuilder();
    }
    for (;;)
    {
      if (i1 < paramPluginLoadParams.libList.size())
      {
        if (i1 != paramPluginLoadParams.libList.size() - 1) {
          ((StringBuilder)???).append((String)paramPluginLoadParams.libList.get(i1)).append(File.pathSeparator);
        } else {
          ((StringBuilder)???).append((String)paramPluginLoadParams.libList.get(i1));
        }
      }
      else
      {
        for (this.c = new DexClassLoader(((StringBuilder)???).toString(), paramContext.getDir("dex", 0).getAbsolutePath(), null, this.a); (paramPluginLoadParams.singleTaskContainers != null) && (paramPluginLoadParams.singleTaskContainers.size() > 0); this.c = this.a)
        {
          ??? = paramPluginLoadParams.singleTaskContainers.iterator();
          while (((Iterator)???).hasNext())
          {
            localObject2 = (Class)((Iterator)???).next();
            this.j.add(((Class)localObject2).getName());
          }
        }
        if ((paramPluginLoadParams.singleTopContainers != null) && (paramPluginLoadParams.singleTopContainers.size() > 0))
        {
          ??? = paramPluginLoadParams.singleTopContainers.iterator();
          while (((Iterator)???).hasNext())
          {
            localObject2 = (Class)((Iterator)???).next();
            this.k.add(((Class)localObject2).getName());
          }
        }
        this.f = new com.sixgod.pluginsdk.a.a(this.a);
        this.e = new com.sixgod.pluginsdk.apkmanager.a(paramContext, this.f, this.c);
        if (Looper.myLooper() == Looper.getMainLooper()) {
          this.e.b();
        }
        for (;;)
        {
          this.g = new com.sixgod.pluginsdk.component.a(paramContext, this.e);
          if (paramPluginLoadParams.componentMap != null) {
            this.h.putAll(paramPluginLoadParams.componentMap);
          }
          if (paramPluginLoadParams.serviceActionMap != null) {
            this.i.putAll(paramPluginLoadParams.serviceActionMap);
          }
          if (this.s == null)
          {
            this.s = new f(this);
            paramPluginLoadParams = new IntentFilter("com.sixgod.pluginsdk.unload_plugin.ACTION");
            SGLog.a("sixgodloader  registerUnLoadReceiver");
          }
          try
          {
            paramContext.registerReceiver(this.s, paramPluginLoadParams);
            return;
            synchronized (this.q)
            {
              Message.obtain(this.t, 1001).sendToTarget();
            }
            try
            {
              this.q.wait();
              continue;
              paramContext = finally;
              throw paramContext;
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                localInterruptedException.printStackTrace();
              }
            }
          }
          catch (Throwable paramContext)
          {
            for (;;)
            {
              paramContext.printStackTrace();
            }
          }
        }
      }
      i1 += 1;
    }
  }
  
  public final Activity a(ContainerActivity paramContainerActivity, Intent paramIntent, Bundle paramBundle)
  {
    SGLog.a("ContainerActiivty createInnerActivity...");
    Object localObject1 = (Intent)paramIntent.getParcelableExtra("plugin_intent");
    if (localObject1 == null) {
      localObject1 = new Intent();
    }
    for (;;)
    {
      String str = paramIntent.getStringExtra("packageName");
      paramIntent = paramIntent.getStringExtra("className");
      SGLog.a("pkg = " + str + " clz = " + paramIntent);
      Object localObject2;
      if (TextUtils.isEmpty(paramIntent))
      {
        paramIntent = this.e;
        localObject2 = this.d.pkgName;
        paramIntent = (c)paramIntent.e.get(localObject2);
        if (paramIntent == null)
        {
          paramIntent = null;
          if ((c)this.e.e.get(str) != null) {
            break label162;
          }
        }
      }
      label162:
      ActivityInfo localActivityInfo;
      do
      {
        do
        {
          return null;
          paramIntent = paramIntent.f;
          break;
          paramIntent = new ComponentName(str, paramIntent);
          break;
          localObject2 = (c)this.e.e.get(str);
          if (localObject2 != null) {
            break label436;
          }
          localObject2 = null;
          ((Intent)localObject1).setExtrasClassLoader((ClassLoader)localObject2);
          localActivityInfo = this.e.a(paramIntent);
        } while (localActivityInfo == null);
        ((Intent)localObject1).setClassName(str, paramIntent.getClassName());
        paramIntent = (IBinder)this.f.bd.a(paramContainerActivity);
        SGLog.a("ContainerActiivty createInnerActivity startActivity now...\n pkg = " + localActivityInfo.packageName + " classname = " + localActivityInfo.name);
        long l1 = System.currentTimeMillis();
        paramIntent = this.e.a(localActivityInfo, (Intent)localObject1, paramBundle, (ClassLoader)localObject2, paramIntent, paramContainerActivity);
        SGLog.a("sixgod_perf", "startActivityNow dtime = " + (System.currentTimeMillis() - l1));
      } while (paramIntent == null);
      localObject1 = paramIntent.getParent();
      this.f.N.a(paramIntent, new Object[] { null });
      if (paramIntent != null) {
        this.f.G.a(paramIntent, new Object[] { paramBundle });
      }
      if (localActivityInfo.labelRes != 0) {
        paramIntent.setTitle(paramIntent.getResources().getString(localActivityInfo.labelRes));
      }
      for (;;)
      {
        this.f.N.a(paramIntent, new Object[] { localObject1 });
        paramIntent.getWindow().setContainer(paramContainerActivity.getWindow());
        return paramIntent;
        label436:
        localObject2 = ((c)localObject2).b;
        break;
        paramBundle = paramIntent.getResources().getString(localActivityInfo.applicationInfo.labelRes);
        if (localActivityInfo.applicationInfo.labelRes != 0) {
          paramIntent.setTitle(paramBundle);
        }
      }
    }
  }
  
  public final String a(int paramInt)
  {
    if (paramInt == 1) {}
    synchronized (this.j)
    {
      while (???.size() != 0)
      {
        String str = (String)???.get(0);
        ???.remove(str);
        return str;
        ??? = this.k;
      }
      return null;
    }
  }
  
  public final String a(String paramString)
  {
    return (String)this.h.get(paramString);
  }
  
  public final void a()
  {
    try
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        Object localObject1 = this.e;
        Object localObject3 = this.d.pkgName;
        localObject1 = (c)((com.sixgod.pluginsdk.apkmanager.a)localObject1).e.get(localObject3);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((c)localObject1).e)
        {
          try
          {
            localObject3 = localObject1.getClass().getDeclaredMethod("preOnCreate", new Class[] { Bundle.class });
            if (localObject3 != null) {
              ((Method)localObject3).invoke(localObject1, new Object[] { this.d.preOnCreateExtras });
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localThrowable.printStackTrace();
            }
          }
          localObject3 = (Instrumentation)this.f.aW.a(this.e.a());
          SGLog.a("sixgod start to callApplicationOnCreate");
          ((Instrumentation)localObject3).callApplicationOnCreate((Application)localObject1);
          SGLog.a("sixgod  callApplicationOnCreate finish,callAppOnCreateSucc");
          this.p.b();
          this.p.a();
          return;
        }
      }
      try
      {
        synchronized (this.r)
        {
          Message.obtain(this.t, 1000).sendToTarget();
          this.r.wait();
          return;
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      SGLog.a("  callApplicationOnCreate RuntimeException");
      this.p.a(6, localRuntimeException.getMessage());
      localRuntimeException.printStackTrace();
      return;
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    if (paramInt == 1) {}
    synchronized (this.j)
    {
      if (!???.contains(paramString)) {
        ???.add(paramString);
      }
      SGLog.a("SpecialTest", "recycleSpecialActivity + list = " + ???.toString());
      return;
      ??? = this.k;
    }
  }
  
  public final boolean a(Context paramContext, PluginLoadParams paramPluginLoadParams)
  {
    try
    {
      b(paramContext, paramPluginLoadParams);
      SGLog.a("SixGod_PluginSdk", "loadPlugin:" + paramPluginLoadParams.apkPath + "," + paramPluginLoadParams.pkgName + "," + this.o);
      if ((!TextUtils.isEmpty(paramPluginLoadParams.apkPath)) && (!TextUtils.isEmpty(paramPluginLoadParams.pkgName))) {
        break label141;
      }
      if (paramPluginLoadParams.pluginLoadCallBack != null) {
        throw new SixGodException("apkPath and pkgName must not be empty:" + paramPluginLoadParams.apkPath + "," + paramPluginLoadParams.pkgName);
      }
    }
    finally {}
    boolean bool = false;
    for (;;)
    {
      return bool;
      label141:
      paramContext = this.e;
      Object localObject1 = paramPluginLoadParams.pkgName;
      paramContext = (c)paramContext.e.get(localObject1);
      if (paramContext == null)
      {
        long l1;
        try
        {
          l1 = System.currentTimeMillis();
          paramContext = this.e.a(paramPluginLoadParams.apkPath, paramPluginLoadParams.pluginResourceFlag, paramPluginLoadParams.useJni, paramPluginLoadParams.defaultUseActionBar, paramPluginLoadParams.versionName, paramPluginLoadParams.supportMultidex, paramPluginLoadParams.supportSpeedyClassloader);
          if ((paramContext == null) || (paramContext.a.equals(paramPluginLoadParams.pkgName))) {
            break label292;
          }
          throw new SixGodException("pkg name!=params pkg = " + paramPluginLoadParams.pkgName + " parsed pkg = " + paramContext.a);
        }
        catch (Exception paramContext)
        {
          this.p.a(5, paramContext.getMessage());
          paramContext.printStackTrace();
          bool = false;
        }
        continue;
        label292:
        SGLog.a("SixGod_PluginSdk", "loadPlugin: loadedApk dTime = " + (System.currentTimeMillis() - l1));
        if (!this.n)
        {
          paramContext = this.e;
          paramPluginLoadParams = paramPluginLoadParams.pkgName;
          paramContext = ((c)paramContext.e.get(paramPluginLoadParams)).h;
          if (paramContext != null)
          {
            paramPluginLoadParams = paramContext.iterator();
            while (paramPluginLoadParams.hasNext())
            {
              Object localObject2 = paramPluginLoadParams.next();
              localObject1 = (ActivityInfo)this.f.aF.a(localObject2);
              localObject2 = (List)this.f.bb.a(localObject2);
              this.g.a((ActivityInfo)localObject1, (List)localObject2);
            }
          }
          paramPluginLoadParams = new StringBuilder("loadPlugin: registerBroadCast, ");
          if (paramContext == null) {}
          for (int i1 = 0;; i1 = paramContext.size())
          {
            SGLog.a("SixGod_PluginSdk", i1);
            this.n = true;
            break;
          }
        }
      }
      bool = true;
    }
  }
  
  public final String b()
  {
    return this.d.defaultActivityContainer;
  }
  
  public final String b(String paramString)
  {
    String str = (String)this.h.get(paramString);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = this.d.defaultServiceContainer;
    }
    return paramString;
  }
  
  public final void b(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      this.l.remove(paramString);
    }
    while (paramInt != 2) {
      return;
    }
    this.m.remove(paramString);
  }
  
  public final com.sixgod.pluginsdk.apkmanager.a c()
  {
    try
    {
      com.sixgod.pluginsdk.apkmanager.a locala = this.e;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String c(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      return (String)this.l.get(paramString);
    }
    if (paramInt == 2) {
      return (String)this.m.get(paramString);
    }
    return null;
  }
  
  public final String c(String paramString)
  {
    return (String)this.h.get(paramString);
  }
  
  public final com.sixgod.pluginsdk.a.a d()
  {
    try
    {
      com.sixgod.pluginsdk.a.a locala = this.f;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean d(String paramString)
  {
    this.e.a(paramString);
    this.g.a();
    return true;
  }
  
  public final PluginLoadParams e()
  {
    try
    {
      PluginLoadParams localPluginLoadParams = this.d;
      return localPluginLoadParams;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.e
 * JD-Core Version:    0.7.0.1
 */
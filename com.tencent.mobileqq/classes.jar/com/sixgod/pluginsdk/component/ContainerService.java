package com.sixgod.pluginsdk.component;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import com.sixgod.pluginsdk.PluginLoadParams;
import com.sixgod.pluginsdk.SixGodHelper;
import com.sixgod.pluginsdk.a.f;
import com.sixgod.pluginsdk.a.g;
import com.sixgod.pluginsdk.apkmanager.PluginResources;
import com.sixgod.pluginsdk.apkmanager.SixGodContext;
import com.sixgod.pluginsdk.apkmanager.c;
import com.sixgod.pluginsdk.b;
import com.sixgod.pluginsdk.log.SGLog;
import com.sixgod.pluginsdk.log.SixGodReporter;
import java.io.File;
import java.util.HashMap;

public class ContainerService
  extends Service
{
  Service a;
  com.sixgod.pluginsdk.apkmanager.a b = null;
  com.sixgod.pluginsdk.a.a c = null;
  ClassLoader d;
  com.sixgod.pluginsdk.e e;
  PluginLoadParams f = null;
  
  private boolean a(Intent paramIntent)
  {
    Object localObject1 = null;
    g localg = null;
    for (;;)
    {
      String str2;
      String str1;
      try
      {
        if (this.a != null) {
          break label1164;
        }
        str2 = paramIntent.getStringExtra("packageName");
        str1 = paramIntent.getStringExtra("className");
        this.e = SixGodHelper.getPluginLoader(str2);
        if (this.e != null)
        {
          SGLog.a("SixGod_PluginSdk.ContainerService", "createService mPluginLoader!=null, plugin already loaded");
          this.f = this.e.e();
          SGLog.a("SixGod_PluginSdk.ContainerService", "createService container= " + this + ", innerClass=" + str1 + ", process=" + Process.myPid());
          if (!new File(this.f.apkPath).exists())
          {
            SGLog.b("SixGod_PluginSdk.ContainerService", "异常场景,理论上不应该走到，启动service的时候，apk文件不存在，这种情况直接stopservice,不处理。");
            super.stopSelf();
            bool = false;
            return bool;
          }
        }
        else
        {
          this.f = PluginLoadParams.parseFromJson(paramIntent.getStringExtra("plugin_load_params"));
          continue;
        }
        this.e = SixGodHelper.getPluginLoader(str2);
      }
      finally {}
      label196:
      label212:
      label225:
      c localc;
      label348:
      Application localApplication;
      if (this.e == null)
      {
        SixGodHelper.loadPlugin(getApplicationContext(), this.f);
        break label1140;
        for (;;)
        {
          if (!bool) {
            break label225;
          }
          SGLog.c("SixGod_PluginSdk.ContainerService", "createService isPreload=true, return after preload");
          bool = false;
          break;
          bool = TextUtils.isEmpty(paramIntent.getStringExtra("className"));
        }
        this.e = SixGodHelper.getPluginLoader(str2);
        if (this.e != null)
        {
          this.c = this.e.d();
          this.b = this.e.c();
          localc = (c)this.b.e.get(str2);
          if (localc == null)
          {
            SGLog.b("SixGod_PluginSdk.ContainerService", "create Activity Failed! msg = appInfo null, not installed or unLaunched!");
            SixGodReporter.reportInfo("StartService", 0, 1, "", "", SixGodReporter.sDevInfo, "appInfo null");
            super.stopSelf();
            bool = false;
          }
        }
        else
        {
          super.stopSelf();
          bool = false;
          continue;
        }
        paramIntent = (c)this.b.e.get(str2);
        if (paramIntent == null)
        {
          paramIntent = null;
          this.d = paramIntent;
          localApplication = localc.e;
        }
      }
      for (;;)
      {
        Object localObject2;
        try
        {
          this.a = ((Service)this.d.loadClass(str1).newInstance());
          localObject2 = this.c.at.a(null);
          if (localObject2 == null) {
            break label1135;
          }
          Object localObject3 = this.c.O;
          paramIntent = (c)this.b.e.get(str2);
          if (paramIntent == null)
          {
            paramIntent = null;
            paramIntent = ((g)localObject3).a(localObject2, new Object[] { paramIntent, null, this.b.a() });
            if (!(paramIntent instanceof Boolean)) {
              break label1135;
            }
            bool = ((Boolean)paramIntent).booleanValue();
            break label1149;
            localObject3 = this.c.be.a(this);
            if (!this.c.U.a()) {
              continue;
            }
            localObject1 = this.c.U;
            localObject2 = this.b.a();
            paramIntent = (c)this.b.e.get(str2);
            if (paramIntent != null) {
              continue;
            }
            paramIntent = localg;
            paramIntent = ((g)localObject1).a(null, new Object[] { localObject2, paramIntent, localObject3 });
            if ((paramIntent != null) && (!(paramIntent instanceof Boolean))) {
              break label1130;
            }
            paramIntent = getBaseContext();
            i = 1;
            if (i != 0) {
              continue;
            }
            this.c.P.a(paramIntent, new Object[] { this.a });
            paramIntent = new SixGodContext((Context)paramIntent, str2, this.b, getApplicationContext());
            this.c.Q.a(this.a, new Object[] { paramIntent, this.b.a(), str1, null, localApplication, null });
            if (this.a == null) {
              continue;
            }
            this.a.onCreate();
            paramIntent = "service success! class = " + this.a.getClass().getName();
            SixGodReporter.reportInfo("StartService", 0, 0, "", "", SixGodReporter.sDevInfo, paramIntent);
            break label1164;
            paramIntent = paramIntent.b;
            break label348;
          }
          paramIntent = paramIntent.d;
          continue;
          paramIntent = paramIntent.d;
          continue;
          if (this.c.V.a())
          {
            localg = this.c.V;
            localObject2 = this.b.a();
            paramIntent = (c)this.b.e.get(str2);
            if (paramIntent == null)
            {
              paramIntent = (Intent)localObject1;
              paramIntent = localg.a(null, new Object[] { localObject2, paramIntent, Integer.valueOf(0), null });
              continue;
            }
            paramIntent = paramIntent.d;
            continue;
          }
          if (this.c.W.a())
          {
            localg = this.c.W;
            localObject1 = this.b.a();
            paramIntent = (c)this.b.e.get(str2);
            if (paramIntent == null)
            {
              paramIntent = null;
              paramIntent = localg.a(null, new Object[] { localObject1, paramIntent, localObject3, Integer.valueOf(0), null });
              continue;
            }
            paramIntent = paramIntent.d;
            continue;
          }
          SGLog.b("SixGod_PluginSdk.ContainerService", "createSerivceContext failed ins create Service.");
          paramIntent = localObject2;
          continue;
        }
        catch (Exception localException)
        {
          if (this.a == null)
          {
            paramIntent = "";
            paramIntent = "exception happaned! msg = " + localException.getMessage() + " class = " + paramIntent;
            SixGodReporter.reportInfo("StartService", 0, 1, "", "", SixGodReporter.sDevInfo, paramIntent);
            SixGodReporter.reportException("StartServiceExp", localException);
            bool = false;
            break;
            paramIntent = new SixGodContext((Context)paramIntent, str2, this.d, localc.k.a(), localc.k.b(), this.b, getApplicationContext());
            continue;
          }
          paramIntent = this.a.getClass().getName();
          continue;
          SixGodReporter.reportInfo("StartService", 0, 1, "", "", SixGodReporter.sDevInfo, "service null");
        }
        label1130:
        int i = 0;
        continue;
        label1135:
        bool = false;
        break label1149;
        label1140:
        if (paramIntent != null) {
          break label212;
        }
        bool = false;
        break label196;
        label1149:
        if (localObject2 != null)
        {
          paramIntent = localObject2;
          if (bool) {}
        }
      }
      label1164:
      boolean bool = true;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    SGLog.a("SixGod_PluginSdk.ContainerService", "ContainerService onBind:" + this);
    if (this.a == null) {}
    try
    {
      a(paramIntent);
      paramIntent = (Intent)paramIntent.getParcelableExtra("plugin_intent");
      if (this.a != null) {
        return this.a.onBind(paramIntent);
      }
    }
    catch (Exception paramIntent)
    {
      SGLog.a("SixGod_PluginSdk.ContainerService", "create service failed ! msg = " + paramIntent.getMessage());
      paramIntent.printStackTrace();
      super.stopSelf();
      return null;
    }
    return null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.a != null) {
      this.a.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate()
  {
    SGLog.a("SixGod_PluginSdk.ContainerService", "ContainerService onCreate:" + this);
    super.onCreate();
  }
  
  public void onDestroy()
  {
    SGLog.a("SixGod_PluginSdk.ContainerService", "ContainerService onDestroy:" + this);
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
  
  public void onLowMemory()
  {
    if (this.a != null) {
      this.a.onLowMemory();
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramIntent == null)
    {
      bool = false;
      SGLog.a("SixGod_PluginSdk.ContainerService", "ContainerService onStartCommand:" + paramInt2 + ", isPreload=" + bool + ", " + this);
      if (this.a != null) {
        break label147;
      }
    }
    for (;;)
    {
      try
      {
        a(paramIntent);
        if (!bool) {
          break label179;
        }
        SGLog.c("SixGod_PluginSdk.ContainerService", "onStartCommand isPreload, stopSelf:" + paramInt2);
        stopSelf(paramInt2);
        return 2;
      }
      catch (Exception paramIntent)
      {
        SGLog.b("SixGod_PluginSdk.ContainerService", "create service failed ! msg = " + paramIntent.getMessage());
        paramIntent.printStackTrace();
        super.stopSelf();
        return 2;
      }
      bool = TextUtils.isEmpty(paramIntent.getStringExtra("className"));
      break;
      label147:
      if (bool)
      {
        SixGodHelper.getPluginLoader(this.f.pkgName).p.a();
        SGLog.a("SixGod_PluginSdk.ContainerService", "onStartCommand, callback loadPluginSucc");
      }
    }
    label179:
    if (this.a != null)
    {
      Object localObject = null;
      if (paramIntent != null) {}
      for (paramIntent = (Intent)paramIntent.getParcelableExtra("plugin_intent");; paramIntent = localObject)
      {
        return this.a.onStartCommand(paramIntent, paramInt1, paramInt2);
        SGLog.a("SixGod_PluginSdk.ContainerService", "intent==null");
      }
    }
    return 2;
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (this.a != null) {
      this.a.onTrimMemory(paramInt);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    SGLog.a("SixGod_PluginSdk.ContainerService", "ContainerService onUnbind:" + this);
    if (this.a != null) {
      return this.a.onUnbind(paramIntent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.component.ContainerService
 * JD-Core Version:    0.7.0.1
 */
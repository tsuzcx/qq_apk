package com.tencent.comic;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.text.TextUtils;
import com.tencent.comic.api.IQQComicPluginUtil.ExtraResult;
import com.tencent.comic.api.plugin.IQQComicPluginPreloadStrategy.PluginPreloadInfo;
import com.tencent.comic.utils.AppHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

final class PluginPreloader$1
  implements Runnable
{
  PluginPreloader$1(String paramString, PluginPreloadStrategy paramPluginPreloadStrategy) {}
  
  public void run()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("do real plugin preload: processName=");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("PluginPreloader", 2, ((StringBuilder)localObject1).toString());
    }
    AppRuntime localAppRuntime = AppHelper.b();
    int n = (int)(DeviceInfoUtil.r() >> 20);
    Object localObject2 = this.b.a.h;
    int i1 = this.b.a.e;
    int i = this.b.a.f;
    int j = this.b.a.g;
    int i2 = this.b.a.b;
    try
    {
      localObject1 = new IQQComicPluginUtil.ExtraResult();
      Object localObject3 = ((ActivityManager)AppHelper.a().getSystemService("activity")).getRunningAppProcesses();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject3).next();
            if (this.a.equals(localRunningAppProcessInfo.processName))
            {
              if ((this.b.a.i) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!QIPCServerHelper.getInstance().isModuleRunning((String)localObject2)))
              {
                if (QLog.isColorLevel())
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("pluginType:");
                  ((StringBuilder)localObject3).append(i1);
                  ((StringBuilder)localObject3).append("  preload:ok:loadmodule ");
                  ((StringBuilder)localObject3).append((String)localObject2);
                  QLog.d("PluginPreloader", 2, ((StringBuilder)localObject3).toString());
                }
                ((IQQComicPluginUtil.ExtraResult)localObject1).a = 1;
                ((IQQComicPluginUtil.ExtraResult)localObject1).b = "preload:ok:loadmodule";
                PluginPreloader.a(localAppRuntime, this.b, n, (IQQComicPluginUtil.ExtraResult)localObject1);
                return;
              }
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("pluginType:");
                ((StringBuilder)localObject1).append(i1);
                ((StringBuilder)localObject1).append("  preload:fail:procexist ");
                ((StringBuilder)localObject1).append(this.a);
                QLog.d("PluginPreloader", 2, ((StringBuilder)localObject1).toString());
              }
            }
          }
        }
      }
      try
      {
        PluginPreloadReportUtils.a(localAppRuntime, 1, i1, i, 3, "preload:fail:procexist", n, new String[] { String.valueOf(j) });
        return;
      }
      catch (Exception localException2) {}
      int k = j;
      int m = i;
      if (!this.b.a((IQQComicPluginUtil.ExtraResult)localObject1))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.a);
          ((StringBuilder)localObject2).append(" is not allowed to preload.");
          QLog.d("PluginPreloader", 2, ((StringBuilder)localObject2).toString());
        }
        PluginPreloadReportUtils.a(localAppRuntime, 1, i1, m, ((IQQComicPluginUtil.ExtraResult)localObject1).a, ((IQQComicPluginUtil.ExtraResult)localObject1).b, n, new String[] { String.valueOf(k) });
        return;
      }
      if (n < i2)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("pluginType:");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append("  preload:fail:memorylimit (");
          ((StringBuilder)localObject1).append(n);
          ((StringBuilder)localObject1).append("MB)");
          QLog.d("PluginPreloader", 2, ((StringBuilder)localObject1).toString());
        }
        PluginPreloadReportUtils.a(localAppRuntime, 1, i1, m, 3, "preload:fail:memorylimit", n, new String[] { String.valueOf(k), String.valueOf(i2) });
        return;
      }
      if (!this.b.b((IQQComicPluginUtil.ExtraResult)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "the plugin is inactive.");
        }
        i2 = ((IQQComicPluginUtil.ExtraResult)localObject1).a;
        localObject1 = ((IQQComicPluginUtil.ExtraResult)localObject1).b;
      }
      try
      {
        PluginPreloadReportUtils.a(localAppRuntime, 1, i1, m, i2, (String)localObject1, n, new String[] { String.valueOf(k) });
        return;
      }
      catch (Exception localException1) {}
      PluginPreloader.a(localAppRuntime, this.b, n, (IQQComicPluginUtil.ExtraResult)localObject1);
      return;
    }
    catch (Exception localException3) {}
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("pluginType:");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(" preload:fail:exception ");
      ((StringBuilder)localObject2).append(localException3.getMessage());
      QLog.d("PluginPreloader", 2, ((StringBuilder)localObject2).toString());
    }
    PluginPreloadReportUtils.a(localAppRuntime, 1, i1, i, 3, "preload:fail:exception", n, new String[] { String.valueOf(j), localException3.getMessage() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.PluginPreloader.1
 * JD-Core Version:    0.7.0.1
 */
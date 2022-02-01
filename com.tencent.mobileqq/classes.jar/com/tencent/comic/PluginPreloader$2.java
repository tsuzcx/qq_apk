package com.tencent.comic;

import com.tencent.comic.api.IQQComicPluginUtil.ExtraResult;
import com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class PluginPreloader$2
  implements IQRoutePluginInstallListener
{
  PluginPreloader$2(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, IQQComicPluginUtil.ExtraResult paramExtraResult, int paramInt3, PluginPreloadStrategy paramPluginPreloadStrategy) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pluginType:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" preload:fail:installerror");
      QLog.d("PluginPreloader", 2, localStringBuilder.toString());
    }
    PluginPreloadReportUtils.a(this.a, 1, paramInt, paramInt, 3, "preload:fail:installerror", this.e, new String[] { paramString });
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "plugin install success, do preload.");
    }
    PluginPreloadReportUtils.a(this.a, 0, this.b, this.c, this.d.a, this.d.b, this.e, new String[] { paramString });
    this.f.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.PluginPreloader.2
 * JD-Core Version:    0.7.0.1
 */
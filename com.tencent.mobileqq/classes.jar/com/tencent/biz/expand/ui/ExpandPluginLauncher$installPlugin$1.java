package com.tencent.biz.expand.ui;

import android.net.TrafficStats;
import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/expand/ui/ExpandPluginLauncher$installPlugin$1", "Lcom/tencent/mobileqq/qroute/module/IQRoutePluginInstallListener;", "onInstallBegin", "", "p0", "", "onInstallDownloadProgress", "p1", "", "p2", "onInstallError", "onInstallFinish", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandPluginLauncher$installPlugin$1
  implements IQRoutePluginInstallListener
{
  public void onInstallBegin(@Nullable String paramString)
  {
    paramString = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandPluginLauncher", 2, "onInstallBegin");
    }
    paramString = (ExpandPluginLoadingFragment)ExpandPluginLauncher.a(this.a).get();
    if (paramString != null) {
      ExpandPluginLoadingFragment.a(paramString, LoadingStatus.LOADING, 0, 0, 6, null);
    }
  }
  
  public void onInstallDownloadProgress(@Nullable String paramString, int paramInt1, int paramInt2)
  {
    ExpandPluginLauncher.b(this.a, true);
    ExpandPluginLauncher.c(this.a, true);
    Object localObject = (ExpandPluginLoadingFragment)ExpandPluginLauncher.a(this.a).get();
    if (localObject != null) {
      ((ExpandPluginLoadingFragment)localObject).b();
    }
    if (ExpandPluginLauncher.a(this.a) == 0L) {
      ExpandPluginLauncher.a(this.a, TrafficStats.getTotalRxBytes());
    }
    int i = (int)(paramInt1 * 1.0D / paramInt2 * 100);
    localObject = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandPluginLauncher", 2, "onInstallDownloadProgress " + paramString + ' ' + paramInt1 + ' ' + paramInt2 + ' ' + i);
    }
    if (i == 100)
    {
      paramString = (ExpandPluginLoadingFragment)ExpandPluginLauncher.a(this.a).get();
      if (paramString != null) {
        paramString.c();
      }
      ExpandPluginLauncher.c(this.a, false);
    }
    paramString = (ExpandPluginLoadingFragment)ExpandPluginLauncher.a(this.a).get();
    if (paramString != null) {
      paramString.b(i);
    }
    if (ExpandPluginLauncher.b(this.a) == 0L) {
      ExpandPluginLauncher.b(this.a, System.currentTimeMillis());
    }
    if ((System.currentTimeMillis() - ExpandPluginLauncher.b(this.a) > 300) && (!ExpandPluginLauncher.c(this.a)))
    {
      ExpandPluginLauncher.d(this.a, true);
      ExpandPluginLauncher.a(this.a, paramInt2 - paramInt1, ExpandPluginLauncher.a(this.a));
    }
  }
  
  public void onInstallError(@Nullable String paramString, int paramInt)
  {
    Object localObject = LogUtils.a;
    localObject = (Throwable)null;
    QLog.e("ExpandPluginLauncher", 1, "onInstallError " + paramString + ' ' + paramInt, (Throwable)localObject);
    if (!ExpandPluginLauncher.b(this.a)) {}
    do
    {
      return;
      paramString = (ExpandPluginLoadingFragment)ExpandPluginLauncher.a(this.a).get();
    } while (paramString == null);
    paramString.a(LoadingStatus.LOADING_ERROR, 2, paramInt);
  }
  
  public void onInstallFinish(@Nullable String paramString)
  {
    paramString = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandPluginLauncher", 2, "onInstallFinish");
    }
    if (ExpandPluginLauncher.a(this.a).get() != null) {
      ExpandPluginLauncher.a(this.a, ExpandPluginLauncher.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPluginLauncher.installPlugin.1
 * JD-Core Version:    0.7.0.1
 */
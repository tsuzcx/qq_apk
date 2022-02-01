package com.tencent.biz.expand.ui;

import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin.OnOpenResultListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "", "onOpenResult"}, k=3, mv={1, 1, 16})
final class ExpandPluginLauncher$loadPlugin$params$1
  implements IQRoutePlugin.OnOpenResultListener
{
  ExpandPluginLauncher$loadPlugin$params$1(ExpandPluginLauncher paramExpandPluginLauncher) {}
  
  public final void onOpenResult(boolean paramBoolean)
  {
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandPluginLauncher", 2, "open plugin result " + paramBoolean);
    }
    if (!paramBoolean)
    {
      localObject = (ExpandPluginLoadingFragment)ExpandPluginLauncher.a(this.a).get();
      if (localObject != null) {
        ExpandPluginLoadingFragment.a((ExpandPluginLoadingFragment)localObject, LoadingStatus.LOADING_ERROR, 1, 0, 4, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPluginLauncher.loadPlugin.params.1
 * JD-Core Version:    0.7.0.1
 */
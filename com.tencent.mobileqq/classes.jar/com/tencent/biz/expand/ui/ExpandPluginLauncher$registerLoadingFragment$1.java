package com.tencent.biz.expand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ExpandPluginLauncher$registerLoadingFragment$1
  implements View.OnClickListener
{
  ExpandPluginLauncher$registerLoadingFragment$1(ExpandPluginLauncher paramExpandPluginLauncher) {}
  
  public final void onClick(View paramView)
  {
    QLog.d("ExpandPluginLauncher", 2, "retry load");
    ExpandPluginLoadingFragment localExpandPluginLoadingFragment = (ExpandPluginLoadingFragment)ExpandPluginLauncher.a(this.a).get();
    if (localExpandPluginLoadingFragment != null) {
      localExpandPluginLoadingFragment.d();
    }
    ExpandPluginLauncher.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPluginLauncher.registerLoadingFragment.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.expand.ui;

import android.support.v4.app.QFragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ExpandPluginLoadingFragment$onCreateView$1
  implements View.OnClickListener
{
  ExpandPluginLoadingFragment$onCreateView$1(ExpandPluginLoadingFragment paramExpandPluginLoadingFragment) {}
  
  public final void onClick(View paramView)
  {
    QFragmentActivity localQFragmentActivity = this.a.getActivity();
    if (localQFragmentActivity != null) {
      localQFragmentActivity.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPluginLoadingFragment.onCreateView.1
 * JD-Core Version:    0.7.0.1
 */
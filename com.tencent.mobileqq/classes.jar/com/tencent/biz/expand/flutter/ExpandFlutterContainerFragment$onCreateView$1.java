package com.tencent.biz.expand.flutter;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ExpandFlutterContainerFragment$onCreateView$1
  implements View.OnClickListener
{
  ExpandFlutterContainerFragment$onCreateView$1(ExpandFlutterContainerFragment paramExpandFlutterContainerFragment) {}
  
  public final void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.ExpandFlutterContainerFragment.onCreateView.1
 * JD-Core Version:    0.7.0.1
 */
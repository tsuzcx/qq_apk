package com.tencent.biz.pubaccount.readinjoy.push.mvp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyParam;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class RIJPushNotifyDialog$initListener$2
  implements View.OnClickListener
{
  RIJPushNotifyDialog$initListener$2(RIJPushNotifyDialog paramRIJPushNotifyDialog) {}
  
  public final void onClick(View paramView)
  {
    RIJPushNotifyDialog.a(this.a).a().invoke(Boolean.valueOf(true), Boolean.valueOf(RIJPushNotifyDialog.a(this.a)), Integer.valueOf(2));
    this.a.b(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.push.mvp.RIJPushNotifyDialog.initListener.2
 * JD-Core Version:    0.7.0.1
 */
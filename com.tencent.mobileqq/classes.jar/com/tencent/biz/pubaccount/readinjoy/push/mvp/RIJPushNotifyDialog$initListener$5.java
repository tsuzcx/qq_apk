package com.tencent.biz.pubaccount.readinjoy.push.mvp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyParam;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class RIJPushNotifyDialog$initListener$5
  implements View.OnClickListener
{
  RIJPushNotifyDialog$initListener$5(RIJPushNotifyDialog paramRIJPushNotifyDialog) {}
  
  public final void onClick(View paramView)
  {
    RIJPushNotifyDialog.a(this.a, RIJPushNotifyDialog.a(this.a) ^ true);
    if (RIJPushNotifyDialog.a(this.a)) {
      if (RIJPushNotifyDialog.a(this.a).a()) {
        RIJPushNotifyDialog.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849823, 0, 0, 0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      RIJPushNotifyDialog.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849824, 0, 0, 0);
      continue;
      if (RIJPushNotifyDialog.a(this.a).a()) {
        RIJPushNotifyDialog.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849829, 0, 0, 0);
      } else {
        RIJPushNotifyDialog.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849830, 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.push.mvp.RIJPushNotifyDialog.initListener.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.analysis.AdUin;
import com.tencent.ad.tangram.preorder.AdAppPreOrderManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtQQReminderDemoFragment$5
  implements View.OnClickListener
{
  GdtQQReminderDemoFragment$5(GdtQQReminderDemoFragment paramGdtQQReminderDemoFragment) {}
  
  public void onClick(View paramView)
  {
    AdAppPreOrderManager.INSTANCE.processPublishMessage("b3f3c5eb-43ac-4325-a40f-2cd1b59024ca", AdUin.INSTANCE.getUIN(), System.currentTimeMillis());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtQQReminderDemoFragment.5
 * JD-Core Version:    0.7.0.1
 */
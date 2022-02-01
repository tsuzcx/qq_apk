package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.preorder.AdAppPreOrderManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtQQReminderDemoFragment$4
  implements View.OnClickListener
{
  GdtQQReminderDemoFragment$4(GdtQQReminderDemoFragment paramGdtQQReminderDemoFragment) {}
  
  public void onClick(View paramView)
  {
    AdAppPreOrderManager.INSTANCE.runTasks();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtQQReminderDemoFragment.4
 * JD-Core Version:    0.7.0.1
 */
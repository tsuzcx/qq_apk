package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.QQReminderAMSHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtQQReminderDemoFragment$1
  implements View.OnClickListener
{
  GdtQQReminderDemoFragment$1(GdtQQReminderDemoFragment paramGdtQQReminderDemoFragment) {}
  
  public void onClick(View paramView)
  {
    GdtQQReminderDemoFragment.a(String.format("%s %b", new Object[] { "getQQReminderSwitch", Boolean.valueOf(QQReminderAMSHelper.a()) }));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtQQReminderDemoFragment.1
 * JD-Core Version:    0.7.0.1
 */
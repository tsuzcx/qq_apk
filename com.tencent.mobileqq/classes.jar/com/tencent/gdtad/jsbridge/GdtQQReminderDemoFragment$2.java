package com.tencent.gdtad.jsbridge;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.QQReminderAMSHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class GdtQQReminderDemoFragment$2
  implements View.OnClickListener
{
  GdtQQReminderDemoFragment$2(GdtQQReminderDemoFragment paramGdtQQReminderDemoFragment) {}
  
  public void onClick(View paramView)
  {
    QQReminderAMSHelper.a(new WeakReference(GdtQQReminderDemoFragment.a()));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtQQReminderDemoFragment.2
 * JD-Core Version:    0.7.0.1
 */
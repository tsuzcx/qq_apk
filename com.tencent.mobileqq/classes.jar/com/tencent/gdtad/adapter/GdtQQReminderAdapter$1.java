package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.preorder.AdQQReminderManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.activateFriend.QQReminderAMSHelper;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderSwitchObserver.QQReminderSwitchListener;

class GdtQQReminderAdapter$1
  implements QQReminderSwitchObserver.QQReminderSwitchListener
{
  GdtQQReminderAdapter$1(GdtQQReminderAdapter paramGdtQQReminderAdapter) {}
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    GdtLog.b("GdtQQReminderAdapter", String.format("QQReminderSwitchListener.onResult %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    if ((paramBoolean) && (QQReminderAMSHelper.a())) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    AdQQReminderManager.INSTANCE.onQQReminderSwichOnResult(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtQQReminderAdapter.1
 * JD-Core Version:    0.7.0.1
 */
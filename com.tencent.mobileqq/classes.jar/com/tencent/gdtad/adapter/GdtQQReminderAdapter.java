package com.tencent.gdtad.adapter;

import android.os.Bundle;
import com.tencent.ad.tangram.preorder.AdQQReminderAdapter;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.activateFriend.QQReminderAMSHelper;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderSwitchObserver.QQReminderSwitchListener;
import java.lang.ref.WeakReference;
import java.util.UUID;

public final class GdtQQReminderAdapter
  implements AdQQReminderAdapter
{
  private QQReminderSwitchObserver.QQReminderSwitchListener a = new GdtQQReminderAdapter.1(this);
  
  public String generateQQReminderId()
  {
    return UUID.randomUUID().toString();
  }
  
  public boolean isQQReminderNotified(String paramString1, String paramString2)
  {
    boolean bool = QQReminderAMSHelper.a(paramString1);
    GdtLog.b("GdtQQReminderAdapter", String.format("isQQReminderNotified reminderId:%s taskId:%s notified:%b", new Object[] { paramString1, paramString2, Boolean.valueOf(bool) }));
    return bool;
  }
  
  public boolean isQQReminderSwichOn()
  {
    boolean bool = QQReminderAMSHelper.a();
    GdtLog.b("GdtQQReminderAdapter", String.format("isQQReminderSwichOn %b", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  public void scheduleQQReminder(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("busi_id", "bf15cdd9f2aa2b578f3af4c3e433f077");
    localBundle.putString("msg_id", paramString1);
    localBundle.putString("mn_reserved", paramString2);
    localBundle.putString("title", paramString3);
    localBundle.putString("content", paramString4);
    localBundle.putString("btn_text", paramString5);
    localBundle.putInt("banner_type", 1);
    localBundle.putString("banner_url", paramString6);
    localBundle.putLong("notice_time", paramLong / 1000L);
    QQReminderAMSHelper.a(localBundle);
    GdtLog.b("GdtQQReminderAdapter", String.format("scheduleQQReminder reminderId:%s taskId:%s bundle:%s", new Object[] { paramString1, paramString2, localBundle.toString() }));
  }
  
  public void swichOnQQReminder()
  {
    GdtLog.b("GdtQQReminderAdapter", "swichOnQQReminder");
    QQReminderAMSHelper.a(new WeakReference(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtQQReminderAdapter
 * JD-Core Version:    0.7.0.1
 */
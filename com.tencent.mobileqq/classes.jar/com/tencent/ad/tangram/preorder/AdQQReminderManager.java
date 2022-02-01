package com.tencent.ad.tangram.preorder;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

@Keep
public enum AdQQReminderManager
{
  INSTANCE;
  
  private static final String TAG = "AdQQReminderManager";
  private WeakReference<AdQQReminderAdapter> adapter;
  private boolean processSwichOnQQReminder = false;
  
  private AdQQReminderManager() {}
  
  public String generateQQReminderId()
  {
    AdQQReminderAdapter localAdQQReminderAdapter = getAdapter();
    if (localAdQQReminderAdapter == null)
    {
      AdLog.e("AdQQReminderManager", "generateQQReminderId error, adapter is null");
      return null;
    }
    return localAdQQReminderAdapter.generateQQReminderId();
  }
  
  public AdQQReminderAdapter getAdapter()
  {
    if (this.adapter != null) {
      return (AdQQReminderAdapter)this.adapter.get();
    }
    return null;
  }
  
  public boolean isQQReminderNotified(String paramString1, String paramString2)
  {
    AdQQReminderAdapter localAdQQReminderAdapter = getAdapter();
    if (localAdQQReminderAdapter == null)
    {
      AdLog.e("AdQQReminderManager", "isQQReminderNotified error, adapter is null");
      return false;
    }
    return localAdQQReminderAdapter.isQQReminderNotified(paramString1, paramString2);
  }
  
  public boolean isQQReminderSwichOn()
  {
    AdQQReminderAdapter localAdQQReminderAdapter = getAdapter();
    if (localAdQQReminderAdapter == null)
    {
      AdLog.e("AdQQReminderManager", "isQQReminderSwichOn error, adapter is null");
      return false;
    }
    return localAdQQReminderAdapter.isQQReminderSwichOn();
  }
  
  public void onQQReminderClicked(WeakReference<Activity> paramWeakReference, String paramString1, String paramString2, Bundle paramBundle, String paramString3)
  {
    AdAppPreOrderManager.INSTANCE.onQQReminderClicked(paramWeakReference, paramString2, paramString1, paramBundle, paramString3);
  }
  
  public void onQQReminderDisplayed(String paramString1, String paramString2)
  {
    AdAppPreOrderManager.INSTANCE.onQQReminderDisplayed(paramString2, paramString1);
  }
  
  public void onQQReminderSwichOnResult(boolean paramBoolean)
  {
    AdThreadManager.INSTANCE.post(new AdQQReminderManager.1(this, paramBoolean), 5);
  }
  
  public void scheduleQQReminder(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
  {
    AdQQReminderAdapter localAdQQReminderAdapter = getAdapter();
    if (localAdQQReminderAdapter == null)
    {
      AdLog.e("AdQQReminderManager", "scheduleQQReminder error, adapter is null");
      return;
    }
    localAdQQReminderAdapter.scheduleQQReminder(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramLong);
  }
  
  public void setAdapter(WeakReference<AdQQReminderAdapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
  
  public boolean swichOnQQReminder()
  {
    AdQQReminderAdapter localAdQQReminderAdapter = getAdapter();
    if (localAdQQReminderAdapter == null) {
      AdLog.e("AdQQReminderManager", "swichOnQQReminder error, adapter is null");
    }
    do
    {
      return false;
      AdLog.i("AdQQReminderManager", String.format("swichOnQQReminder processSwichOnQQReminder:%b", new Object[] { Boolean.valueOf(this.processSwichOnQQReminder) }));
    } while (this.processSwichOnQQReminder);
    this.processSwichOnQQReminder = true;
    localAdQQReminderAdapter.swichOnQQReminder();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdQQReminderManager
 * JD-Core Version:    0.7.0.1
 */
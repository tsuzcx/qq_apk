package com.tencent.ad.tangram.preorder;

import android.support.annotation.Keep;

@Keep
public abstract interface AdQQReminderAdapter
{
  public abstract String generateQQReminderId();
  
  public abstract boolean isQQReminderNotified(String paramString1, String paramString2);
  
  public abstract boolean isQQReminderSwichOn();
  
  public abstract void scheduleQQReminder(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong);
  
  public abstract void swichOnQQReminder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdQQReminderAdapter
 * JD-Core Version:    0.7.0.1
 */
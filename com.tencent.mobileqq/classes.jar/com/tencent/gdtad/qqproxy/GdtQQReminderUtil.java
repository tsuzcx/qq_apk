package com.tencent.gdtad.qqproxy;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.ad.tangram.preorder.AdQQReminderManager;
import java.lang.ref.WeakReference;

public final class GdtQQReminderUtil
{
  public static void a(String paramString1, String paramString2)
  {
    AdQQReminderManager.INSTANCE.onQQReminderDisplayed(paramString1, paramString2);
  }
  
  public static void a(WeakReference<Activity> paramWeakReference, String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("big_brother_source_key", "biz_src_ads");
    AdQQReminderManager.INSTANCE.onQQReminderClicked(paramWeakReference, paramString1, paramString2, localBundle, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.qqproxy.GdtQQReminderUtil
 * JD-Core Version:    0.7.0.1
 */
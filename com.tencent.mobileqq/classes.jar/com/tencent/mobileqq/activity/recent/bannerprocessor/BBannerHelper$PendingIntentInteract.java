package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class BBannerHelper$PendingIntentInteract
  implements BBannerHelper.IBannerInteract
{
  @NonNull
  private final PendingIntent a;
  @NonNull
  private final WeakReference<QQAppInterface> b;
  @Nullable
  private BBannerHelper.MessageToShowBanner c;
  
  public BBannerHelper$PendingIntentInteract(@NonNull PendingIntent paramPendingIntent, @NonNull QQAppInterface paramQQAppInterface)
  {
    this.a = paramPendingIntent;
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void a(@Nullable BBannerHelper.MessageToShowBanner paramMessageToShowBanner)
  {
    this.c = paramMessageToShowBanner;
  }
  
  public boolean isNeedAutoCloseWhenAccountChange()
  {
    return true;
  }
  
  public void onClose()
  {
    if (this.c == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if (localQQAppInterface == null) {
      return;
    }
    BBannerHelper.a(localQQAppInterface, this.c);
  }
  
  public void onEnter()
  {
    if (this.c == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if (localQQAppInterface == null) {
      return;
    }
    try
    {
      this.a.send();
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send pending intent fail with ");
      localStringBuilder.append(this.a);
      localStringBuilder.append("\r\n");
      localStringBuilder.append(localCanceledException);
      QLog.e("Q.recent.banner", 1, localStringBuilder.toString());
    }
    BBannerHelper.a(localQQAppInterface, this.c);
  }
  
  public void onOverride() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.PendingIntentInteract
 * JD-Core Version:    0.7.0.1
 */
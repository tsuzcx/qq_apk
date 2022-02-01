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
  private final PendingIntent jdField_a_of_type_AndroidAppPendingIntent;
  @Nullable
  private BBannerHelper.MessageToShowBanner jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner;
  @NonNull
  private final WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public BBannerHelper$PendingIntentInteract(@NonNull PendingIntent paramPendingIntent, @NonNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidAppPendingIntent = paramPendingIntent;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void a(@Nullable BBannerHelper.MessageToShowBanner paramMessageToShowBanner)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner = paramMessageToShowBanner;
  }
  
  public boolean isNeedAutoCloseWhenAccountChange()
  {
    return true;
  }
  
  public void onClose()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    BBannerHelper.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner);
  }
  
  public void onEnter()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    try
    {
      this.jdField_a_of_type_AndroidAppPendingIntent.send();
      BBannerHelper.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner);
      return;
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      for (;;)
      {
        QLog.e("Q.recent.banner", 1, "send pending intent fail with " + this.jdField_a_of_type_AndroidAppPendingIntent + "\r\n" + localCanceledException);
      }
    }
  }
  
  public void onOverride() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.PendingIntentInteract
 * JD-Core Version:    0.7.0.1
 */
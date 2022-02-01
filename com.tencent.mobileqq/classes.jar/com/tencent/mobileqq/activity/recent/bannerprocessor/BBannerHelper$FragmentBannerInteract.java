package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class BBannerHelper$FragmentBannerInteract
  implements BBannerHelper.IBannerInteract
{
  private BBannerHelper.MessageToShowBanner jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner;
  private String jdField_a_of_type_JavaLangString;
  private final WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public BBannerHelper$FragmentBannerInteract(String paramString, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
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
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    Intent localIntent;
    if (BaseActivity.sTopActivity != null)
    {
      localIntent = new Intent();
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      try
      {
        PublicTransFragmentActivity.b(localQQAppInterface.getApp(), localIntent, Class.forName(this.jdField_a_of_type_JavaLangString));
        BBannerHelper.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner);
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "sTopActivity is null");
      }
    }
  }
  
  public void onOverride() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.FragmentBannerInteract
 * JD-Core Version:    0.7.0.1
 */
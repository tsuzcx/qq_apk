package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class BBannerHelper$WebViewBannerInteract
  implements BBannerHelper.IBannerInteract
{
  private final int jdField_a_of_type_Int;
  @Nullable
  private final Bundle jdField_a_of_type_AndroidOsBundle;
  @Nullable
  private BBannerHelper.MessageToShowBanner jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner;
  @NonNull
  private final String jdField_a_of_type_JavaLangString;
  @NonNull
  private final WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  @Nullable
  private final String b;
  
  public BBannerHelper$WebViewBannerInteract(@NonNull String paramString1, @NonNull QQAppInterface paramQQAppInterface, @Nullable String paramString2, int paramInt, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    BBannerHelper.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner);
  }
  
  public void onEnter()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onEnter: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner);
      ((StringBuilder)localObject1).append(" / ");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(" / ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append(" / ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    Object localObject3 = QQBrowserActivity.class;
    Object localObject1 = localObject3;
    if (!TextUtils.isEmpty(this.b)) {}
    try
    {
      localObject1 = Class.forName(this.b);
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      localObject3 = localBaseActivity;
      if (localBaseActivity == null)
      {
        localObject3 = BaseApplicationImpl.getContext();
        QLog.d("Q.recent.banner", 1, "sTopActivity is null,set Application context");
      }
      if (localObject3 != null)
      {
        localObject1 = new Intent(localQQAppInterface.getApp(), (Class)localObject1);
        ((Intent)localObject1).setFlags(this.jdField_a_of_type_Int);
        ((Intent)localObject1).putExtra("banner_fromBanner", true);
        ((Intent)localObject1).putExtra("url", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("banner_webview_extra", this.jdField_a_of_type_AndroidOsBundle);
        ((Intent)localObject1).putExtra("force_no_reload", this.jdField_a_of_type_Boolean);
        try
        {
          ((Context)localObject3).startActivity((Intent)localObject1);
        }
        catch (Exception localException)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("startActivity,error =");
          ((StringBuilder)localObject3).append(localException);
          QLog.d("Q.recent.banner", 1, ((StringBuilder)localObject3).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.recent.banner", 2, "sTopActivity is null");
      }
      BBannerHelper.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public void onOverride()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("banner for ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" is overrided");
      QLog.d("Q.recent.banner", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.WebViewBannerInteract
 * JD-Core Version:    0.7.0.1
 */
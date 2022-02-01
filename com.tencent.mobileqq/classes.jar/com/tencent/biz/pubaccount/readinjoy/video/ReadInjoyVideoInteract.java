package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.IBannerInteract;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.MessageToShowBanner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ReadInjoyVideoInteract
  implements BBannerHelper.IBannerInteract
{
  @NonNull
  private final PendingIntent jdField_a_of_type_AndroidAppPendingIntent;
  @Nullable
  private BBannerHelper.MessageToShowBanner jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner;
  String jdField_a_of_type_JavaLangString;
  @NonNull
  private final WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  String b;
  String c;
  String d;
  
  public ReadInjoyVideoInteract(@NonNull PendingIntent paramPendingIntent, @NonNull QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidAppPendingIntent = paramPendingIntent;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, PendingIntent paramPendingIntent, String paramString1, String paramString2)
  {
    int i = paramIntent.getIntExtra("banner_iconIdx", -1);
    if ((paramPendingIntent == null) || (i < 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("ReadInjoyVideoInteract", 1, "invalid intent extra from ReadinjoyVideo, " + paramString1 + " / " + paramString2 + " / " + paramPendingIntent + " / " + i);
      return;
    }
    String str1 = paramIntent.getStringExtra("banner_readinjoy_puin");
    String str2 = paramIntent.getStringExtra("banner_readinjoy_vid");
    String str3 = paramIntent.getStringExtra("banner_readinjoy_md5");
    paramIntent = new ReadInjoyVideoInteract(paramPendingIntent, paramQQAppInterface, str1, paramIntent.getStringExtra("banner_readinjoy_article_id"), str2, str3, paramIntent.getBooleanExtra("banner_readinjoy_is_weishi_mode", false));
    paramQQAppInterface = BBannerHelper.a(paramQQAppInterface, i, paramString1, paramString2, paramIntent);
    paramIntent.a();
    paramIntent.a(paramQQAppInterface);
  }
  
  private void a(String paramString)
  {
    VideoR5.Builder localBuilder;
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    AppInterface localAppInterface;
    String str2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      localBuilder = new VideoR5.Builder(this.d, this.jdField_a_of_type_JavaLangString, this.c, this.b);
      localBuilder.i(this.b);
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      str2 = this.jdField_a_of_type_JavaLangString;
      if (!this.jdField_a_of_type_Boolean) {
        break label110;
      }
    }
    label110:
    for (String str1 = "1";; str1 = "0")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(localAppInterface, str2, paramString, paramString, 0, 0, str1, "", "", localBuilder.a().a(), false);
      return;
    }
  }
  
  public void a()
  {
    a("0X80097F8");
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
    VideoFeedsLoadDelegate.a(this.jdField_a_of_type_AndroidAppPendingIntent);
    a("0X80097FA");
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
      a("0X80097F9");
      return;
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      for (;;)
      {
        QLog.e("ReadInjoyVideoInteract", 1, "send pending intent fail with " + this.jdField_a_of_type_AndroidAppPendingIntent + "\r\n" + localCanceledException);
      }
    }
  }
  
  public void onOverride() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ReadInjoyVideoInteract
 * JD-Core Version:    0.7.0.1
 */
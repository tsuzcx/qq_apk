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
  @NonNull
  private final String a;
  @NonNull
  private final WeakReference<QQAppInterface> b;
  @Nullable
  private final String c;
  @Nullable
  private BBannerHelper.MessageToShowBanner d;
  @Nullable
  private final Bundle e;
  private final int f;
  private final boolean g;
  
  public BBannerHelper$WebViewBannerInteract(@NonNull String paramString1, @NonNull QQAppInterface paramQQAppInterface, @Nullable String paramString2, int paramInt, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = new WeakReference(paramQQAppInterface);
    this.c = paramString2;
    this.f = paramInt;
    this.e = paramBundle;
    this.g = paramBoolean;
  }
  
  public void a(@Nullable BBannerHelper.MessageToShowBanner paramMessageToShowBanner)
  {
    this.d = paramMessageToShowBanner;
  }
  
  public boolean isNeedAutoCloseWhenAccountChange()
  {
    return true;
  }
  
  public void onClose()
  {
    if (this.d == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if (localQQAppInterface == null) {
      return;
    }
    BBannerHelper.a(localQQAppInterface, this.d);
  }
  
  public void onEnter()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onEnter: ");
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append(" / ");
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append(" / ");
      ((StringBuilder)localObject1).append(this.f);
      ((StringBuilder)localObject1).append(" / ");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.d == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if (localQQAppInterface == null) {
      return;
    }
    Object localObject3 = QQBrowserActivity.class;
    Object localObject1 = localObject3;
    if (!TextUtils.isEmpty(this.c)) {}
    try
    {
      localObject1 = Class.forName(this.c);
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
        ((Intent)localObject1).setFlags(this.f);
        ((Intent)localObject1).putExtra("banner_fromBanner", true);
        ((Intent)localObject1).putExtra("url", this.a);
        ((Intent)localObject1).putExtra("banner_webview_extra", this.e);
        ((Intent)localObject1).putExtra("force_no_reload", this.g);
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
      BBannerHelper.a(localQQAppInterface, this.d);
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
      localStringBuilder.append(this.a);
      localStringBuilder.append(" is overrided");
      QLog.d("Q.recent.banner", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.WebViewBannerInteract
 * JD-Core Version:    0.7.0.1
 */
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
  private final WeakReference<QQAppInterface> a;
  private String b;
  private BBannerHelper.MessageToShowBanner c;
  
  public BBannerHelper$FragmentBannerInteract(String paramString, QQAppInterface paramQQAppInterface)
  {
    this.b = paramString;
    this.a = new WeakReference(paramQQAppInterface);
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
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null) {
      return;
    }
    BBannerHelper.a(localQQAppInterface, this.c);
  }
  
  public void onEnter()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null) {
      return;
    }
    if (BaseActivity.sTopActivity != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.addFlags(268435456);
      try
      {
        PublicTransFragmentActivity.b(localQQAppInterface.getApp(), localIntent, Class.forName(this.b));
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("Q.recent.banner", 2, "sTopActivity is null");
    }
    BBannerHelper.a(localQQAppInterface, this.c);
  }
  
  public void onOverride() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.FragmentBannerInteract
 * JD-Core Version:    0.7.0.1
 */
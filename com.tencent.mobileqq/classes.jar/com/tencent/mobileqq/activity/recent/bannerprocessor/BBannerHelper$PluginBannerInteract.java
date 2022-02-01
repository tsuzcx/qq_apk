package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.lang.ref.WeakReference;

class BBannerHelper$PluginBannerInteract
  implements BBannerHelper.IBannerInteract
{
  @NonNull
  private final WeakReference<QQAppInterface> a;
  @NonNull
  private final String b;
  @NonNull
  private final String c;
  @NonNull
  private final String d;
  @Nullable
  private final String e;
  @Nullable
  private BBannerHelper.MessageToShowBanner f;
  @NonNull
  private final Intent g;
  @NonNull
  private final String h;
  private final int i;
  
  public BBannerHelper$PluginBannerInteract(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, @NonNull Intent paramIntent, @NonNull String paramString5, int paramInt)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.g = paramIntent;
    this.h = paramString5;
    this.i = paramInt;
  }
  
  public void a(@Nullable BBannerHelper.MessageToShowBanner paramMessageToShowBanner)
  {
    this.f = paramMessageToShowBanner;
  }
  
  public boolean isNeedAutoCloseWhenAccountChange()
  {
    return true;
  }
  
  public void onClose()
  {
    if (this.f == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null) {
      return;
    }
    BBannerHelper.a(localQQAppInterface, this.f);
  }
  
  public void onEnter()
  {
    if (this.f == null) {
      return;
    }
    Object localObject = (QQAppInterface)this.a.get();
    if (localObject == null) {
      return;
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      if (localBaseActivity.isFinishing()) {
        return;
      }
    }
    try
    {
      Class localClass = Class.forName(this.c).asSubclass(Activity.class);
      this.g.putExtra("banner_fromBanner", true);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(this.i);
      localPluginParams.g = this.e;
      localPluginParams.h = this.b;
      localPluginParams.i = localClass;
      localPluginParams.d = this.d;
      localPluginParams.c = this.h;
      localPluginParams.j = this.g;
      localPluginParams.k = -1;
      IPluginManager.a(localBaseActivity, localPluginParams);
      BBannerHelper.a((QQAppInterface)localObject, this.f);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label150:
      break label150;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("return to plugin error, can not find the ckass ");
    ((StringBuilder)localObject).append(this.c);
    QLog.e("Q.recent.banner", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onOverride() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.PluginBannerInteract
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.weishi_new.api;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IWSMinePanel
  extends QRouteApi
{
  public abstract void downloadWeishiWithDialog(Activity paramActivity, boolean paramBoolean);
  
  public abstract void reportProfileCardExposure(boolean paramBoolean, String paramString);
  
  public abstract void reportProfilePageVisitEnter(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface);
  
  public abstract void reportProfilePageVisitExit(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface);
  
  public abstract void reportProfileSettingBtnClick(boolean paramBoolean);
  
  public abstract void reportProfileSettingExposure(boolean paramBoolean);
  
  public abstract void reportProfileSettingPageVisitEnter();
  
  public abstract void reportProfileSettingPageVisitExit();
  
  public abstract void reportWeiShiProfileClick(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.api.IWSMinePanel
 * JD-Core Version:    0.7.0.1
 */
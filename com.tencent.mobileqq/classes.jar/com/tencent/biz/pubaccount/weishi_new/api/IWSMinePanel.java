package com.tencent.biz.pubaccount.weishi_new.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IWSMinePanel
  extends QRouteApi
{
  public abstract void downloadWeishiWithDialog(Activity paramActivity, boolean paramBoolean);
  
  public abstract void reportProfileCardExposure(boolean paramBoolean, String paramString);
  
  public abstract void reportProfilePageVisitEnter(String paramString, boolean paramBoolean);
  
  public abstract void reportProfilePageVisitExit(String paramString, boolean paramBoolean);
  
  public abstract void reportProfileSettingBtnClick(boolean paramBoolean);
  
  public abstract void reportProfileSettingExposure(boolean paramBoolean);
  
  public abstract void reportProfileSettingPageVisitEnter();
  
  public abstract void reportProfileSettingPageVisitExit();
  
  public abstract void reportWeiShiProfileClick(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.api.IWSMinePanel
 * JD-Core Version:    0.7.0.1
 */
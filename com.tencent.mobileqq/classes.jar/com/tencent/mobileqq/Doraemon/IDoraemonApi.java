package com.tencent.mobileqq.Doraemon;

import android.os.Bundle;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.miniapp.MiniAppInfoCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDoraemonApi
  extends QRouteApi
{
  public abstract void bindService();
  
  public abstract MiniAppInfo getAppInfo(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, MiniAppInfoCallback paramMiniAppInfoCallback);
  
  public abstract MiniAppInfo getAppInfo(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, MiniAppInfoCallback paramMiniAppInfoCallback, int paramInt3);
  
  public abstract Bundle getUserInfo();
  
  public abstract void initBosses();
  
  public abstract boolean isLogin(DoraemonAPIModule paramDoraemonAPIModule);
  
  public abstract void putAppInfo(MiniAppInfo paramMiniAppInfo);
  
  public abstract void unbindService();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.IDoraemonApi
 * JD-Core Version:    0.7.0.1
 */
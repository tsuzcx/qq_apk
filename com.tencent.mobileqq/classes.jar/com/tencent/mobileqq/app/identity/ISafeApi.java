package com.tencent.mobileqq.app.identity;

import QQService.DeviceItemDes;
import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.observer.WtloginObserver;

@QAPI(process={"all"})
public abstract interface ISafeApi
  extends QRouteApi
{
  public abstract int checkDevLockSms(AppRuntime paramAppRuntime, String paramString1, String paramString2, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver);
  
  public abstract int checkDevLockStatus(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver);
  
  public abstract int closeDevLock(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver);
  
  public abstract boolean delAuthDev(AppRuntime paramAppRuntime, String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt, boolean paramBoolean, long paramLong);
  
  public abstract boolean delHistoryDev(AppRuntime paramAppRuntime, String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt);
  
  public abstract boolean getAuthLoginDevList(AppRuntime paramAppRuntime, String paramString, long paramLong);
  
  public abstract IFriendObserver getDevListObserver(IDevListView paramIDevListView);
  
  public abstract BusinessObserver getDevLockObserver(IDevListView paramIDevListView);
  
  public abstract boolean getIsPushRecommandDevLock(AppRuntime paramAppRuntime);
  
  public abstract boolean getLoginDevList(AppRuntime paramAppRuntime, String paramString, long paramLong);
  
  public abstract Class<? extends Activity> getLoginInfoActivity();
  
  public abstract boolean getRecentLoginDevList(AppRuntime paramAppRuntime, String paramString, long paramLong);
  
  public abstract void getWxMsgOptions(AppRuntime paramAppRuntime);
  
  public abstract boolean isH5Jump();
  
  public abstract void sendRegisterPush(AppRuntime paramAppRuntime);
  
  public abstract int setLocalDevlockStatus(AppRuntime paramAppRuntime, Context paramContext, String paramString, boolean paramBoolean);
  
  public abstract void setWXSyncQQMsgOption(AppRuntime paramAppRuntime, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.ISafeApi
 * JD-Core Version:    0.7.0.1
 */
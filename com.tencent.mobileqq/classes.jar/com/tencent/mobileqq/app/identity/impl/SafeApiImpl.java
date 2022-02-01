package com.tencent.mobileqq.app.identity.impl;

import QQService.DeviceItemDes;
import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.identity.IDevListView;
import com.tencent.mobileqq.app.identity.ISafeApi;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.observer.WtloginObserver;

public class SafeApiImpl
  implements ISafeApi
{
  public int checkDevLockSms(AppRuntime paramAppRuntime, String paramString1, String paramString2, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver)
  {
    return EquipmentLockImpl.a().a(paramAppRuntime, paramString1, paramString2, paramArrayOfByte, paramWtloginObserver);
  }
  
  public int checkDevLockStatus(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver)
  {
    return EquipmentLockImpl.a().a(paramAppRuntime, paramString, paramWtloginObserver);
  }
  
  public int closeDevLock(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver)
  {
    return EquipmentLockImpl.a().b(paramAppRuntime, paramString, paramWtloginObserver);
  }
  
  public boolean delAuthDev(AppRuntime paramAppRuntime, String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt, boolean paramBoolean, long paramLong)
  {
    return EquipmentLockImpl.a().a(paramAppRuntime, paramString, paramArrayList, paramInt, paramBoolean, paramLong);
  }
  
  public boolean delHistoryDev(AppRuntime paramAppRuntime, String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt)
  {
    return EquipmentLockImpl.a().a(paramAppRuntime, paramString, paramArrayList, paramInt);
  }
  
  public boolean getAuthLoginDevList(AppRuntime paramAppRuntime, String paramString, long paramLong)
  {
    return EquipmentLockImpl.a().c(paramAppRuntime, paramString, paramLong);
  }
  
  public IFriendObserver getDevListObserver(IDevListView paramIDevListView)
  {
    return new SafeApiImpl.1(this, paramIDevListView);
  }
  
  public BusinessObserver getDevLockObserver(IDevListView paramIDevListView)
  {
    return new SafeApiImpl.2(this, paramIDevListView);
  }
  
  public boolean getIsPushRecommandDevLock(AppRuntime paramAppRuntime)
  {
    return EquipmentLockImpl.a().c();
  }
  
  public boolean getLoginDevList(AppRuntime paramAppRuntime, String paramString, long paramLong)
  {
    return EquipmentLockImpl.a().a(paramAppRuntime, paramString, paramLong);
  }
  
  public Class<? extends Activity> getLoginInfoActivity()
  {
    return LoginInfoActivity.class;
  }
  
  public boolean getRecentLoginDevList(AppRuntime paramAppRuntime, String paramString, long paramLong)
  {
    return EquipmentLockImpl.a().b(paramAppRuntime, paramString, paramLong);
  }
  
  public void getWxMsgOptions(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof AppInterface)) {
      return;
    }
    paramAppRuntime = (SecSvcHandler)((AppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime.a();
  }
  
  public boolean isH5Jump()
  {
    return AuthDevOpenUgActivity.getIsH5Jump();
  }
  
  public void sendRegisterPush(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)paramAppRuntime).sendRegisterPush();
    }
  }
  
  public int setLocalDevlockStatus(AppRuntime paramAppRuntime, Context paramContext, String paramString, boolean paramBoolean)
  {
    return EquipmentLockImpl.a().a(paramAppRuntime, paramContext, paramString, paramBoolean);
  }
  
  public void setWXSyncQQMsgOption(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if ((paramAppRuntime instanceof AppInterface)) {
      paramAppRuntime = (SecSvcHandler)((AppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    } else {
      paramAppRuntime = null;
    }
    if (paramAppRuntime != null) {
      paramAppRuntime.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.impl.SafeApiImpl
 * JD-Core Version:    0.7.0.1
 */
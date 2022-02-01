package com.tencent.mobileqq.app;

import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

class FriendsManager$1
  extends AccountObserver
{
  FriendsManager$1(FriendsManager paramFriendsManager) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.executeOnSubThread(new FriendsManager.1.1(this, paramString2, paramString1));
  }
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, long paramLong1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onOnlineStatusChanged isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" ,curStatus =  , isUserSet = ");
      ((StringBuilder)localObject).append(paramStatus);
      ((StringBuilder)localObject).append(" ,isFriendListChang = ");
      ((StringBuilder)localObject).append(paramBoolean3);
      ((StringBuilder)localObject).append(" ,timeStamp = ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(" ,isGatherListChange = ");
      ((StringBuilder)localObject).append(paramBoolean4);
      QLog.d("Q.contacttab.friend", 2, ((StringBuilder)localObject).toString());
    }
    FriendsManager.a(this.a).mAutomator.a(paramBoolean3, paramLong2, paramBoolean4);
    if (!paramBoolean3)
    {
      localObject = new QQProfileItem(FriendsManager.a(this.a));
      FriendsManager.a(this.a).mAutomator.a(101, (CheckUpdateItemInterface)localObject);
    }
    Object localObject = (IOnlineStatusDataManager)((IOnlineStatusManagerService)FriendsManager.a(this.a).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusDataManager.class);
    if (localObject != null) {
      ((IOnlineStatusDataManager)localObject).a(paramBoolean1, paramStatus);
    }
  }
  
  protected void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong)
  {
    super.onOnlineStatusPush(paramStatus, paramLong);
    paramStatus = (IOnlineStatusDataManager)((IOnlineStatusManagerService)FriendsManager.a(this.a).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusDataManager.class);
    if (paramStatus != null) {
      paramStatus.d(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendsManager.1
 * JD-Core Version:    0.7.0.1
 */
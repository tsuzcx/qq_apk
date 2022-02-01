package com.tencent.mobileqq.app;

import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager;
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
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "onOnlineStatusChanged isSuccess = " + paramBoolean1 + " ,curStatus =  , isUserSet = " + paramStatus + " ,isFriendListChang = " + paramBoolean3 + " ,timeStamp = " + paramLong + " ,isGatherListChange = " + paramBoolean4);
    }
    FriendsManager.a(this.a).mAutomator.a(paramBoolean3, paramLong, paramBoolean4);
    if (!paramBoolean3)
    {
      localObject = new QQProfileItem(FriendsManager.a(this.a));
      FriendsManager.a(this.a).mAutomator.a(101, (CheckUpdateItemInterface)localObject);
    }
    Object localObject = (OnlineStatusManager)FriendsManager.a(this.a).getManager(QQManagerFactory.ONLINE_STATUS_MANAGER);
    if (localObject != null) {
      ((OnlineStatusManager)localObject).a(paramBoolean1, paramStatus);
    }
  }
  
  public void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong)
  {
    super.onOnlineStatusPush(paramStatus, paramLong);
    ((OnlineStatusManager)FriendsManager.a(this.a).getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendsManager.1
 * JD-Core Version:    0.7.0.1
 */
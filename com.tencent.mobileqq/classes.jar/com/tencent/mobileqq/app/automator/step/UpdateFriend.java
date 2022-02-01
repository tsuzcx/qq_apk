package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.qphone.base.util.QLog;

public class UpdateFriend
  extends AsyncStep
{
  private FriendListObserver a;
  
  private void a()
  {
    if (this.a == null)
    {
      this.a = new UpdateFriend.MyFriendListObserver(this, null);
      this.mAutomator.k.addObserver(this.a);
    }
    ((FriendListHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getGatheredContactsList(0);
  }
  
  private void b()
  {
    if (this.a == null)
    {
      this.a = new UpdateFriend.MyFriendListObserver(this, null);
      this.mAutomator.k.addObserver(this.a);
    }
    ((FriendListHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true);
  }
  
  protected int doStep()
  {
    if (this.mStepId == 3)
    {
      boolean bool = this.mAutomator.d.getBoolean("isFriendlistok", false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doStep PREF_ISFRIENDLIST_OK=");
        ((StringBuilder)localObject).append(bool);
        QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (FriendsManager)this.mAutomator.k.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (bool)
      {
        FriendListHandler localFriendListHandler = (FriendListHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        bool = ((FriendsManager)localObject).a();
        ((FriendsManager)localObject).f();
        localFriendListHandler.notifyUI(1, bool, Boolean.valueOf(bool));
        this.mAutomator.notifyUI(3, true, Integer.valueOf(1));
        return 7;
      }
      ((FriendsManager)localObject).a();
      ((FriendsManager)localObject).f();
      b();
      return 2;
    }
    if (this.mStepId == 7)
    {
      b();
      return 2;
    }
    a();
    return 2;
  }
  
  public void onCreate()
  {
    if (this.mStepId == 3) {
      ((IPhoneContactService)this.mAutomator.k.getRuntimeService(IPhoneContactService.class, "")).initContactCache();
    }
    int i;
    if (this.mStepId == 8) {
      i = 0;
    } else {
      i = 2;
    }
    this.mCountRetry = i;
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.mAutomator.k.removeObserver(this.a);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateFriend
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.qphone.base.util.QLog;

public class StrangerAddFriendHelper
  extends AddFriendHelper
{
  private ShieldListObserver k = new StrangerAddFriendHelper.1(this);
  
  public StrangerAddFriendHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected boolean h()
  {
    if (((FullScreenInputHelper)this.a.a(24)).e()) {
      return false;
    }
    if (this.a.l()) {
      return false;
    }
    if (this.e.a == 10007) {
      return false;
    }
    if (this.e.a == 1006)
    {
      PhoneContact localPhoneContact = ((IPhoneContactService)this.b.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(this.e.b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("StrangerChatPie.showorhideAddFriend curFriendUin=");
        localStringBuilder.append(this.e.b);
        localStringBuilder.append(" contact=");
        String str;
        if (localPhoneContact == null) {
          str = "null";
        } else {
          str = "real";
        }
        localStringBuilder.append(str);
        QLog.d("StrangerAddFriendHelper", 2, localStringBuilder.toString());
      }
      if (localPhoneContact != null) {
        return false;
      }
    }
    if (this.e.a == 10004) {
      return false;
    }
    return !((FriendsManager)this.b.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(this.e.b);
  }
  
  public void onMoveToState(int paramInt)
  {
    super.onMoveToState(paramInt);
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      this.b.removeObserver(this.k);
      return;
    }
    this.b.addObserver(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.StrangerAddFriendHelper
 * JD-Core Version:    0.7.0.1
 */
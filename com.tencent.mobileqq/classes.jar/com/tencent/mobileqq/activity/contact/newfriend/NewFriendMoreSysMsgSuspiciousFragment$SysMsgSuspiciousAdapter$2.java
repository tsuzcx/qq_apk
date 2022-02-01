package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import java.util.List;
import mqq.os.MqqHandler;

class NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter$2
  implements Runnable
{
  NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter$2(NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter paramSysMsgSuspiciousAdapter) {}
  
  public void run()
  {
    List localList = NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.a(this.this$0).getAllSysSuspiciousMsg();
    ThreadManager.getUIHandler().post(new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.contact.newfriend;

import ahma;
import alxr;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter$2
  implements Runnable
{
  public NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter$2(ahma paramahma) {}
  
  public void run()
  {
    List localList = ahma.a(this.this$0).b();
    ThreadManager.getUIHandler().post(new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2
 * JD-Core Version:    0.7.0.1
 */
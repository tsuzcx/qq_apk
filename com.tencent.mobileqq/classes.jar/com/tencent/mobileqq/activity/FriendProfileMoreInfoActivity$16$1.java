package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import mqq.os.MqqHandler;

class FriendProfileMoreInfoActivity$16$1
  implements Runnable
{
  FriendProfileMoreInfoActivity$16$1(FriendProfileMoreInfoActivity.16 param16, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  public void run()
  {
    ((IBizTroopMemberInfoService)this.f.a.app.getRuntimeService(IBizTroopMemberInfoService.class, "")).saveHomeworkTroopMemberIdentity(this.f.a.J, this.a, this.b, this.c, this.d, this.e);
    ThreadManager.getUIHandler().post(new FriendProfileMoreInfoActivity.16.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.16.1
 * JD-Core Version:    0.7.0.1
 */
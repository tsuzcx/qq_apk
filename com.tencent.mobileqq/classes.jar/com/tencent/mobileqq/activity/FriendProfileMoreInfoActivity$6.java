package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;

class FriendProfileMoreInfoActivity$6
  implements Runnable
{
  FriendProfileMoreInfoActivity$6(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void run()
  {
    Card localCard = ((FriendsManager)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).g(this.this$0.app.getCurrentAccountUin());
    this.this$0.app.runOnUiThread(new FriendProfileMoreInfoActivity.6.1(this, localCard));
    ((IProfileProtocolService)this.this$0.app.getRuntimeService(IProfileProtocolService.class, "all")).getProfileDetailForEdit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.6
 * JD-Core Version:    0.7.0.1
 */
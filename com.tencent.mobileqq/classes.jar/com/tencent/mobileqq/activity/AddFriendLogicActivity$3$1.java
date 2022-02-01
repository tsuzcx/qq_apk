package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class AddFriendLogicActivity$3$1
  implements Runnable
{
  AddFriendLogicActivity$3$1(AddFriendLogicActivity.3 param3, String paramString) {}
  
  public void run()
  {
    ((FriendListHandler)this.b.a.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).addFriendToFriendList(this.a, 0, 3999, "", true, false, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity.3.1
 * JD-Core Version:    0.7.0.1
 */
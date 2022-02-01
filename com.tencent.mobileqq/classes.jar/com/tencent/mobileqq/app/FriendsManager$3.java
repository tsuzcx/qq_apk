package com.tencent.mobileqq.app;

import anvk;

public class FriendsManager$3
  implements Runnable
{
  public FriendsManager$3(anvk paramanvk) {}
  
  public void run()
  {
    this.this$0.a();
    anvk.a(this.this$0, "buildGroupList2");
    ((FriendListHandler)anvk.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(103, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendsManager.3
 * JD-Core Version:    0.7.0.1
 */
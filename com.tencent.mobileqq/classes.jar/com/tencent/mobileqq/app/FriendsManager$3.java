package com.tencent.mobileqq.app;

import amsw;

public class FriendsManager$3
  implements Runnable
{
  public FriendsManager$3(amsw paramamsw) {}
  
  public void run()
  {
    this.this$0.a();
    amsw.a(this.this$0, "buildGroupList2");
    ((FriendListHandler)amsw.a(this.this$0).getBusinessHandler(1)).notifyUI(103, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendsManager.3
 * JD-Core Version:    0.7.0.1
 */
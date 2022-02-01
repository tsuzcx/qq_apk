package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.FriendListObserver;

class CheckFriendsLastLoginInfo$MyFriendListObserver
  extends FriendListObserver
{
  private CheckFriendsLastLoginInfo$MyFriendListObserver(CheckFriendsLastLoginInfo paramCheckFriendsLastLoginInfo) {}
  
  protected void onUpdateLastLoginInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.a.setResult(6);
    }
    else if (paramBoolean2)
    {
      i = 1;
      break label27;
    }
    int i = 0;
    label27:
    if (i != 0) {
      this.a.setResult(7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckFriendsLastLoginInfo.MyFriendListObserver
 * JD-Core Version:    0.7.0.1
 */
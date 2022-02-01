package com.tencent.mobileqq.activity.selectmember;

import com.tencent.mobileqq.app.FriendListObserver;

class FriendTeamListInnerFrame$4
  extends FriendListObserver
{
  FriendTeamListInnerFrame$4(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      FriendTeamListInnerFrame.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame.4
 * JD-Core Version:    0.7.0.1
 */
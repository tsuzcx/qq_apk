package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.friend.api.callback.GetGroupListCallback;
import java.util.List;

class FriendsManager$3
  implements GetGroupListCallback
{
  FriendsManager$3(FriendsManager paramFriendsManager) {}
  
  public void a(List<Groups> paramList)
  {
    ((FriendListHandler)FriendsManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(101, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendsManager.3
 * JD-Core Version:    0.7.0.1
 */
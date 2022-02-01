package com.tencent.mobileqq.addfriend.ui;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;

class AddFriendCheckFragment$8$1
  implements Runnable
{
  AddFriendCheckFragment$8$1(AddFriendCheckFragment.8 param8, String paramString) {}
  
  public void run()
  {
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).addFriendToFriendList(AddFriendCheckFragment.f(this.b.a), this.a, 0, 3999, "", true, false, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment.8.1
 * JD-Core Version:    0.7.0.1
 */
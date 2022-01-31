package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.profile.view.ProfileHeaderView;

class FriendCardApolloViewController$2
  implements Runnable
{
  FriendCardApolloViewController$2(FriendCardApolloViewController paramFriendCardApolloViewController, ProfileHeaderView paramProfileHeaderView) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (this.a == null)) {
      return;
    }
    int i = (int)this.this$0.a.getManRectMaxHeight();
    this.a.c(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController.2
 * JD-Core Version:    0.7.0.1
 */
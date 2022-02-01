package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;

class FriendCardApolloViewController$2
  implements Runnable
{
  FriendCardApolloViewController$2(FriendCardApolloViewController paramFriendCardApolloViewController, AbsProfileHeaderView paramAbsProfileHeaderView) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (this.a == null)) {
      return;
    }
    int i = (int)this.this$0.a.getManRectMaxHeight();
    this.a.onApolloExpand(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController.2
 * JD-Core Version:    0.7.0.1
 */
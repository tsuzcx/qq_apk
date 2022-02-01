package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.widget.AbsListView.OnScrollListener;

class FriendProfileCardActivity$23
  implements IProfileActivityDelegate
{
  FriendProfileCardActivity$23(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void addFriend()
  {
    FriendProfileCardActivity.a(this.a);
  }
  
  public void addProfileScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a.a(paramOnScrollListener);
  }
  
  public void notifyCardUpdate()
  {
    this.a.a(this.a.a.a, false, 8);
  }
  
  public void removeProfileScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a.b(paramOnScrollListener);
  }
  
  public void requestUpdateCard()
  {
    this.a.a(0L, null, null, false);
  }
  
  public void scrollToMoreInfoView(int paramInt)
  {
    this.a.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.23
 * JD-Core Version:    0.7.0.1
 */
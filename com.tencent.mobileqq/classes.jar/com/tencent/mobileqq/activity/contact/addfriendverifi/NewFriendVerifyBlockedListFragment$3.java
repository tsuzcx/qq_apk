package com.tencent.mobileqq.activity.contact.addfriendverifi;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class NewFriendVerifyBlockedListFragment$3
  implements AbsListView.OnScrollListener
{
  NewFriendVerifyBlockedListFragment$3(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (NewFriendVerifyBlockedListFragment.a(this.a) != null)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        NewFriendVerifyBlockedListFragment.a(this.a).a();
      }
    }
    else {
      return;
    }
    NewFriendVerifyBlockedListFragment.a(this.a).b();
    NewFriendVerifyBlockedListFragment.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment.3
 * JD-Core Version:    0.7.0.1
 */
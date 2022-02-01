package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.view.View.OnClickListener;
import com.tencent.widget.ExpandableListView.OnGroupExpandListener;

class FriendListFragment$1
  implements ExpandableListView.OnGroupExpandListener
{
  FriendListFragment$1(FriendListFragment paramFriendListFragment) {}
  
  public void onGroupExpand(int paramInt)
  {
    if (FriendListFragment.a(this.a) != null) {
      FriendListFragment.a(this.a).onClick(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FriendListFragment.1
 * JD-Core Version:    0.7.0.1
 */
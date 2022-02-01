package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.view.View.OnClickListener;
import com.tencent.widget.ExpandableListView.OnGroupCollapseListener;

class FriendListFragment$2
  implements ExpandableListView.OnGroupCollapseListener
{
  FriendListFragment$2(FriendListFragment paramFriendListFragment) {}
  
  public void onGroupCollapse(int paramInt)
  {
    if (FriendListFragment.a(this.a) != null) {
      FriendListFragment.a(this.a).onClick(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FriendListFragment.2
 * JD-Core Version:    0.7.0.1
 */
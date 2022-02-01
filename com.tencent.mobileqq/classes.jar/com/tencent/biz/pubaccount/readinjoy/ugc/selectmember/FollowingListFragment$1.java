package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.FollowingMember;
import java.util.List;

class FollowingListFragment$1
  extends ReadInJoyObserver
{
  FollowingListFragment$1(FollowingListFragment paramFollowingListFragment) {}
  
  public void b(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2)
  {
    FollowingListFragment.a(this.a, paramList);
    if (FollowingListFragment.a(this.a) != null) {
      FollowingListFragment.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FollowingListFragment.1
 * JD-Core Version:    0.7.0.1
 */
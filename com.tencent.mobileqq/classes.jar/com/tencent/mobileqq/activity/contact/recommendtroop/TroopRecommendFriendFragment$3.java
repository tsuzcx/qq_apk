package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.troop.adapter.QuickRecyclerAdapter.OnItemClickListener;
import com.tencent.mobileqq.troop.recommend.data.RecommendMember;
import com.tencent.mobileqq.troop.utils.TroopUtils;

class TroopRecommendFriendFragment$3
  implements QuickRecyclerAdapter.OnItemClickListener
{
  TroopRecommendFriendFragment$3(TroopRecommendFriendFragment paramTroopRecommendFriendFragment) {}
  
  public void a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!(paramViewHolder instanceof MemberViewHolder)) {
      return;
    }
    paramView = ((MemberViewHolder)paramViewHolder).a;
    TroopUtils.a(TroopRecommendFriendFragment.c(this.a), TroopRecommendFriendFragment.d(this.a), paramView.a, TroopRecommendFriendFragment.e(this.a), TroopRecommendFriendFragment.f(this.a));
  }
  
  public boolean b(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment.3
 * JD-Core Version:    0.7.0.1
 */
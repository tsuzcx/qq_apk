package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.adapter.CommonAdapter;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;
import com.tencent.mobileqq.troop.recommend.data.RecommendMember;

class TroopRecommendFriendFragment$2
  extends CommonAdapter<RecommendMember>
{
  TroopRecommendFriendFragment$2(TroopRecommendFriendFragment paramTroopRecommendFriendFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new MemberViewHolder(paramContext, LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
  
  protected void a(ViewHolder paramViewHolder, RecommendMember paramRecommendMember, int paramInt)
  {
    TroopRecommendFriendFragment.a(this.a, paramViewHolder, paramRecommendMember, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment.2
 * JD-Core Version:    0.7.0.1
 */
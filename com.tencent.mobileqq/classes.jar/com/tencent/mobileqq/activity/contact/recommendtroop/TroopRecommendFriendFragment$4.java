package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.recommend.data.RecommendMember;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopRecommendFriendFragment$4
  implements View.OnClickListener
{
  TroopRecommendFriendFragment$4(TroopRecommendFriendFragment paramTroopRecommendFriendFragment, RecommendMember paramRecommendMember) {}
  
  public void onClick(View paramView)
  {
    TroopRecommendFriendFragment localTroopRecommendFriendFragment = this.b;
    TroopRecommendFriendFragment.a(localTroopRecommendFriendFragment, TroopRecommendFriendFragment.f(localTroopRecommendFriendFragment), this.a.a, TroopRecommendFriendFragment.f(this.b));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RecommendTroopAdapter$1
  implements View.OnClickListener
{
  RecommendTroopAdapter$1(RecommendTroopAdapter paramRecommendTroopAdapter) {}
  
  public void onClick(View paramView)
  {
    RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)paramView.getTag(-1);
    TroopUtils.a(RecommendTroopAdapter.a(this.a), localRecommendTroopItem, this.a.a());
    this.a.b(localRecommendTroopItem);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopAdapter.1
 * JD-Core Version:    0.7.0.1
 */
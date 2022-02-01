package com.tencent.biz.qqstory.troop.memories;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopStoryMemoriesListAdapter$ShootingItemViewHolder$1
  implements View.OnClickListener
{
  TroopStoryMemoriesListAdapter$ShootingItemViewHolder$1(TroopStoryMemoriesListAdapter.ShootingItemViewHolder paramShootingItemViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.a != null) {
      this.a.a.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.ShootingItemViewHolder.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqstory.troop.memories;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopStoryMemoriesListAdapter$VideoItemViewHolder$1
  implements View.OnClickListener
{
  TroopStoryMemoriesListAdapter$VideoItemViewHolder$1(TroopStoryMemoriesListAdapter.VideoItemViewHolder paramVideoItemViewHolder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.b.g.c != null) {
      this.b.g.c.a(this.a, this.b.f);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.VideoItemViewHolder.1
 * JD-Core Version:    0.7.0.1
 */
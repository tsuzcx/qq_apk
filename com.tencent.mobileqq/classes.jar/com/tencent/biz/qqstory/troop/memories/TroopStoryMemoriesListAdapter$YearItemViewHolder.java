package com.tencent.biz.qqstory.troop.memories;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.DateUtils;

class TroopStoryMemoriesListAdapter$YearItemViewHolder
{
  public TextView a;
  public TextView b;
  
  public TroopStoryMemoriesListAdapter$YearItemViewHolder(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131450356));
    this.b = ((TextView)paramView.findViewById(2131449518));
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo)
  {
    this.a.setText(DateUtils.d(paramTroopStoryItemInfo.publishTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.YearItemViewHolder
 * JD-Core Version:    0.7.0.1
 */
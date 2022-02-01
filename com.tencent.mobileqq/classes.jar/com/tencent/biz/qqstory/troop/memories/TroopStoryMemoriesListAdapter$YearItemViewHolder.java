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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381304));
    this.b = ((TextView)paramView.findViewById(2131380561));
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(DateUtils.c(paramTroopStoryItemInfo.publishTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.YearItemViewHolder
 * JD-Core Version:    0.7.0.1
 */
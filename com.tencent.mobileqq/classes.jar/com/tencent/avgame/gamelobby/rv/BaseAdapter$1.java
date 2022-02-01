package com.tencent.avgame.gamelobby.rv;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;

class BaseAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  BaseAdapter$1(BaseAdapter paramBaseAdapter, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.getItemViewType(paramInt) != 7) {
      return this.jdField_a_of_type_AndroidxRecyclerviewWidgetGridLayoutManager.getSpanCount();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.BaseAdapter.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.wtogether.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QGroupExpandableListAdapter$2
  implements View.OnClickListener
{
  QGroupExpandableListAdapter$2(QGroupExpandableListAdapter paramQGroupExpandableListAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter.a[this.jdField_a_of_type_Int] = 2;
    this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter.notifyDataSetChanged();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter.2
 * JD-Core Version:    0.7.0.1
 */
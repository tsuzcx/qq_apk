package com.tencent.mobileqq.activity.contact.recommendtroop.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QuickRecyclerAdapter$2
  implements View.OnClickListener
{
  QuickRecyclerAdapter$2(QuickRecyclerAdapter paramQuickRecyclerAdapter, ViewHolder paramViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseQuickRecyclerAdapter.a != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseViewHolder.getAdapterPosition();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseQuickRecyclerAdapter.a.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseViewHolder, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.base.QuickRecyclerAdapter.2
 * JD-Core Version:    0.7.0.1
 */
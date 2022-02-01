package com.tencent.mobileqq.activity.contact.recommendtroop.base;

import android.view.View;
import android.view.View.OnLongClickListener;

class QuickRecyclerAdapter$3
  implements View.OnLongClickListener
{
  QuickRecyclerAdapter$3(QuickRecyclerAdapter paramQuickRecyclerAdapter, ViewHolder paramViewHolder) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseQuickRecyclerAdapter.a != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseViewHolder.getAdapterPosition();
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseQuickRecyclerAdapter.a.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseViewHolder, i);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.base.QuickRecyclerAdapter.3
 * JD-Core Version:    0.7.0.1
 */
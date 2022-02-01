package com.tencent.mobileqq.activity.contact.recommendtroop.base;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class QuickRecyclerAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  QuickRecyclerAdapter$1(QuickRecyclerAdapter paramQuickRecyclerAdapter, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseQuickRecyclerAdapter.a(paramInt)) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseQuickRecyclerAdapter.b(paramInt)) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseQuickRecyclerAdapter.c(paramInt)) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseQuickRecyclerAdapter.b())) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getSpanCount();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.base.QuickRecyclerAdapter.1
 * JD-Core Version:    0.7.0.1
 */
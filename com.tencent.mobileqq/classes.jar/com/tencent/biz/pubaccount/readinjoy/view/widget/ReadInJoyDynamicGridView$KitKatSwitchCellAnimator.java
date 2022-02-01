package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.view.ViewTreeObserver;

class ReadInJoyDynamicGridView$KitKatSwitchCellAnimator
  implements ReadInJoyDynamicGridView.SwitchCellAnimator
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public ReadInJoyDynamicGridView$KitKatSwitchCellAnimator(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.getViewTreeObserver().addOnPreDrawListener(new ReadInJoyDynamicGridView.KitKatSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener(this, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView), paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.KitKatSwitchCellAnimator
 * JD-Core Version:    0.7.0.1
 */
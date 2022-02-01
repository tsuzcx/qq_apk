package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  ReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator$AnimateSwitchViewOnPreDrawListener(ReadInJoyNinePicDeliverDynamicGridView.KitKatSwitchCellAnimator paramKitKatSwitchCellAnimator, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a) + ReadInJoyNinePicDeliverDynamicGridView.KitKatSwitchCellAnimator.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a) + ReadInJoyNinePicDeliverDynamicGridView.KitKatSwitchCellAnimator.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView$KitKatSwitchCellAnimator.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView.KitKatSwitchCellAnimator.AnimateSwitchViewOnPreDrawListener
 * JD-Core Version:    0.7.0.1
 */
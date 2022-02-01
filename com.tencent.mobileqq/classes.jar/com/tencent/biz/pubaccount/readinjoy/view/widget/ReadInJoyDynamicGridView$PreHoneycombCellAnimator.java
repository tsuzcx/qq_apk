package com.tencent.biz.pubaccount.readinjoy.view.widget;

class ReadInJoyDynamicGridView$PreHoneycombCellAnimator
  implements ReadInJoyDynamicGridView.SwitchCellAnimator
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public ReadInJoyDynamicGridView$PreHoneycombCellAnimator(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView) + this.jdField_a_of_type_Int);
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView) + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.PreHoneycombCellAnimator
 * JD-Core Version:    0.7.0.1
 */
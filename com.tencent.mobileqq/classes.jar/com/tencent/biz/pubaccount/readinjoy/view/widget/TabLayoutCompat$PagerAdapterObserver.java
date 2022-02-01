package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.database.DataSetObserver;

class TabLayoutCompat$PagerAdapterObserver
  extends DataSetObserver
{
  private boolean jdField_a_of_type_Boolean;
  
  TabLayoutCompat$PagerAdapterObserver(TabLayoutCompat paramTabLayoutCompat) {}
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a != null) && (TabLayoutCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat) != null))
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a.getCurrentItem();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.b() == i) {
        TabLayoutCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat).b(i, 300);
      }
    }
    if (TabLayoutCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat) != null) {
      TabLayoutCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat).a();
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onChanged()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.b();
      return;
    }
    a();
  }
  
  public void onInvalidated()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.b();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.PagerAdapterObserver
 * JD-Core Version:    0.7.0.1
 */
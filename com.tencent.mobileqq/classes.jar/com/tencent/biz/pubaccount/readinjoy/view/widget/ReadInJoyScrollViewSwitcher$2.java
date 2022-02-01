package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyScrollViewSwitcher$2
  implements View.OnClickListener
{
  ReadInJoyScrollViewSwitcher$2(ReadInJoyScrollViewSwitcher paramReadInJoyScrollViewSwitcher, ReadInJoyScrollViewSwitcher.ScrollItem paramScrollItem) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher.a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher$ScrollItem);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyScrollViewSwitcher.2
 * JD-Core Version:    0.7.0.1
 */
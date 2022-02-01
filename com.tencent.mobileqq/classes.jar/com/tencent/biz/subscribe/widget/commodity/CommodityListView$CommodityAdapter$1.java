package com.tencent.biz.subscribe.widget.commodity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class CommodityListView$CommodityAdapter$1
  implements View.OnClickListener
{
  CommodityListView$CommodityAdapter$1(CommodityListView.CommodityAdapter paramCommodityAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int < CommodityListView.CommodityAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$CommodityAdapter).size())
    {
      CommodityListView.CommodityAdapter.b(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$CommodityAdapter).remove(this.jdField_a_of_type_Int);
      ((ArrayList)this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$CommodityAdapter.a.a()).remove(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$CommodityAdapter.notifyDataSetChanged();
      if (CommodityListView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$CommodityAdapter.a) != null) {
        CommodityListView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$CommodityAdapter.a).a(CommodityListView.CommodityAdapter.c(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$CommodityAdapter).size());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityListView.CommodityAdapter.1
 * JD-Core Version:    0.7.0.1
 */
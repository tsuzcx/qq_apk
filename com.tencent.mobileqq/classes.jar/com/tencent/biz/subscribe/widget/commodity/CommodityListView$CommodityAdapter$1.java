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
    if (this.a < CommodityListView.CommodityAdapter.a(this.b).size())
    {
      CommodityListView.CommodityAdapter.b(this.b).remove(this.a);
      ((ArrayList)this.b.a.getData()).remove(this.a);
      this.b.notifyDataSetChanged();
      if (CommodityListView.c(this.b.a) != null) {
        CommodityListView.c(this.b.a).a(CommodityListView.CommodityAdapter.c(this.b).size());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityListView.CommodityAdapter.1
 * JD-Core Version:    0.7.0.1
 */
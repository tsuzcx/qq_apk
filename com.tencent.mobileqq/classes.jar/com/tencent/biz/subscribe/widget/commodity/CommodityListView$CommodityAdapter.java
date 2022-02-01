package com.tencent.biz.subscribe.widget.commodity;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.part.block.base.BaseListViewAdapter;
import com.tencent.biz.subscribe.part.block.base.BaseListViewAdapter.BaseVH;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;

public class CommodityListView$CommodityAdapter
  extends BaseListViewAdapter
{
  public CommodityListView$CommodityAdapter(CommodityListView paramCommodityListView) {}
  
  public BaseListViewAdapter.BaseVH a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new CommodityItemView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView.getContext());
    paramViewGroup.setIsPublishUI(CommodityListView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView));
    paramViewGroup.setCurrentFeed(CommodityListView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView));
    return new BaseListViewAdapter.BaseVH(this, paramViewGroup);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!ArrayUtils.a(paramInt, this.jdField_a_of_type_JavaUtilArrayList))
    {
      ((CommodityItemView)paramViewHolder.itemView).setData(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      ((CommodityItemView)paramViewHolder.itemView).b().setOnClickListener(new CommodityListView.CommodityAdapter.1(this, paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityListView.CommodityAdapter
 * JD-Core Version:    0.7.0.1
 */
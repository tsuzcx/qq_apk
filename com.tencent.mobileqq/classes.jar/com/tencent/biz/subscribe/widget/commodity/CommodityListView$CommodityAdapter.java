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
    paramViewGroup = new CommodityItemView(this.a.getContext());
    paramViewGroup.setIsPublishUI(CommodityListView.a(this.a));
    paramViewGroup.setCurrentFeed(CommodityListView.b(this.a));
    return new BaseListViewAdapter.BaseVH(this, paramViewGroup);
  }
  
  public int getItemCount()
  {
    return this.j.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!ArrayUtils.isOutOfArrayIndex(paramInt, this.j))
    {
      ((CommodityItemView)paramViewHolder.itemView).setData(this.j.get(paramInt));
      ((CommodityItemView)paramViewHolder.itemView).getDeleteBtn().setOnClickListener(new CommodityListView.CommodityAdapter.1(this, paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityListView.CommodityAdapter
 * JD-Core Version:    0.7.0.1
 */
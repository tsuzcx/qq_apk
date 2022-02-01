package com.tencent.biz.subscribe.part.extendsblock;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.part.block.base.BaseListViewAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;

public class HorizontalRvInnerView$HorizontalRvAdapter
  extends BaseListViewAdapter
{
  public HorizontalRvInnerView$HorizontalRvAdapter(HorizontalRvInnerView paramHorizontalRvInnerView) {}
  
  public HorizontalRVBlock.CommonRvVH a(ViewGroup paramViewGroup, int paramInt)
  {
    if (HorizontalRvInnerView.a(this.jdField_a_of_type_ComTencentBizSubscribePartExtendsblockHorizontalRvInnerView) != null) {
      return HorizontalRvInnerView.a(this.jdField_a_of_type_ComTencentBizSubscribePartExtendsblockHorizontalRvInnerView).a(paramViewGroup, paramInt);
    }
    return null;
  }
  
  public int getItemCount()
  {
    if (HorizontalRvInnerView.a(this.jdField_a_of_type_ComTencentBizSubscribePartExtendsblockHorizontalRvInnerView) != null) {
      return HorizontalRvInnerView.a(this.jdField_a_of_type_ComTencentBizSubscribePartExtendsblockHorizontalRvInnerView).b();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((!ArrayUtils.a(paramInt, this.jdField_a_of_type_JavaUtilArrayList)) && (HorizontalRvInnerView.a(this.jdField_a_of_type_ComTencentBizSubscribePartExtendsblockHorizontalRvInnerView) != null)) {
      HorizontalRvInnerView.a(this.jdField_a_of_type_ComTencentBizSubscribePartExtendsblockHorizontalRvInnerView).a(paramViewHolder, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.extendsblock.HorizontalRvInnerView.HorizontalRvAdapter
 * JD-Core Version:    0.7.0.1
 */
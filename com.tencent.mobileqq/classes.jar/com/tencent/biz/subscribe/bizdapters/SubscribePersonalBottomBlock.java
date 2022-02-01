package com.tencent.biz.subscribe.bizdapters;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.part.extendsblock.SingleViewBlock;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class SubscribePersonalBottomBlock
  extends SingleViewBlock
{
  private BlockMerger.ShareData jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData;
  private RelativePersonalBottomView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView;
  
  public SubscribePersonalBottomBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView = new RelativePersonalBottomView(paramViewGroup.getContext(), paramMultiViewBlock);
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView;
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(LoadInfo paramLoadInfo) {}
  
  public int b()
  {
    RelativePersonalBottomView localRelativePersonalBottomView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView;
    if (localRelativePersonalBottomView != null) {
      return localRelativePersonalBottomView.c();
    }
    return 0;
  }
  
  public void b(String paramString, BlockMerger.ShareData paramShareData)
  {
    super.b(paramString, paramShareData);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData = paramShareData;
    paramString = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView;
    if (paramString != null) {
      paramString.a(paramShareData);
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    RelativePersonalBottomView localRelativePersonalBottomView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView;
    if (localRelativePersonalBottomView != null) {
      localRelativePersonalBottomView.a(this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.SubscribePersonalBottomBlock
 * JD-Core Version:    0.7.0.1
 */
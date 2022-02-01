package com.tencent.biz.subscribe.part.extendsblock;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.base.BaseListViewAdapter.BaseVH;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public abstract class HorizontalRVBlock
  extends MultiViewBlock
{
  private HorizontalRvInnerView a;
  
  public HorizontalRVBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public abstract HorizontalRVBlock.CommonRvVH a(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public abstract void a(HorizontalRvInnerView paramHorizontalRvInnerView);
  
  public void b(ArrayList paramArrayList)
  {
    N().clear();
    N().addAll(paramArrayList);
    HorizontalRvInnerView localHorizontalRvInnerView = this.a;
    if (localHorizontalRvInnerView != null) {
      localHorizontalRvInnerView.setData(paramArrayList);
    }
  }
  
  public int c()
  {
    return 3;
  }
  
  public abstract int d();
  
  protected boolean e()
  {
    return false;
  }
  
  public int getItemCount()
  {
    boolean bool = e();
    int i = 1;
    if (bool)
    {
      if (N().size() > 0) {
        return 1;
      }
      i = 0;
    }
    return i;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder.itemView instanceof HorizontalRvInnerView)) {
      this.a.setData(N());
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    this.a = new HorizontalRvInnerView(paramViewGroup.getContext(), this);
    this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup = new BaseListViewAdapter.BaseVH(this, this.a);
    paramViewGroup.setIsRecyclable(false);
    a(this.a);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.extendsblock.HorizontalRVBlock
 * JD-Core Version:    0.7.0.1
 */
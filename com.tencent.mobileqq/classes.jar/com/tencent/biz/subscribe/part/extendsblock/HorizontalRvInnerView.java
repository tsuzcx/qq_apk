package com.tencent.biz.subscribe.part.extendsblock;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import com.tencent.biz.subscribe.part.block.base.SafeLinearLayoutManager;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;

public class HorizontalRvInnerView
  extends RecyclerViewCompat
{
  private HorizontalRVBlock a;
  private LinearLayoutManager b;
  private HorizontalRvInnerView.HorizontalRvAdapter c;
  
  public HorizontalRvInnerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalRvInnerView(Context paramContext, HorizontalRVBlock paramHorizontalRVBlock)
  {
    super(paramContext);
    this.a = paramHorizontalRVBlock;
    setDescendantFocusability(393216);
    this.c = new HorizontalRvInnerView.HorizontalRvAdapter(this);
    setAdapter(this.c);
    this.b = new SafeLinearLayoutManager(getContext(), 0, false);
    setLayoutManager(this.b);
    setOverScrollMode(2);
  }
  
  public HorizontalRvInnerView.HorizontalRvAdapter getHorizontalRvAdapter()
  {
    return this.c;
  }
  
  public void setData(ArrayList paramArrayList)
  {
    HorizontalRvInnerView.HorizontalRvAdapter localHorizontalRvAdapter = this.c;
    if (localHorizontalRvAdapter != null) {
      localHorizontalRvAdapter.b(paramArrayList);
    }
  }
  
  public void setOrientation(int paramInt)
  {
    LinearLayoutManager localLinearLayoutManager = this.b;
    if (localLinearLayoutManager != null) {
      localLinearLayoutManager.setOrientation(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.extendsblock.HorizontalRvInnerView
 * JD-Core Version:    0.7.0.1
 */
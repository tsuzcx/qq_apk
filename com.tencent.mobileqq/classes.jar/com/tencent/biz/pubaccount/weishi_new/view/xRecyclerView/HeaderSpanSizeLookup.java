package com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;

public class HeaderSpanSizeLookup
  extends GridLayoutManager.SpanSizeLookup
{
  private final RecyclerViewHeaderViewAdapter a;
  private final GridLayoutManager b;
  private GridLayoutManager.SpanSizeLookup c;
  
  public HeaderSpanSizeLookup(RecyclerViewHeaderViewAdapter paramRecyclerViewHeaderViewAdapter, GridLayoutManager paramGridLayoutManager)
  {
    this.a = paramRecyclerViewHeaderViewAdapter;
    this.b = paramGridLayoutManager;
  }
  
  public void a(GridLayoutManager.SpanSizeLookup paramSpanSizeLookup)
  {
    this.c = paramSpanSizeLookup;
  }
  
  public int getSpanSize(int paramInt)
  {
    paramInt = this.a.getItemViewType(paramInt);
    if ((!this.a.a(paramInt)) && (!this.a.b(paramInt)) && (paramInt != 1024) && (paramInt != 1025)) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    if (paramInt != 0) {
      return this.b.getSpanCount();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.HeaderSpanSizeLookup
 * JD-Core Version:    0.7.0.1
 */
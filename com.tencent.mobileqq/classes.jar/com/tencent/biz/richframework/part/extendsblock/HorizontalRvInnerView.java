package com.tencent.biz.richframework.part.extendsblock;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HorizontalRvInnerView
  extends RecyclerView
{
  private HorizontalRVBlock a;
  private LinearLayoutManager b;
  private HorizontalRvInnerView.HorizontalRvAdapter c;
  
  public HorizontalRvInnerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalRvInnerView.HorizontalRvAdapter getHorizontalRvAdapter()
  {
    return this.c;
  }
  
  public void setData(List paramList)
  {
    HorizontalRvInnerView.HorizontalRvAdapter localHorizontalRvAdapter = this.c;
    if (localHorizontalRvAdapter != null) {
      localHorizontalRvAdapter.setDatas(paramList);
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
 * Qualified Name:     com.tencent.biz.richframework.part.extendsblock.HorizontalRvInnerView
 * JD-Core Version:    0.7.0.1
 */
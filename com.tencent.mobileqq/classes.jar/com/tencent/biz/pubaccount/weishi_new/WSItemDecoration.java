package com.tencent.biz.pubaccount.weishi_new;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;

public class WSItemDecoration
  extends RecyclerView.ItemDecoration
{
  public static final int a = WSFeedUtils.a(5.0F);
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    if ((paramRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager))
    {
      paramView = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      i = paramView.getSpanIndex();
      if (paramView.isFullSpan())
      {
        paramRect.left = a;
        paramRect.right = a;
        paramRect.top = a;
      }
    }
    while ((!(paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) || (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).getOrientation() != 0)) {
      for (;;)
      {
        int i;
        return;
        if (i % 2 == 0)
        {
          paramRect.left = a;
          paramRect.right = (a / 2);
        }
        else
        {
          paramRect.left = (a / 2);
          paramRect.right = a;
        }
      }
    }
    paramRect.right = a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSItemDecoration
 * JD-Core Version:    0.7.0.1
 */
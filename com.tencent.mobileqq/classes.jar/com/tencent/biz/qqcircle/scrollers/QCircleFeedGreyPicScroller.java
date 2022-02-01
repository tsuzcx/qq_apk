package com.tencent.biz.qqcircle.scrollers;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter.QCircleVH;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentHorizontalAdapter;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVerticalAdapter.VerticalVH;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import feedcloud.FeedCloudMeta.StFeed;

public class QCircleFeedGreyPicScroller
  extends QCircleFeedBaseScroller
{
  private QCircleFeedGreyPicReport g = new QCircleFeedGreyPicReport();
  
  private void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)paramLayoutManager;
    int i = localLinearLayoutManager.findFirstVisibleItemPosition();
    int j = localLinearLayoutManager.findLastVisibleItemPosition();
    if (i <= j) {
      a(paramLayoutManager, i, j);
    }
  }
  
  private void a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    while (paramInt1 <= paramInt2)
    {
      View localView = paramLayoutManager.findViewByPosition(paramInt1);
      if ((localView != null) && (a(localView))) {
        a(this.b.getChildViewHolder(localView), localView);
      }
      paramInt1 += 1;
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, View paramView)
  {
    if (paramViewHolder != null)
    {
      if (paramView == null) {
        return;
      }
      if ((paramViewHolder instanceof QCircleInsFeedAdapter.QCircleVH))
      {
        this.g.a(c(paramView), paramView);
        return;
      }
      if ((paramViewHolder instanceof QCircleContentVerticalAdapter.VerticalVH)) {
        this.g.a(c(paramViewHolder), paramView);
      }
    }
  }
  
  private void b(RecyclerView.LayoutManager paramLayoutManager)
  {
    Object localObject = (SafeStaggeredGridLayoutManager)paramLayoutManager;
    int[] arrayOfInt = ((SafeStaggeredGridLayoutManager)localObject).findFirstVisibleItemPositions(null);
    localObject = ((SafeStaggeredGridLayoutManager)localObject).findLastVisibleItemPositions(null);
    int i = arrayOfInt[0];
    int j = localObject[0];
    if (i <= j) {
      a(paramLayoutManager, i, j);
    }
  }
  
  private FeedCloudMeta.StFeed c(View paramView)
  {
    if ((paramView instanceof BaseWidgetView))
    {
      paramView = (BaseWidgetView)paramView;
      if ((paramView.getData() instanceof FeedBlockData)) {
        return ((FeedBlockData)paramView.getData()).b();
      }
    }
    return null;
  }
  
  private FeedCloudMeta.StFeed c(RecyclerView.ViewHolder paramViewHolder)
  {
    return ((QCircleContentVerticalAdapter.VerticalVH)paramViewHolder).a().a();
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super.a(paramRecyclerView, paramInt1, paramInt2, paramBoolean);
    if (this.b == null) {
      return;
    }
    paramRecyclerView = this.b.getLayoutManager();
    if ((paramRecyclerView instanceof SafeStaggeredGridLayoutManager))
    {
      b(paramRecyclerView);
      return;
    }
    if ((paramRecyclerView instanceof LinearLayoutManager)) {
      a(paramRecyclerView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedGreyPicScroller
 * JD-Core Version:    0.7.0.1
 */
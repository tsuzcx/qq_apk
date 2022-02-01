package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;

public class WSVerticalLinearLayoutManager
  extends LinearLayoutManager
{
  private VideoFeedsRecyclerView a;
  
  public WSVerticalLinearLayoutManager(Context paramContext, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
    this.a = paramVideoFeedsRecyclerView;
  }
  
  private boolean a(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    int i = this.a.getChildViewHolder(paramView).getLayoutPosition();
    int j = this.a.b();
    return (j >= 0) && ((i == j + 1) || (i == j - 1));
  }
  
  protected int getExtraLayoutSpace(RecyclerView.State paramState)
  {
    return super.getExtraLayoutSpace(paramState) + 200;
  }
  
  public void removeAndRecycleView(View paramView, RecyclerView.Recycler paramRecycler)
  {
    if (!a(paramView)) {
      super.removeAndRecycleView(paramView, paramRecycler);
    }
  }
  
  public void removeAndRecycleViewAt(int paramInt, RecyclerView.Recycler paramRecycler)
  {
    if (!a(getChildAt(paramInt))) {
      super.removeAndRecycleViewAt(paramInt, paramRecycler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */
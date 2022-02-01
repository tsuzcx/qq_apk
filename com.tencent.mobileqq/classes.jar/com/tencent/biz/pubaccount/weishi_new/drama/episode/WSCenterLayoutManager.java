package com.tencent.biz.pubaccount.weishi_new.drama.episode;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.State;

public class WSCenterLayoutManager
  extends LinearLayoutManager
{
  int a;
  
  public WSCenterLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramInt;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    paramRecyclerView = new WSCenterLayoutManager.CenterSmoothScroller(paramRecyclerView.getContext(), this.a);
    paramRecyclerView.setTargetPosition(paramInt);
    startSmoothScroll(paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.episode.WSCenterLayoutManager
 * JD-Core Version:    0.7.0.1
 */
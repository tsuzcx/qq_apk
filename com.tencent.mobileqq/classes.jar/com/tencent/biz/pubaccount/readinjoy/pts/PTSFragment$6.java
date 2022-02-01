package com.tencent.biz.pubaccount.readinjoy.pts;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;

class PTSFragment$6
  extends RecyclerView.OnScrollListener
{
  PTSFragment$6(PTSFragment paramPTSFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      DropFrameMonitor.a().a("list_kandian_daily_new", false);
      return;
    }
    DropFrameMonitor.a().a("list_kandian_daily_new");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment.6
 * JD-Core Version:    0.7.0.1
 */
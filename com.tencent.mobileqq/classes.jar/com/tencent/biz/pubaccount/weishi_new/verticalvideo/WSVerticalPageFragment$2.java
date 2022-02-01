package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.util.WSMonitorUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.view.WSSwipeRefreshLayout;

class WSVerticalPageFragment$2
  extends RecyclerView.OnScrollListener
{
  WSVerticalPageFragment$2(WSVerticalPageFragment paramWSVerticalPageFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      WSMonitorUtil.a("weishi_video_play_list");
      return;
    }
    WSMonitorUtil.a(this.a.getActivity(), "weishi_video_play_list");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    if ((paramRecyclerView == null) || (paramRecyclerView.getChildCount() == 0)) {}
    for (paramInt1 = 0;; paramInt1 = paramRecyclerView.getChildAt(0).getTop())
    {
      paramRecyclerView = WSVerticalPageFragment.a(this.a);
      boolean bool1 = bool2;
      if (paramInt1 >= 0)
      {
        bool1 = bool2;
        if (WSVerticalPageFragment.a(this.a) != null)
        {
          bool1 = bool2;
          if (((WSVerticalPageContract.Presenter)WSVerticalPageFragment.b(this.a)).a()) {
            bool1 = true;
          }
        }
      }
      paramRecyclerView.setEnabled(bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment.2
 * JD-Core Version:    0.7.0.1
 */
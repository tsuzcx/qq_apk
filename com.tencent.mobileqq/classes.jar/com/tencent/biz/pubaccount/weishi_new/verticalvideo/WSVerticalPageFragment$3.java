package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSMonitorUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.view.WSSwipeRefreshLayout;
import com.tencent.biz.pubaccount.weishi_new.view.RecyclerViewHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;

class WSVerticalPageFragment$3
  extends RecyclerView.OnScrollListener
{
  WSVerticalPageFragment$3(WSVerticalPageFragment paramWSVerticalPageFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      if (!RecyclerViewHelper.b(paramRecyclerView)) {
        WSVerticalPageFragment.a(this.a, false);
      }
      ((WSVerticalPageContract.Presenter)this.a.aO_()).b(WSVerticalPageFragment.f(this.a).getChildViewHolder(WSVerticalPageFragment.f(this.a).f()));
      WSMonitorUtil.a("weishi_video_play_list");
    }
    else
    {
      ((WSVerticalPageContract.Presenter)this.a.aO_()).a(WSVerticalPageFragment.f(this.a).getCenterVH());
      WSMonitorUtil.a(this.a.getActivity(), "weishi_video_play_list");
    }
    paramRecyclerView = new StringBuilder();
    paramRecyclerView.append("[WSVerticalPageFragment][onScrollStateChanged] newState:");
    paramRecyclerView.append(paramInt);
    WSLog.e("WSVerticalPageFragmentLog", paramRecyclerView.toString());
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    if ((paramRecyclerView != null) && (paramRecyclerView.getChildCount() != 0)) {
      paramInt1 = paramRecyclerView.getChildAt(0).getTop();
    } else {
      paramInt1 = 0;
    }
    Object localObject = WSVerticalPageFragment.c(this.a);
    boolean bool1 = bool2;
    if (paramInt1 >= 0)
    {
      bool1 = bool2;
      if (WSVerticalPageFragment.a(this.a) != null)
      {
        bool1 = bool2;
        if (((WSVerticalPageContract.Presenter)WSVerticalPageFragment.b(this.a)).i()) {
          bool1 = true;
        }
      }
    }
    ((WSSwipeRefreshLayout)localObject).setEnabled(bool1);
    localObject = this.a;
    if ((WSVerticalPageFragment.a((WSVerticalPageFragment)localObject, WSVerticalPageFragment.d((WSVerticalPageFragment)localObject))) && (RecyclerViewHelper.b(paramRecyclerView)) && (!WSVerticalPageFragment.e(this.a)))
    {
      WSVerticalPageFragment.a(this.a, true);
      ((WSVerticalPageContract.Presenter)this.a.aO_()).q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment.3
 * JD-Core Version:    0.7.0.1
 */
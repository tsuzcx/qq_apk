package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.util.WSMonitorUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.view.WSSwipeRefreshLayout;
import com.tencent.biz.pubaccount.weishi_new.view.RecyclerViewHelper;

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
      WSMonitorUtil.a("weishi_video_play_list");
      return;
    }
    WSMonitorUtil.a(this.a.getActivity(), "weishi_video_play_list");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    if ((paramRecyclerView != null) && (paramRecyclerView.getChildCount() != 0)) {
      paramInt1 = paramRecyclerView.getChildAt(0).getTop();
    } else {
      paramInt1 = 0;
    }
    Object localObject = WSVerticalPageFragment.a(this.a);
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
    ((WSSwipeRefreshLayout)localObject).setEnabled(bool1);
    localObject = this.a;
    if ((WSVerticalPageFragment.a((WSVerticalPageFragment)localObject, WSVerticalPageFragment.a((WSVerticalPageFragment)localObject))) && (RecyclerViewHelper.b(paramRecyclerView)) && (!WSVerticalPageFragment.a(this.a)))
    {
      WSVerticalPageFragment.a(this.a, true);
      ((WSVerticalPageContract.Presenter)this.a.b()).j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment.3
 * JD-Core Version:    0.7.0.1
 */
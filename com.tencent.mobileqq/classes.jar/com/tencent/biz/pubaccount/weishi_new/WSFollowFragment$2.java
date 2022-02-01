package com.tencent.biz.pubaccount.weishi_new;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.weishi_new.holder.WSPlayableHolder;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSMonitorUtil;
import com.tencent.biz.pubaccount.weishi_new.view.RecyclerViewHelper;

class WSFollowFragment$2
  extends RecyclerView.OnScrollListener
{
  WSFollowFragment$2(WSFollowFragment paramWSFollowFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 1) {
      WSFollowFragment.a(this.a, true);
    }
    if (paramInt == 0) {
      WSMonitorUtil.a("weishi_follow_list");
    } else {
      WSMonitorUtil.a(this.a.getActivity(), "weishi_follow_list");
    }
    if (RecyclerViewHelper.a(paramRecyclerView)) {
      ((WSFollowPresenter)this.a.b).c();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = WSFollowFragment.a(this.a).b;
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    if (paramRecyclerView == null)
    {
      paramInt1 = WSFollowFragment.b(this.a).findFirstVisibleItemPosition();
      paramRecyclerView = WSFollowFragment.a(this.a, paramInt1, false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mAdapter.mPlayingHolder is null. startPosition:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", lastOrNextVideoHolder:");
      ((StringBuilder)localObject).append(paramRecyclerView);
      WSLog.d("WSFollowContinuePlayLog", ((StringBuilder)localObject).toString());
    }
    else
    {
      paramRecyclerView = this.a;
      localObject = WSFollowFragment.a(paramRecyclerView).b;
      if (paramInt2 > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramRecyclerView = paramRecyclerView.a((WSPlayableHolder)localObject, bool1, false);
    }
    if (WSFollowFragment.a(this.a, paramRecyclerView))
    {
      if (WSFollowFragment.c(this.a))
      {
        WSLog.d("WSFollowContinuePlayLog", "[WSFollowFragment.java][onScrolled] mIsHandlingBackFromVertical true.");
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSFollowFragment.java][onScrolled] playVideo title:");
      ((StringBuilder)localObject).append(paramRecyclerView.a.g);
      ((StringBuilder)localObject).append(", mPlayingHolder:");
      ((StringBuilder)localObject).append(paramRecyclerView);
      WSLog.g("WSFollowContinuePlayLog", ((StringBuilder)localObject).toString());
      WSFollowFragment.b(this.a, paramRecyclerView);
      localObject = this.a;
      bool1 = bool2;
      if (paramInt2 > 0) {
        bool1 = true;
      }
      paramRecyclerView = ((WSFollowFragment)localObject).a(paramRecyclerView, bool1, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSFollowFragment.java][onScrolled] setPrePlayingHolder prePlayHolder:");
      ((StringBuilder)localObject).append(paramRecyclerView);
      WSLog.a("WS_VIDEO_PRE_PLAY", ((StringBuilder)localObject).toString());
      WSFollowFragment.a(this.a).b(paramRecyclerView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.weishi_new.recommend;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSMonitorUtil;
import com.tencent.biz.pubaccount.weishi_new.view.RecyclerViewHelper;

class WSGridPageFragment$3
  extends RecyclerView.OnScrollListener
{
  WSGridPageFragment$3(WSGridPageFragment paramWSGridPageFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 1) {
      WSGridPageFragment.a(this.a, true);
    }
    if (paramInt == 0) {
      WSMonitorUtil.a("weishi_recommend_list");
    } else {
      WSMonitorUtil.a(this.a.getActivity(), "weishi_recommend_list");
    }
    if (RecyclerViewHelper.a(paramRecyclerView)) {
      ((WSGridPageContract.Presenter)this.a.aO_()).i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment.3
 * JD-Core Version:    0.7.0.1
 */
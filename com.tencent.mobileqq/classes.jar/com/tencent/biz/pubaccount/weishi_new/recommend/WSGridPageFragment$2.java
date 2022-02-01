package com.tencent.biz.pubaccount.weishi_new.recommend;

import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.view.WSXRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;

class WSGridPageFragment$2
  implements XRecyclerView.RefreshCallback
{
  WSGridPageFragment$2(WSGridPageFragment paramWSGridPageFragment) {}
  
  public void endOfRefresh()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][endOfRefresh] mSubTabId:");
    localStringBuilder.append(WSGridPageFragment.a(this.a));
    WSLog.e("WSGridPageFragmentLog", localStringBuilder.toString());
    WSGridPageFragment.a(this.a).backToTopAtOnce();
  }
  
  public void startLoadMore(XRecyclerView paramXRecyclerView, int paramInt)
  {
    paramXRecyclerView = new StringBuilder();
    paramXRecyclerView.append("[WSGridPageFragment.java][startLoadMore] mSubTabId:");
    paramXRecyclerView.append(WSGridPageFragment.a(this.a));
    WSLog.e("WSGridPageFragmentLog", paramXRecyclerView.toString());
    ((WSGridPageContract.Presenter)this.a.b()).a(false, false);
    WSGridPageFragment.a(this.a, WSExpABTestManager.a().d());
    ((WSGridPageContract.Presenter)this.a.b()).h();
  }
  
  public void startTopRefresh(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    paramXRecyclerView = new StringBuilder();
    paramXRecyclerView.append("[WSGridPageFragment.java][startTopRefresh] mSubTabId:");
    paramXRecyclerView.append(WSGridPageFragment.a(this.a));
    WSLog.e("WSGridPageFragmentLog", paramXRecyclerView.toString());
    WSGridPageFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment.2
 * JD-Core Version:    0.7.0.1
 */
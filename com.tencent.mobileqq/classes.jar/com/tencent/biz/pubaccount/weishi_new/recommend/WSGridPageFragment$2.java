package com.tencent.biz.pubaccount.weishi_new.recommend;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;

class WSGridPageFragment$2
  implements XRecyclerView.RefreshCallback
{
  WSGridPageFragment$2(WSGridPageFragment paramWSGridPageFragment) {}
  
  public void a()
  {
    WSLog.e("WSGridPageFragmentLog", "[WSGridPageFragment.java][endOfRefresh] mSubTabId:" + WSGridPageFragment.a(this.a));
    WSGridPageFragment.a(this.a).d();
  }
  
  public void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    WSLog.e("WSGridPageFragmentLog", "[WSGridPageFragment.java][startLoadMore] mSubTabId:" + WSGridPageFragment.a(this.a));
    ((WSGridPageContract.Presenter)this.a.b()).a(false, false);
  }
  
  public void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    WSLog.e("WSGridPageFragmentLog", "[WSGridPageFragment.java][startTopRefresh] mSubTabId:" + WSGridPageFragment.a(this.a));
    WSGridPageFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment.2
 * JD-Core Version:    0.7.0.1
 */
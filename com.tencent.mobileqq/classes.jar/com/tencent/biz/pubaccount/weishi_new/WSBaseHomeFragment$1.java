package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;

class WSBaseHomeFragment$1
  implements XRecyclerView.RefreshCallback
{
  WSBaseHomeFragment$1(WSBaseHomeFragment paramWSBaseHomeFragment) {}
  
  public void endOfRefresh()
  {
    this.a.o();
  }
  
  public void startLoadMore(XRecyclerView paramXRecyclerView, int paramInt)
  {
    this.a.a(paramXRecyclerView, paramInt);
  }
  
  public void startTopRefresh(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    this.a.a(paramXRecyclerView, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSBaseHomeFragment.1
 * JD-Core Version:    0.7.0.1
 */
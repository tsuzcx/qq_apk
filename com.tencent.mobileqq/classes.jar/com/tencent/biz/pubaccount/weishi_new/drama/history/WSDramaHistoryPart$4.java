package com.tencent.biz.pubaccount.weishi_new.drama.history;

import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;

class WSDramaHistoryPart$4
  implements XRecyclerView.RefreshCallback
{
  WSDramaHistoryPart$4(WSDramaHistoryPart paramWSDramaHistoryPart) {}
  
  public void endOfRefresh() {}
  
  public void startLoadMore(XRecyclerView paramXRecyclerView, int paramInt)
  {
    WSDramaHistoryPart.d(this.a).a(new FetcherParams(false, false));
  }
  
  public void startTopRefresh(XRecyclerView paramXRecyclerView, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryPart.4
 * JD-Core Version:    0.7.0.1
 */
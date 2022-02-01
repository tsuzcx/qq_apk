package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class RIJInvokeHandler$1
  implements AbsListView.OnScrollListener
{
  RIJInvokeHandler$1(RIJInvokeHandler paramRIJInvokeHandler) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.a.a(paramAbsListView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler.1
 * JD-Core Version:    0.7.0.1
 */
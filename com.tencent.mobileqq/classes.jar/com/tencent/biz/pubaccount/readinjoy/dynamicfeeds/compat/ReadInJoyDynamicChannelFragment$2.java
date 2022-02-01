package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;

class ReadInJoyDynamicChannelFragment$2
  implements XRecyclerView.RefreshCallback
{
  ReadInJoyDynamicChannelFragment$2(ReadInJoyDynamicChannelFragment paramReadInJoyDynamicChannelFragment) {}
  
  public void a()
  {
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "endRefresh.");
  }
  
  public void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "startLoadMore.");
    if (ReadInJoyDynamicChannelFragment.h(this.a) == 40830) {}
    for (paramInt = ReadInJoyDynamicChannelFragment.i(this.a);; paramInt = 1)
    {
      ReadInJoyLogicEngine.a().a(ReadInJoyDynamicChannelFragment.j(this.a), ReadInJoyDynamicChannelFragment.k(this.a), 2, 0, paramInt);
      return;
    }
  }
  
  public void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "startTopRefresh.");
    if (paramBoolean) {}
    for (int i = 1;; i = 3)
    {
      this.a.b(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment.2
 * JD-Core Version:    0.7.0.1
 */
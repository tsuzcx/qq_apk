package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi;

import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;

class ReadInJoyCGIDynamicChannelFragment$2
  implements XRecyclerView.RefreshCallback
{
  ReadInJoyCGIDynamicChannelFragment$2(ReadInJoyCGIDynamicChannelFragment paramReadInJoyCGIDynamicChannelFragment) {}
  
  public void a()
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "endOfRefresh.");
  }
  
  public void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "startLoadMore.");
    paramXRecyclerView = DynamicChannelDataModule.a();
    if (paramXRecyclerView != null) {
      paramXRecyclerView.a(ReadInJoyCGIDynamicChannelFragment.f(this.a), ReadInJoyCGIDynamicChannelFragment.a(this.a).a(), 10);
    }
  }
  
  public void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "startTopRefresh.");
    paramXRecyclerView = DynamicChannelDataModule.a();
    if (paramXRecyclerView != null) {
      paramXRecyclerView.a(ReadInJoyCGIDynamicChannelFragment.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment.2
 * JD-Core Version:    0.7.0.1
 */
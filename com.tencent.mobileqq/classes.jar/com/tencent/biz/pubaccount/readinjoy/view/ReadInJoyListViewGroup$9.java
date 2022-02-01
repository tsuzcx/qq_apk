package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.readinfo.UserReadUnReadInfoManager;

class ReadInJoyListViewGroup$9
  implements Runnable
{
  ReadInJoyListViewGroup$9(ReadInJoyListViewGroup paramReadInJoyListViewGroup, Runnable paramRunnable) {}
  
  public void run()
  {
    if ((UserReadUnReadInfoManager.a().a()) && (!this.this$0.a.a().d())) {
      this.this$0.a(false, 8);
    }
    while (this.a == null) {
      return;
    }
    this.a.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.9
 * JD-Core Version:    0.7.0.1
 */
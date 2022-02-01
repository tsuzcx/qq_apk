package com.tencent.biz.pubaccount.readinjoy.view;

import pmz;
import pnb;
import rbi;

class ReadInJoyListViewGroup$9
  implements Runnable
{
  ReadInJoyListViewGroup$9(ReadInJoyListViewGroup paramReadInJoyListViewGroup, Runnable paramRunnable) {}
  
  public void run()
  {
    if ((rbi.a().a()) && (!this.this$0.a.a().d())) {
      this.this$0.a(false, 8);
    }
    while (this.a == null) {
      return;
    }
    this.a.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.9
 * JD-Core Version:    0.7.0.1
 */
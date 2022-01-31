package com.tencent.biz.pubaccount.readinjoy.view;

import pxe;

class ReadInJoyListViewGroup$46
  implements Runnable
{
  ReadInJoyListViewGroup$46(ReadInJoyListViewGroup paramReadInJoyListViewGroup, Runnable paramRunnable) {}
  
  public void run()
  {
    if ((pxe.a().a()) && (!ReadInJoyListViewGroup.b(this.this$0))) {
      this.this$0.a(false, 8);
    }
    while (this.a == null) {
      return;
    }
    this.a.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.46
 * JD-Core Version:    0.7.0.1
 */
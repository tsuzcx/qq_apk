package com.tencent.biz.pubaccount.readinjoy.view;

import pqj;

class ReadInJoyListViewGroup$48
  implements Runnable
{
  ReadInJoyListViewGroup$48(ReadInJoyListViewGroup paramReadInJoyListViewGroup, Runnable paramRunnable) {}
  
  public void run()
  {
    if ((pqj.a().a()) && (!ReadInJoyListViewGroup.b(this.this$0))) {
      this.this$0.a(false, 8);
    }
    while (this.a == null) {
      return;
    }
    this.a.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.48
 * JD-Core Version:    0.7.0.1
 */
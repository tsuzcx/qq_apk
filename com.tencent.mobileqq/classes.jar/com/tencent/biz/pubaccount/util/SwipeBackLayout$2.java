package com.tencent.biz.pubaccount.util;

import com.tencent.qphone.base.util.QLog;

class SwipeBackLayout$2
  implements Runnable
{
  SwipeBackLayout$2(SwipeBackLayout paramSwipeBackLayout) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_SwipeBackLayout", 2, "isFling:" + this.this$0.c);
    }
    if (!this.this$0.c) {
      this.this$0.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SwipeBackLayout.2
 * JD-Core Version:    0.7.0.1
 */
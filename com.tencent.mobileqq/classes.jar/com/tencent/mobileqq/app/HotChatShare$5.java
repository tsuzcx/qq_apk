package com.tencent.mobileqq.app;

import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class HotChatShare$5
  implements Runnable
{
  HotChatShare$5(HotChatShare paramHotChatShare) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!this.this$0.a.isShowing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "30s has gone, goto share....");
    }
    this.this$0.c();
    HotChatShare.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatShare.5
 * JD-Core Version:    0.7.0.1
 */
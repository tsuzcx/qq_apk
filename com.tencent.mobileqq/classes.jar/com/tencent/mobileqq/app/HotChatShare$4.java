package com.tencent.mobileqq.app;

import ajkp;
import bbms;
import com.tencent.qphone.base.util.QLog;

public class HotChatShare$4
  implements Runnable
{
  public HotChatShare$4(ajkp paramajkp) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!this.this$0.a.isShowing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "30s has gone, goto share....");
    }
    this.this$0.c();
    ajkp.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatShare.4
 * JD-Core Version:    0.7.0.1
 */
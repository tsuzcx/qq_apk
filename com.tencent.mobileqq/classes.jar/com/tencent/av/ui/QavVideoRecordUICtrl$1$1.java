package com.tencent.av.ui;

import java.lang.ref.WeakReference;
import mdd;
import mlf;

class QavVideoRecordUICtrl$1$1
  implements Runnable
{
  QavVideoRecordUICtrl$1$1(QavVideoRecordUICtrl.1 param1) {}
  
  public void run()
  {
    this.a.this$0.c();
    if (((AVActivity)mlf.a(this.a.this$0).get()).a != null) {
      mdd.a(((AVActivity)mlf.a(this.a.this$0).get()).a, 1023, 2131696240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.1.1
 * JD-Core Version:    0.7.0.1
 */
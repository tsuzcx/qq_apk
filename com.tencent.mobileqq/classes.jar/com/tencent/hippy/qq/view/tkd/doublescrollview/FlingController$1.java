package com.tencent.hippy.qq.view.tkd.doublescrollview;

import android.os.Handler;
import android.os.Message;

class FlingController$1
  extends Handler
{
  FlingController$1(FlingController paramFlingController) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      int i = -this.this$0.computeDistance();
      if (this.this$0.isFling) {
        FlingController.access$000(this.this$0).notifyNestViewToFling(0, i);
      }
      if ((Math.abs(i) < 5) || (Math.abs(FlingController.access$100(this.this$0)) < 10)) {
        FlingController.access$200(this.this$0);
      }
    } while (!this.this$0.isFling);
    FlingController.access$300(this.this$0).sendEmptyMessageDelayed(95, 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.doublescrollview.FlingController.1
 * JD-Core Version:    0.7.0.1
 */
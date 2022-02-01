package com.tencent.mobileqq.app;

import android.os.Handler;

class FrameHelperActivity$8
  implements Runnable
{
  FrameHelperActivity$8(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void run()
  {
    if (this.this$0.C() != null)
    {
      if (this.this$0.C().getAppRuntime() == null) {
        return;
      }
      this.this$0.D();
      if (this.this$0.q != null) {
        this.this$0.q.sendEmptyMessage(9);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.8
 * JD-Core Version:    0.7.0.1
 */
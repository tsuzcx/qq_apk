package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;

class MultiVideoEnterPageActivity$RefreshDisplayNameRunnable
  implements Runnable
{
  MultiVideoEnterPageActivity$RefreshDisplayNameRunnable(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void run()
  {
    MultiVideoEnterPageActivity localMultiVideoEnterPageActivity = this.this$0;
    localMultiVideoEnterPageActivity.A += 1;
    if (this.this$0.y != null)
    {
      if (this.this$0.A < 3)
      {
        this.this$0.t.a().postDelayed(this.this$0.y, 1000L);
        return;
      }
      this.this$0.t.a().removeCallbacks(this.this$0.y);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.RefreshDisplayNameRunnable
 * JD-Core Version:    0.7.0.1
 */
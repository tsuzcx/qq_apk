package com.tencent.biz.now;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class NowVideoView$3
  extends Thread
{
  NowVideoView$3(NowVideoView paramNowVideoView) {}
  
  public void run()
  {
    if (this.this$0.z != null) {
      this.this$0.z.set(true);
    } else {
      this.this$0.z = new AtomicBoolean(true);
    }
    for (;;)
    {
      if (!this.this$0.l) {
        if ((this.this$0.y != 0L) && (System.currentTimeMillis() - this.this$0.y > 2000L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("NowVideoView", 2, "no draw for Now");
          }
          this.this$0.m.sendEmptyMessage(1003);
        }
      }
      try
      {
        Thread.sleep(1000L);
      }
      catch (Exception localException) {}
      this.this$0.z.set(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoView.3
 * JD-Core Version:    0.7.0.1
 */
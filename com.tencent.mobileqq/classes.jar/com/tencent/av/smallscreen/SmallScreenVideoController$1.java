package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import java.util.Timer;
import java.util.TimerTask;

class SmallScreenVideoController$1
  extends TimerTask
{
  SmallScreenVideoController$1(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  public void run()
  {
    if (this.this$0.s != null)
    {
      if (this.this$0.u == null) {
        return;
      }
      SessionInfo localSessionInfo = this.this$0.s.k();
      if (localSessionInfo == null) {
        return;
      }
      if (localSessionInfo.bT <= 0)
      {
        if (this.this$0.e != null)
        {
          this.this$0.e.cancel();
          this.this$0.e = null;
        }
        return;
      }
      long l1 = this.this$0.u.c(this.this$0.s.k().s);
      long l2 = System.currentTimeMillis();
      if ((l1 != 0L) && (l2 - l1 > this.this$0.s.k().bT * 1000)) {
        this.this$0.r.runOnUiThread(new SmallScreenVideoController.1.1(this, l2, l1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.1
 * JD-Core Version:    0.7.0.1
 */
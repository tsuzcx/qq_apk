package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.ControlUIObserver;

class SmallScreenVideoController$OnResumeRunnable
  implements Runnable
{
  long a;
  
  SmallScreenVideoController$OnResumeRunnable(SmallScreenVideoController paramSmallScreenVideoController, long paramLong)
  {
    this.a = paramLong;
  }
  
  public void run()
  {
    if (this.this$0.s == null) {
      return;
    }
    if (this.this$0.s.k() == null) {
      return;
    }
    if (this.this$0.s.k().b())
    {
      this.this$0.s.a(this.this$0.s.k().s, 226);
      this.this$0.s.b(226);
      int i = this.this$0.s.k().g;
      this.this$0.s.b(this.this$0.s.k().s, 21);
      if (i == 1) {
        this.this$0.s.k().a(this.a, "small.onResume.1", 3);
      } else if (i == 2) {
        this.this$0.s.k().a(this.a, "small.onResume.2", 4);
      }
      if (this.this$0.s.k().c()) {
        this.this$0.s.k().p = 1;
      } else {
        this.this$0.s.k().p = 3000;
      }
      this.this$0.s.k().c(this.a, false);
      this.this$0.s.k().d("SmallScreen.onResume", 0);
    }
    if ((this.this$0.s.k().I) && (this.this$0.s.k().bR) && (this.this$0.s.k().bT > 0)) {
      SmallScreenVideoController.a(this.this$0);
    }
    if (this.this$0.s.k().g == 2) {
      this.this$0.z.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.OnResumeRunnable
 * JD-Core Version:    0.7.0.1
 */
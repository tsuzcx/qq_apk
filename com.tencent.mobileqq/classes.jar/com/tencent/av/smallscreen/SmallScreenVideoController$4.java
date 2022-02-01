package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

class SmallScreenVideoController$4
  implements Runnable
{
  SmallScreenVideoController$4(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  public void run()
  {
    if ((this.this$0.t instanceof SmallScreenDoubleVideoControlUI))
    {
      String str = this.this$0.r.getCurrentAccountUin();
      int i = this.this$0.s.k().bS;
      this.this$0.r.a(new Object[] { Integer.valueOf(42), str, Integer.valueOf(i) });
    }
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.4
 * JD-Core Version:    0.7.0.1
 */
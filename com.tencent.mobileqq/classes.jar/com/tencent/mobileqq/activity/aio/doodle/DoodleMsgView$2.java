package com.tencent.mobileqq.activity.aio.doodle;

import agpa;
import java.util.TimerTask;

class DoodleMsgView$2
  extends TimerTask
{
  DoodleMsgView$2(DoodleMsgView paramDoodleMsgView, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    try
    {
      agpa localagpa = DoodleMsgView.a(this.this$0);
      if (localagpa == null)
      {
        this.this$0.a(new DoodleMsgView.2.1(this));
        return;
      }
      if (DoodleMsgView.a(this.this$0) < 0L) {
        DoodleMsgView.a(this.this$0, this.a);
      }
      if (DoodleMsgView.a(this.this$0) < this.a) {
        DoodleMsgView.a(this.this$0, DoodleMsgView.a(this.this$0) + this.b);
      }
      if (localagpa != null) {
        localagpa.a(DoodleMsgView.a(this.this$0), true);
      }
      if (DoodleMsgView.a(this.this$0) >= this.a)
      {
        DoodleMsgView.a(this.this$0);
        return;
      }
      if ((!DoodleMsgView.a(this.this$0)) && (localagpa != null)) {
        localagpa.a(this.a, true);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.2
 * JD-Core Version:    0.7.0.1
 */
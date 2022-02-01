package com.tencent.ilive.audiencepages.room.bizmodule;

import com.tencent.falco.utils.ThreadCenter;

class FloatWindowModule$10$1
  implements Runnable
{
  FloatWindowModule$10$1(FloatWindowModule.10 param10) {}
  
  public void run()
  {
    if (FloatWindowModule.access$3000(this.a.this$0))
    {
      if (!FloatWindowModule.canBackgroundStart(FloatWindowModule.access$3100(this.a.this$0))) {
        ThreadCenter.postUITask(this.a.this$0, FloatWindowModule.access$3200(this.a.this$0));
      }
    }
    else {
      ThreadCenter.postDelayedUITask(this.a.this$0, FloatWindowModule.access$3300(this.a.this$0), 5000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.10.1
 * JD-Core Version:    0.7.0.1
 */
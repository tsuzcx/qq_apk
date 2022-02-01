package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.falco.utils.ThreadCenter;

class AVPreloadTaskManager$1$1
  implements Runnable
{
  AVPreloadTaskManager$1$1(AVPreloadTaskManager.1 param1) {}
  
  public void run()
  {
    if (this.a.c != null) {
      this.a.c.a();
    }
    ThreadCenter.postDelayedUITask(this.a.this$0, AVPreloadTaskManager.b(this.a.this$0), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadTaskManager.1.1
 * JD-Core Version:    0.7.0.1
 */
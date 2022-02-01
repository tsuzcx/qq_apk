package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.falco.utils.ThreadCenter;

class AVPreloadTaskManager$1
  implements Runnable
{
  AVPreloadTaskManager$1(AVPreloadTaskManager paramAVPreloadTaskManager) {}
  
  public void run()
  {
    AVPreloadTaskManager.a(this.this$0);
    AVPreloadTaskManager.b(this.this$0);
    ThreadCenter.postDelayedUITask(this.this$0, AVPreloadTaskManager.a(this.this$0), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadTaskManager.1
 * JD-Core Version:    0.7.0.1
 */
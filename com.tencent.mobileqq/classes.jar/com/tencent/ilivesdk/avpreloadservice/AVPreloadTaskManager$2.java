package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.falco.utils.ThreadCenter;

class AVPreloadTaskManager$2
  implements Runnable
{
  AVPreloadTaskManager$2(AVPreloadTaskManager paramAVPreloadTaskManager) {}
  
  public void run()
  {
    AVPreloadTaskManager.c(this.this$0);
    AVPreloadTaskManager.d(this.this$0);
    AVPreloadTaskManager localAVPreloadTaskManager = this.this$0;
    ThreadCenter.postDelayedUITask(localAVPreloadTaskManager, AVPreloadTaskManager.b(localAVPreloadTaskManager), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadTaskManager.2
 * JD-Core Version:    0.7.0.1
 */
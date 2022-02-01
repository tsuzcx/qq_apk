package com.tencent.avgame.qav;

import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qphone.base.util.QLog;
import nei;

public class AsyncExitTask$2
  implements Runnable
{
  public AsyncExitTask$2(nei paramnei, QQGAudioCtrl paramQQGAudioCtrl) {}
  
  public void run()
  {
    QLog.d("AsyncExitTask", 1, "asyncExitRoom.quit start.");
    if (this.a != null) {
      nei.a(this.this$0, this.a.quit(0));
    }
    QLog.d("AsyncExitTask", 1, "asyncExitRoom.quit end. quitResult = " + nei.a(this.this$0));
    synchronized (nei.a(this.this$0))
    {
      nei.a(this.this$0).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.AsyncExitTask.2
 * JD-Core Version:    0.7.0.1
 */
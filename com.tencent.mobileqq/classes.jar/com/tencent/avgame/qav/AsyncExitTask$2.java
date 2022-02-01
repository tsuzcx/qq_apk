package com.tencent.avgame.qav;

import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qphone.base.util.QLog;
import ngb;

public class AsyncExitTask$2
  implements Runnable
{
  public AsyncExitTask$2(ngb paramngb, QQGAudioCtrl paramQQGAudioCtrl) {}
  
  public void run()
  {
    QLog.d("AsyncExitTask", 1, "asyncExitRoom.quitRoom start.");
    if (this.a != null) {
      ngb.a(this.this$0, this.a.quitRoom(0));
    }
    QLog.d("AsyncExitTask", 1, "asyncExitRoom.quitRoom end. quitResult = " + ngb.a(this.this$0));
    synchronized (ngb.a(this.this$0))
    {
      ngb.a(this.this$0).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.AsyncExitTask.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.avgame.qav;

import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qphone.base.util.QLog;
import nhj;

public class AsyncExitTask$2
  implements Runnable
{
  public AsyncExitTask$2(nhj paramnhj, QQGAudioCtrl paramQQGAudioCtrl) {}
  
  public void run()
  {
    QLog.d("AsyncExitTask", 1, "asyncExitRoom.quitRoom start.");
    if (this.a != null) {
      nhj.a(this.this$0, this.a.quitRoom(0));
    }
    QLog.d("AsyncExitTask", 1, "asyncExitRoom.quitRoom end. quitResult = " + nhj.a(this.this$0));
    synchronized (nhj.a(this.this$0))
    {
      nhj.a(this.this$0).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.AsyncExitTask.2
 * JD-Core Version:    0.7.0.1
 */
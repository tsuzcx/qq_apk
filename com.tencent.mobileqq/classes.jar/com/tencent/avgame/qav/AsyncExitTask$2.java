package com.tencent.avgame.qav;

import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qphone.base.util.QLog;
import nob;

public class AsyncExitTask$2
  implements Runnable
{
  public AsyncExitTask$2(nob paramnob, QQGAudioCtrl paramQQGAudioCtrl) {}
  
  public void run()
  {
    QLog.d("AsyncExitTask", 1, "asyncExitRoom.quitRoom start.");
    if (this.a != null) {
      nob.a(this.this$0, this.a.quitRoom(0));
    }
    QLog.d("AsyncExitTask", 1, "asyncExitRoom.quitRoom end. quitResult = " + nob.a(this.this$0));
    synchronized (nob.a(this.this$0))
    {
      nob.a(this.this$0).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.AsyncExitTask.2
 * JD-Core Version:    0.7.0.1
 */
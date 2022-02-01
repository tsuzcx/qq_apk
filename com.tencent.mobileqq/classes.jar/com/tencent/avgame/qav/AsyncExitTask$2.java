package com.tencent.avgame.qav;

import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qphone.base.util.QLog;

class AsyncExitTask$2
  implements Runnable
{
  AsyncExitTask$2(AsyncExitTask paramAsyncExitTask, QQGAudioCtrl paramQQGAudioCtrl) {}
  
  public void run()
  {
    QLog.d("AsyncExitTask", 1, "asyncExitRoom.quitRoom start.");
    ??? = this.a;
    if (??? != null) {
      AsyncExitTask.a(this.this$0, ((QQGAudioCtrl)???).quitRoom(0));
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("asyncExitRoom.quitRoom end. quitResult = ");
    ((StringBuilder)???).append(AsyncExitTask.a(this.this$0));
    QLog.d("AsyncExitTask", 1, ((StringBuilder)???).toString());
    synchronized (AsyncExitTask.b(this.this$0))
    {
      AsyncExitTask.b(this.this$0).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AsyncExitTask.2
 * JD-Core Version:    0.7.0.1
 */
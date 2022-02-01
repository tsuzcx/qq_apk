package com.tencent.avgame.gameroom.video;

import com.tencent.mobileqq.qrscan.IToolProcStart.Callback;
import com.tencent.qphone.base.util.QLog;

class AVGameLaunchWebHelper$3
  implements IToolProcStart.Callback
{
  AVGameLaunchWebHelper$3(AVGameLaunchWebHelper paramAVGameLaunchWebHelper, Runnable paramRunnable, long paramLong) {}
  
  public void a()
  {
    AVGameLaunchWebHelper.a(this.c, this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preLoadToolProcAndExecuteCallable time end: ");
    localStringBuilder.append(System.currentTimeMillis() - this.b);
    QLog.d("AVGameLaunchWebHelper", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameLaunchWebHelper.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app;

import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class ProcessExitReceiver$1
  implements Runnable
{
  ProcessExitReceiver$1(ProcessExitReceiver paramProcessExitReceiver) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Kill process ");
      localStringBuilder.append(MobileQQ.getMobileQQ().getQQProcessName());
      QLog.d("ProcessExitReceiver", 2, localStringBuilder.toString());
    }
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ProcessExitReceiver.1
 * JD-Core Version:    0.7.0.1
 */
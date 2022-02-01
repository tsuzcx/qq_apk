package com.tencent.mobileqq.app;

final class ThreadManagerV2$1
  extends Thread
{
  public void run()
  {
    ThreadManagerV2.IsRunTimeShutDown = true;
    ThreadLog.printQLog("ThreadManager", "QQ Runtime ShutDown");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManagerV2.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app;

import java.util.concurrent.ThreadFactory;

final class ThreadManagerV2$3
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    ThreadLog.printQLog("ThreadManager", "new NetExcutor5Thread");
    return new Thread(paramRunnable, "NetExcutor5Thread");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManagerV2.3
 * JD-Core Version:    0.7.0.1
 */
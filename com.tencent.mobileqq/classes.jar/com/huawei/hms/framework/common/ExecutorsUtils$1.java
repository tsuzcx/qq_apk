package com.huawei.hms.framework.common;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class ExecutorsUtils$1
  implements ThreadFactory
{
  private final AtomicInteger threadNumbers = new AtomicInteger(0);
  
  ExecutorsUtils$1(String paramString) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetworkKit_");
    localStringBuilder.append(this.val$threadName);
    localStringBuilder.append("_");
    localStringBuilder.append(this.threadNumbers.getAndIncrement());
    return new Thread(paramRunnable, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.ExecutorsUtils.1
 * JD-Core Version:    0.7.0.1
 */
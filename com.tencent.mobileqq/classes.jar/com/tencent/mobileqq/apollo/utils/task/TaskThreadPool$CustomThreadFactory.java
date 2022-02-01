package com.tencent.mobileqq.apollo.utils.task;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class TaskThreadPool$CustomThreadFactory
  implements ThreadFactory
{
  private static final AtomicInteger a = new AtomicInteger(1);
  private final ThreadGroup b;
  private final AtomicInteger c = new AtomicInteger(1);
  private final String d;
  
  TaskThreadPool$CustomThreadFactory(String paramString)
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {
      localObject = ((SecurityManager)localObject).getThreadGroup();
    } else {
      localObject = Thread.currentThread().getThreadGroup();
    }
    this.b = ((ThreadGroup)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "threadpool";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("-");
    localStringBuilder.append(a.getAndIncrement());
    localStringBuilder.append("-thread-");
    this.d = localStringBuilder.toString();
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    ThreadGroup localThreadGroup = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append(this.c.getAndIncrement());
    paramRunnable = new Thread(localThreadGroup, paramRunnable, localStringBuilder.toString(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskThreadPool.CustomThreadFactory
 * JD-Core Version:    0.7.0.1
 */
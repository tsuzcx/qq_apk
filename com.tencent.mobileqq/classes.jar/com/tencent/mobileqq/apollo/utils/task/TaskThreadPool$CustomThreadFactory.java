package com.tencent.mobileqq.apollo.utils.task;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class TaskThreadPool$CustomThreadFactory
  implements ThreadFactory
{
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  private final String jdField_a_of_type_JavaLangString;
  private final ThreadGroup jdField_a_of_type_JavaLangThreadGroup;
  private final AtomicInteger b = new AtomicInteger(1);
  
  TaskThreadPool$CustomThreadFactory(String paramString)
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {
      localObject = ((SecurityManager)localObject).getThreadGroup();
    } else {
      localObject = Thread.currentThread().getThreadGroup();
    }
    this.jdField_a_of_type_JavaLangThreadGroup = ((ThreadGroup)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "threadpool";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("-");
    localStringBuilder.append(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
    localStringBuilder.append("-thread-");
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    ThreadGroup localThreadGroup = this.jdField_a_of_type_JavaLangThreadGroup;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(this.b.getAndIncrement());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskThreadPool.CustomThreadFactory
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.featuretoggle.hltxkg.common.a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  implements ThreadFactory
{
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  private final String jdField_a_of_type_JavaLangString;
  private final ThreadGroup jdField_a_of_type_JavaLangThreadGroup;
  private final AtomicInteger b = new AtomicInteger(1);
  
  public a(String paramString)
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {
      localObject = ((SecurityManager)localObject).getThreadGroup();
    } else {
      localObject = Thread.currentThread().getThreadGroup();
    }
    this.jdField_a_of_type_JavaLangThreadGroup = ((ThreadGroup)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
    ((StringBuilder)localObject).append("_thread_");
    this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    ThreadGroup localThreadGroup = this.jdField_a_of_type_JavaLangThreadGroup;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(this.b.getAndIncrement());
    paramRunnable = new Thread(localThreadGroup, paramRunnable, localStringBuilder.toString(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    try
    {
      paramRunnable.setPriority(5);
      return paramRunnable;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.a.a
 * JD-Core Version:    0.7.0.1
 */
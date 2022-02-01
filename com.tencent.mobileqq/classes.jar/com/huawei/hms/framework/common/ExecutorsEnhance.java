package com.huawei.hms.framework.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorsEnhance
{
  public static ExecutorService newSingleThreadExecutor(ThreadFactory paramThreadFactory)
  {
    return new ExecutorsEnhance.FinalizableDelegatedExecutorService(new ThreadPoolExcutorEnhance(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), paramThreadFactory));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.ExecutorsEnhance
 * JD-Core Version:    0.7.0.1
 */
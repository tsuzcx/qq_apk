package com.mojitox.mxflutter.framework.executor;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class JobExecutor$JobThreadFactory
  implements ThreadFactory
{
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mx_js_pool_#");
    ((StringBuilder)localObject).append(JobExecutor.a().getAndIncrement());
    localObject = ((StringBuilder)localObject).toString();
    if ((paramRunnable instanceof JsTask)) {
      localObject = ((JsTask)paramRunnable).b();
    }
    return new Thread(paramRunnable, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.executor.JobExecutor.JobThreadFactory
 * JD-Core Version:    0.7.0.1
 */
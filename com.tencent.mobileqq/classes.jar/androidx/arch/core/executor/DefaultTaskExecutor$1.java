package androidx.arch.core.executor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class DefaultTaskExecutor$1
  implements ThreadFactory
{
  private static final String THREAD_NAME_STEM = "arch_disk_io_%d";
  private final AtomicInteger mThreadId = new AtomicInteger(0);
  
  DefaultTaskExecutor$1(DefaultTaskExecutor paramDefaultTaskExecutor) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable);
    paramRunnable.setName(String.format("arch_disk_io_%d", new Object[] { Integer.valueOf(this.mThreadId.getAndIncrement()) }));
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.arch.core.executor.DefaultTaskExecutor.1
 * JD-Core Version:    0.7.0.1
 */
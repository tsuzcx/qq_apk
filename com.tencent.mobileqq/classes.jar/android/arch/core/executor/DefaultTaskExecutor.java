package android.arch.core.executor;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class DefaultTaskExecutor
  extends TaskExecutor
{
  private ExecutorService mDiskIO = Executors.newFixedThreadPool(2);
  private final Object mLock = new Object();
  @Nullable
  private volatile Handler mMainHandler;
  
  public void executeOnDiskIO(Runnable paramRunnable)
  {
    this.mDiskIO.execute(paramRunnable);
  }
  
  public boolean isMainThread()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public void postToMainThread(Runnable paramRunnable)
  {
    if (this.mMainHandler == null) {}
    synchronized (this.mLock)
    {
      if (this.mMainHandler == null) {
        this.mMainHandler = new Handler(Looper.getMainLooper());
      }
      this.mMainHandler.post(paramRunnable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.arch.core.executor.DefaultTaskExecutor
 * JD-Core Version:    0.7.0.1
 */
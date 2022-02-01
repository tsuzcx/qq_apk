package com.google.android.exoplayer2.upstream;

import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader
  implements LoaderErrorThrower
{
  public static final int DONT_RETRY = 2;
  public static final int DONT_RETRY_FATAL = 3;
  public static final int RETRY = 0;
  public static final int RETRY_RESET_ERROR_COUNT = 1;
  private Loader.LoadTask<? extends Loader.Loadable> currentTask;
  private final ExecutorService downloadExecutorService;
  private IOException fatalError;
  
  public Loader(String paramString)
  {
    this.downloadExecutorService = Util.newSingleThreadExecutor(paramString);
  }
  
  public void cancelLoading()
  {
    this.currentTask.cancel(false);
  }
  
  public boolean isLoading()
  {
    return this.currentTask != null;
  }
  
  public void maybeThrowError()
  {
    maybeThrowError(-2147483648);
  }
  
  public void maybeThrowError(int paramInt)
  {
    Object localObject = this.fatalError;
    if (localObject == null)
    {
      localObject = this.currentTask;
      if (localObject != null)
      {
        int i = paramInt;
        if (paramInt == -2147483648) {
          i = ((Loader.LoadTask)localObject).defaultMinRetryCount;
        }
        ((Loader.LoadTask)localObject).maybeThrowError(i);
      }
      return;
    }
    throw ((Throwable)localObject);
  }
  
  public void release()
  {
    release(null);
  }
  
  public void release(@Nullable Loader.ReleaseCallback paramReleaseCallback)
  {
    Loader.LoadTask localLoadTask = this.currentTask;
    if (localLoadTask != null) {
      localLoadTask.cancel(true);
    }
    if (paramReleaseCallback != null) {
      this.downloadExecutorService.execute(new Loader.ReleaseTask(paramReleaseCallback));
    }
    this.downloadExecutorService.shutdown();
  }
  
  public <T extends Loader.Loadable> long startLoading(T paramT, Loader.Callback<T> paramCallback, int paramInt)
  {
    Looper localLooper = Looper.myLooper();
    boolean bool;
    if (localLooper != null) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    long l = SystemClock.elapsedRealtime();
    new Loader.LoadTask(this, localLooper, paramT, paramCallback, paramInt, l).start(0L);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.Loader
 * JD-Core Version:    0.7.0.1
 */
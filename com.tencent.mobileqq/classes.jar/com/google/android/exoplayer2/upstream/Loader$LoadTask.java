package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TraceUtil;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

@SuppressLint({"HandlerLeak"})
final class Loader$LoadTask<T extends Loader.Loadable>
  extends Handler
  implements Runnable
{
  private static final int MSG_CANCEL = 1;
  private static final int MSG_END_OF_SOURCE = 2;
  private static final int MSG_FATAL_ERROR = 4;
  private static final int MSG_IO_EXCEPTION = 3;
  private static final int MSG_START = 0;
  private static final String TAG = "LoadTask";
  private final Loader.Callback<T> callback;
  private IOException currentError;
  public final int defaultMinRetryCount;
  private int errorCount;
  private volatile Thread executorThread;
  private final T loadable;
  private volatile boolean released;
  private final long startTimeMs;
  
  public Loader$LoadTask(Looper paramLooper, T paramT, Loader.Callback<T> paramCallback, int paramInt, long paramLong)
  {
    super(paramT);
    this.loadable = paramCallback;
    this.callback = paramInt;
    this.defaultMinRetryCount = paramLong;
    Object localObject;
    this.startTimeMs = localObject;
  }
  
  private void execute()
  {
    this.currentError = null;
    Loader.access$200(this.this$0).execute(Loader.access$000(this.this$0));
  }
  
  private void finish()
  {
    Loader.access$002(this.this$0, null);
  }
  
  private long getRetryDelayMillis()
  {
    return Math.min((this.errorCount - 1) * 1000, 5000);
  }
  
  public void cancel(boolean paramBoolean)
  {
    this.released = paramBoolean;
    this.currentError = null;
    if (hasMessages(0))
    {
      removeMessages(0);
      if (!paramBoolean) {
        sendEmptyMessage(1);
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        finish();
        long l = SystemClock.elapsedRealtime();
        this.callback.onLoadCanceled(this.loadable, l, l - this.startTimeMs, true);
      }
      return;
      this.loadable.cancelLoad();
      if (this.executorThread != null) {
        this.executorThread.interrupt();
      }
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.released) {}
    do
    {
      return;
      if (paramMessage.what == 0)
      {
        execute();
        return;
      }
      if (paramMessage.what == 4) {
        throw ((Error)paramMessage.obj);
      }
      finish();
      long l1 = SystemClock.elapsedRealtime();
      long l2 = l1 - this.startTimeMs;
      if (this.loadable.isLoadCanceled())
      {
        this.callback.onLoadCanceled(this.loadable, l1, l2, false);
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        this.callback.onLoadCanceled(this.loadable, l1, l2, false);
        return;
      case 2: 
        try
        {
          this.callback.onLoadCompleted(this.loadable, l1, l2);
          return;
        }
        catch (RuntimeException paramMessage)
        {
          Log.e("LoadTask", "Unexpected exception handling load completed", paramMessage);
          Loader.access$102(this.this$0, new Loader.UnexpectedLoaderException(paramMessage));
          return;
        }
      }
      this.currentError = ((IOException)paramMessage.obj);
      i = this.callback.onLoadError(this.loadable, l1, l2, this.currentError);
      if (i == 3)
      {
        Loader.access$102(this.this$0, this.currentError);
        return;
      }
    } while (i == 2);
    if (i == 1) {}
    for (int i = 1;; i = this.errorCount + 1)
    {
      this.errorCount = i;
      start(getRetryDelayMillis());
      return;
    }
  }
  
  public void maybeThrowError(int paramInt)
  {
    if ((this.currentError != null) && (this.errorCount > paramInt)) {
      throw this.currentError;
    }
  }
  
  public void run()
  {
    try
    {
      this.executorThread = Thread.currentThread();
      if (!this.loadable.isLoadCanceled()) {
        TraceUtil.beginSection("load:" + this.loadable.getClass().getSimpleName());
      }
      try
      {
        this.loadable.load();
        TraceUtil.endSection();
        if (!this.released)
        {
          sendEmptyMessage(2);
          return;
        }
      }
      finally
      {
        TraceUtil.endSection();
      }
      return;
    }
    catch (IOException localIOException)
    {
      if (!this.released)
      {
        obtainMessage(3, localIOException).sendToTarget();
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      Assertions.checkState(this.loadable.isLoadCanceled());
      if (!this.released)
      {
        sendEmptyMessage(2);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("LoadTask", "Unexpected exception loading stream", localException);
      if (!this.released)
      {
        obtainMessage(3, new Loader.UnexpectedLoaderException(localException)).sendToTarget();
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Log.e("LoadTask", "OutOfMemory error loading stream", localOutOfMemoryError);
      if (!this.released)
      {
        obtainMessage(3, new Loader.UnexpectedLoaderException(localOutOfMemoryError)).sendToTarget();
        return;
      }
    }
    catch (Error localError)
    {
      Log.e("LoadTask", "Unexpected error loading stream", localError);
      if (!this.released) {
        obtainMessage(4, localError).sendToTarget();
      }
      throw localError;
    }
  }
  
  public void start(long paramLong)
  {
    if (Loader.access$000(this.this$0) == null) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      Loader.access$002(this.this$0, this);
      if (paramLong <= 0L) {
        break;
      }
      sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    execute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.Loader.LoadTask
 * JD-Core Version:    0.7.0.1
 */
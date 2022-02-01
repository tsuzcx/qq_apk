package com.tencent.component.network.utils.thread;

import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AsyncTask<Params, Progress, Result>
{
  private static final int CORE_POOL_SIZE = 1;
  private static final int KEEP_ALIVE = 1;
  private static final String LOG_TAG = "AsyncTask";
  private static final int MAXIMUM_POOL_SIZE = 128;
  private static final int MESSAGE_POST_PROGRESS = 2;
  private static final int MESSAGE_POST_RESULT = 1;
  public static final Executor SERIAL_EXECUTOR = new AsyncTask.SerialExecutor(null);
  public static final Executor THREAD_POOL_EXECUTOR;
  private static volatile Executor sDefaultExecutor = SERIAL_EXECUTOR;
  private static final BlockingQueue<Runnable> sPoolWorkQueue;
  private static final ThreadFactory sThreadFactory = new AsyncTask.1();
  private final AtomicBoolean mCancelled = new AtomicBoolean();
  private final FutureTask<Result> mFuture = new AsyncTask.3(this, this.mWorker);
  private volatile AsyncTask.Status mStatus = AsyncTask.Status.PENDING;
  private final AtomicBoolean mTaskInvoked = new AtomicBoolean();
  private final AsyncTask.WorkerRunnable<Params, Result> mWorker = new AsyncTask.2(this);
  
  static
  {
    sPoolWorkQueue = new LinkedBlockingQueue(10);
    THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(1, 128, 1L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
  }
  
  public static void execute(Runnable paramRunnable)
  {
    sDefaultExecutor.execute(paramRunnable);
  }
  
  private void finish(Result paramResult)
  {
    if (isCancelled()) {
      onCancelled(paramResult);
    } else {
      onPostExecute(paramResult);
    }
    this.mStatus = AsyncTask.Status.FINISHED;
  }
  
  private Result postResult(Result paramResult)
  {
    AsyncTask.HandlerHolder.Handler.obtainMessage(1, new AsyncTask.AsyncTaskResult(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  private void postResultIfNotInvoked(Result paramResult)
  {
    if (!this.mTaskInvoked.get()) {
      postResult(paramResult);
    }
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    this.mCancelled.set(true);
    return this.mFuture.cancel(paramBoolean);
  }
  
  protected abstract Result doInBackground(Params... paramVarArgs);
  
  public final AsyncTask<Params, Progress, Result> execute(Params... paramVarArgs)
  {
    return executeOnExecutor(sDefaultExecutor, paramVarArgs);
  }
  
  public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executor paramExecutor, Params... paramVarArgs)
  {
    if (this.mStatus != AsyncTask.Status.PENDING)
    {
      int i = AsyncTask.4.$SwitchMap$com$tencent$component$network$utils$thread$AsyncTask$Status[this.mStatus.ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        }
      }
      else {
        throw new IllegalStateException("Cannot execute task: the task is already running.");
      }
    }
    this.mStatus = AsyncTask.Status.RUNNING;
    onPreExecute();
    this.mWorker.mParams = paramVarArgs;
    paramExecutor.execute(this.mFuture);
    return this;
  }
  
  public final Result get()
  {
    return this.mFuture.get();
  }
  
  public final Result get(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.mFuture.get(paramLong, paramTimeUnit);
  }
  
  public final AsyncTask.Status getStatus()
  {
    return this.mStatus;
  }
  
  public final boolean isCancelled()
  {
    return this.mCancelled.get();
  }
  
  protected void onCancelled() {}
  
  protected void onCancelled(Result paramResult)
  {
    onCancelled();
  }
  
  protected void onPostExecute(Result paramResult) {}
  
  protected void onPreExecute() {}
  
  protected void onProgressUpdate(Progress... paramVarArgs) {}
  
  protected final void publishProgress(Progress... paramVarArgs)
  {
    if (!isCancelled()) {
      AsyncTask.HandlerHolder.Handler.obtainMessage(2, new AsyncTask.AsyncTaskResult(this, paramVarArgs)).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.AsyncTask
 * JD-Core Version:    0.7.0.1
 */
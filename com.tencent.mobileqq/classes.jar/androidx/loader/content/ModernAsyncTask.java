package androidx.loader.content;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.RestrictTo;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class ModernAsyncTask<Params, Progress, Result>
{
  private static final int CORE_POOL_SIZE = 5;
  private static final int KEEP_ALIVE = 1;
  private static final String LOG_TAG = "AsyncTask";
  private static final int MAXIMUM_POOL_SIZE = 128;
  private static final int MESSAGE_POST_PROGRESS = 2;
  private static final int MESSAGE_POST_RESULT = 1;
  public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
  private static volatile Executor sDefaultExecutor = THREAD_POOL_EXECUTOR;
  private static ModernAsyncTask.InternalHandler sHandler;
  private static final BlockingQueue<Runnable> sPoolWorkQueue;
  private static final ThreadFactory sThreadFactory = new ModernAsyncTask.1();
  final AtomicBoolean mCancelled = new AtomicBoolean();
  private final FutureTask<Result> mFuture = new ModernAsyncTask.3(this, this.mWorker);
  private volatile ModernAsyncTask.Status mStatus = ModernAsyncTask.Status.PENDING;
  final AtomicBoolean mTaskInvoked = new AtomicBoolean();
  private final ModernAsyncTask.WorkerRunnable<Params, Result> mWorker = new ModernAsyncTask.2(this);
  
  static
  {
    sPoolWorkQueue = new LinkedBlockingQueue(10);
  }
  
  public static void execute(Runnable paramRunnable)
  {
    sDefaultExecutor.execute(paramRunnable);
  }
  
  private static Handler getHandler()
  {
    try
    {
      if (sHandler == null) {
        sHandler = new ModernAsyncTask.InternalHandler();
      }
      ModernAsyncTask.InternalHandler localInternalHandler = sHandler;
      return localInternalHandler;
    }
    finally {}
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static void setDefaultExecutor(Executor paramExecutor)
  {
    sDefaultExecutor = paramExecutor;
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    this.mCancelled.set(true);
    return this.mFuture.cancel(paramBoolean);
  }
  
  protected abstract Result doInBackground(Params... paramVarArgs);
  
  public final ModernAsyncTask<Params, Progress, Result> execute(Params... paramVarArgs)
  {
    return executeOnExecutor(sDefaultExecutor, paramVarArgs);
  }
  
  public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor paramExecutor, Params... paramVarArgs)
  {
    if (this.mStatus != ModernAsyncTask.Status.PENDING)
    {
      switch (ModernAsyncTask.4.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status[this.mStatus.ordinal()])
      {
      default: 
        throw new IllegalStateException("We should never reach this state");
      case 1: 
        throw new IllegalStateException("Cannot execute task: the task is already running.");
      }
      throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }
    this.mStatus = ModernAsyncTask.Status.RUNNING;
    onPreExecute();
    this.mWorker.mParams = paramVarArgs;
    paramExecutor.execute(this.mFuture);
    return this;
  }
  
  void finish(Result paramResult)
  {
    if (isCancelled()) {
      onCancelled(paramResult);
    }
    for (;;)
    {
      this.mStatus = ModernAsyncTask.Status.FINISHED;
      return;
      onPostExecute(paramResult);
    }
  }
  
  public final Result get()
  {
    return this.mFuture.get();
  }
  
  public final Result get(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.mFuture.get(paramLong, paramTimeUnit);
  }
  
  public final ModernAsyncTask.Status getStatus()
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
  
  Result postResult(Result paramResult)
  {
    getHandler().obtainMessage(1, new ModernAsyncTask.AsyncTaskResult(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  void postResultIfNotInvoked(Result paramResult)
  {
    if (!this.mTaskInvoked.get()) {
      postResult(paramResult);
    }
  }
  
  protected final void publishProgress(Progress... paramVarArgs)
  {
    if (!isCancelled()) {
      getHandler().obtainMessage(2, new ModernAsyncTask.AsyncTaskResult(this, paramVarArgs)).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.loader.content.ModernAsyncTask
 * JD-Core Version:    0.7.0.1
 */
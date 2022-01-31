package com.tencent.map.lib.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.map.sdk.a.jk;
import com.tencent.map.sdk.a.jl;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AsyncTask<Params, Progress, Result>
{
  private static final AsyncTask.b a = new AsyncTask.b(Looper.getMainLooper());
  public static final Executor sHighThreadExecutor;
  public static final Executor sHightSerialExecutor;
  public static final Executor sLowSerialExecutor;
  public static final Executor sLowThreadExecutor = new jl();
  private final AsyncTask.e<Params, Result> b = new AsyncTask.1(this);
  private final FutureTask<Result> c = new AsyncTask.2(this, this.b);
  private volatile AsyncTask.d d = AsyncTask.d.a;
  private final AtomicBoolean e = new AtomicBoolean();
  private final AtomicBoolean f = new AtomicBoolean();
  private boolean g = true;
  
  static
  {
    sHighThreadExecutor = new jk();
    sLowSerialExecutor = new AsyncTask.c((byte)0);
    sHightSerialExecutor = new AsyncTask.c((byte)0);
  }
  
  private Result a(Result paramResult)
  {
    Message localMessage = a.obtainMessage(1, new AsyncTask.a(this, new Object[] { paramResult }));
    if (this.g)
    {
      localMessage.sendToTarget();
      return paramResult;
    }
    a.sendMessageAtFrontOfQueue(localMessage);
    return paramResult;
  }
  
  public static void execute(Runnable paramRunnable)
  {
    sLowThreadExecutor.execute(paramRunnable);
  }
  
  public static void init()
  {
    a.getLooper();
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    this.e.set(true);
    return this.c.cancel(paramBoolean);
  }
  
  protected abstract Result doInBackground(Params... paramVarArgs);
  
  public final AsyncTask<Params, Progress, Result> execute(boolean paramBoolean, Params... paramVarArgs)
  {
    this.g = paramBoolean;
    if (this.g) {
      return executeOnExecutor(sLowThreadExecutor, paramVarArgs);
    }
    return executeOnExecutor(sHighThreadExecutor, paramVarArgs);
  }
  
  public final AsyncTask<Params, Progress, Result> execute(Params... paramVarArgs)
  {
    return execute(true, paramVarArgs);
  }
  
  public final void execute(long paramLong, Params... paramVarArgs)
  {
    new Handler(Looper.getMainLooper()).postDelayed(new AsyncTask.3(this, paramVarArgs), paramLong);
  }
  
  public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executor paramExecutor, Params... paramVarArgs)
  {
    if (this.d != AsyncTask.d.a) {}
    switch (AsyncTask.4.a[this.d.ordinal()])
    {
    default: 
      this.d = AsyncTask.d.b;
      onPreExecute();
      this.b.b = paramVarArgs;
      paramExecutor.execute(this.c);
      return this;
    case 1: 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }
  
  public final Result get()
  {
    return this.c.get();
  }
  
  public final Result get(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.c.get(paramLong, paramTimeUnit);
  }
  
  public final AsyncTask.d getStatus()
  {
    return this.d;
  }
  
  public final boolean isCancelled()
  {
    return this.e.get();
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
      a.obtainMessage(2, new AsyncTask.a(this, paramVarArgs)).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncTask
 * JD-Core Version:    0.7.0.1
 */
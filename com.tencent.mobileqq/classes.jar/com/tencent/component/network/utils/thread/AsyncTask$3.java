package com.tencent.component.network.utils.thread;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class AsyncTask$3
  extends FutureTask<Result>
{
  AsyncTask$3(AsyncTask paramAsyncTask, Callable paramCallable)
  {
    super(paramCallable);
  }
  
  protected void done()
  {
    try
    {
      AsyncTask.access$400(this.this$0, get());
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      throw new RuntimeException("An error occured while executing doInBackground()", localExecutionException.getCause());
    }
    catch (InterruptedException localInterruptedException)
    {
      Log.w("AsyncTask", localInterruptedException);
      return;
    }
    catch (CancellationException localCancellationException)
    {
      label12:
      break label12;
    }
    AsyncTask.access$400(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.AsyncTask.3
 * JD-Core Version:    0.7.0.1
 */
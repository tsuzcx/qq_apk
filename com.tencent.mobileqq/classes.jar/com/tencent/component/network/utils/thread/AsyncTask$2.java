package com.tencent.component.network.utils.thread;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

class AsyncTask$2
  extends AsyncTask.WorkerRunnable<Params, Result>
{
  AsyncTask$2(AsyncTask paramAsyncTask)
  {
    super(null);
  }
  
  public Result call()
  {
    AsyncTask.access$200(this.this$0).set(true);
    Process.setThreadPriority(10);
    AsyncTask localAsyncTask = this.this$0;
    return AsyncTask.access$300(localAsyncTask, localAsyncTask.doInBackground(this.mParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.AsyncTask.2
 * JD-Core Version:    0.7.0.1
 */
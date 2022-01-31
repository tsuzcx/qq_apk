package com.tencent.map.lib.thread;

import java.util.concurrent.atomic.AtomicBoolean;

final class AsyncTask$1
  extends AsyncTask.e<Params, Result>
{
  AsyncTask$1(AsyncTask paramAsyncTask)
  {
    super((byte)0);
  }
  
  public final Result call()
  {
    AsyncTask.a(this.a).set(true);
    Object localObject = this.a.doInBackground(this.b);
    return AsyncTask.a(this.a, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncTask.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.aladdin.config;

import android.os.AsyncTask;

class Aladdin$SimpleAsyncTask
  extends AsyncTask<Void, Void, Void>
{
  private final Runnable task;
  
  private Aladdin$SimpleAsyncTask(Runnable paramRunnable)
  {
    this.task = paramRunnable;
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    this.task.run();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.Aladdin.SimpleAsyncTask
 * JD-Core Version:    0.7.0.1
 */
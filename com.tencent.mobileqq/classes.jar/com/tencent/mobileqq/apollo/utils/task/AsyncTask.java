package com.tencent.mobileqq.apollo.utils.task;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public abstract class AsyncTask
  extends BaseTask
{
  public AsyncTask(Context paramContext)
  {
    super(paramContext, 2);
  }
  
  public abstract void a();
  
  public final void b()
  {
    ThreadManager.getSubThreadHandler().post(new AsyncTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.AsyncTask
 * JD-Core Version:    0.7.0.1
 */
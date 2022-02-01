package com.tencent.aelight.camera.aeeditor.lyric.common;

import android.util.Log;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

class TimerTaskManager$1
  extends ScheduledThreadPoolExecutor
{
  TimerTaskManager$1(TimerTaskManager paramTimerTaskManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    Throwable localThrowable = paramThrowable;
    if (paramThrowable == null)
    {
      localThrowable = paramThrowable;
      if ((paramRunnable instanceof Future)) {
        try
        {
          paramRunnable = (Future)paramRunnable;
          localThrowable = paramThrowable;
          if (paramRunnable.isDone())
          {
            paramRunnable.get();
            localThrowable = paramThrowable;
          }
        }
        catch (InterruptedException paramRunnable)
        {
          paramRunnable.printStackTrace();
          localThrowable = paramThrowable;
        }
        catch (ExecutionException paramRunnable)
        {
          localThrowable = paramRunnable.getCause();
        }
        catch (CancellationException localCancellationException) {}
      }
    }
    if (localCancellationException != null)
    {
      paramRunnable = new StringBuilder();
      paramRunnable.append("Exception happen when execute task! : ");
      paramRunnable.append(localCancellationException.toString());
      Log.e("LyricTimerTaskManager", paramRunnable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.common.TimerTaskManager.1
 * JD-Core Version:    0.7.0.1
 */
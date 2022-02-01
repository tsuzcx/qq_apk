package com.tencent.aelight.camera.aeeditor.lyric.common;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class TimerTaskManager
{
  private ScheduledThreadPoolExecutor a;
  private Map<String, TimerTaskManager.InternalTaskEntry> b = new HashMap();
  
  public TimerTaskManager()
  {
    a();
  }
  
  private void a()
  {
    try
    {
      if (this.a == null) {
        this.a = new TimerTaskManager.1(this, 1);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      TimerTaskManager.InternalTaskEntry localInternalTaskEntry = (TimerTaskManager.InternalTaskEntry)this.b.get(paramString);
      if (localInternalTaskEntry != null)
      {
        Log.i("LyricTimerTaskManager", String.format("cancel -> cancel TimerTask [%s].", new Object[] { paramString }));
        if (TimerTaskManager.InternalTaskEntry.b(localInternalTaskEntry) != null) {
          TimerTaskManager.InternalTaskEntry.b(localInternalTaskEntry).cancel(true);
        }
        boolean bool = this.a.remove(TimerTaskManager.InternalTaskEntry.a(localInternalTaskEntry));
        this.a.purge();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cancel -> cancel TimerTask:");
        localStringBuilder.append(bool);
        localStringBuilder.append("\n");
        localStringBuilder.append(this.a.toString());
        Log.d("LyricTimerTaskManager", localStringBuilder.toString());
        TimerTaskManager.TimerTaskRunnable.a(TimerTaskManager.InternalTaskEntry.c(localInternalTaskEntry), false);
        TimerTaskManager.InternalTaskEntry.a(localInternalTaskEntry, null);
        this.b.remove(paramString);
      }
      else
      {
        Log.i("LyricTimerTaskManager", String.format("cancel -> not find task[%s].", new Object[] { paramString }));
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.common.TimerTaskManager
 * JD-Core Version:    0.7.0.1
 */
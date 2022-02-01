package com.tencent.aelight.camera.aeeditor.lyric.common;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class TimerTaskManager
{
  private Map<String, TimerTaskManager.InternalTaskEntry> jdField_a_of_type_JavaUtilMap = new HashMap();
  private ScheduledThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
  
  public TimerTaskManager()
  {
    a();
  }
  
  private void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor == null) {
        this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor = new TimerTaskManager.1(this, 1);
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
      TimerTaskManager.InternalTaskEntry localInternalTaskEntry = (TimerTaskManager.InternalTaskEntry)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localInternalTaskEntry != null)
      {
        Log.i("LyricTimerTaskManager", String.format("cancel -> cancel TimerTask [%s].", new Object[] { paramString }));
        if (TimerTaskManager.InternalTaskEntry.a(localInternalTaskEntry) != null) {
          TimerTaskManager.InternalTaskEntry.a(localInternalTaskEntry).cancel(true);
        }
        boolean bool = this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.remove(TimerTaskManager.InternalTaskEntry.a(localInternalTaskEntry));
        this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.purge();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cancel -> cancel TimerTask:");
        localStringBuilder.append(bool);
        localStringBuilder.append("\n");
        localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.toString());
        Log.d("LyricTimerTaskManager", localStringBuilder.toString());
        TimerTaskManager.TimerTaskRunnable.a(TimerTaskManager.InternalTaskEntry.a(localInternalTaskEntry), false);
        TimerTaskManager.InternalTaskEntry.a(localInternalTaskEntry, null);
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.common.TimerTaskManager
 * JD-Core Version:    0.7.0.1
 */
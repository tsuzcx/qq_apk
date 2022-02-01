package com.tencent.mobileqq.app;

import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class ThreadManager$2
  extends MqqHandler
{
  ThreadManager$2(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void removeCallbacksAndMessages(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("ThreadManager", 1, "global fileHandler cannot excute removeCallbacksAndMessages");
      return;
    }
    super.removeCallbacksAndMessages(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManager.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.featuretoggle.hltxkg.common.a;

import com.tencent.featuretoggle.hltxkg.common.a;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public final class o
{
  private static o jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonAO = new o();
  private Map<Runnable, TimerTask> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Timer jdField_a_of_type_JavaUtilTimer;
  
  private o()
  {
    StringBuilder localStringBuilder = new StringBuilder("halley_");
    localStringBuilder.append(a.c());
    localStringBuilder.append("_");
    localStringBuilder.append("ConnectionTimer");
    this.jdField_a_of_type_JavaUtilTimer = new Timer(localStringBuilder.toString(), true);
  }
  
  public static o a()
  {
    return jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonAO;
  }
  
  private void a(Runnable paramRunnable, boolean paramBoolean, long paramLong)
  {
    try
    {
      a(paramRunnable);
      p localp = new p(this, paramRunnable);
      if (paramBoolean) {
        this.jdField_a_of_type_JavaUtilTimer.schedule(localp, paramLong, paramLong);
      } else {
        this.jdField_a_of_type_JavaUtilTimer.schedule(localp, paramLong);
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramRunnable, localp);
      return;
    }
    finally {}
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, false, paramLong);
  }
  
  public final boolean a(Runnable paramRunnable)
  {
    try
    {
      TimerTask localTimerTask = (TimerTask)this.jdField_a_of_type_JavaUtilMap.get(paramRunnable);
      if (localTimerTask != null)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramRunnable);
        boolean bool = localTimerTask.cancel();
        return bool;
      }
      return true;
    }
    finally {}
  }
  
  public final void b(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, true, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.o
 * JD-Core Version:    0.7.0.1
 */
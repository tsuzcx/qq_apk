package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import zfw;

public class JobReporter
{
  private static final int LEVEL_COUNT = 3;
  private static final int MSG_PUT_INTO_THRED_LIST = 1;
  private static final int MSG_REPORT_THRED_PEAK = 2;
  private static final int MSG_THRED_CREATE_CHECK = 3;
  private static final int REPORT_LEVEL_SEPARATOR = 500;
  private static final int REPORT_THRESHOLD = 200;
  private static final String TAG = "JobReporter";
  private static final long THREAD_COUNT_REPORT_INTERVAL_Debug = 20000L;
  private static final long THREAD_COUNT_REPORT_INTERVAL_Release = 86400000L;
  private static final String ThreadMonitorPeakCount = "thread_monitor_peak_count";
  public static final String ThreadOnCreatedCallBack = "com/tencent/mobileqq/app/JobReporter";
  private static Handler mFileHandler = new zfw(ThreadManager.getFileThreadLooper());
  public static ThreadCheck mThreadCheck;
  private static boolean sInited;
  private static long sMonitorStartTime;
  private static Random sRandom = new Random();
  private static long sThreadPeakCount;
  private static List weakThreadList = new ArrayList();
  
  private static int getCurrentThreadCount()
  {
    Iterator localIterator = weakThreadList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((WeakReference)localIterator.next()).get() == null) {
        break label44;
      }
      i += 1;
    }
    label44:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private static void initThreadPeakCount()
  {
    if (sInited) {
      return;
    }
    sThreadPeakCount = SharedPreUtils.c();
    sMonitorStartTime = SharedPreUtils.d();
    if (QLog.isColorLevel()) {
      QLog.d("JobReporter", 2, "initThreadPeakCount sThreadPeakCount " + sThreadPeakCount + " sMonitorStartTime " + sMonitorStartTime);
    }
    sInited = true;
  }
  
  public static void onThreadCreatedCallback(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Thread)))
    {
      Message localMessage = mFileHandler.obtainMessage(1);
      localMessage.obj = paramObject;
      mFileHandler.sendMessage(localMessage);
    }
  }
  
  public static boolean ramdomReport(int paramInt)
  {
    return sRandom.nextInt(paramInt) == 1;
  }
  
  static void reportJobTime(long paramLong)
  {
    try
    {
      if (BaseApplicationImpl.sProcessId != 1) {
        return;
      }
      GuardManager.b.incrementAndGet();
      if (paramLong <= 200L) {
        break label94;
      }
      switch (Math.min((int)(paramLong / 500L), 2))
      {
      case 0: 
        GuardManager.c.incrementAndGet();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("JobReporter", 1, "reportJobTime error!!!  : ", localThrowable);
      return;
    }
    GuardManager.d.incrementAndGet();
    return;
    GuardManager.e.incrementAndGet();
    label94:
    return;
  }
  
  public static void reportThreadPeakCount(String paramString)
  {
    Message localMessage = mFileHandler.obtainMessage(2);
    localMessage.obj = paramString;
    mFileHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.JobReporter
 * JD-Core Version:    0.7.0.1
 */
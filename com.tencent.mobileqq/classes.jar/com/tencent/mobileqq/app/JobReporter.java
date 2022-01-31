package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

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
  private static Handler mFileHandler;
  public static ThreadCheck mThreadCheck;
  private static Field nativePeerF = null;
  private static boolean nativePeerGetFailed;
  private static boolean nativePeerReflectFailed = false;
  private static boolean sInited;
  private static long sMonitorStartTime;
  private static Random sRandom = new Random();
  public static AtomicLong sThreadJobReportCountLevelOne;
  public static AtomicLong sThreadJobReportCountLevelThree;
  public static AtomicLong sThreadJobReportCountLevelTwo;
  public static AtomicLong sThreadJobReportLastReportTs;
  public static AtomicLong sThreadJobReportTotalCount;
  private static long sThreadPeakCount = 0L;
  private static List<WeakReference<Thread>> weakThreadList;
  
  static
  {
    sMonitorStartTime = 0L;
    sInited = false;
    weakThreadList = new ArrayList();
    sThreadJobReportLastReportTs = new AtomicLong(0L);
    sThreadJobReportTotalCount = new AtomicLong(0L);
    sThreadJobReportCountLevelOne = new AtomicLong(0L);
    sThreadJobReportCountLevelTwo = new AtomicLong(0L);
    sThreadJobReportCountLevelThree = new AtomicLong(0L);
    mFileHandler = new Handler(ThreadManagerV2.getFileThreadLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if ((paramAnonymousMessage.what == 1) && (paramAnonymousMessage.obj != null))
        {
          paramAnonymousMessage = new WeakReference((Thread)paramAnonymousMessage.obj);
          JobReporter.weakThreadList.add(paramAnonymousMessage);
        }
        do
        {
          long l1;
          do
          {
            do
            {
              return;
              if (paramAnonymousMessage.what != 2) {
                break;
              }
            } while (ThreadManagerV2.sThreadWrapContext == null);
            JobReporter.access$100();
            long l2 = System.currentTimeMillis();
            if (ThreadSetting.isPublicVersion) {}
            for (l1 = 86400000L; (l2 - JobReporter.sMonitorStartTime > l1) && (JobReporter.sThreadPeakCount > 0L) && (JobReporter.access$400()); l1 = 20000L)
            {
              if (JobReporter.sThreadPeakCount < 500L)
              {
                paramAnonymousMessage = (String)paramAnonymousMessage.obj;
                ThreadManagerV2.sThreadWrapContext.reportDengTaException(paramAnonymousMessage, "thread_monitor_peak_count", true, JobReporter.sThreadPeakCount, 1L, null, "", false);
                ThreadLog.printQLog("JobReporter", "reportThreadPeakCount Yes " + JobReporter.sThreadPeakCount);
                JobReporter.access$202(l2);
                ThreadManagerV2.sThreadWrapContext.setMainProccessThreadMonitorTime(l2);
              }
              JobReporter.access$302(0L);
              ThreadManagerV2.sThreadWrapContext.setMainProccessThreadPeakCounts(JobReporter.sThreadPeakCount);
              return;
            }
            l1 = JobReporter.access$500();
            ThreadLog.printQLog("JobReporter", "saveThreadPeakCount count" + l1 + " sThreadPeakCount " + JobReporter.sThreadPeakCount);
          } while (l1 <= JobReporter.sThreadPeakCount);
          JobReporter.access$302(l1);
          ThreadManagerV2.sThreadWrapContext.setMainProccessThreadPeakCounts(JobReporter.sThreadPeakCount);
          return;
          if (paramAnonymousMessage.what != 3) {
            break;
          }
        } while ((ThreadSetting.isPublicVersion) || (JobReporter.mThreadCheck == null) || (paramAnonymousMessage.obj == null));
        paramAnonymousMessage = (JobReporter.CheckParams)paramAnonymousMessage.obj;
        JobReporter.mThreadCheck.isLegalName(paramAnonymousMessage);
        return;
        super.handleMessage(paramAnonymousMessage);
      }
    };
    nativePeerGetFailed = false;
  }
  
  private static int getCurrentThreadCount()
  {
    Field localField = getNativePeerField();
    if (localField == null) {
      return 0;
    }
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = weakThreadList.iterator();
    for (;;)
    {
      int j = i;
      WeakReference localWeakReference;
      if (localIterator.hasNext())
      {
        localWeakReference = (WeakReference)localIterator.next();
        if (nativePeerGetFailed) {
          j = 0;
        }
      }
      else
      {
        if (nativePeerGetFailed) {
          j = 0;
        }
        weakThreadList.removeAll(localArrayList);
        return j;
      }
      Thread localThread = (Thread)localWeakReference.get();
      if (localThread != null)
      {
        try
        {
          if (((Long)localField.get(localThread)).longValue() > 0L) {
            break label140;
          }
          localArrayList.add(localWeakReference);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          nativePeerGetFailed = true;
        }
        continue;
        label140:
        i += 1;
      }
      else
      {
        localArrayList.add(localException);
      }
    }
  }
  
  private static Field getNativePeerField()
  {
    if ((nativePeerF != null) || (nativePeerReflectFailed)) {
      return nativePeerF;
    }
    try
    {
      nativePeerF = Thread.class.getDeclaredField("nativePeer");
      nativePeerF.setAccessible(true);
      return nativePeerF;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      nativePeerF = null;
      nativePeerReflectFailed = true;
    }
    return null;
  }
  
  private static void initThreadPeakCount()
  {
    if ((sInited) || (ThreadManagerV2.sThreadWrapContext == null)) {
      return;
    }
    sThreadPeakCount = ThreadManagerV2.sThreadWrapContext.getMainProccessThreadPeakCounts();
    sMonitorStartTime = ThreadManagerV2.sThreadWrapContext.getMainProccessThreadMonitorTime();
    ThreadLog.printQLog("JobReporter", "initThreadPeakCount sThreadPeakCount " + sThreadPeakCount + " sMonitorStartTime " + sMonitorStartTime);
    sInited = true;
  }
  
  public static void onThreadCreatedCallback(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Thread)))
    {
      Object localObject = mFileHandler.obtainMessage(1);
      ((Message)localObject).obj = paramObject;
      mFileHandler.sendMessage((Message)localObject);
      if (!ThreadSetting.isPublicVersion)
      {
        localObject = (Thread)paramObject;
        paramObject = new CheckParams();
        paramObject.newThreadName = ((Thread)localObject).getName();
        paramObject.ste = Thread.currentThread().getStackTrace();
        localObject = mFileHandler.obtainMessage(3);
        ((Message)localObject).obj = paramObject;
        mFileHandler.sendMessage((Message)localObject);
      }
    }
  }
  
  private static boolean peakCountRamdomReport()
  {
    if (!ThreadSetting.isPublicVersion) {
      return true;
    }
    if (ThreadSetting.isGrayVersion) {
      return ramdomReport(10);
    }
    return ramdomReport(10000);
  }
  
  public static boolean ramdomReport(int paramInt)
  {
    if (!ThreadSetting.isPublicVersion) {}
    do
    {
      return true;
      if (paramInt <= 0) {
        break;
      }
    } while (sRandom.nextInt(paramInt) == 0);
    return false;
    return false;
  }
  
  static void reportJobTime(long paramLong)
  {
    try
    {
      if (ThreadSetting.sProcessId != ThreadSetting.PROCESS_QQ) {
        return;
      }
      sThreadJobReportTotalCount.incrementAndGet();
      if (paramLong <= 200L) {
        break label94;
      }
      switch (Math.min((int)(paramLong / 500L), 2))
      {
      case 0: 
        sThreadJobReportCountLevelOne.incrementAndGet();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ThreadLog.printQLog("JobReporter", "reportJobTime error!!!  : ", localThrowable);
      return;
    }
    sThreadJobReportCountLevelTwo.incrementAndGet();
    return;
    sThreadJobReportCountLevelThree.incrementAndGet();
    label94:
    return;
  }
  
  public static void reportThreadPeakCount(String paramString)
  {
    Message localMessage = mFileHandler.obtainMessage(2);
    localMessage.obj = paramString;
    mFileHandler.sendMessage(localMessage);
  }
  
  public static class CheckParams
  {
    public String newThreadName = "";
    public StackTraceElement[] ste;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.JobReporter
 * JD-Core Version:    0.7.0.1
 */
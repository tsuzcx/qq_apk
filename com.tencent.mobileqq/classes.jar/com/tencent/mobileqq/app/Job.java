package com.tencent.mobileqq.app;

import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Job
  extends WeakReference<Object>
  implements Comparable<Job>, Runnable
{
  private static int RUNNING_TIME_OUT = 9990000;
  private static final String TAG = "Job";
  public static ConcurrentLinkedQueue<String> runningJmapInAync;
  public static ConcurrentLinkedQueue<String> runningJmapInDB;
  public static ConcurrentLinkedQueue<String> runningJmapInDownload;
  public static ConcurrentLinkedQueue<String> runningJmapInFile;
  public static ConcurrentLinkedQueue<String> runningJmapInHeavy = new ConcurrentLinkedQueue();
  public static ConcurrentLinkedQueue<String> runningJmapInLight = new ConcurrentLinkedQueue();
  public static ConcurrentLinkedQueue<String> runningJmapInNet;
  public static ConcurrentLinkedQueue<String> runningJmapInNormal;
  public static ConcurrentLinkedQueue<String> runningJmapInOther;
  public long addPoint = 0L;
  public long blcokingCost = -1L;
  private boolean canAutoRetrieve;
  public long cost = -1L;
  private boolean hasKey = false;
  public long mId = 0L;
  public Runnable mJob;
  public ThreadExcutor.IThreadListener mListener;
  public String mName;
  public int mType = 0;
  public int poolNum = -1;
  public long postCost = -1L;
  public long wait = -1L;
  
  static
  {
    runningJmapInDownload = new ConcurrentLinkedQueue();
    runningJmapInNormal = new ConcurrentLinkedQueue();
    runningJmapInDB = new ConcurrentLinkedQueue();
    runningJmapInFile = new ConcurrentLinkedQueue();
    runningJmapInNet = new ConcurrentLinkedQueue();
    runningJmapInAync = new ConcurrentLinkedQueue();
    runningJmapInOther = new ConcurrentLinkedQueue();
  }
  
  public Job(Object paramObject, Runnable paramRunnable, boolean paramBoolean)
  {
    super(paramObject);
    if (paramObject != null) {
      this.hasKey = true;
    }
    this.mJob = paramRunnable;
    this.canAutoRetrieve = paramBoolean;
  }
  
  Job(Object paramObject, String paramString, int paramInt, Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    super(paramObject);
    if (paramObject != null) {
      this.hasKey = true;
    }
    this.mName = paramRunnable.toString();
    this.mType = paramInt;
    this.mJob = paramRunnable;
    this.mListener = paramIThreadListener;
    paramObject = this.mListener;
    if (paramObject != null) {
      paramObject.onAdded();
    }
    this.addPoint = SystemClock.uptimeMillis();
    this.canAutoRetrieve = paramBoolean;
  }
  
  private void afterRun()
  {
    this.cost = (SystemClock.uptimeMillis() - (this.wait + this.addPoint));
    Object localObject = this.mListener;
    if (localObject != null) {
      ((ThreadExcutor.IThreadListener)localObject).onPostRun();
    }
    reportRunningTooLong();
    if (ThreadSetting.logcatBgTaskMonitor)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tsp execute-");
      ((StringBuilder)localObject).append(toString());
      ThreadLog.printQLog("ThreadManager", ((StringBuilder)localObject).toString());
    }
    if (ThreadLog.needRecordJob())
    {
      int i = this.poolNum;
      if (i != 1)
      {
        if (i != 2)
        {
          switch (i)
          {
          default: 
            return;
          case 11: 
            runningJmapInOther.remove(this.mName);
            return;
          case 10: 
            runningJmapInAync.remove(this.mName);
            return;
          case 9: 
            runningJmapInNet.remove(this.mName);
            return;
          case 8: 
            runningJmapInFile.remove(this.mName);
            return;
          case 7: 
            runningJmapInDB.remove(this.mName);
            return;
          case 6: 
            runningJmapInNormal.remove(this.mName);
            return;
          }
          runningJmapInDownload.remove(this.mName);
          return;
        }
        runningJmapInHeavy.remove(this.mName);
        return;
      }
      runningJmapInLight.remove(this.mName);
    }
  }
  
  private void beforeRun()
  {
    this.wait = (SystemClock.uptimeMillis() - this.addPoint);
    JobReporter.reportJobTime(this.wait);
    Object localObject = this.mListener;
    if (localObject != null) {
      ((ThreadExcutor.IThreadListener)localObject).onPreRun();
    }
    if (ThreadSetting.logcatBgTaskMonitor)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tsp execute|");
      ((StringBuilder)localObject).append(toString());
      ThreadLog.printQLog("ThreadManager", ((StringBuilder)localObject).toString());
    }
    if (ThreadLog.needRecordJob())
    {
      int i = this.poolNum;
      if (i != 1)
      {
        if (i != 2)
        {
          switch (i)
          {
          default: 
            return;
          case 11: 
            runningJmapInOther.add(this.mName);
            return;
          case 10: 
            runningJmapInAync.add(this.mName);
            return;
          case 9: 
            runningJmapInNet.add(this.mName);
            return;
          case 8: 
            runningJmapInFile.add(this.mName);
            return;
          case 7: 
            runningJmapInDB.add(this.mName);
            return;
          case 6: 
            runningJmapInNormal.add(this.mName);
            return;
          }
          runningJmapInDownload.add(this.mName);
          return;
        }
        runningJmapInHeavy.add(this.mName);
        return;
      }
      runningJmapInLight.add(this.mName);
    }
  }
  
  private static long get_RUNNING_TIME_OUT()
  {
    if (!ThreadSetting.isPublicVersion) {
      RUNNING_TIME_OUT = 60000;
    }
    return RUNNING_TIME_OUT;
  }
  
  private void reportRunningTooLong()
  {
    if ((ThreadLog.needReportRunOrBlocking()) && (this.cost >= get_RUNNING_TIME_OUT()) && (ThreadManagerV2.OPEN_RDM_REPORT) && (ThreadManagerV2.sThreadWrapContext != null))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("process_");
      localStringBuilder2.append(ThreadSetting.sProcessId);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" mjobName_");
      localStringBuilder2.append(this.mName);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" mType_");
      localStringBuilder2.append(this.mType);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" cost_");
      localStringBuilder2.append(this.cost);
      localStringBuilder1.append(localStringBuilder2.toString());
      ThreadLog.printQLog("Job", localStringBuilder1.toString());
      ThreadManagerV2.sThreadWrapContext.reportRDMException(new TSPRunTooLongCatchedException("max_reportJobRunningTooLong"), "max_reportJobRunningTooLong", localStringBuilder1.toString());
    }
  }
  
  public boolean checkShouldRun()
  {
    boolean bool3 = this.canAutoRetrieve;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (this.hasKey)
      {
        Object localObject = get();
        if (localObject != null)
        {
          try
          {
            Field localField = this.mJob.getClass().getDeclaredField("this$0");
            localField.setAccessible(true);
            localField.set(this.mJob, localObject);
            return true;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            ThreadLog.printQLog("Job", this.mName, localIllegalAccessException);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            ThreadLog.printQLog("Job", this.mName, localIllegalArgumentException);
          }
          catch (NoSuchFieldException localNoSuchFieldException)
          {
            ThreadLog.printQLog("Job", this.mName, localNoSuchFieldException);
          }
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.mName);
          localStringBuilder.append(" never run, becuse outer object is retrieve already");
          ThreadLog.printQLog("Job", localStringBuilder.toString());
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public int compareTo(Job paramJob)
  {
    int i = this.mType;
    int j = paramJob.mType;
    if (i == j) {
      return 0;
    }
    if (i > j) {
      return -1;
    }
    return 1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (Job)paramObject;
    Runnable localRunnable = this.mJob;
    if (localRunnable == null)
    {
      if (paramObject.mJob != null) {
        return false;
      }
    }
    else if (!localRunnable.equals(paramObject.mJob)) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    Runnable localRunnable = this.mJob;
    int i;
    if (localRunnable == null) {
      i = 0;
    } else {
      i = localRunnable.hashCode();
    }
    return 31 + i;
  }
  
  public void run()
  {
    if (checkShouldRun())
    {
      beforeRun();
      this.mJob.run();
      afterRun();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mName);
    localStringBuilder.append(" is recycled");
    ThreadLog.printQLog("Job", localStringBuilder.toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(" cost=");
    localStringBuilder.append(this.cost);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mName);
    localStringBuilder.append("|pool-");
    localStringBuilder.append(this.poolNum);
    localStringBuilder.append("|t-id=");
    localStringBuilder.append(this.mId);
    localStringBuilder.append("|mType=");
    localStringBuilder.append(this.mType);
    localStringBuilder.append("|wait=");
    localStringBuilder.append(this.wait);
    localStringBuilder.append("|postCost=");
    localStringBuilder.append(this.postCost);
    localStringBuilder.append("|bCost=");
    localStringBuilder.append(this.blcokingCost);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.Job
 * JD-Core Version:    0.7.0.1
 */
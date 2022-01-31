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
    if (this.mListener != null) {
      this.mListener.onAdded();
    }
    this.addPoint = SystemClock.uptimeMillis();
    this.canAutoRetrieve = paramBoolean;
  }
  
  private void afterRun()
  {
    this.cost = (SystemClock.uptimeMillis() - (this.wait + this.addPoint));
    if (this.mListener != null) {
      this.mListener.onPostRun();
    }
    reportRunningTooLong();
    if (ThreadSetting.logcatBgTaskMonitor) {
      ThreadLog.printQLog("ThreadManager", "tsp execute-" + toString());
    }
    if (ThreadLog.needRecordJob()) {}
    switch (this.poolNum)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 1: 
      runningJmapInLight.remove(this.mName);
      return;
    case 2: 
      runningJmapInHeavy.remove(this.mName);
      return;
    case 5: 
      runningJmapInDownload.remove(this.mName);
      return;
    case 6: 
      runningJmapInNormal.remove(this.mName);
      return;
    case 7: 
      runningJmapInDB.remove(this.mName);
      return;
    case 8: 
      runningJmapInFile.remove(this.mName);
      return;
    case 9: 
      runningJmapInNet.remove(this.mName);
      return;
    case 10: 
      runningJmapInAync.remove(this.mName);
      return;
    }
    runningJmapInOther.remove(this.mName);
  }
  
  private void beforeRun()
  {
    this.wait = (SystemClock.uptimeMillis() - this.addPoint);
    JobReporter.reportJobTime(this.wait);
    if (this.mListener != null) {
      this.mListener.onPreRun();
    }
    if (ThreadSetting.logcatBgTaskMonitor) {
      ThreadLog.printQLog("ThreadManager", "tsp execute|" + toString());
    }
    if (ThreadLog.needRecordJob()) {}
    switch (this.poolNum)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 1: 
      runningJmapInLight.add(this.mName);
      return;
    case 2: 
      runningJmapInHeavy.add(this.mName);
      return;
    case 5: 
      runningJmapInDownload.add(this.mName);
      return;
    case 6: 
      runningJmapInNormal.add(this.mName);
      return;
    case 7: 
      runningJmapInDB.add(this.mName);
      return;
    case 8: 
      runningJmapInFile.add(this.mName);
      return;
    case 9: 
      runningJmapInNet.add(this.mName);
      return;
    case 10: 
      runningJmapInAync.add(this.mName);
      return;
    }
    runningJmapInOther.add(this.mName);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("process_" + ThreadSetting.sProcessId).append(" mjobName_" + this.mName).append(" mType_" + this.mType).append(" cost_" + this.cost);
      ThreadLog.printQLog("Job", localStringBuilder.toString());
      ThreadManagerV2.sThreadWrapContext.reportRDMException(new TSPRunTooLongCatchedException("max_reportJobRunningTooLong"), "max_reportJobRunningTooLong", localStringBuilder.toString());
    }
  }
  
  public boolean checkShouldRun()
  {
    Object localObject;
    if ((this.canAutoRetrieve) && (this.hasKey))
    {
      localObject = get();
      if (localObject == null) {}
    }
    else
    {
      try
      {
        Field localField = this.mJob.getClass().getDeclaredField("this$0");
        localField.setAccessible(true);
        localField.set(this.mJob, localObject);
        return true;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        ThreadLog.printQLog("Job", this.mName, localNoSuchFieldException);
        return false;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ThreadLog.printQLog("Job", this.mName, localIllegalArgumentException);
        return false;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        ThreadLog.printQLog("Job", this.mName, localIllegalAccessException);
        return false;
      }
    }
    ThreadLog.printQLog("Job", this.mName + " never run, becuse outer object is retrieve already");
    return false;
  }
  
  public int compareTo(Job paramJob)
  {
    if (this.mType == paramJob.mType) {
      return 0;
    }
    if (this.mType > paramJob.mType) {
      return -1;
    }
    return 1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (Job)paramObject;
        if (this.mJob != null) {
          break;
        }
      } while (paramObject.mJob == null);
      return false;
    } while (this.mJob.equals(paramObject.mJob));
    return false;
  }
  
  public int hashCode()
  {
    if (this.mJob == null) {}
    for (int i = 0;; i = this.mJob.hashCode()) {
      return i + 31;
    }
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
    ThreadLog.printQLog("Job", this.mName + " is recycled");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(" cost=").append(this.cost).append(", ").append(this.mName).append("|pool-").append(this.poolNum).append("|t-id=").append(this.mId).append("|mType=").append(this.mType).append("|wait=").append(this.wait).append("|postCost=").append(this.postCost).append("|bCost=").append(this.blcokingCost);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.Job
 * JD-Core Version:    0.7.0.1
 */
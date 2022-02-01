package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.LinkedList;

@TargetApi(14)
public class PreloadQueue
  extends LinkedList<DownloadTask>
{
  public static final String TAG = "Q.qqstory.download.preload.PreloadQueue";
  private final Object dataSafeLock = new Object();
  private int mQueueId;
  private final Object notEmptyLock = new Object();
  
  public void addTask(DownloadTask paramDownloadTask, boolean paramBoolean)
  {
    Object localObject = this.dataSafeLock;
    if (paramBoolean) {}
    try
    {
      addFirst(paramDownloadTask);
      break label25;
      add(paramDownloadTask);
      label25:
      releaseBlock();
      return;
    }
    finally {}
  }
  
  void clearAllTask()
  {
    synchronized (this.dataSafeLock)
    {
      clear();
      return;
    }
  }
  
  public DownloadTask getFirstAndBlockIfLowestPriority()
  {
    try
    {
      ??? = pollFirst();
      if ((this.mQueueId == 2) && (??? == null))
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append(this.mQueueId);
        ((StringBuilder)???).append(" wait");
        SLog.b("Q.qqstory.download.preload.PreloadQueue", ((StringBuilder)???).toString());
        synchronized (this.notEmptyLock)
        {
          this.notEmptyLock.wait(90000L);
          ??? = pollFirst();
          return ???;
        }
      }
      return ???;
    }
    catch (InterruptedException localInterruptedException)
    {
      label83:
      break label83;
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("getFirst error , current queue id = ");
    ((StringBuilder)???).append(this.mQueueId);
    SLog.d("Q.qqstory.download.preload.PreloadQueue", ((StringBuilder)???).toString());
    return null;
  }
  
  public int getId()
  {
    return this.mQueueId;
  }
  
  public boolean isBusy()
  {
    for (;;)
    {
      synchronized (this.dataSafeLock)
      {
        if (size() > 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public DownloadTask pollFirst()
  {
    synchronized (this.dataSafeLock)
    {
      DownloadTask localDownloadTask = (DownloadTask)super.pollFirst();
      return localDownloadTask;
    }
  }
  
  public void releaseBlock()
  {
    synchronized (this.notEmptyLock)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mQueueId);
      localStringBuilder.append(" releaseBlock");
      SLog.b("Q.qqstory.download.preload.PreloadQueue", localStringBuilder.toString());
      this.notEmptyLock.notifyAll();
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PreloadQueue{mQueueId=");
    localStringBuilder.append(this.mQueueId);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadQueue
 * JD-Core Version:    0.7.0.1
 */
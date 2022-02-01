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
    localObject = this.dataSafeLock;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        addFirst(paramDownloadTask);
        releaseBlock();
        return;
      }
      finally {}
      add(paramDownloadTask);
    }
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
      DownloadTask localDownloadTask = pollFirst();
      ??? = localDownloadTask;
      if (this.mQueueId == 2)
      {
        ??? = localDownloadTask;
        if (localDownloadTask == null) {
          SLog.b("Q.qqstory.download.preload.PreloadQueue", this.mQueueId + " wait");
        }
      }
      synchronized (this.notEmptyLock)
      {
        this.notEmptyLock.wait(90000L);
        ??? = pollFirst();
        return ???;
      }
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      SLog.d("Q.qqstory.download.preload.PreloadQueue", "getFirst error , current queue id = " + this.mQueueId);
    }
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
      SLog.b("Q.qqstory.download.preload.PreloadQueue", this.mQueueId + " releaseBlock");
      this.notEmptyLock.notifyAll();
      return;
    }
  }
  
  public String toString()
  {
    return "PreloadQueue{mQueueId=" + this.mQueueId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadQueue
 * JD-Core Version:    0.7.0.1
 */
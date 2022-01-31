package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import java.util.LinkedList;
import unj;
import wxe;

@TargetApi(14)
public class PreloadQueue
  extends LinkedList<unj>
{
  public static final String TAG = "Q.qqstory.download.preload.PreloadQueue";
  private final Object dataSafeLock = new Object();
  private int mQueueId;
  private final Object notEmptyLock = new Object();
  
  public void addTask(unj paramunj, boolean paramBoolean)
  {
    localObject = this.dataSafeLock;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        addFirst(paramunj);
        releaseBlock();
        return;
      }
      finally {}
      add(paramunj);
    }
  }
  
  public void clearAllTask()
  {
    synchronized (this.dataSafeLock)
    {
      clear();
      return;
    }
  }
  
  public unj getFirstAndBlockIfLowestPriority()
  {
    try
    {
      unj localunj = pollFirst();
      ??? = localunj;
      if (this.mQueueId == 2)
      {
        ??? = localunj;
        if (localunj == null) {
          wxe.b("Q.qqstory.download.preload.PreloadQueue", this.mQueueId + " wait");
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
      wxe.d("Q.qqstory.download.preload.PreloadQueue", "getFirst error , current queue id = " + this.mQueueId);
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
  
  public unj pollFirst()
  {
    synchronized (this.dataSafeLock)
    {
      unj localunj = (unj)super.pollFirst();
      return localunj;
    }
  }
  
  public void releaseBlock()
  {
    synchronized (this.notEmptyLock)
    {
      wxe.b("Q.qqstory.download.preload.PreloadQueue", this.mQueueId + " releaseBlock");
      this.notEmptyLock.notifyAll();
      return;
    }
  }
  
  public String toString()
  {
    return "PreloadQueue{mQueueId=" + this.mQueueId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadQueue
 * JD-Core Version:    0.7.0.1
 */
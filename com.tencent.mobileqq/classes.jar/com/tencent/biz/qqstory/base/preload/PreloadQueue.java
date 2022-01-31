package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import java.util.LinkedList;
import uja;
import wsv;

@TargetApi(14)
public class PreloadQueue
  extends LinkedList<uja>
{
  public static final String TAG = "Q.qqstory.download.preload.PreloadQueue";
  private final Object dataSafeLock = new Object();
  private int mQueueId;
  private final Object notEmptyLock = new Object();
  
  public void addTask(uja paramuja, boolean paramBoolean)
  {
    localObject = this.dataSafeLock;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        addFirst(paramuja);
        releaseBlock();
        return;
      }
      finally {}
      add(paramuja);
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
  
  public uja getFirstAndBlockIfLowestPriority()
  {
    try
    {
      uja localuja = pollFirst();
      ??? = localuja;
      if (this.mQueueId == 2)
      {
        ??? = localuja;
        if (localuja == null) {
          wsv.b("Q.qqstory.download.preload.PreloadQueue", this.mQueueId + " wait");
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
      wsv.d("Q.qqstory.download.preload.PreloadQueue", "getFirst error , current queue id = " + this.mQueueId);
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
  
  public uja pollFirst()
  {
    synchronized (this.dataSafeLock)
    {
      uja localuja = (uja)super.pollFirst();
      return localuja;
    }
  }
  
  public void releaseBlock()
  {
    synchronized (this.notEmptyLock)
    {
      wsv.b("Q.qqstory.download.preload.PreloadQueue", this.mQueueId + " releaseBlock");
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
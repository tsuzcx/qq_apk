package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import java.util.LinkedList;
import wkq;
import yuk;

@TargetApi(14)
public class PreloadQueue
  extends LinkedList<wkq>
{
  public static final String TAG = "Q.qqstory.download.preload.PreloadQueue";
  private final Object dataSafeLock = new Object();
  private int mQueueId;
  private final Object notEmptyLock = new Object();
  
  public void addTask(wkq paramwkq, boolean paramBoolean)
  {
    localObject = this.dataSafeLock;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        addFirst(paramwkq);
        releaseBlock();
        return;
      }
      finally {}
      add(paramwkq);
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
  
  public wkq getFirstAndBlockIfLowestPriority()
  {
    try
    {
      wkq localwkq = pollFirst();
      ??? = localwkq;
      if (this.mQueueId == 2)
      {
        ??? = localwkq;
        if (localwkq == null) {
          yuk.b("Q.qqstory.download.preload.PreloadQueue", this.mQueueId + " wait");
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
      yuk.d("Q.qqstory.download.preload.PreloadQueue", "getFirst error , current queue id = " + this.mQueueId);
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
  
  public wkq pollFirst()
  {
    synchronized (this.dataSafeLock)
    {
      wkq localwkq = (wkq)super.pollFirst();
      return localwkq;
    }
  }
  
  public void releaseBlock()
  {
    synchronized (this.notEmptyLock)
    {
      yuk.b("Q.qqstory.download.preload.PreloadQueue", this.mQueueId + " releaseBlock");
      this.notEmptyLock.notifyAll();
      return;
    }
  }
  
  public String toString()
  {
    return "PreloadQueue{mQueueId=" + this.mQueueId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadQueue
 * JD-Core Version:    0.7.0.1
 */
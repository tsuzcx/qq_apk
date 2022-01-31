package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import java.util.LinkedList;
import sul;
import veg;

@TargetApi(14)
public class PreloadQueue
  extends LinkedList<sul>
{
  public static final String TAG = "Q.qqstory.download.preload.PreloadQueue";
  private final Object dataSafeLock = new Object();
  private int mQueueId;
  private final Object notEmptyLock = new Object();
  
  public void addTask(sul paramsul, boolean paramBoolean)
  {
    localObject = this.dataSafeLock;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        addFirst(paramsul);
        releaseBlock();
        return;
      }
      finally {}
      add(paramsul);
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
  
  public sul getFirstAndBlockIfLowestPriority()
  {
    try
    {
      sul localsul = pollFirst();
      ??? = localsul;
      if (this.mQueueId == 2)
      {
        ??? = localsul;
        if (localsul == null) {
          veg.b("Q.qqstory.download.preload.PreloadQueue", this.mQueueId + " wait");
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
      veg.d("Q.qqstory.download.preload.PreloadQueue", "getFirst error , current queue id = " + this.mQueueId);
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
  
  public sul pollFirst()
  {
    synchronized (this.dataSafeLock)
    {
      sul localsul = (sul)super.pollFirst();
      return localsul;
    }
  }
  
  public void releaseBlock()
  {
    synchronized (this.notEmptyLock)
    {
      veg.b("Q.qqstory.download.preload.PreloadQueue", this.mQueueId + " releaseBlock");
      this.notEmptyLock.notifyAll();
      return;
    }
  }
  
  public String toString()
  {
    return "PreloadQueue{mQueueId=" + this.mQueueId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadQueue
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.component.media.image;

import android.util.Log;

public class RecycleResourceTask
  extends ImageTask
{
  private static double averageTime;
  private static int mObjectPoolSize;
  private static long requestNum = 0L;
  private static RecycleResourceTask sPool;
  private static final Object sPoolSync;
  private RecycleResourceTask next = null;
  private long startTime = 0L;
  
  static
  {
    averageTime = 0.0D;
    sPool = null;
    sPoolSync = new Object();
    mObjectPoolSize = 0;
    clearAndInitSize();
  }
  
  private RecycleResourceTask(ImageTask paramImageTask)
  {
    super(paramImageTask);
  }
  
  public static void clearAndInitSize()
  {
    synchronized (sPoolSync)
    {
      sPool = null;
      int i = 0;
      while (i < mInitAllocatedSize)
      {
        RecycleResourceTask localRecycleResourceTask = new RecycleResourceTask(null);
        localRecycleResourceTask.next = sPool;
        sPool = localRecycleResourceTask;
        mObjectPoolSize += 1;
        i += 1;
      }
      return;
    }
  }
  
  public static RecycleResourceTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {}
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        RecycleResourceTask localRecycleResourceTask = sPool;
        sPool = sPool.next;
        localRecycleResourceTask.next = null;
        mObjectPoolSize -= 1;
        localRecycleResourceTask.setImageTask(paramImageTask);
        return localRecycleResourceTask;
      }
      return new RecycleResourceTask(paramImageTask);
    }
  }
  
  private void updateTime(long paramLong)
  {
    try
    {
      averageTime = (requestNum * averageTime + paramLong) / (requestNum + 1L);
      Log.i("ttt", "ImageTask averageTime: " + averageTime);
      requestNum += 1L;
      return;
    }
    finally {}
  }
  
  public void excuteTask()
  {
    if (this.mNextTask != null)
    {
      ImageTaskTracer.addImageTaskLifeCycleRecord(this.mImageKey.hashCodeEx());
      ImageTaskManager.addImageTask(this);
      this.mNextTask.excuteTask();
    }
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs)
  {
    ImageTaskTracer.removeImageTaskLifeCycleRecord(this.mImageKey.hashCodeEx());
    Log.d("RecycleResourceTask", "onResult type:" + paramInt + " hashcode:" + this.mImageKey.hashCodeEx() + " url:" + getImageKey().url);
    ImageTaskManager.removeImageTask(getImageKey());
    ImageTask localImageTask;
    for (paramVarArgs = this.mNextTask; paramVarArgs != null; paramVarArgs = localImageTask)
    {
      localImageTask = paramVarArgs.getNextTask();
      paramVarArgs.recycle();
    }
    recycle();
  }
  
  public void recycle()
  {
    if (!needRecycle) {
      return;
    }
    reset();
    synchronized (sPoolSync)
    {
      if (mObjectPoolSize < 50)
      {
        this.next = sPool;
        sPool = this;
        mObjectPoolSize += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.RecycleResourceTask
 * JD-Core Version:    0.7.0.1
 */
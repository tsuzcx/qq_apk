package com.tencent.component.media.image;

import android.util.Log;

public class RecycleResourceTask
  extends ImageTask
{
  private static double averageTime;
  private static int mObjectPoolSize;
  private static long requestNum;
  private static RecycleResourceTask sPool;
  private static final Object sPoolSync = new Object();
  private RecycleResourceTask next = null;
  private long startTime = 0L;
  
  static
  {
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
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static RecycleResourceTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {
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
      }
    }
    return new RecycleResourceTask(paramImageTask);
  }
  
  private void updateTime(long paramLong)
  {
    try
    {
      double d1 = requestNum;
      double d2 = averageTime;
      Double.isNaN(d1);
      double d3 = paramLong;
      Double.isNaN(d3);
      paramLong = requestNum;
      double d4 = paramLong + 1L;
      Double.isNaN(d4);
      d1 = (d1 * d2 + d3) / d4;
      averageTime = d1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ImageTask averageTime: ");
      localStringBuilder.append(averageTime);
      Log.i("ttt", localStringBuilder.toString());
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
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("onResult type:");
    paramVarArgs.append(paramInt);
    paramVarArgs.append(" hashcode:");
    paramVarArgs.append(this.mImageKey.hashCodeEx());
    paramVarArgs.append(" url:");
    paramVarArgs.append(getImageKey().url);
    Log.d("RecycleResourceTask", paramVarArgs.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.RecycleResourceTask
 * JD-Core Version:    0.7.0.1
 */
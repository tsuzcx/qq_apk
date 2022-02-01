package com.tencent.component.media.image;

public class CancelableDecodeImageTask
  extends DecodeImageTask
{
  private static int mObjectPoolSize;
  private static CancelableDecodeImageTask sPool;
  private static final Object sPoolSync = new Object();
  private CancelableDecodeImageTask next = null;
  
  static
  {
    mObjectPoolSize = 0;
    clearAndInitSize();
  }
  
  private CancelableDecodeImageTask(ImageKey paramImageKey)
  {
    super(paramImageKey);
  }
  
  private CancelableDecodeImageTask(ImageTask paramImageTask)
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
        CancelableDecodeImageTask localCancelableDecodeImageTask = new CancelableDecodeImageTask(null);
        localCancelableDecodeImageTask.next = sPool;
        sPool = localCancelableDecodeImageTask;
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
  
  public static CancelableDecodeImageTask obtain(ImageKey paramImageKey)
  {
    if (needRecycle) {
      synchronized (sPoolSync)
      {
        if (sPool != null)
        {
          CancelableDecodeImageTask localCancelableDecodeImageTask = sPool;
          sPool = sPool.next;
          localCancelableDecodeImageTask.next = null;
          mObjectPoolSize -= 1;
          localCancelableDecodeImageTask.setImageKey(paramImageKey);
          return localCancelableDecodeImageTask;
        }
      }
    }
    return new CancelableDecodeImageTask(paramImageKey);
  }
  
  public static CancelableDecodeImageTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {
      synchronized (sPoolSync)
      {
        if (sPool != null)
        {
          CancelableDecodeImageTask localCancelableDecodeImageTask = sPool;
          sPool = sPool.next;
          localCancelableDecodeImageTask.next = null;
          mObjectPoolSize -= 1;
          localCancelableDecodeImageTask.setImageTask(paramImageTask);
          return localCancelableDecodeImageTask;
        }
      }
    }
    return new CancelableDecodeImageTask(paramImageTask);
  }
  
  public void excuteTask()
  {
    if (!isCanceled())
    {
      super.excuteTask();
      return;
    }
    setResult(13, new Object[0]);
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 13)
    {
      setResult(13, new Object[0]);
      return;
    }
    super.onResult(paramInt, paramVarArgs);
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
  
  public void startDecodeTask()
  {
    if (!isCanceled())
    {
      super.startDecodeTask();
      return;
    }
    setResult(13, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.CancelableDecodeImageTask
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.component.media.image;

import com.tencent.component.media.utils.ImageManagerLog;

public class CancelStreamDecodeGifTask
  extends StreamDecodeGifTask
{
  private static int mObjectPoolSize;
  private static CancelStreamDecodeGifTask sPool = null;
  private static final Object sPoolSync = new Object();
  private CancelStreamDecodeGifTask next = null;
  
  static
  {
    mObjectPoolSize = 0;
    clearAndInitSize();
  }
  
  private CancelStreamDecodeGifTask(ImageKey paramImageKey)
  {
    super(paramImageKey);
  }
  
  private CancelStreamDecodeGifTask(ImageTask paramImageTask)
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
        CancelStreamDecodeGifTask localCancelStreamDecodeGifTask = new CancelStreamDecodeGifTask(null);
        localCancelStreamDecodeGifTask.next = sPool;
        sPool = localCancelStreamDecodeGifTask;
        mObjectPoolSize += 1;
        i += 1;
      }
      return;
    }
  }
  
  public static CancelStreamDecodeGifTask obtain(ImageKey paramImageKey)
  {
    if (needRecycle) {}
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        CancelStreamDecodeGifTask localCancelStreamDecodeGifTask = sPool;
        sPool = sPool.next;
        localCancelStreamDecodeGifTask.next = null;
        mObjectPoolSize -= 1;
        localCancelStreamDecodeGifTask.setImageKey(paramImageKey);
        return localCancelStreamDecodeGifTask;
      }
      return new CancelStreamDecodeGifTask(paramImageKey);
    }
  }
  
  public static CancelStreamDecodeGifTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {}
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        CancelStreamDecodeGifTask localCancelStreamDecodeGifTask = sPool;
        sPool = sPool.next;
        localCancelStreamDecodeGifTask.next = null;
        mObjectPoolSize -= 1;
        localCancelStreamDecodeGifTask.setImageTask(paramImageTask);
        return localCancelStreamDecodeGifTask;
      }
      return new CancelStreamDecodeGifTask(paramImageTask);
    }
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
    if (!isCanceled())
    {
      super.onResult(paramInt, paramVarArgs);
      return;
    }
    removeRecord((String)paramVarArgs[0]);
    if (this.mImageKey != null) {
      ImageManagerLog.d("CancelStreamDecodeGifTask", "onResult type:" + paramInt + " hashcode:" + this.mImageKey.hashCodeEx());
    }
    setResult(13, new Object[0]);
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
 * Qualified Name:     com.tencent.component.media.image.CancelStreamDecodeGifTask
 * JD-Core Version:    0.7.0.1
 */
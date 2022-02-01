package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;

public class FetchCachedImageTask
  extends ImageTask
{
  private static int mObjectPoolSize;
  private static FetchCachedImageTask sPool;
  private static final Object sPoolSync = new Object();
  private FetchCachedImageTask next = null;
  
  static
  {
    mObjectPoolSize = 0;
    clearAndInitSize();
  }
  
  private FetchCachedImageTask(ImageTask paramImageTask)
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
        FetchCachedImageTask localFetchCachedImageTask = new FetchCachedImageTask(null);
        localFetchCachedImageTask.next = sPool;
        sPool = localFetchCachedImageTask;
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
  
  public static FetchCachedImageTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {
      synchronized (sPoolSync)
      {
        if (sPool != null)
        {
          FetchCachedImageTask localFetchCachedImageTask = sPool;
          sPool = sPool.next;
          localFetchCachedImageTask.next = null;
          mObjectPoolSize -= 1;
          localFetchCachedImageTask.setImageTask(paramImageTask);
          return localFetchCachedImageTask;
        }
      }
    }
    return new FetchCachedImageTask(paramImageTask);
  }
  
  public void excuteTask()
  {
    Drawable localDrawable = ImageManager.getInstance().getDrawbleFromCache(this.mImageKey);
    if (localDrawable != null)
    {
      setResult(6, new Object[] { localDrawable, null });
      return;
    }
    if (this.mNextTask != null)
    {
      this.mNextTask.excuteTask();
      return;
    }
    if ((this.mImageKey != null) && (this.mImageKey.options != null)) {
      this.mImageKey.options.errCode = ImageManager.getErrorString(this.mImageKey, 600);
    }
    setResult(4, new Object[0]);
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 3)
    {
      if (paramInt != 11)
      {
        if (paramInt != 8)
        {
          if (paramInt != 9)
          {
            setResult(paramInt, paramVarArgs);
            return;
          }
          setResult(4, new Object[0]);
          return;
        }
        setResult(6, new Object[] { (Drawable)paramVarArgs[0], (BitmapReference)paramVarArgs[1] });
        return;
      }
      setResult(6, new Object[] { (Drawable)paramVarArgs[0], null });
      return;
    }
    setResult(7, new Object[] { (String)paramVarArgs[0], Long.valueOf(((Long)paramVarArgs[1]).longValue()), Float.valueOf(((Float)paramVarArgs[2]).floatValue()) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.FetchCachedImageTask
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.tencent.component.media.utils.BaseHandler;

public class UICallbackTask
  extends ImageTask
{
  private static BaseHandler mMainHandler = new BaseHandler(Looper.getMainLooper());
  private static int mObjectPoolSize;
  private static UICallbackTask sPool = null;
  private static final Object sPoolSync = new Object();
  private UICallbackTask next = null;
  
  static
  {
    mObjectPoolSize = 0;
    clearAndInitSize();
  }
  
  private UICallbackTask(ImageTask paramImageTask)
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
        UICallbackTask localUICallbackTask = new UICallbackTask(null);
        localUICallbackTask.next = sPool;
        sPool = localUICallbackTask;
        mObjectPoolSize += 1;
        i += 1;
      }
      return;
    }
  }
  
  private String getCallbackUrl(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {
      return null;
    }
    if (paramImageKey.srUrl != null) {
      return paramImageKey.srUrl;
    }
    return paramImageKey.url;
  }
  
  public static UICallbackTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {}
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        UICallbackTask localUICallbackTask = sPool;
        sPool = sPool.next;
        localUICallbackTask.next = null;
        mObjectPoolSize -= 1;
        localUICallbackTask.setImageTask(paramImageTask);
        return localUICallbackTask;
      }
      return new UICallbackTask(paramImageTask);
    }
  }
  
  private void onImageCanceled(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {}
    do
    {
      return;
      ProgressTracer.print(1003, getCallbackUrl(paramImageKey));
      if (paramImageKey.imglistener != null) {
        paramImageKey.imglistener.onDownloadCanceled(getCallbackUrl(paramImageKey));
      }
    } while (paramImageKey.listener == null);
    if (paramImageKey.options == null) {}
    for (boolean bool = false; bool; bool = paramImageKey.options.useMainThread)
    {
      mMainHandler.post(new UICallbackTask.2(this, paramImageKey));
      return;
    }
    paramImageKey.listener.onImageCanceled(getCallbackUrl(paramImageKey), paramImageKey.options);
  }
  
  private void onImageFailed(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {}
    do
    {
      return;
      if (paramImageKey.imglistener != null) {
        paramImageKey.imglistener.onDownloadFailed(getCallbackUrl(paramImageKey));
      }
    } while (paramImageKey.listener == null);
    if (paramImageKey.options == null) {}
    for (boolean bool = false; bool; bool = paramImageKey.options.useMainThread)
    {
      mMainHandler.post(new UICallbackTask.1(this, paramImageKey));
      return;
    }
    paramImageKey.listener.onImageFailed(getCallbackUrl(paramImageKey), paramImageKey.options);
  }
  
  private void onImageLoaded(ImageKey paramImageKey, Drawable paramDrawable)
  {
    if (paramImageKey == null) {}
    do
    {
      return;
      if (paramImageKey.imglistener != null) {
        paramImageKey.imglistener.onDownloadSucceed(getCallbackUrl(paramImageKey));
      }
    } while (paramImageKey.listener == null);
    if (paramImageKey.options == null) {}
    for (boolean bool = false; bool; bool = paramImageKey.options.useMainThread)
    {
      mMainHandler.post(new UICallbackTask.3(this, paramImageKey, paramDrawable));
      return;
    }
    paramImageKey.listener.onImageLoaded(getCallbackUrl(paramImageKey), paramDrawable, paramImageKey.options);
    ProgressTracer.printI(new Object[] { Long.valueOf(System.currentTimeMillis()), " : ", Integer.valueOf(6), " : ", getCallbackUrl(paramImageKey), " : ", Integer.valueOf(paramImageKey.listener.hashCode()) });
  }
  
  private void onImageProgress(ImageKey paramImageKey, long paramLong, float paramFloat)
  {
    if (paramImageKey == null) {}
    do
    {
      do
      {
        return;
      } while (!paramImageKey.needCallBackProcessPercent);
      if (paramImageKey.imglistener != null) {
        paramImageKey.imglistener.onDownloadProgress(getCallbackUrl(paramImageKey), paramLong, paramFloat);
      }
    } while (paramImageKey.listener == null);
    if (paramImageKey.options != null) {
      paramImageKey.options.totalSize = paramLong;
    }
    if (paramImageKey.options == null) {}
    for (boolean bool = false; bool; bool = paramImageKey.options.useMainThread)
    {
      mMainHandler.post(new UICallbackTask.4(this, paramImageKey, paramFloat));
      return;
    }
    paramImageKey.listener.onImageProgress(getCallbackUrl(paramImageKey), paramFloat, paramImageKey.options);
  }
  
  public void excuteTask()
  {
    if (this.mNextTask != null) {
      this.mNextTask.excuteTask();
    }
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((paramInt != 3) && (paramInt != 7) && (paramInt != 14) && (paramInt != 15)) {
        setResult(paramInt, paramVarArgs);
      }
      return;
      onImageFailed(this.mImageKey);
      continue;
      onImageCanceled(this.mImageKey);
      continue;
      Object localObject = (Drawable)paramVarArgs[0];
      onImageLoaded(this.mImageKey, (Drawable)localObject);
      continue;
      localObject = (String)paramVarArgs[0];
      long l = ((Long)paramVarArgs[1]).longValue();
      float f = ((Float)paramVarArgs[2]).floatValue();
      onImageProgress(this.mImageKey, l, f);
      continue;
      onImageCanceled(this.mImageKey);
      continue;
      onImageCanceled(this.mImageKey);
      continue;
      onImageFailed(this.mImageKey);
      continue;
      onImageLoaded(this.mImageKey, null);
      continue;
      localObject = (String)paramVarArgs[0];
      l = ((Long)paramVarArgs[1]).longValue();
      f = ((Float)paramVarArgs[2]).floatValue();
      onImageProgress(this.mImageKey, l, f);
      continue;
      localObject = (Drawable)paramVarArgs[0];
      onImageLoaded(this.mImageKey, (Drawable)localObject);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.UICallbackTask
 * JD-Core Version:    0.7.0.1
 */
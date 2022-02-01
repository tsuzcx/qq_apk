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
    for (;;)
    {
      throw localObject2;
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
    if (needRecycle) {
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
      }
    }
    return new UICallbackTask(paramImageTask);
  }
  
  private void onImageCanceled(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {
      return;
    }
    ProgressTracer.print(1003, getCallbackUrl(paramImageKey));
    if (paramImageKey.imglistener != null) {
      paramImageKey.imglistener.onDownloadCanceled(getCallbackUrl(paramImageKey));
    }
    if (paramImageKey.listener != null)
    {
      boolean bool;
      if (paramImageKey.options == null) {
        bool = false;
      } else {
        bool = paramImageKey.options.useMainThread;
      }
      if (bool)
      {
        mMainHandler.post(new UICallbackTask.2(this, paramImageKey));
        return;
      }
      paramImageKey.listener.onImageCanceled(getCallbackUrl(paramImageKey), paramImageKey.options);
    }
  }
  
  private void onImageFailed(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {
      return;
    }
    if (paramImageKey.imglistener != null) {
      paramImageKey.imglistener.onDownloadFailed(getCallbackUrl(paramImageKey));
    }
    if (paramImageKey.listener != null)
    {
      boolean bool;
      if (paramImageKey.options == null) {
        bool = false;
      } else {
        bool = paramImageKey.options.useMainThread;
      }
      if (bool)
      {
        mMainHandler.post(new UICallbackTask.1(this, paramImageKey));
        return;
      }
      paramImageKey.listener.onImageFailed(getCallbackUrl(paramImageKey), paramImageKey.options);
    }
  }
  
  private void onImageLoaded(ImageKey paramImageKey, Drawable paramDrawable)
  {
    if (paramImageKey == null) {
      return;
    }
    if (paramImageKey.imglistener != null) {
      paramImageKey.imglistener.onDownloadSucceed(getCallbackUrl(paramImageKey));
    }
    if (paramImageKey.listener != null)
    {
      boolean bool;
      if (paramImageKey.options == null) {
        bool = false;
      } else {
        bool = paramImageKey.options.useMainThread;
      }
      if (bool)
      {
        mMainHandler.post(new UICallbackTask.3(this, paramImageKey, paramDrawable));
        return;
      }
      paramImageKey.listener.onImageLoaded(getCallbackUrl(paramImageKey), paramDrawable, paramImageKey.options);
      ProgressTracer.printI(new Object[] { Long.valueOf(System.currentTimeMillis()), " : ", Integer.valueOf(6), " : ", getCallbackUrl(paramImageKey), " : ", Integer.valueOf(paramImageKey.listener.hashCode()) });
    }
  }
  
  private void onImageProgress(ImageKey paramImageKey, long paramLong, float paramFloat)
  {
    if (paramImageKey == null) {
      return;
    }
    if (paramImageKey.needCallBackProcessPercent)
    {
      if (paramImageKey.imglistener != null) {
        paramImageKey.imglistener.onDownloadProgress(getCallbackUrl(paramImageKey), paramLong, paramFloat);
      }
      if (paramImageKey.listener != null)
      {
        if (paramImageKey.options != null) {
          paramImageKey.options.totalSize = paramLong;
        }
        boolean bool;
        if (paramImageKey.options == null) {
          bool = false;
        } else {
          bool = paramImageKey.options.useMainThread;
        }
        if (bool)
        {
          mMainHandler.post(new UICallbackTask.4(this, paramImageKey, paramFloat));
          return;
        }
        paramImageKey.listener.onImageProgress(getCallbackUrl(paramImageKey), paramFloat, paramImageKey.options);
      }
    }
  }
  
  public void excuteTask()
  {
    if (this.mNextTask != null) {
      this.mNextTask.excuteTask();
    }
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs)
  {
    Object localObject;
    long l;
    float f;
    switch (paramInt)
    {
    case 8: 
    case 9: 
    case 10: 
    case 14: 
    default: 
      break;
    case 15: 
      localObject = (Drawable)paramVarArgs[0];
      onImageLoaded(this.mImageKey, (Drawable)localObject);
      break;
    case 13: 
      onImageCanceled(this.mImageKey);
      break;
    case 7: 
      localObject = (String)paramVarArgs[0];
      l = ((Long)paramVarArgs[1]).longValue();
      f = ((Float)paramVarArgs[2]).floatValue();
      onImageProgress(this.mImageKey, l, f);
      break;
    case 6: 
      localObject = (Drawable)paramVarArgs[0];
      onImageLoaded(this.mImageKey, (Drawable)localObject);
      break;
    case 5: 
      onImageCanceled(this.mImageKey);
      break;
    case 4: 
      onImageFailed(this.mImageKey);
      break;
    case 3: 
      localObject = (String)paramVarArgs[0];
      l = ((Long)paramVarArgs[1]).longValue();
      f = ((Float)paramVarArgs[2]).floatValue();
      onImageProgress(this.mImageKey, l, f);
      break;
    case 2: 
    case 11: 
    case 12: 
      onImageLoaded(this.mImageKey, null);
      break;
    case 1: 
      onImageFailed(this.mImageKey);
      break;
    case 0: 
      onImageCanceled(this.mImageKey);
    }
    if ((paramInt != 3) && (paramInt != 7) && (paramInt != 14) && (paramInt != 15)) {
      setResult(paramInt, paramVarArgs);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.UICallbackTask
 * JD-Core Version:    0.7.0.1
 */
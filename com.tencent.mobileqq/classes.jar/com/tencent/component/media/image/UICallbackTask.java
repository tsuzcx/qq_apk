package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.tencent.component.media.utils.BaseHandler;
import pfn;
import pfv;
import pfw;
import pfx;
import pfy;

public class UICallbackTask
  extends pfn
{
  private static int jdField_a_of_type_Int;
  private static UICallbackTask jdField_a_of_type_ComTencentComponentMediaImageUICallbackTask;
  private static BaseHandler jdField_a_of_type_ComTencentComponentMediaUtilsBaseHandler = new BaseHandler(Looper.getMainLooper());
  private static final Object jdField_a_of_type_JavaLangObject;
  private UICallbackTask b = null;
  
  static
  {
    jdField_a_of_type_ComTencentComponentMediaImageUICallbackTask = null;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Int = 0;
    clearAndInitSize();
  }
  
  private UICallbackTask(pfn parampfn)
  {
    super(parampfn);
  }
  
  private String a(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {
      return null;
    }
    if (paramImageKey.srUrl != null) {
      return paramImageKey.srUrl;
    }
    return paramImageKey.url;
  }
  
  private void a(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {}
    do
    {
      return;
      if (paramImageKey.imglistener != null) {
        paramImageKey.imglistener.onDownloadFailed(a(paramImageKey));
      }
    } while (paramImageKey.listener == null);
    if (paramImageKey.options == null) {}
    for (boolean bool = false; bool; bool = paramImageKey.options.useMainThread)
    {
      jdField_a_of_type_ComTencentComponentMediaUtilsBaseHandler.post(new pfv(this, paramImageKey));
      return;
    }
    paramImageKey.listener.onImageFailed(a(paramImageKey), paramImageKey.options);
  }
  
  private void a(ImageKey paramImageKey, long paramLong, float paramFloat)
  {
    if (paramImageKey == null) {}
    do
    {
      do
      {
        return;
      } while (!paramImageKey.needCallBackProcessPercent);
      if (paramImageKey.imglistener != null) {
        paramImageKey.imglistener.onDownloadProgress(a(paramImageKey), paramLong, paramFloat);
      }
    } while (paramImageKey.listener == null);
    if (paramImageKey.options != null) {
      paramImageKey.options.totalSize = paramLong;
    }
    if (paramImageKey.options == null) {}
    for (boolean bool = false; bool; bool = paramImageKey.options.useMainThread)
    {
      jdField_a_of_type_ComTencentComponentMediaUtilsBaseHandler.post(new pfy(this, paramImageKey, paramFloat));
      return;
    }
    paramImageKey.listener.onImageProgress(a(paramImageKey), paramFloat, paramImageKey.options);
  }
  
  private void a(ImageKey paramImageKey, Drawable paramDrawable)
  {
    if (paramImageKey == null) {}
    do
    {
      return;
      if (paramImageKey.imglistener != null) {
        paramImageKey.imglistener.onDownloadSucceed(a(paramImageKey));
      }
    } while (paramImageKey.listener == null);
    if (paramImageKey.options == null) {}
    for (boolean bool = false; bool; bool = paramImageKey.options.useMainThread)
    {
      jdField_a_of_type_ComTencentComponentMediaUtilsBaseHandler.post(new pfx(this, paramImageKey, paramDrawable));
      return;
    }
    paramImageKey.listener.onImageLoaded(a(paramImageKey), paramDrawable, paramImageKey.options);
    ProgressTracer.printI(new Object[] { Long.valueOf(System.currentTimeMillis()), " : ", Integer.valueOf(6), " : ", a(paramImageKey), " : ", Integer.valueOf(paramImageKey.listener.hashCode()) });
  }
  
  private void b(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {}
    do
    {
      return;
      ProgressTracer.print(1003, a(paramImageKey));
      if (paramImageKey.imglistener != null) {
        paramImageKey.imglistener.onDownloadCanceled(a(paramImageKey));
      }
    } while (paramImageKey.listener == null);
    if (paramImageKey.options == null) {}
    for (boolean bool = false; bool; bool = paramImageKey.options.useMainThread)
    {
      jdField_a_of_type_ComTencentComponentMediaUtilsBaseHandler.post(new pfw(this, paramImageKey));
      return;
    }
    paramImageKey.listener.onImageCanceled(a(paramImageKey), paramImageKey.options);
  }
  
  public static void clearAndInitSize()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_ComTencentComponentMediaImageUICallbackTask = null;
      int i = 0;
      while (i < mInitAllocatedSize)
      {
        UICallbackTask localUICallbackTask = new UICallbackTask(null);
        localUICallbackTask.b = jdField_a_of_type_ComTencentComponentMediaImageUICallbackTask;
        jdField_a_of_type_ComTencentComponentMediaImageUICallbackTask = localUICallbackTask;
        jdField_a_of_type_Int += 1;
        i += 1;
      }
      return;
    }
  }
  
  public static UICallbackTask obtain(pfn parampfn)
  {
    if (needRecycle) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageUICallbackTask != null)
      {
        UICallbackTask localUICallbackTask = jdField_a_of_type_ComTencentComponentMediaImageUICallbackTask;
        jdField_a_of_type_ComTencentComponentMediaImageUICallbackTask = jdField_a_of_type_ComTencentComponentMediaImageUICallbackTask.b;
        localUICallbackTask.b = null;
        jdField_a_of_type_Int -= 1;
        localUICallbackTask.setImageTask(parampfn);
        return localUICallbackTask;
      }
      return new UICallbackTask(parampfn);
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
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((paramInt != 3) && (paramInt != 7) && (paramInt != 14) && (paramInt != 15)) {
        setResult(paramInt, paramVarArgs);
      }
      return;
      a(this.mImageKey);
      continue;
      b(this.mImageKey);
      continue;
      Object localObject = (Drawable)paramVarArgs[0];
      a(this.mImageKey, (Drawable)localObject);
      continue;
      localObject = (String)paramVarArgs[0];
      long l = ((Long)paramVarArgs[1]).longValue();
      float f = ((Float)paramVarArgs[2]).floatValue();
      a(this.mImageKey, l, f);
      continue;
      b(this.mImageKey);
      continue;
      b(this.mImageKey);
      continue;
      a(this.mImageKey);
      continue;
      a(this.mImageKey, null);
      continue;
      localObject = (String)paramVarArgs[0];
      l = ((Long)paramVarArgs[1]).longValue();
      f = ((Float)paramVarArgs[2]).floatValue();
      a(this.mImageKey, l, f);
      continue;
      localObject = (Drawable)paramVarArgs[0];
      a(this.mImageKey, (Drawable)localObject);
    }
  }
  
  public void recycle()
  {
    if (!needRecycle) {
      return;
    }
    reset();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 50)
      {
        this.b = jdField_a_of_type_ComTencentComponentMediaImageUICallbackTask;
        jdField_a_of_type_ComTencentComponentMediaImageUICallbackTask = this;
        jdField_a_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.UICallbackTask
 * JD-Core Version:    0.7.0.1
 */
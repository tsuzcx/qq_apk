package com.tencent.component.media.image;

import com.tencent.component.media.utils.ImageManagerLog;
import phh;

public class CancelStreamDecodeGifTask
  extends StreamDecodeGifTask
{
  private static int jdField_a_of_type_Int;
  private static CancelStreamDecodeGifTask jdField_a_of_type_ComTencentComponentMediaImageCancelStreamDecodeGifTask = null;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private CancelStreamDecodeGifTask b = null;
  
  static
  {
    jdField_a_of_type_Int = 0;
    clearAndInitSize();
  }
  
  private CancelStreamDecodeGifTask(ImageKey paramImageKey)
  {
    super(paramImageKey);
  }
  
  private CancelStreamDecodeGifTask(phh paramphh)
  {
    super(paramphh);
  }
  
  public static void clearAndInitSize()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_ComTencentComponentMediaImageCancelStreamDecodeGifTask = null;
      int i = 0;
      while (i < mInitAllocatedSize)
      {
        CancelStreamDecodeGifTask localCancelStreamDecodeGifTask = new CancelStreamDecodeGifTask(null);
        localCancelStreamDecodeGifTask.b = jdField_a_of_type_ComTencentComponentMediaImageCancelStreamDecodeGifTask;
        jdField_a_of_type_ComTencentComponentMediaImageCancelStreamDecodeGifTask = localCancelStreamDecodeGifTask;
        jdField_a_of_type_Int += 1;
        i += 1;
      }
      return;
    }
  }
  
  public static CancelStreamDecodeGifTask obtain(ImageKey paramImageKey)
  {
    if (needRecycle) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageCancelStreamDecodeGifTask != null)
      {
        CancelStreamDecodeGifTask localCancelStreamDecodeGifTask = jdField_a_of_type_ComTencentComponentMediaImageCancelStreamDecodeGifTask;
        jdField_a_of_type_ComTencentComponentMediaImageCancelStreamDecodeGifTask = jdField_a_of_type_ComTencentComponentMediaImageCancelStreamDecodeGifTask.b;
        localCancelStreamDecodeGifTask.b = null;
        jdField_a_of_type_Int -= 1;
        localCancelStreamDecodeGifTask.setImageKey(paramImageKey);
        return localCancelStreamDecodeGifTask;
      }
      return new CancelStreamDecodeGifTask(paramImageKey);
    }
  }
  
  public static CancelStreamDecodeGifTask obtain(phh paramphh)
  {
    if (needRecycle) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageCancelStreamDecodeGifTask != null)
      {
        CancelStreamDecodeGifTask localCancelStreamDecodeGifTask = jdField_a_of_type_ComTencentComponentMediaImageCancelStreamDecodeGifTask;
        jdField_a_of_type_ComTencentComponentMediaImageCancelStreamDecodeGifTask = jdField_a_of_type_ComTencentComponentMediaImageCancelStreamDecodeGifTask.b;
        localCancelStreamDecodeGifTask.b = null;
        jdField_a_of_type_Int -= 1;
        localCancelStreamDecodeGifTask.setImageTask(paramphh);
        return localCancelStreamDecodeGifTask;
      }
      return new CancelStreamDecodeGifTask(paramphh);
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
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 50)
      {
        this.b = jdField_a_of_type_ComTencentComponentMediaImageCancelStreamDecodeGifTask;
        jdField_a_of_type_ComTencentComponentMediaImageCancelStreamDecodeGifTask = this;
        jdField_a_of_type_Int += 1;
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
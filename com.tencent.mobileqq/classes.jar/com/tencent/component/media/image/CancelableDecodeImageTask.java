package com.tencent.component.media.image;

import plz;

public class CancelableDecodeImageTask
  extends DecodeImageTask
{
  private static int jdField_a_of_type_Int;
  private static CancelableDecodeImageTask jdField_a_of_type_ComTencentComponentMediaImageCancelableDecodeImageTask = null;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private CancelableDecodeImageTask b = null;
  
  static
  {
    jdField_a_of_type_Int = 0;
    clearAndInitSize();
  }
  
  private CancelableDecodeImageTask(ImageKey paramImageKey)
  {
    super(paramImageKey);
  }
  
  private CancelableDecodeImageTask(plz paramplz)
  {
    super(paramplz);
  }
  
  public static void clearAndInitSize()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_ComTencentComponentMediaImageCancelableDecodeImageTask = null;
      int i = 0;
      while (i < mInitAllocatedSize)
      {
        CancelableDecodeImageTask localCancelableDecodeImageTask = new CancelableDecodeImageTask(null);
        localCancelableDecodeImageTask.b = jdField_a_of_type_ComTencentComponentMediaImageCancelableDecodeImageTask;
        jdField_a_of_type_ComTencentComponentMediaImageCancelableDecodeImageTask = localCancelableDecodeImageTask;
        jdField_a_of_type_Int += 1;
        i += 1;
      }
      return;
    }
  }
  
  public static CancelableDecodeImageTask obtain(ImageKey paramImageKey)
  {
    if (needRecycle) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageCancelableDecodeImageTask != null)
      {
        CancelableDecodeImageTask localCancelableDecodeImageTask = jdField_a_of_type_ComTencentComponentMediaImageCancelableDecodeImageTask;
        jdField_a_of_type_ComTencentComponentMediaImageCancelableDecodeImageTask = jdField_a_of_type_ComTencentComponentMediaImageCancelableDecodeImageTask.b;
        localCancelableDecodeImageTask.b = null;
        jdField_a_of_type_Int -= 1;
        localCancelableDecodeImageTask.setImageKey(paramImageKey);
        return localCancelableDecodeImageTask;
      }
      return new CancelableDecodeImageTask(paramImageKey);
    }
  }
  
  public static CancelableDecodeImageTask obtain(plz paramplz)
  {
    if (needRecycle) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageCancelableDecodeImageTask != null)
      {
        CancelableDecodeImageTask localCancelableDecodeImageTask = jdField_a_of_type_ComTencentComponentMediaImageCancelableDecodeImageTask;
        jdField_a_of_type_ComTencentComponentMediaImageCancelableDecodeImageTask = jdField_a_of_type_ComTencentComponentMediaImageCancelableDecodeImageTask.b;
        localCancelableDecodeImageTask.b = null;
        jdField_a_of_type_Int -= 1;
        localCancelableDecodeImageTask.setImageTask(paramplz);
        return localCancelableDecodeImageTask;
      }
      return new CancelableDecodeImageTask(paramplz);
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
    super.onResult(paramInt, paramVarArgs);
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
        this.b = jdField_a_of_type_ComTencentComponentMediaImageCancelableDecodeImageTask;
        jdField_a_of_type_ComTencentComponentMediaImageCancelableDecodeImageTask = this;
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
 * Qualified Name:     com.tencent.component.media.image.CancelableDecodeImageTask
 * JD-Core Version:    0.7.0.1
 */
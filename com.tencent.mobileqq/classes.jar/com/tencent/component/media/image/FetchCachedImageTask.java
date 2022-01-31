package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;
import pfn;

public class FetchCachedImageTask
  extends pfn
{
  private static int jdField_a_of_type_Int;
  private static FetchCachedImageTask jdField_a_of_type_ComTencentComponentMediaImageFetchCachedImageTask = null;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private FetchCachedImageTask b = null;
  
  static
  {
    jdField_a_of_type_Int = 0;
    clearAndInitSize();
  }
  
  private FetchCachedImageTask(pfn parampfn)
  {
    super(parampfn);
  }
  
  public static void clearAndInitSize()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_ComTencentComponentMediaImageFetchCachedImageTask = null;
      int i = 0;
      while (i < mInitAllocatedSize)
      {
        FetchCachedImageTask localFetchCachedImageTask = new FetchCachedImageTask(null);
        localFetchCachedImageTask.b = jdField_a_of_type_ComTencentComponentMediaImageFetchCachedImageTask;
        jdField_a_of_type_ComTencentComponentMediaImageFetchCachedImageTask = localFetchCachedImageTask;
        jdField_a_of_type_Int += 1;
        i += 1;
      }
      return;
    }
  }
  
  public static FetchCachedImageTask obtain(pfn parampfn)
  {
    if (needRecycle) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageFetchCachedImageTask != null)
      {
        FetchCachedImageTask localFetchCachedImageTask = jdField_a_of_type_ComTencentComponentMediaImageFetchCachedImageTask;
        jdField_a_of_type_ComTencentComponentMediaImageFetchCachedImageTask = jdField_a_of_type_ComTencentComponentMediaImageFetchCachedImageTask.b;
        localFetchCachedImageTask.b = null;
        jdField_a_of_type_Int -= 1;
        localFetchCachedImageTask.setImageTask(parampfn);
        return localFetchCachedImageTask;
      }
      return new FetchCachedImageTask(parampfn);
    }
  }
  
  public void excuteTask()
  {
    Drawable localDrawable = ImageManager.getInstance().a(this.mImageKey);
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
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 10: 
    default: 
      setResult(paramInt, paramVarArgs);
      return;
    case 8: 
      setResult(6, new Object[] { (Drawable)paramVarArgs[0], (BitmapReference)paramVarArgs[1] });
      return;
    case 9: 
      setResult(4, new Object[0]);
      return;
    case 11: 
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
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 50)
      {
        this.b = jdField_a_of_type_ComTencentComponentMediaImageFetchCachedImageTask;
        jdField_a_of_type_ComTencentComponentMediaImageFetchCachedImageTask = this;
        jdField_a_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.FetchCachedImageTask
 * JD-Core Version:    0.7.0.1
 */
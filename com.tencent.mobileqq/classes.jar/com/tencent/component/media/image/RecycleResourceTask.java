package com.tencent.component.media.image;

import android.util.Log;
import plz;
import pma;

public class RecycleResourceTask
  extends plz
{
  private static double jdField_a_of_type_Double;
  private static int jdField_a_of_type_Int;
  private static RecycleResourceTask jdField_a_of_type_ComTencentComponentMediaImageRecycleResourceTask;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static long jdField_b_of_type_Long = 0L;
  private long jdField_a_of_type_Long = 0L;
  private RecycleResourceTask jdField_b_of_type_ComTencentComponentMediaImageRecycleResourceTask = null;
  
  static
  {
    jdField_a_of_type_Double = 0.0D;
    jdField_a_of_type_ComTencentComponentMediaImageRecycleResourceTask = null;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Int = 0;
    clearAndInitSize();
  }
  
  private RecycleResourceTask(plz paramplz)
  {
    super(paramplz);
  }
  
  public static void clearAndInitSize()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_ComTencentComponentMediaImageRecycleResourceTask = null;
      int i = 0;
      while (i < mInitAllocatedSize)
      {
        RecycleResourceTask localRecycleResourceTask = new RecycleResourceTask(null);
        localRecycleResourceTask.jdField_b_of_type_ComTencentComponentMediaImageRecycleResourceTask = jdField_a_of_type_ComTencentComponentMediaImageRecycleResourceTask;
        jdField_a_of_type_ComTencentComponentMediaImageRecycleResourceTask = localRecycleResourceTask;
        jdField_a_of_type_Int += 1;
        i += 1;
      }
      return;
    }
  }
  
  public static RecycleResourceTask obtain(plz paramplz)
  {
    if (needRecycle) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageRecycleResourceTask != null)
      {
        RecycleResourceTask localRecycleResourceTask = jdField_a_of_type_ComTencentComponentMediaImageRecycleResourceTask;
        jdField_a_of_type_ComTencentComponentMediaImageRecycleResourceTask = jdField_a_of_type_ComTencentComponentMediaImageRecycleResourceTask.jdField_b_of_type_ComTencentComponentMediaImageRecycleResourceTask;
        localRecycleResourceTask.jdField_b_of_type_ComTencentComponentMediaImageRecycleResourceTask = null;
        jdField_a_of_type_Int -= 1;
        localRecycleResourceTask.setImageTask(paramplz);
        return localRecycleResourceTask;
      }
      return new RecycleResourceTask(paramplz);
    }
  }
  
  public void excuteTask()
  {
    if (this.mNextTask != null)
    {
      ImageTaskTracer.addImageTaskLifeCycleRecord(this.mImageKey.hashCodeEx());
      pma.a(this);
      this.mNextTask.excuteTask();
    }
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs)
  {
    ImageTaskTracer.removeImageTaskLifeCycleRecord(this.mImageKey.hashCodeEx());
    Log.d("RecycleResourceTask", "onResult type:" + paramInt + " hashcode:" + this.mImageKey.hashCodeEx() + " url:" + getImageKey().url);
    pma.a(getImageKey());
    plz localplz;
    for (paramVarArgs = this.mNextTask; paramVarArgs != null; paramVarArgs = localplz)
    {
      localplz = paramVarArgs.getNextTask();
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
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 50)
      {
        this.jdField_b_of_type_ComTencentComponentMediaImageRecycleResourceTask = jdField_a_of_type_ComTencentComponentMediaImageRecycleResourceTask;
        jdField_a_of_type_ComTencentComponentMediaImageRecycleResourceTask = this;
        jdField_a_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.RecycleResourceTask
 * JD-Core Version:    0.7.0.1
 */
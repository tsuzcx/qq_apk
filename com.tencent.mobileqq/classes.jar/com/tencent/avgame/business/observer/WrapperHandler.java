package com.tencent.avgame.business.observer;

import android.os.Handler;
import android.os.Looper;
import mqq.os.MqqHandler;

public class WrapperHandler
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public WrapperHandler(Looper paramLooper)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(paramLooper);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramLooper);
  }
  
  public WrapperHandler(MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramMqqHandler.getLooper());
  }
  
  public final boolean a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_AndroidOsHandler.postAtFrontOfQueue(paramRunnable);
    }
    return this.jdField_a_of_type_MqqOsMqqHandler.postAtFrontOfQueue(paramRunnable);
  }
  
  public final boolean b(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
    }
    return this.jdField_a_of_type_MqqOsMqqHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.observer.WrapperHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import java.lang.ref.WeakReference;
import sfe;
import sfg;

class RunningJob$4
  implements Runnable
{
  RunningJob$4(RunningJob paramRunningJob, WeakReference paramWeakReference, Throwable paramThrowable) {}
  
  public void run()
  {
    if (this.this$0.a.a) {}
    while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ((sfe)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.this$0.a, this.jdField_a_of_type_JavaLangThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob.4
 * JD-Core Version:    0.7.0.1
 */
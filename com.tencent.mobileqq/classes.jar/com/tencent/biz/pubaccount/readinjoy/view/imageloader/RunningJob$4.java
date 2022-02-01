package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptReport;
import java.lang.ref.WeakReference;

class RunningJob$4
  implements Runnable
{
  RunningJob$4(RunningJob paramRunningJob, WeakReference paramWeakReference, Throwable paramThrowable) {}
  
  public void run()
  {
    if (this.this$0.a.a)
    {
      RIJImageOptReport.a(6, this.this$0.a);
      RIJImageOptReport.a(this.this$0.a, false, "cancelled");
    }
    while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ((IBitmapCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.this$0.a, this.jdField_a_of_type_JavaLangThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob.4
 * JD-Core Version:    0.7.0.1
 */
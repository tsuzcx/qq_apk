package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import rpd;
import rpf;
import rph;

class RunningJob$2
  implements Runnable
{
  RunningJob$2(RunningJob paramRunningJob, rpd paramrpd) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Rph.a)
    {
      this.a.a();
      return;
    }
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((rpf)localWeakReference.get()).a(this.this$0.jdField_a_of_type_Rph, this.a.a());
      }
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob.2
 * JD-Core Version:    0.7.0.1
 */
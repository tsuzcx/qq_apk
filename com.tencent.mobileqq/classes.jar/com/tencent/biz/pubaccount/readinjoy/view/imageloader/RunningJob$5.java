package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import tdu;
import tdv;

class RunningJob$5
  implements Runnable
{
  RunningJob$5(RunningJob paramRunningJob) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference.get() != null) && (this.this$0.jdField_a_of_type_Tdv != null)) {
        this.this$0.jdField_a_of_type_Tdv.a(this.this$0.jdField_a_of_type_Tdw, (tdu)localWeakReference.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob.5
 * JD-Core Version:    0.7.0.1
 */
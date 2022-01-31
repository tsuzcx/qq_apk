package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import rpg;
import rpi;
import rpk;

class RunningJob$2
  implements Runnable
{
  RunningJob$2(RunningJob paramRunningJob, rpg paramrpg) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Rpk.a)
    {
      this.a.a();
      return;
    }
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((rpi)localWeakReference.get()).a(this.this$0.jdField_a_of_type_Rpk, this.a.a());
      }
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob.2
 * JD-Core Version:    0.7.0.1
 */
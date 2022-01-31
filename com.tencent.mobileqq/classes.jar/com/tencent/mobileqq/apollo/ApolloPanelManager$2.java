package com.tencent.mobileqq.apollo;

import aisr;
import ajer;
import ajfg;
import ajfj;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$2
  implements Runnable
{
  public ApolloPanelManager$2(aisr paramaisr) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    int i = this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (this.this$0.jdField_a_of_type_Ajpz != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((aisr)localObject).a(i, bool, aisr.a(this.this$0));
      if ((this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) && (!aisr.a(this.this$0)) && (this.this$0.a() != null) && (this.this$0.jdField_a_of_type_Ajpz != null))
      {
        localObject = ajfj.a(this.this$0.a()).a();
        if (localObject != null) {
          ((ajer)localObject).a(this.this$0.b);
        }
      }
      if (((aisr.a(this.this$0)) || (this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0)) && (this.this$0.jdField_a_of_type_Ajpz != null)) {
        aisr.a(this.this$0, this.this$0.jdField_a_of_type_Ajpz);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.2
 * JD-Core Version:    0.7.0.1
 */
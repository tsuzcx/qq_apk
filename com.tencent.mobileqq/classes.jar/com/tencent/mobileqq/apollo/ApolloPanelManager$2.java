package com.tencent.mobileqq.apollo;

import amtq;
import anfq;
import angf;
import angi;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$2
  implements Runnable
{
  public ApolloPanelManager$2(amtq paramamtq) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    int i = this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (this.this$0.jdField_a_of_type_Anra != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((amtq)localObject).a(i, bool, amtq.a(this.this$0));
      if ((this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) && (!amtq.a(this.this$0)) && (this.this$0.a() != null) && (this.this$0.jdField_a_of_type_Anra != null))
      {
        localObject = angi.a(this.this$0.a()).a();
        if (localObject != null) {
          ((anfq)localObject).a(this.this$0.b);
        }
      }
      if (((amtq.a(this.this$0)) || (this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0)) && (this.this$0.jdField_a_of_type_Anra != null)) {
        amtq.a(this.this$0, this.this$0.jdField_a_of_type_Anra);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.2
 * JD-Core Version:    0.7.0.1
 */
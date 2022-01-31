package com.tencent.mobileqq.apollo;

import aify;
import airt;
import aisi;
import aisl;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$2
  implements Runnable
{
  public ApolloPanelManager$2(aify paramaify) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    int i = this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (this.this$0.jdField_a_of_type_Ajbx != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((aify)localObject).a(i, bool, aify.a(this.this$0));
      if ((this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) && (!aify.a(this.this$0)) && (this.this$0.a() != null) && (this.this$0.jdField_a_of_type_Ajbx != null))
      {
        localObject = aisl.a(this.this$0.a()).a();
        if (localObject != null) {
          ((airt)localObject).a(this.this$0.b);
        }
      }
      if (((aify.a(this.this$0)) || (this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0)) && (this.this$0.jdField_a_of_type_Ajbx != null)) {
        aify.a(this.this$0, this.this$0.jdField_a_of_type_Ajbx);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.2
 * JD-Core Version:    0.7.0.1
 */
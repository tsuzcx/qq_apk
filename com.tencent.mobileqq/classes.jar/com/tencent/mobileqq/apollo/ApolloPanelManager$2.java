package com.tencent.mobileqq.apollo;

import akoq;
import alaq;
import albf;
import albi;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$2
  implements Runnable
{
  public ApolloPanelManager$2(akoq paramakoq) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    int i = this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (this.this$0.jdField_a_of_type_Allz != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((akoq)localObject).a(i, bool, akoq.a(this.this$0));
      if ((this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) && (!akoq.a(this.this$0)) && (this.this$0.a() != null) && (this.this$0.jdField_a_of_type_Allz != null))
      {
        localObject = albi.a(this.this$0.a()).a();
        if (localObject != null) {
          ((alaq)localObject).a(this.this$0.b);
        }
      }
      if (((akoq.a(this.this$0)) || (this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0)) && (this.this$0.jdField_a_of_type_Allz != null)) {
        akoq.a(this.this$0, this.this$0.jdField_a_of_type_Allz);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.2
 * JD-Core Version:    0.7.0.1
 */
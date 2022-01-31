package com.tencent.mobileqq.apollo;

import akkb;
import akwb;
import akwq;
import akwt;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$2
  implements Runnable
{
  public ApolloPanelManager$2(akkb paramakkb) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    int i = this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (this.this$0.jdField_a_of_type_Alhk != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((akkb)localObject).a(i, bool, akkb.a(this.this$0));
      if ((this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) && (!akkb.a(this.this$0)) && (this.this$0.a() != null) && (this.this$0.jdField_a_of_type_Alhk != null))
      {
        localObject = akwt.a(this.this$0.a()).a();
        if (localObject != null) {
          ((akwb)localObject).a(this.this$0.b);
        }
      }
      if (((akkb.a(this.this$0)) || (this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0)) && (this.this$0.jdField_a_of_type_Alhk != null)) {
        akkb.a(this.this$0, this.this$0.jdField_a_of_type_Alhk);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo;

import amhw;
import amtw;
import amul;
import amuo;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$2
  implements Runnable
{
  public ApolloPanelManager$2(amhw paramamhw) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    int i = this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (this.this$0.jdField_a_of_type_Anff != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((amhw)localObject).a(i, bool, amhw.a(this.this$0));
      if ((this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) && (!amhw.a(this.this$0)) && (this.this$0.a() != null) && (this.this$0.jdField_a_of_type_Anff != null))
      {
        localObject = amuo.a(this.this$0.a()).a();
        if (localObject != null) {
          ((amtw)localObject).a(this.this$0.b);
        }
      }
      if (((amhw.a(this.this$0)) || (this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0)) && (this.this$0.jdField_a_of_type_Anff != null)) {
        amhw.a(this.this$0, this.this$0.jdField_a_of_type_Anff);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.2
 * JD-Core Version:    0.7.0.1
 */
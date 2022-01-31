package com.tencent.mobileqq.apollo;

import aisp;
import ajep;
import ajfe;
import ajfh;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$2
  implements Runnable
{
  public ApolloPanelManager$2(aisp paramaisp) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    int i = this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (this.this$0.jdField_a_of_type_Ajpx != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((aisp)localObject).a(i, bool, aisp.a(this.this$0));
      if ((this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) && (!aisp.a(this.this$0)) && (this.this$0.a() != null) && (this.this$0.jdField_a_of_type_Ajpx != null))
      {
        localObject = ajfh.a(this.this$0.a()).a();
        if (localObject != null) {
          ((ajep)localObject).a(this.this$0.b);
        }
      }
      if (((aisp.a(this.this$0)) || (this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0)) && (this.this$0.jdField_a_of_type_Ajpx != null)) {
        aisp.a(this.this$0, this.this$0.jdField_a_of_type_Ajpx);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.2
 * JD-Core Version:    0.7.0.1
 */
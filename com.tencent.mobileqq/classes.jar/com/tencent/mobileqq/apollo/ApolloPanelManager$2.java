package com.tencent.mobileqq.apollo;

import amna;
import anbs;
import anch;
import anck;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$2
  implements Runnable
{
  public ApolloPanelManager$2(amna paramamna) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    int i = this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (this.this$0.jdField_a_of_type_Annl != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((amna)localObject).a(i, bool, amna.a(this.this$0));
      if ((this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) && (!amna.a(this.this$0)) && (this.this$0.a() != null) && (this.this$0.jdField_a_of_type_Annl != null))
      {
        localObject = anck.a(this.this$0.a()).a();
        if (localObject != null) {
          ((anbs)localObject).a(this.this$0.b);
        }
      }
      if (((amna.a(this.this$0)) || (this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0)) && (this.this$0.jdField_a_of_type_Annl != null)) {
        amna.a(this.this$0, this.this$0.jdField_a_of_type_Annl);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.2
 * JD-Core Version:    0.7.0.1
 */
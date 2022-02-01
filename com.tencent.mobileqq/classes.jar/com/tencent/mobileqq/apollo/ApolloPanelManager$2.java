package com.tencent.mobileqq.apollo;

import alok;
import amak;
import amaz;
import ambc;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$2
  implements Runnable
{
  public ApolloPanelManager$2(alok paramalok) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    int i = this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (this.this$0.jdField_a_of_type_Amlu != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((alok)localObject).a(i, bool, alok.a(this.this$0));
      if ((this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) && (!alok.a(this.this$0)) && (this.this$0.a() != null) && (this.this$0.jdField_a_of_type_Amlu != null))
      {
        localObject = ambc.a(this.this$0.a()).a();
        if (localObject != null) {
          ((amak)localObject).a(this.this$0.b);
        }
      }
      if (((alok.a(this.this$0)) || (this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0)) && (this.this$0.jdField_a_of_type_Amlu != null)) {
        alok.a(this.this$0, this.this$0.jdField_a_of_type_Amlu);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.2
 * JD-Core Version:    0.7.0.1
 */
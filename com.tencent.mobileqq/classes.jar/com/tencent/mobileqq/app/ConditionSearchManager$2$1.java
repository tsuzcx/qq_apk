package com.tencent.mobileqq.app;

import ampm;
import ampq;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class ConditionSearchManager$2$1
  implements Runnable
{
  ConditionSearchManager$2$1(ConditionSearchManager.2 param2) {}
  
  public void run()
  {
    ampm.a(this.a.this$0, false);
    if (this.a.this$0.c) {
      for (;;)
      {
        try
        {
          if (this.a.this$0.jdField_a_of_type_JavaUtilLinkedList == null) {
            continue;
          }
          Object localObject = new LinkedList();
          ((LinkedList)localObject).addAll(this.a.this$0.jdField_a_of_type_JavaUtilLinkedList);
          localObject = ((LinkedList)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            continue;
          }
          localampq = (ampq)((Iterator)localObject).next();
          if (ampm.a(this.a.this$0) == null) {
            continue;
          }
          bool = true;
        }
        catch (Exception localException)
        {
          ampq localampq;
          QLog.e("ConditionSearch.Manager", 1, "updateLocal callback fail.", localException);
          if ((!this.a.this$0.d) || (ampm.a(this.a.this$0) == null)) {
            continue;
          }
          this.a.this$0.a(this.a.this$0.jdField_a_of_type_ComTencentMobileqqDataCard);
          return;
          boolean bool = false;
          continue;
          this.a.this$0.d = false;
          this.a.this$0.jdField_a_of_type_ComTencentMobileqqDataCard = null;
          this.a.this$0.b(this.a.this$0.jdField_a_of_type_JavaLangObject);
          return;
        }
        localampq.a(2, bool);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "updateLocal | SearchActivity is not running");
    }
    ampm.a(this.a.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.2.1
 * JD-Core Version:    0.7.0.1
 */
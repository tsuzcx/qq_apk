package com.tencent.mobileqq.app;

import alpy;
import alqc;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class ConditionSearchManager$2$1
  implements Runnable
{
  ConditionSearchManager$2$1(ConditionSearchManager.2 param2) {}
  
  public void run()
  {
    alpy.a(this.a.this$0, false);
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
          localalqc = (alqc)((Iterator)localObject).next();
          if (alpy.a(this.a.this$0) == null) {
            continue;
          }
          bool = true;
        }
        catch (Exception localException)
        {
          alqc localalqc;
          QLog.e("ConditionSearch.Manager", 1, "updateLocal callback fail.", localException);
          if ((!this.a.this$0.d) || (alpy.a(this.a.this$0) == null)) {
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
        localalqc.a(2, bool);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "updateLocal | SearchActivity is not running");
    }
    alpy.a(this.a.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.2.1
 * JD-Core Version:    0.7.0.1
 */
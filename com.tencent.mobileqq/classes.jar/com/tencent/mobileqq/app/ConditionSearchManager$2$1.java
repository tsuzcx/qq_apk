package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class ConditionSearchManager$2$1
  implements Runnable
{
  ConditionSearchManager$2$1(ConditionSearchManager.2 param2) {}
  
  public void run()
  {
    ConditionSearchManager.a(this.a.this$0, false);
    if (this.a.this$0.c) {}
    for (;;)
    {
      try
      {
        if (this.a.this$0.jdField_a_of_type_JavaUtilLinkedList != null)
        {
          Object localObject = new LinkedList();
          ((LinkedList)localObject).addAll(this.a.this$0.jdField_a_of_type_JavaUtilLinkedList);
          localObject = ((LinkedList)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            ConditionSearchManager.IConfigListener localIConfigListener = (ConditionSearchManager.IConfigListener)((Iterator)localObject).next();
            if (ConditionSearchManager.a(this.a.this$0) == null) {
              break label241;
            }
            bool = true;
            localIConfigListener.a(2, bool);
            continue;
          }
        }
        if (!QLog.isColorLevel()) {
          break label228;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ConditionSearch.Manager", 1, "updateLocal callback fail.", localException);
        if ((this.a.this$0.d) && (ConditionSearchManager.a(this.a.this$0) != null))
        {
          this.a.this$0.a(this.a.this$0.jdField_a_of_type_ComTencentMobileqqDataCard);
          return;
        }
        this.a.this$0.d = false;
        this.a.this$0.jdField_a_of_type_ComTencentMobileqqDataCard = null;
        this.a.this$0.b(this.a.this$0.jdField_a_of_type_JavaLangObject);
        return;
      }
      QLog.d("ConditionSearch.Manager", 2, "updateLocal | SearchActivity is not running");
      label228:
      ConditionSearchManager.a(this.a.this$0, null);
      return;
      label241:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.2.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import anec;
import arps;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Leba$10$1
  implements Runnable
{
  Leba$10$1(Leba.10 param10, List paramList) {}
  
  public void run()
  {
    if (Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0) == null) {
      Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0, new ArrayList());
    }
    Iterator localIterator1 = Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0).iterator();
    while (localIterator1.hasNext())
    {
      anec localanec1 = (anec)localIterator1.next();
      if ((localanec1 != null) && (localanec1.b != null) && (localanec1.a != null))
      {
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          anec localanec2 = (anec)localIterator2.next();
          if ((localanec2 != null) && (localanec2.a != null) && (localanec2.a.strPkgName.equals(localanec1.a.strPkgName))) {
            localanec2.b = localanec1.b;
          }
        }
      }
    }
    Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0).clear();
    Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0).addAll(this.jdField_a_of_type_JavaUtilList);
    QLog.i("Q.lebatab.leba", 1, "refreshLebaConfig. lebaData size=" + Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0).size());
    if (Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0) != null)
    {
      Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0).a(true);
      Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0).b();
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. notifyData.");
      }
      Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.10.1
 * JD-Core Version:    0.7.0.1
 */
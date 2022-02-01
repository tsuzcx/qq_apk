package com.tencent.mobileqq.activity;

import akgm;
import arsh;
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
      arsh localarsh1 = (arsh)localIterator1.next();
      if ((localarsh1 != null) && (localarsh1.b != null) && (localarsh1.a != null))
      {
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          arsh localarsh2 = (arsh)localIterator2.next();
          if ((localarsh2 != null) && (localarsh2.a != null) && (localarsh2.a.strPkgName.equals(localarsh1.a.strPkgName))) {
            localarsh2.b = localarsh1.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.10.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import ajvd;
import arcs;
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
      arcs localarcs1 = (arcs)localIterator1.next();
      if ((localarcs1 != null) && (localarcs1.b != null) && (localarcs1.a != null))
      {
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          arcs localarcs2 = (arcs)localIterator2.next();
          if ((localarcs2 != null) && (localarcs2.a != null) && (localarcs2.a.strPkgName.equals(localarcs1.a.strPkgName))) {
            localarcs2.b = localarcs1.b;
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
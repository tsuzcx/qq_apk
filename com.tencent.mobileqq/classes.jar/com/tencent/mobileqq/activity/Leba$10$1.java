package com.tencent.mobileqq.activity;

import abai;
import aiba;
import amnq;
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
    if (abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0) == null) {
      abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0, new ArrayList());
    }
    Iterator localIterator1 = abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0).iterator();
    while (localIterator1.hasNext())
    {
      amnq localamnq1 = (amnq)localIterator1.next();
      if ((localamnq1 != null) && (localamnq1.b != null) && (localamnq1.a != null))
      {
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          amnq localamnq2 = (amnq)localIterator2.next();
          if ((localamnq2 != null) && (localamnq2.a != null) && (localamnq2.a.strPkgName.equals(localamnq1.a.strPkgName))) {
            localamnq2.b = localamnq1.b;
          }
        }
      }
    }
    abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0).clear();
    abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0).addAll(this.jdField_a_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. lebaData size=" + abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0).size());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0.a.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. notifyData.");
      }
      abai.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$10.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.10.1
 * JD-Core Version:    0.7.0.1
 */
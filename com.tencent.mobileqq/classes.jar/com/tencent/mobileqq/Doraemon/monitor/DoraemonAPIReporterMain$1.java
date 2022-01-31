package com.tencent.mobileqq.Doraemon.monitor;

import aady;
import aukp;
import aukq;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class DoraemonAPIReporterMain$1
  implements Runnable
{
  public DoraemonAPIReporterMain$1(aady paramaady, QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(APIQuotaEntity.class, false, "type=? and appid=?", new String[] { String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }, null, null, null, null);
    if ((localList != null) && (localList.size() > 0)) {
      aady.a(this.this$0, this.b, localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.1
 * JD-Core Version:    0.7.0.1
 */
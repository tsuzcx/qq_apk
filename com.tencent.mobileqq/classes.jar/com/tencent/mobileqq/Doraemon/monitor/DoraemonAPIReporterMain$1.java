package com.tencent.mobileqq.Doraemon.monitor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.List;

class DoraemonAPIReporterMain$1
  implements Runnable
{
  DoraemonAPIReporterMain$1(DoraemonAPIReporterMain paramDoraemonAPIReporterMain, QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().query(APIQuotaEntity.class, false, "type=? and appid=?", new String[] { String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }, null, null, null, null);
    if ((localList != null) && (localList.size() > 0)) {
      DoraemonAPIReporterMain.a(this.this$0, this.b, localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.1
 * JD-Core Version:    0.7.0.1
 */
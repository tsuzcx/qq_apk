package com.tencent.mobileqq.Doraemon.monitor;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class DoraemonAPIReporterMain$1
  implements Runnable
{
  DoraemonAPIReporterMain$1(DoraemonAPIReporterMain paramDoraemonAPIReporterMain, AppRuntime paramAppRuntime, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager();
    if (localObject == null)
    {
      QLog.d("DoraemonOpenAPI.report", 1, "EntityManager is null");
      return;
    }
    localObject = ((EntityManager)localObject).query(APIQuotaEntity.class, false, "type=? and appid=?", new String[] { String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      DoraemonAPIReporterMain.a(this.this$0, this.b, (List)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.1
 * JD-Core Version:    0.7.0.1
 */
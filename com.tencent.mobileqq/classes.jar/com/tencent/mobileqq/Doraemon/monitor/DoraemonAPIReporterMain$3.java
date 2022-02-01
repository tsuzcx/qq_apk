package com.tencent.mobileqq.Doraemon.monitor;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import mqq.app.AppRuntime;

class DoraemonAPIReporterMain$3
  implements Runnable
{
  DoraemonAPIReporterMain$3(DoraemonAPIReporterMain paramDoraemonAPIReporterMain, AppRuntime paramAppRuntime, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager();
    APIQuotaEntity localAPIQuotaEntity = new APIQuotaEntity();
    localAPIQuotaEntity.type = this.jdField_a_of_type_Int;
    localAPIQuotaEntity.appid = this.jdField_a_of_type_JavaLangString;
    localAPIQuotaEntity.apiName = this.jdField_b_of_type_JavaLangString;
    localAPIQuotaEntity.remainTimes = this.jdField_a_of_type_Long;
    localAPIQuotaEntity.expireTimeMillis = this.jdField_b_of_type_Long;
    localEntityManager.persistOrReplace(localAPIQuotaEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.3
 * JD-Core Version:    0.7.0.1
 */
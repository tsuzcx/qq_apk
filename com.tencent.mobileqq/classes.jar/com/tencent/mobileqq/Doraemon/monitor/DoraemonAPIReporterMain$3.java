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
    EntityManager localEntityManager = this.a.getEntityManagerFactory().createEntityManager();
    APIQuotaEntity localAPIQuotaEntity = new APIQuotaEntity();
    localAPIQuotaEntity.type = this.b;
    localAPIQuotaEntity.appid = this.c;
    localAPIQuotaEntity.apiName = this.d;
    localAPIQuotaEntity.remainTimes = this.e;
    localAPIQuotaEntity.expireTimeMillis = this.f;
    localEntityManager.persistOrReplace(localAPIQuotaEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.3
 * JD-Core Version:    0.7.0.1
 */
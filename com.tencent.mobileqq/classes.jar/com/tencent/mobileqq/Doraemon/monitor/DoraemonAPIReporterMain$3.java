package com.tencent.mobileqq.Doraemon.monitor;

import abzk;
import awgf;
import awgg;
import com.tencent.mobileqq.app.QQAppInterface;

public class DoraemonAPIReporterMain$3
  implements Runnable
{
  public DoraemonAPIReporterMain$3(abzk paramabzk, QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    APIQuotaEntity localAPIQuotaEntity = new APIQuotaEntity();
    localAPIQuotaEntity.type = this.jdField_a_of_type_Int;
    localAPIQuotaEntity.appid = this.jdField_a_of_type_JavaLangString;
    localAPIQuotaEntity.apiName = this.jdField_b_of_type_JavaLangString;
    localAPIQuotaEntity.remainTimes = this.jdField_a_of_type_Long;
    localAPIQuotaEntity.expireTimeMillis = this.jdField_b_of_type_Long;
    localawgf.b(localAPIQuotaEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.3
 * JD-Core Version:    0.7.0.1
 */
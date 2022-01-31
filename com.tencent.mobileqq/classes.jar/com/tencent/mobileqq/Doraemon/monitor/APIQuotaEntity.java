package com.tencent.mobileqq.Doraemon.monitor;

import aukm;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="type,appid,apiName")
public class APIQuotaEntity
  extends aukm
{
  public String apiName;
  public String appid;
  public long expireTimeMillis;
  public long remainTimes;
  public int type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.APIQuotaEntity
 * JD-Core Version:    0.7.0.1
 */
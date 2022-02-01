package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class QcircleRedDotEntity
  extends Entity
{
  public boolean isShowRedDot;
  public String jumpSchema;
  public long timeStamp;
  @unique
  public String uin;
  
  public QcircleRedDotEntity()
  {
    this.uin = "";
    this.isShowRedDot = false;
    this.timeStamp = 0L;
    this.jumpSchema = "";
  }
  
  public QcircleRedDotEntity(String paramString1, boolean paramBoolean, long paramLong, String paramString2)
  {
    this.uin = paramString1;
    this.isShowRedDot = paramBoolean;
    this.timeStamp = paramLong;
    this.jumpSchema = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    QcircleRedDotEntity localQcircleRedDotEntity = null;
    if ((paramObject instanceof QcircleRedDotEntity)) {
      localQcircleRedDotEntity = (QcircleRedDotEntity)paramObject;
    }
    return (paramObject == this) || ((this.uin != null) && (localQcircleRedDotEntity != null) && (this.uin.equals(localQcircleRedDotEntity.uin)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.QcircleRedDotEntity
 * JD-Core Version:    0.7.0.1
 */
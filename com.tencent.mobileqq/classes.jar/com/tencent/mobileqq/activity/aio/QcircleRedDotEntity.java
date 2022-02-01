package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class QcircleRedDotEntity
  extends Entity
{
  public boolean isShowRedDot;
  public long timeStamp;
  @unique
  public String uin;
  
  public QcircleRedDotEntity() {}
  
  public QcircleRedDotEntity(String paramString, boolean paramBoolean, long paramLong)
  {
    this.uin = paramString;
    this.isShowRedDot = paramBoolean;
    this.timeStamp = paramLong;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.QcircleRedDotEntity
 * JD-Core Version:    0.7.0.1
 */
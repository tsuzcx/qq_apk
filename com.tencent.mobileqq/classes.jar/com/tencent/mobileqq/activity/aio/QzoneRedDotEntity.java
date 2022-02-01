package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import org.jetbrains.annotations.NotNull;

@KeepClassConstructor
public class QzoneRedDotEntity
  extends Entity
{
  public String iconUrl;
  public boolean isShowRedDot;
  public String jumpSchema;
  public long timeStamp;
  @unique
  public String uin;
  
  public QzoneRedDotEntity()
  {
    this.uin = "";
    this.isShowRedDot = false;
    this.timeStamp = 0L;
    this.jumpSchema = "";
    this.iconUrl = "https://sola.gtimg.cn/aoi/sola/20201120145856_F8zRPy6aU6.png";
  }
  
  public QzoneRedDotEntity(@NotNull String paramString1, boolean paramBoolean, long paramLong, @NotNull String paramString2, @NotNull String paramString3)
  {
    this.uin = paramString1;
    this.isShowRedDot = paramBoolean;
    this.timeStamp = paramLong;
    this.jumpSchema = paramString2;
    this.iconUrl = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    QzoneRedDotEntity localQzoneRedDotEntity;
    if ((paramObject instanceof QzoneRedDotEntity)) {
      localQzoneRedDotEntity = (QzoneRedDotEntity)paramObject;
    } else {
      localQzoneRedDotEntity = null;
    }
    if (paramObject != this)
    {
      paramObject = this.uin;
      if ((paramObject == null) || (localQzoneRedDotEntity == null) || (!paramObject.equals(localQzoneRedDotEntity.uin))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.QzoneRedDotEntity
 * JD-Core Version:    0.7.0.1
 */
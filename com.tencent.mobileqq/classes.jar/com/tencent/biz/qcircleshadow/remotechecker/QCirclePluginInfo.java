package com.tencent.biz.qcircleshadow.remotechecker;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import cooperation.qzone.QUA;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="version")
public class QCirclePluginInfo
  extends Entity
  implements Serializable, Cloneable
{
  public String cookie;
  public boolean isInvalid;
  public boolean isReady;
  public long mUin;
  public String managerFileUrl;
  public long managerFilelength;
  public String pluginManagerPath;
  public String pluginZipPath;
  public String qua;
  @unique
  public int version;
  public long zipFileLength;
  public String zipFileUrl;
  
  public QCirclePluginInfo() {}
  
  public QCirclePluginInfo(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    this.version = paramInt;
    this.cookie = paramString1;
    this.zipFileUrl = paramString2;
    this.managerFileUrl = paramString3;
    this.zipFileLength = paramLong1;
    this.managerFilelength = paramLong2;
    this.qua = QUA.getQUA3();
    this.mUin = paramLong3;
  }
  
  protected Object clone()
  {
    return new QCirclePluginInfo(this.version, this.cookie, this.zipFileUrl, this.managerFileUrl, this.zipFileLength, this.managerFilelength, this.mUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remotechecker.QCirclePluginInfo
 * JD-Core Version:    0.7.0.1
 */
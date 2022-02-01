package com.tencent.biz.qcircleshadow.remoteCheck;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import cooperation.qzone.QUA;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="version")
public class QCircleFlutterPluginInfo
  extends Entity
  implements Serializable, Cloneable
{
  public boolean isInvalid;
  public boolean isReady;
  public long mUin;
  public String pluginZipPath;
  public String qua;
  public String salt;
  @unique
  public String version;
  public long zipFileLength;
  public String zipFileMD5;
  public String zipFileUrl;
  
  public QCircleFlutterPluginInfo() {}
  
  public QCircleFlutterPluginInfo(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2)
  {
    this.version = paramString1;
    this.zipFileUrl = paramString2;
    this.zipFileMD5 = paramString3;
    this.zipFileLength = paramLong2;
    this.qua = QUA.getQUA3();
    this.mUin = paramLong1;
    this.salt = paramString4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remoteCheck.QCircleFlutterPluginInfo
 * JD-Core Version:    0.7.0.1
 */
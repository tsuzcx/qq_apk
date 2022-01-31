package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AppInfoForUpdate
  extends JceStruct
{
  public byte actionFlag = 0;
  public long appId = 0L;
  public byte appType = 1;
  public int grayVersionCode = 0;
  public String manifestMd5 = "";
  public String packageName = "";
  public String signatureMd5 = "";
  public int targetGrayVersionCode = 0;
  public int targetVersionCode = 0;
  public int versionCode = 0;
  public String versionName = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.packageName = paramJceInputStream.readString(0, true);
    this.signatureMd5 = paramJceInputStream.readString(1, true);
    this.versionCode = paramJceInputStream.read(this.versionCode, 2, true);
    this.manifestMd5 = paramJceInputStream.readString(3, false);
    this.appId = paramJceInputStream.read(this.appId, 4, false);
    this.appType = paramJceInputStream.read(this.appType, 5, false);
    this.versionName = paramJceInputStream.readString(6, false);
    this.actionFlag = paramJceInputStream.read(this.actionFlag, 7, false);
    this.grayVersionCode = paramJceInputStream.read(this.grayVersionCode, 8, false);
    this.targetVersionCode = paramJceInputStream.read(this.targetVersionCode, 9, false);
    this.targetGrayVersionCode = paramJceInputStream.read(this.targetGrayVersionCode, 10, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.packageName, 0);
    paramJceOutputStream.write(this.signatureMd5, 1);
    paramJceOutputStream.write(this.versionCode, 2);
    if (this.manifestMd5 != null) {
      paramJceOutputStream.write(this.manifestMd5, 3);
    }
    paramJceOutputStream.write(this.appId, 4);
    paramJceOutputStream.write(this.appType, 5);
    if (this.versionName != null) {
      paramJceOutputStream.write(this.versionName, 6);
    }
    paramJceOutputStream.write(this.actionFlag, 7);
    paramJceOutputStream.write(this.grayVersionCode, 8);
    paramJceOutputStream.write(this.targetVersionCode, 9);
    paramJceOutputStream.write(this.targetGrayVersionCode, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.jce.AppInfoForUpdate
 * JD-Core Version:    0.7.0.1
 */
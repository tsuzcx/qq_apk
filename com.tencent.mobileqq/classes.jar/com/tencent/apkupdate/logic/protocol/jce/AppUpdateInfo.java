package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AppUpdateInfo
  extends JceStruct
{
  static ArrayList cache_apkDownUrl;
  static PicInfo cache_iconUrl;
  static RatingInfo cache_rating;
  public ArrayList apkDownUrl = null;
  public long apkId = 0L;
  public String apkMd5 = "";
  public String apkUrl = "";
  public long appId = 0L;
  public String appName = "";
  public String diffApkMd5 = "";
  public String diffApkUrl = "";
  public long diffFileSize = 0L;
  public long downCount = 0L;
  public long fileSize = 0L;
  public int flag = 0;
  public int grayVersionCode = 0;
  public PicInfo iconUrl = null;
  public byte isAdded = 0;
  public String newFeature = "";
  public String packageName = "";
  public RatingInfo rating = null;
  public String signatureMd5 = "";
  public int versionCode = 0;
  public String versionName = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.packageName = paramJceInputStream.readString(0, true);
    this.appName = paramJceInputStream.readString(1, true);
    this.signatureMd5 = paramJceInputStream.readString(2, true);
    this.versionCode = paramJceInputStream.read(this.versionCode, 3, true);
    if (cache_iconUrl == null) {
      cache_iconUrl = new PicInfo();
    }
    this.iconUrl = ((PicInfo)paramJceInputStream.read(cache_iconUrl, 4, true));
    this.newFeature = paramJceInputStream.readString(5, true);
    if (cache_rating == null) {
      cache_rating = new RatingInfo();
    }
    this.rating = ((RatingInfo)paramJceInputStream.read(cache_rating, 6, true));
    this.apkMd5 = paramJceInputStream.readString(7, true);
    this.apkUrl = paramJceInputStream.readString(8, true);
    this.fileSize = paramJceInputStream.read(this.fileSize, 9, true);
    this.diffApkMd5 = paramJceInputStream.readString(10, false);
    this.diffApkUrl = paramJceInputStream.readString(11, false);
    this.diffFileSize = paramJceInputStream.read(this.diffFileSize, 12, false);
    this.versionName = paramJceInputStream.readString(13, false);
    this.appId = paramJceInputStream.read(this.appId, 14, false);
    this.downCount = paramJceInputStream.read(this.downCount, 15, false);
    this.flag = paramJceInputStream.read(this.flag, 16, false);
    this.apkId = paramJceInputStream.read(this.apkId, 18, false);
    if (cache_apkDownUrl == null)
    {
      cache_apkDownUrl = new ArrayList();
      ApkDownUrl localApkDownUrl = new ApkDownUrl();
      cache_apkDownUrl.add(localApkDownUrl);
    }
    this.apkDownUrl = ((ArrayList)paramJceInputStream.read(cache_apkDownUrl, 19, false));
    this.isAdded = paramJceInputStream.read(this.isAdded, 21, false);
    this.grayVersionCode = paramJceInputStream.read(this.grayVersionCode, 22, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.packageName, 0);
    paramJceOutputStream.write(this.appName, 1);
    paramJceOutputStream.write(this.signatureMd5, 2);
    paramJceOutputStream.write(this.versionCode, 3);
    paramJceOutputStream.write(this.iconUrl, 4);
    paramJceOutputStream.write(this.newFeature, 5);
    paramJceOutputStream.write(this.rating, 6);
    paramJceOutputStream.write(this.apkMd5, 7);
    paramJceOutputStream.write(this.apkUrl, 8);
    paramJceOutputStream.write(this.fileSize, 9);
    if (this.diffApkMd5 != null) {
      paramJceOutputStream.write(this.diffApkMd5, 10);
    }
    if (this.diffApkUrl != null) {
      paramJceOutputStream.write(this.diffApkUrl, 11);
    }
    paramJceOutputStream.write(this.diffFileSize, 12);
    if (this.versionName != null) {
      paramJceOutputStream.write(this.versionName, 13);
    }
    paramJceOutputStream.write(this.appId, 14);
    paramJceOutputStream.write(this.downCount, 15);
    paramJceOutputStream.write(this.flag, 16);
    paramJceOutputStream.write(this.apkId, 18);
    if (this.apkDownUrl != null) {
      paramJceOutputStream.write(this.apkDownUrl, 19);
    }
    paramJceOutputStream.write(this.isAdded, 21);
    paramJceOutputStream.write(this.grayVersionCode, 22);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.jce.AppUpdateInfo
 * JD-Core Version:    0.7.0.1
 */
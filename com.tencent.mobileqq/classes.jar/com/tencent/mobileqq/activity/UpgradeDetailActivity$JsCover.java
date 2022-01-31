package com.tencent.mobileqq.activity;

import akgo;
import aqre;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeDetailActivity$JsCover
  extends aqre
{
  protected UpgradeDetailActivity$JsCover(UpgradeDetailActivity paramUpgradeDetailActivity) {}
  
  public String getApkName()
  {
    return UpgradeDetailActivity.a(this.a);
  }
  
  public long getApkSize()
  {
    return UpgradeDetailActivity.a(this.a);
  }
  
  public String getApkVersion()
  {
    return UpgradeDetailActivity.b(this.a);
  }
  
  public int getDownloadState()
  {
    return akgo.a().a();
  }
  
  public long getUpgradeTime()
  {
    return UpgradeDetailActivity.a(this.a).a.iNewTimeStamp;
  }
  
  public int installApk()
  {
    akgo.a().a(this.a);
    return 0;
  }
  
  public int pauseDownload()
  {
    akgo.a().e();
    return 0;
  }
  
  public int resumeDownload()
  {
    if (QLog.isColorLevel()) {
      QLog.d("preLoad_configServlet", 2, "resume download from web, mark it.");
    }
    akgo.a().d();
    return 0;
  }
  
  public int startDownload()
  {
    if (QLog.isColorLevel()) {
      QLog.d("preLoad_configServlet", 2, "start download from web, mark it.");
    }
    akgo.a().a(false, UpgradeDetailActivity.a(this.a, UpgradeDetailActivity.a(this.a).b));
    return 0;
  }
  
  public int stopDownload()
  {
    akgo.a().c();
    return 0;
  }
  
  public int tipsLoadComplete()
  {
    QLog.d("Hyim", 2, "loadTipsComplete");
    this.a.a = true;
    int i = getDownloadState();
    this.a.a(i, akgo.a());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UpgradeDetailActivity.JsCover
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import amqe;
import atgv;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeDetailActivity$JsCover
  extends atgv
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
    return amqe.a().a();
  }
  
  public long getUpgradeTime()
  {
    return UpgradeDetailActivity.a(this.a).a.iNewTimeStamp;
  }
  
  public int installApk()
  {
    amqe.a().a(this.a);
    return 0;
  }
  
  public int pauseDownload()
  {
    amqe.a().e();
    return 0;
  }
  
  public int resumeDownload()
  {
    if (QLog.isColorLevel()) {
      QLog.d("preLoad_configServlet", 2, "resume download from web, mark it.");
    }
    amqe.a().d();
    return 0;
  }
  
  public int startDownload()
  {
    if (QLog.isColorLevel()) {
      QLog.d("preLoad_configServlet", 2, "start download from web, mark it.");
    }
    UpgradeDetailActivity.a(this.a, true);
    return 0;
  }
  
  public int stopDownload()
  {
    amqe.a().c();
    return 0;
  }
  
  public int tipsLoadComplete()
  {
    QLog.d("Hyim", 2, "loadTipsComplete");
    this.a.a = true;
    int i = getDownloadState();
    this.a.a(i, amqe.a());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UpgradeDetailActivity.JsCover
 * JD-Core Version:    0.7.0.1
 */
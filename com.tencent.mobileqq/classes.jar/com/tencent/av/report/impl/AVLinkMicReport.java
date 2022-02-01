package com.tencent.av.report.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import com.tencent.av.report.utils.AVReportUtils;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpImpl;
import java.util.Map;

public class AVLinkMicReport
  extends AVBaseReport
{
  public AVLinkMicReport(SimpleCoreHttpImpl paramSimpleCoreHttpImpl)
  {
    setHttpComponent(paramSimpleCoreHttpImpl);
    init();
  }
  
  public String getReportId()
  {
    return "07700032024";
  }
  
  public String getToken()
  {
    return "5991332928";
  }
  
  public void prepareData()
  {
    String str2 = "";
    this.reportData.put("attaid", getReportId());
    this.reportData.put("token", getToken());
    this.reportData.put("terminaltype", "android");
    this.reportData.put("model", Build.MODEL);
    this.reportData.put("band", Build.BRAND);
    Object localObject1 = AVReportUtils.getAppContext().getPackageManager();
    try
    {
      Object localObject2 = ((PackageManager)localObject1).getPackageInfo(AVReportUtils.getAppContext().getPackageName(), 0);
      localObject1 = ((PackageInfo)localObject2).versionName;
      try
      {
        localObject2 = String.valueOf(((PackageInfo)localObject2).versionCode);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1) {}
      localNameNotFoundException2.printStackTrace();
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException2)
    {
      localObject1 = "";
    }
    String str1 = str2;
    this.reportData.put("clientversion", str1);
    this.reportData.put("sdkversion", localObject1);
    this.reportData.put("bundle", AVReportUtils.getAppContext().getPackageName());
    this.reportData.put("netstring", String.valueOf(AVReportUtils.getNetworkType(AVReportUtils.getAppContext())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.report.impl.AVLinkMicReport
 * JD-Core Version:    0.7.0.1
 */
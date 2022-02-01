package com.tencent.av.report.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import com.tencent.av.report.utils.AVReportUtils;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class AVMonitorReport
  extends AVBaseReport
{
  public AVMonitorReport(SimpleCoreHttpImpl paramSimpleCoreHttpImpl)
  {
    setHttpComponent(paramSimpleCoreHttpImpl);
    init();
  }
  
  public void addUploadStreamData(Map<String, String> paramMap)
  {
    this.reportData.putAll(paramMap);
  }
  
  public String getReportId()
  {
    return "08900014684";
  }
  
  public String getToken()
  {
    return "9298697425";
  }
  
  public void prepareData()
  {
    String str2 = "";
    this.reportData.put("attaid", getReportId());
    this.reportData.put("token", getToken());
    this.reportData.put("machineAbstract", Build.MODEL);
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
    this.reportData.put("clientVersion", localObject1);
    this.reportData.put("sdkVersion", str1);
  }
  
  public void send()
  {
    long l = System.currentTimeMillis();
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(l));
    this.reportData.put("ftime", str);
    super.send();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.report.impl.AVMonitorReport
 * JD-Core Version:    0.7.0.1
 */
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

public class AVCatonReport
  extends AVBaseReport
{
  public AVCatonReport(SimpleCoreHttpImpl paramSimpleCoreHttpImpl)
  {
    setHttpComponent(paramSimpleCoreHttpImpl);
    init();
  }
  
  public void addGapValue(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.reportData.put("gap0_5", String.valueOf(paramLong1));
    this.reportData.put("gap5_10", String.valueOf(paramLong2));
    this.reportData.put("gap10_100", String.valueOf(paramLong3));
    this.reportData.put("framecount", String.valueOf(paramLong4));
  }
  
  public void addPlayerParams(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.reportData.put("url", paramString1);
    this.reportData.put("resolution", paramString2);
    this.reportData.put("roomid", paramString3);
    this.reportData.put("sdktyp", paramString4);
    this.reportData.put("sdkversion", paramString5);
    this.reportData.put("openid", paramString6);
  }
  
  public void addTimeValue(long paramLong1, long paramLong2)
  {
    this.reportData.put("firstframeduration", String.valueOf(paramLong1));
    this.reportData.put("playduration", String.valueOf(paramLong2));
  }
  
  public String getReportId()
  {
    return "0ab00017681";
  }
  
  public String getToken()
  {
    return "9298697425";
  }
  
  public void prepareData()
  {
    this.reportData.put("attaid", getReportId());
    this.reportData.put("token", getToken());
    this.reportData.put("terminaltype", "android");
    this.reportData.put("model", Build.MODEL);
    this.reportData.put("band", Build.BRAND);
    this.reportData.put("eventid", "exit-room");
    Object localObject1 = AVReportUtils.getAppContext().getPackageManager();
    String str2 = "";
    for (;;)
    {
      try
      {
        Object localObject2 = ((PackageManager)localObject1).getPackageInfo(AVReportUtils.getAppContext().getPackageName(), 0);
        localObject1 = ((PackageInfo)localObject2).versionName;
        int i;
        localNameNotFoundException1.printStackTrace();
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        try
        {
          i = ((PackageInfo)localObject2).versionCode;
          localObject2 = String.valueOf(i);
          this.reportData.put("clientversion", localObject2);
          this.reportData.put("versionName", localObject1);
          this.reportData.put("bundle", AVReportUtils.getAppContext().getPackageName());
          this.reportData.put("netstring", String.valueOf(AVReportUtils.getNetworkType(AVReportUtils.getAppContext())));
          return;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          String str1;
          break label198;
        }
        localNameNotFoundException1 = localNameNotFoundException1;
        localObject1 = "";
      }
      label198:
      str1 = str2;
    }
  }
  
  public void send()
  {
    long l = System.currentTimeMillis();
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(l));
    this.reportData.put("ftime", str);
    super.send();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.report.impl.AVCatonReport
 * JD-Core Version:    0.7.0.1
 */
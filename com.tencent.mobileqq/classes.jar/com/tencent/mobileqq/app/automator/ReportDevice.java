package com.tencent.mobileqq.app.automator;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;

public class ReportDevice
  extends AsyncStep
{
  protected int doStep()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    int i = 0;
    Object localObject = localBaseApplicationImpl.getSharedPreferences("mobileQQ", 0);
    if (((SharedPreferences)localObject).getInt("needDoReportAppDeviceStat", 0) == 1)
    {
      try
      {
        StatisticCollector.getInstance(BaseApplication.getContext()).reportDeviceStatistic("");
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putInt("needDoReportAppDeviceStat", 0);
        ((SharedPreferences.Editor)localObject).commit();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    else
    {
      int k = localException1.getInt("firstTimeCollectpdInt", 0);
      try
      {
        int j = localBaseApplicationImpl.getPackageManager().getPackageInfo(localBaseApplicationImpl.getPackageName(), 0).versionCode;
        i = j;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      if ((k == 0) || (i != k))
      {
        SharedPreferences.Editor localEditor = localException1.edit();
        localEditor.putInt("firstTimeCollectpdInt", i);
        localEditor.putInt("needDoReportAppDeviceStat", 1);
        localEditor.commit();
      }
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.ReportDevice
 * JD-Core Version:    0.7.0.1
 */
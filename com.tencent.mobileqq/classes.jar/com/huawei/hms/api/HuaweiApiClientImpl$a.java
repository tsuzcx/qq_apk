package com.huawei.hms.api;

import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;

class HuaweiApiClientImpl$a
  implements CheckUpdateCallBack
{
  HuaweiApiClientImpl$a(HuaweiApiClientImpl paramHuaweiApiClientImpl) {}
  
  public void onMarketInstallInfo(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("downloadStatus", -99);
      int j = paramIntent.getIntExtra("installState", -99);
      int k = paramIntent.getIntExtra("installType", -99);
      paramIntent = new StringBuilder();
      paramIntent.append("onMarketInstallInfo installState: ");
      paramIntent.append(j);
      paramIntent.append(",installType: ");
      paramIntent.append(k);
      paramIntent.append(",downloadCode: ");
      paramIntent.append(i);
      HMSLog.i("HuaweiApiClientImpl", paramIntent.toString());
    }
  }
  
  public void onMarketStoreError(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMarketStoreError responseCode: ");
    localStringBuilder.append(paramInt);
    HMSLog.e("HuaweiApiClientImpl", localStringBuilder.toString());
  }
  
  public void onUpdateInfo(Intent paramIntent)
  {
    if ((paramIntent != null) && (HuaweiApiClientImpl.a(this.a) != null)) {
      try
      {
        int i = paramIntent.getIntExtra("status", -99);
        int j = paramIntent.getIntExtra("failcause", -99);
        boolean bool = paramIntent.getBooleanExtra("compulsoryUpdateCancel", false);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUpdateInfo status: ");
        localStringBuilder.append(i);
        localStringBuilder.append(",failcause: ");
        localStringBuilder.append(j);
        localStringBuilder.append(",isExit: ");
        localStringBuilder.append(bool);
        HMSLog.i("HuaweiApiClientImpl", localStringBuilder.toString());
        if (i == 7)
        {
          paramIntent = (ApkUpgradeInfo)paramIntent.getSerializableExtra("updatesdk_update_info");
          if (paramIntent != null)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onUpdateInfo: ");
            localStringBuilder.append(paramIntent.toString());
            HMSLog.i("HuaweiApiClientImpl", localStringBuilder.toString());
          }
          HuaweiApiClientImpl.a(this.a).onResult(1);
        }
        else if (i == 3)
        {
          HuaweiApiClientImpl.a(this.a).onResult(0);
        }
        else
        {
          HuaweiApiClientImpl.a(this.a).onResult(-1);
        }
        HuaweiApiClientImpl.a(this.a, null);
        return;
      }
      catch (Exception paramIntent)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("intent has some error");
        localStringBuilder.append(paramIntent.getMessage());
        HMSLog.e("HuaweiApiClientImpl", localStringBuilder.toString());
        HuaweiApiClientImpl.a(this.a).onResult(-1);
      }
    }
  }
  
  public void onUpdateStoreError(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpdateStoreError responseCode: ");
    localStringBuilder.append(paramInt);
    HMSLog.e("HuaweiApiClientImpl", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl.a
 * JD-Core Version:    0.7.0.1
 */
package com.huawei.hms.api;

import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;

class HuaweiApiClientImpl$1
  implements CheckUpdateCallBack
{
  HuaweiApiClientImpl$1(HuaweiApiClientImpl paramHuaweiApiClientImpl) {}
  
  public void onMarketInstallInfo(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("downloadStatus", -99);
      int j = paramIntent.getIntExtra("installState", -99);
      int k = paramIntent.getIntExtra("installType", -99);
      HMSLog.i("HuaweiApiClientImpl", "onMarketInstallInfo installState: " + j + ",installType: " + k + ",downloadCode: " + i);
    }
  }
  
  public void onMarketStoreError(int paramInt)
  {
    HMSLog.e("HuaweiApiClientImpl", "onMarketStoreError responseCode: " + paramInt);
  }
  
  public void onUpdateInfo(Intent paramIntent)
  {
    if ((paramIntent != null) && (HuaweiApiClientImpl.a(this.a) != null)) {}
    for (;;)
    {
      int i;
      try
      {
        i = paramIntent.getIntExtra("status", -99);
        int j = paramIntent.getIntExtra("failcause", -99);
        boolean bool = paramIntent.getBooleanExtra("compulsoryUpdateCancel", false);
        HMSLog.i("HuaweiApiClientImpl", "onUpdateInfo status: " + i + ",failcause: " + j + ",isExit: " + bool);
        if (i == 7)
        {
          paramIntent = (ApkUpgradeInfo)paramIntent.getSerializableExtra("updatesdk_update_info");
          if (paramIntent != null) {
            HMSLog.i("HuaweiApiClientImpl", "onUpdateInfo: " + paramIntent.toString());
          }
          HuaweiApiClientImpl.a(this.a).onResult(1);
          HuaweiApiClientImpl.a(this.a, null);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        HMSLog.e("HuaweiApiClientImpl", "intent has some error" + paramIntent.getMessage());
        HuaweiApiClientImpl.a(this.a).onResult(-1);
        return;
      }
      if (i == 3) {
        HuaweiApiClientImpl.a(this.a).onResult(0);
      } else {
        HuaweiApiClientImpl.a(this.a).onResult(-1);
      }
    }
  }
  
  public void onUpdateStoreError(int paramInt)
  {
    HMSLog.e("HuaweiApiClientImpl", "onUpdateStoreError responseCode: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl.1
 * JD-Core Version:    0.7.0.1
 */
package com.huawei.hms.api;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.HMSPublishStateHolder;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;

class HuaweiApiClientImpl$2
  implements CheckUpdateCallBack
{
  HuaweiApiClientImpl$2(HuaweiApiClientImpl paramHuaweiApiClientImpl, int paramInt) {}
  
  public void onMarketInstallInfo(Intent paramIntent)
  {
    if (HMSPublishStateHolder.getPublishState() != 1) {
      HMSPublishStateHolder.setPublishState(2);
    }
    HuaweiApiClientImpl.a(this.b, this.a);
  }
  
  public void onMarketStoreError(int paramInt)
  {
    HMSLog.e("HuaweiApiClientImpl", "onMarketStoreError responseCode: " + paramInt);
    if (HMSPublishStateHolder.getPublishState() != 1) {
      HMSPublishStateHolder.setPublishState(2);
    }
    HuaweiApiClientImpl.a(this.b, this.a);
  }
  
  public void onUpdateInfo(Intent paramIntent)
  {
    if (paramIntent != null) {}
    try
    {
      int i = paramIntent.getIntExtra("status", -99);
      HMSLog.i("HuaweiApiClientImpl", "CheckUpdateCallBack status is " + i);
      String str = paramIntent.getStringExtra("failreason");
      if (!TextUtils.isEmpty(str)) {
        HMSLog.e("HuaweiApiClientImpl", "checkTargetAppUpdate reason is " + str);
      }
      if (i == 7)
      {
        paramIntent = paramIntent.getSerializableExtra("updatesdk_update_info");
        if (((paramIntent instanceof ApkUpgradeInfo)) && (((ApkUpgradeInfo)paramIntent).getPackage_().equalsIgnoreCase("com.huawei.hms")))
        {
          HMSLog.i("HuaweiApiClientImpl", "com.huawei.hms has already be published");
          HMSPublishStateHolder.setPublishState(1);
        }
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        HMSLog.e("HuaweiApiClientImpl", "intent has some error" + paramIntent.getMessage());
      }
    }
    if (HMSPublishStateHolder.getPublishState() != 1) {
      HMSPublishStateHolder.setPublishState(2);
    }
    HuaweiApiClientImpl.a(this.b, this.a);
  }
  
  public void onUpdateStoreError(int paramInt)
  {
    HMSLog.e("HuaweiApiClientImpl", "onUpdateStoreError responseCode: " + paramInt);
    if (HMSPublishStateHolder.getPublishState() != 1) {
      HMSPublishStateHolder.setPublishState(2);
    }
    HuaweiApiClientImpl.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl.2
 * JD-Core Version:    0.7.0.1
 */
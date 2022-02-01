package com.huawei.hms.adapter.ui;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.HMSPublishStateHolder;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;

class UpdateAdapter$1
  implements CheckUpdateCallBack
{
  UpdateAdapter$1(UpdateAdapter paramUpdateAdapter) {}
  
  public void onMarketInstallInfo(Intent paramIntent)
  {
    if (HMSPublishStateHolder.getPublishState() != 1) {
      HMSPublishStateHolder.setPublishState(2);
    }
    UpdateAdapter.a(this.a, "com.huawei.hwid");
    UpdateAdapter.b(this.a);
  }
  
  public void onMarketStoreError(int paramInt)
  {
    HMSLog.e("UpdateAdapter", "onMarketStoreError responseCode: " + paramInt);
    if (HMSPublishStateHolder.getPublishState() != 1) {
      HMSPublishStateHolder.setPublishState(2);
    }
    UpdateAdapter.a(this.a, "com.huawei.hwid");
    UpdateAdapter.b(this.a);
  }
  
  public void onUpdateInfo(Intent paramIntent)
  {
    if (paramIntent != null) {}
    try
    {
      int i = paramIntent.getIntExtra("status", -99);
      HMSLog.i("UpdateAdapter", "CheckUpdateCallBack status is " + i);
      String str = paramIntent.getStringExtra("failreason");
      if (!TextUtils.isEmpty(str)) {
        HMSLog.e("UpdateAdapter", "checkTargetAppUpdate reason is " + str);
      }
      if (i == 7)
      {
        paramIntent = paramIntent.getSerializableExtra("updatesdk_update_info");
        if ((paramIntent instanceof ApkUpgradeInfo))
        {
          paramIntent = ((ApkUpgradeInfo)paramIntent).getPackage_();
          if (paramIntent.equalsIgnoreCase("com.huawei.hms"))
          {
            HMSLog.i("UpdateAdapter", "com.huawei.hms has already be published");
            UpdateAdapter.a(this.a, paramIntent);
            HMSPublishStateHolder.setPublishState(1);
          }
        }
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        HMSLog.e("UpdateAdapter", "intent has some error" + paramIntent.getMessage());
      }
    }
    if (UpdateAdapter.a(this.a) == null)
    {
      if (HMSPublishStateHolder.getPublishState() != 1) {
        HMSPublishStateHolder.setPublishState(2);
      }
      UpdateAdapter.a(this.a, "com.huawei.hwid");
    }
    UpdateAdapter.b(this.a);
  }
  
  public void onUpdateStoreError(int paramInt)
  {
    HMSLog.e("UpdateAdapter", "onUpdateStoreError responseCode: " + paramInt);
    if (HMSPublishStateHolder.getPublishState() != 1) {
      HMSPublishStateHolder.setPublishState(2);
    }
    UpdateAdapter.a(this.a, "com.huawei.hwid");
    UpdateAdapter.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.adapter.ui.UpdateAdapter.1
 * JD-Core Version:    0.7.0.1
 */
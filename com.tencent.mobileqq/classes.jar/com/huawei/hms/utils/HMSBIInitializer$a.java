package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsConfig.Builder;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsInstance.Builder;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class HMSBIInitializer$a
  implements IQueryUrlCallBack
{
  public HMSBIInitializer$a(HMSBIInitializer paramHMSBIInitializer) {}
  
  public void onCallBackFail(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get grs failed, the errorcode is ");
    localStringBuilder.append(paramInt);
    HMSLog.e("HMSBIInitializer", localStringBuilder.toString());
    HMSBIInitializer.c(this.a).set(false);
  }
  
  public void onCallBackSuccess(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!HMSBIInitializer.a(this.a))
      {
        HmsHiAnalyticsUtils.init(HMSBIInitializer.b(this.a), false, false, false, paramString, "com.huawei.hwid");
      }
      else
      {
        HiAnalyticsConfig localHiAnalyticsConfig = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(paramString).build();
        paramString = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(paramString).build();
        HMSBIInitializer.a(new HiAnalyticsInstance.Builder(HMSBIInitializer.b(this.a)).setOperConf(localHiAnalyticsConfig).setMaintConf(paramString).create("hms_config_tag"));
        HMSBIInitializer.a().setAppid("com.huawei.hwid");
      }
      HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");
    }
    HMSBIInitializer.c(this.a).set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.utils.HMSBIInitializer.a
 * JD-Core Version:    0.7.0.1
 */
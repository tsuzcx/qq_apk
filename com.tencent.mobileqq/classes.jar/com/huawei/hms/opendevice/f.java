package com.huawei.hms.opendevice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.support.log.HMSLog;

public abstract class f
{
  public static String a(@NonNull Context paramContext)
  {
    String str = AGConnectServicesConfig.fromContext(paramContext).getString("region");
    if (TextUtils.isEmpty(str))
    {
      HMSLog.i("QueryGrs", "The data storage region is empty.");
      return "";
    }
    GrsBaseInfo localGrsBaseInfo = new GrsBaseInfo();
    localGrsBaseInfo.setSerCountry(str);
    paramContext = new GrsClient(paramContext, localGrsBaseInfo).synGetGrsUrl("com.huawei.hms.opendevicesdk", "ROOT");
    if (TextUtils.isEmpty(paramContext))
    {
      HMSLog.i("QueryGrs", "Query Grs base url is empty.");
      return "";
    }
    HMSLog.i("QueryGrs", "Query Grs base url: " + paramContext);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.opendevice.f
 * JD-Core Version:    0.7.0.1
 */
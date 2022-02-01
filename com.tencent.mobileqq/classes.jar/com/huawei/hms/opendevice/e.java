package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.support.log.HMSLog;

public abstract class e
{
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    GrsBaseInfo localGrsBaseInfo = new GrsBaseInfo();
    localGrsBaseInfo.setSerCountry(paramString4);
    if (!TextUtils.isEmpty(paramString3)) {
      localGrsBaseInfo.setAppName(paramString3);
    }
    paramContext = new GrsClient(paramContext, localGrsBaseInfo).synGetGrsUrl(paramString1, paramString2);
    if (TextUtils.isEmpty(paramContext))
    {
      HMSLog.i("QueryGrs", "Query Grs base url is empty.");
      return "";
    }
    HMSLog.i("QueryGrs", "Query Grs base url success.");
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.opendevice.e
 * JD-Core Version:    0.7.0.1
 */
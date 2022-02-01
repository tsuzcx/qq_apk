package com.tencent.mobileqq.ark.secure;

import android.text.TextUtils;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;

public class ArkSecureUtil
{
  public static void a(long paramLong, String paramString1, String paramString2, ArkAppMgr.IGetAppPathByNameCallback paramIGetAppPathByNameCallback)
  {
    ArkSecureUtil.GetAppPathTask localGetAppPathTask = new ArkSecureUtil.GetAppPathTask();
    localGetAppPathTask.a = paramIGetAppPathByNameCallback;
    ArkAppMgr.getInstance().getAppPathByName(paramString1, paramString2, new ArkSecureUtil.2(localGetAppPathTask, paramString1));
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToLogicThreadDelay(new ArkSecureUtil.3(localGetAppPathTask, paramString1), (int)paramLong);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, CheckShareUrlResult paramCheckShareUrlResult)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      a(3000L, paramString1, "0.0.0.1", new ArkSecureUtil.1(paramString1, paramString3, paramCheckShareUrlResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.secure.ArkSecureUtil
 * JD-Core Version:    0.7.0.1
 */
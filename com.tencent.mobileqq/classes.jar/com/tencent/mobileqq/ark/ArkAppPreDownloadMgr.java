package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.MobileQQ;

@Deprecated
public class ArkAppPreDownloadMgr
{
  @Deprecated
  public static void a()
  {
    if (MobileQQ.sMobileQQ.waitAppRuntime(null) == null) {
      return;
    }
    ((IArkHelper)QRoute.api(IArkHelper.class)).preloadCommon();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.NativeAd.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;

final class NativeAdUtils$3
  implements Runnable
{
  NativeAdUtils$3(String paramString) {}
  
  public void run()
  {
    if (BaseApplicationImpl.getApplication().peekAppRuntime() != null)
    {
      Object localObject = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySP(true, false);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        if (localObject != null)
        {
          ((SharedPreferences.Editor)localObject).putString("sp_key_ad_cookie", this.a);
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).applySharedPreferences((SharedPreferences.Editor)localObject, true);
          NativeAdUtils.a("saveAdCookie cookie=", this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.3
 * JD-Core Version:    0.7.0.1
 */
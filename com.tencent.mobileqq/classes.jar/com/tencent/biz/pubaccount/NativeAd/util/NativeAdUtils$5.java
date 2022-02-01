package com.tencent.biz.pubaccount.NativeAd.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.readinjoy.ReadInJoyHelper;
import mqq.app.AppRuntime;

final class NativeAdUtils$5
  implements Runnable
{
  NativeAdUtils$5(String paramString) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
    if (localObject != null)
    {
      localObject = ReadInJoyHelper.a((AppRuntime)localObject, true, false);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        if (localObject != null)
        {
          ((SharedPreferences.Editor)localObject).putString("sp_key_ad_cookie", this.a);
          ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
          NativeAdUtils.a("saveAdCookie cookie=", this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.5
 * JD-Core Version:    0.7.0.1
 */
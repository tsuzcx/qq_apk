package com.tencent.biz.pubaccount.NativeAd.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bmhv;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import ois;

public final class NativeAdUtils$5
  implements Runnable
{
  public NativeAdUtils$5(String paramString) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
    if (localObject != null)
    {
      localObject = bmhv.a((AppRuntime)localObject, true, false);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        if (localObject != null)
        {
          ((SharedPreferences.Editor)localObject).putString("sp_key_ad_cookie", this.a);
          bmhv.a((SharedPreferences.Editor)localObject, true);
          ois.a("saveAdCookie cookie=", this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.5
 * JD-Core Version:    0.7.0.1
 */
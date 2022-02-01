package com.tencent.biz.pubaccount.NativeAd.util;

import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.common.app.BaseApplicationImpl;

final class NativeAdUtils$5
  implements Runnable
{
  NativeAdUtils$5(String paramString) {}
  
  public void run()
  {
    Object localObject = new Bundle();
    HttpUtil.addCookie((Bundle)localObject);
    try
    {
      localObject = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), this.a, "GET", null, (Bundle)localObject);
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = new String((byte[])localObject);
      }
      ReadInJoyAdLog.a("reportAmsExpose, result:", (String)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      ReadInJoyAdLog.a("reportAmsExpose, e:", localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.5
 * JD-Core Version:    0.7.0.1
 */
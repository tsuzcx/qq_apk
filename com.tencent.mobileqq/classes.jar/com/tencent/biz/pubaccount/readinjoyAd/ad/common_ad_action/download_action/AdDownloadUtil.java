package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class AdDownloadUtil
{
  public static void a(ADVideoAppDownloadData paramADVideoAppDownloadData, AdDownloadUtil.PkgExistCallback paramPkgExistCallback)
  {
    if (paramADVideoAppDownloadData == null)
    {
      paramPkgExistCallback.a(false);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new AdDownloadUtil.1(paramADVideoAppDownloadData, paramPkgExistCallback));
  }
  
  public static boolean a(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if ((paramADVideoAppDownloadData == null) || (TextUtils.isEmpty(paramADVideoAppDownloadData.d))) {
      return false;
    }
    return a(paramADVideoAppDownloadData.d);
  }
  
  public static boolean a(String paramString)
  {
    return NativeAdUtils.a(BaseApplicationImpl.getContext(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
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
    if ((paramADVideoAppDownloadData != null) && (!TextUtils.isEmpty(paramADVideoAppDownloadData.d))) {
      return a(paramADVideoAppDownloadData.d);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppInstall(BaseApplicationImpl.getContext(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil
 * JD-Core Version:    0.7.0.1
 */
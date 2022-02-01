package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJAppSetting;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ReadInJoyAdSwitchUtil
{
  public static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFeedsAutoPlay->AdvertisementInfo:");
      localStringBuilder.append(paramAdvertisementInfo);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    if (paramAdvertisementInfo == null) {
      return 0;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 2);
    if (QLog.isColorLevel())
    {
      paramAdvertisementInfo = new StringBuilder();
      paramAdvertisementInfo.append("isFeedsAutoPlay->value:");
      paramAdvertisementInfo.append(i);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramAdvertisementInfo.toString());
    }
    return i;
  }
  
  public static int a(ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isWebBottomAutoPlay->BannerVideoAdData:");
      localStringBuilder.append(paramProteusBannerVideoItemData);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    if (paramProteusBannerVideoItemData == null) {
      return 0;
    }
    int i = a(paramProteusBannerVideoItemData.F, 3);
    if (QLog.isColorLevel())
    {
      paramProteusBannerVideoItemData = new StringBuilder();
      paramProteusBannerVideoItemData.append("isWebBottomAutoPlay->value:");
      paramProteusBannerVideoItemData.append(i);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramProteusBannerVideoItemData.toString());
    }
    return i;
  }
  
  private static int a(VideoAdInfo paramVideoAdInfo, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getExtValue pos->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" , VideoAdInfo:");
      localStringBuilder.append(paramVideoAdInfo);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    if (paramVideoAdInfo == null) {
      return 0;
    }
    int i = b(paramVideoAdInfo.R, paramInt);
    if (QLog.isColorLevel())
    {
      paramVideoAdInfo = new StringBuilder();
      paramVideoAdInfo.append("getExtValue pos->");
      paramVideoAdInfo.append(paramInt);
      paramVideoAdInfo.append(" , value:");
      paramVideoAdInfo.append(i);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramVideoAdInfo.toString());
    }
    return i;
  }
  
  public static int a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSwitchInt(");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(")->switchStr:");
      localStringBuilder.append(paramString);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramInt <= 0) {
        return -1;
      }
      try
      {
        paramInt = Integer.parseInt(paramString.substring(paramInt - 1, paramInt));
        return paramInt;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          paramString.printStackTrace();
        }
      }
    }
    return -1;
  }
  
  private static int a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSwitchFromExtra(");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(")->extraData:");
      localStringBuilder.append(paramString2);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString2)) {
      return -1;
    }
    try
    {
      paramString2 = new JSONObject(paramString2);
      if (!paramString2.has(paramString1)) {
        return -1;
      }
      paramString1 = paramString2.optString(paramString1);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("getSwitchFromExtra(");
        paramString2.append(paramInt);
        paramString2.append(")->switchs:");
        paramString2.append(paramString1);
        QLog.d("ReadInJoyAdSwitchUtil", 2, paramString2.toString());
      }
      paramInt = a(paramString1, paramInt);
      return paramInt;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        paramString1.printStackTrace();
      }
    }
    return -1;
  }
  
  public static <T> T a(String paramString1, String paramString2, T paramT)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramT != null)) {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if (paramString1.has(paramString2))
        {
          if ((paramT instanceof String)) {
            return paramString1.optString(paramString2, (String)paramT);
          }
          if ((paramT instanceof Integer)) {
            return Integer.valueOf(paramString1.optInt(paramString2, ((Integer)paramT).intValue()));
          }
          if ((paramT instanceof Double))
          {
            double d = paramString1.optDouble(paramString2, ((Double)paramT).doubleValue());
            return Double.valueOf(d);
          }
        }
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          paramString1.printStackTrace();
        }
      }
    }
    return paramT;
  }
  
  public static boolean a()
  {
    return ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isVideoFeedsTiktokStyle();
  }
  
  public static boolean a(Context paramContext)
  {
    int i = CUKingCardUtils.a();
    boolean bool2 = false;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).getMainFeedsKingCardAutoPlayConfig() == 1) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (j != 0)
      {
        bool1 = bool2;
        if (NetworkUtil.isNetworkAvailable(paramContext)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, ProteusBannerVideoItemData paramProteusBannerVideoItemData, Context paramContext, int paramInt)
  {
    boolean bool2 = false;
    if (((paramInt == 1) && (paramAdvertisementInfo == null)) || ((paramInt == 2) && (paramProteusBannerVideoItemData == null)) || ((paramInt == 3) && (paramAdvertisementInfo == null)) || ((paramAdvertisementInfo == null) && (paramProteusBannerVideoItemData == null))) {
      return false;
    }
    if (paramInt == 1)
    {
      paramInt = a(paramAdvertisementInfo);
    }
    else if (paramInt == 2)
    {
      paramInt = a(paramProteusBannerVideoItemData);
    }
    else
    {
      bool1 = bool2;
      if (paramInt != 3) {
        break label288;
      }
      paramInt = b(paramAdvertisementInfo);
    }
    paramAdvertisementInfo = ((IRIJAppSetting)QRoute.api(IRIJAppSetting.class)).getVideoAutoPlaySetting();
    if (QLog.isColorLevel())
    {
      paramProteusBannerVideoItemData = new StringBuilder();
      paramProteusBannerVideoItemData.append(" isADVideoAutoPlayFlag adFlag = ");
      paramProteusBannerVideoItemData.append(paramInt);
      paramProteusBannerVideoItemData.append(" kandianVideoAutoPlaySetting = ");
      paramProteusBannerVideoItemData.append(paramAdvertisementInfo);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramProteusBannerVideoItemData.toString());
    }
    if ("2".equals(paramAdvertisementInfo)) {
      return false;
    }
    if ("0".equals(paramAdvertisementInfo))
    {
      if (paramInt == 0) {
        return false;
      }
      if ((paramInt == 1) && (paramContext != null) && ((NetworkUtil.isWifiConnected(paramContext)) || (a(paramContext)))) {
        return true;
      }
      if ((paramInt == 2) && (paramContext != null) && (NetworkUtil.isNetworkAvailable(paramContext))) {
        return true;
      }
    }
    boolean bool1 = bool2;
    if ("1".equals(paramAdvertisementInfo))
    {
      if (paramInt == 0) {
        return false;
      }
      if ((paramInt == 1) && (paramContext != null) && ((NetworkUtil.isWifiConnected(paramContext)) || (a(paramContext)))) {
        return true;
      }
      bool1 = bool2;
      if (paramInt == 2)
      {
        bool1 = bool2;
        if (paramContext != null)
        {
          bool1 = bool2;
          if (NetworkUtil.isWifiConnected(paramContext)) {
            bool1 = true;
          }
        }
      }
    }
    label288:
    return bool1;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isServerRspReport->AdvertisementInfo:");
      localStringBuilder.append(paramAdvertisementInfo);
      localStringBuilder.append(" adInfo = ");
      localStringBuilder.append(paramVideoAdInfo);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    if ((paramAdvertisementInfo == null) && (paramVideoAdInfo == null)) {
      return false;
    }
    int i = -1;
    if (paramAdvertisementInfo != null) {
      i = b(paramAdvertisementInfo.mAdExtInfo, 6);
    }
    if (paramVideoAdInfo != null) {
      i = b(paramVideoAdInfo.R, 6);
    }
    if (QLog.isColorLevel())
    {
      paramAdvertisementInfo = new StringBuilder();
      paramAdvertisementInfo.append("isServerRspReport->value:");
      paramAdvertisementInfo.append(i);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramAdvertisementInfo.toString());
    }
    return i == 1;
  }
  
  public static boolean a(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, 1) == 1;
  }
  
  public static boolean a(AdData paramAdData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNewExposureProtocol->adData:");
      localStringBuilder.append(paramAdData);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    if (paramAdData == null) {
      return false;
    }
    int i = -1;
    if (paramAdData != null) {
      i = a(paramAdData.F, 7);
    }
    return i == 1;
  }
  
  public static boolean a(AdData paramAdData, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNewClickOrNegativeProtocol->adData:");
      localStringBuilder.append(paramAdData);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    if (paramAdData == null) {
      return false;
    }
    int i = -1;
    if (paramAdData != null) {
      if (!paramBoolean) {
        i = a(paramAdData.F, 13);
      } else {
        i = a(paramAdData.F, 14);
      }
    }
    return i == 1;
  }
  
  public static int b(AdvertisementInfo paramAdvertisementInfo)
  {
    return a(paramAdvertisementInfo);
  }
  
  private static int b(String paramString, int paramInt)
  {
    return a("ad_switchs", paramString, paramInt);
  }
  
  public static boolean b(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, 1) == 2;
  }
  
  public static boolean b(AdData paramAdData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDirectPlay->AdData:");
      localStringBuilder.append(paramAdData);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    boolean bool = false;
    if (paramAdData == null) {
      return false;
    }
    int i = a(paramAdData.F, 10);
    if (QLog.isColorLevel())
    {
      paramAdData = new StringBuilder();
      paramAdData.append("isDirectPlay->value:");
      paramAdData.append(i);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramAdData.toString());
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static int c(AdvertisementInfo paramAdvertisementInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFeedsAdStyle->AdvertisementInfo:");
      localStringBuilder.append(paramAdvertisementInfo);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    if (paramAdvertisementInfo == null) {
      return 0;
    }
    int j = b(paramAdvertisementInfo.mAdExtInfo, 4);
    if (QLog.isColorLevel())
    {
      paramAdvertisementInfo = new StringBuilder();
      paramAdvertisementInfo.append("getFeedsAdStyle->value:");
      paramAdvertisementInfo.append(j);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramAdvertisementInfo.toString());
    }
    int i = j;
    if (j == -1) {
      i = 0;
    }
    return i;
  }
  
  public static boolean c(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, 5) == 1;
  }
  
  public static boolean c(AdData paramAdData)
  {
    boolean bool = false;
    if (paramAdData == null) {
      return false;
    }
    if (a(paramAdData.F, 16) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean d(AdvertisementInfo paramAdvertisementInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isADVideoDownloadProgress->AdvertisementInfo:");
      ((StringBuilder)localObject).append(paramAdvertisementInfo);
      QLog.d("ReadInJoyAdSwitchUtil", 2, ((StringBuilder)localObject).toString());
    }
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 8);
    Object localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adInfo.name = ");
    localStringBuilder.append(paramAdvertisementInfo.mTitle);
    localStringBuilder.append(" showProgress = ");
    boolean bool;
    if (i == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    ((IRIJAdLogService)localObject).d("AD_DOWNLOAD_TAG", localStringBuilder.toString());
    return i == 1;
  }
  
  public static boolean d(VideoAdInfo paramVideoAdInfo)
  {
    int i = a(paramVideoAdInfo, 8);
    boolean bool2 = false;
    if (paramVideoAdInfo != null)
    {
      IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adInfo.name = ");
      localStringBuilder.append(paramVideoAdInfo.x);
      localStringBuilder.append(" showProgress = ");
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      localIRIJAdLogService.d("AD_DOWNLOAD_TAG", localStringBuilder.toString());
    }
    boolean bool1 = bool2;
    if (i == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean d(AdData paramAdData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isAmsSubcribeEnable->adData:");
      localStringBuilder.append(paramAdData);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    boolean bool = false;
    if (paramAdData == null) {
      return false;
    }
    int i = a(paramAdData.F, 15);
    if (QLog.isColorLevel())
    {
      paramAdData = new StringBuilder();
      paramAdData.append("isAmsSubcribeEnable->value:");
      paramAdData.append(i);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramAdData.toString());
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean e(AdvertisementInfo paramAdvertisementInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDirectPlay->AdvertisementInfo:");
      localStringBuilder.append(paramAdvertisementInfo);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    boolean bool = false;
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 10);
    if (QLog.isColorLevel())
    {
      paramAdvertisementInfo = new StringBuilder();
      paramAdvertisementInfo.append("isDirectPlay->value:");
      paramAdvertisementInfo.append(i);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramAdvertisementInfo.toString());
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean e(VideoAdInfo paramVideoAdInfo)
  {
    int i = a(paramVideoAdInfo, 11);
    if (QLog.isColorLevel())
    {
      paramVideoAdInfo = new StringBuilder();
      paramVideoAdInfo.append("SWITCH_POS_VIDEO_CIRCLE->extValue:");
      paramVideoAdInfo.append(i);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramVideoAdInfo.toString());
    }
    return i == 1;
  }
  
  public static boolean e(AdData paramAdData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isTelephoneComponentForDetail->AdData:");
      localStringBuilder.append(paramAdData);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    boolean bool = false;
    if (paramAdData == null) {
      return false;
    }
    int i = a(paramAdData.F, 18);
    if (QLog.isColorLevel())
    {
      paramAdData = new StringBuilder();
      paramAdData.append("isTelephoneComponentForDetail->value:");
      paramAdData.append(i);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramAdData.toString());
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean f(AdvertisementInfo paramAdvertisementInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isAdjustAdExposure->AdvertisementInfo:");
      localStringBuilder.append(paramAdvertisementInfo);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    boolean bool = false;
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 17);
    if (QLog.isColorLevel())
    {
      paramAdvertisementInfo = new StringBuilder();
      paramAdvertisementInfo.append("SWITCH_POS_VIDEO_SWITCH->extValue:");
      paramAdvertisementInfo.append(i);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramAdvertisementInfo.toString());
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean f(VideoAdInfo paramVideoAdInfo)
  {
    int i = a(paramVideoAdInfo, 12);
    if (QLog.isColorLevel())
    {
      paramVideoAdInfo = new StringBuilder();
      paramVideoAdInfo.append("SWITCH_POS_VIDEO_SWITCH->extValue:");
      paramVideoAdInfo.append(i);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramVideoAdInfo.toString());
    }
    return i == 1;
  }
  
  public static int g(AdvertisementInfo paramAdvertisementInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVideoClickZoneSwitch->AdvertisementInfo:");
      localStringBuilder.append(paramAdvertisementInfo);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    if (paramAdvertisementInfo == null) {
      return 0;
    }
    int j = b(paramAdvertisementInfo.mAdExtInfo, 19);
    if (QLog.isColorLevel())
    {
      paramAdvertisementInfo = new StringBuilder();
      paramAdvertisementInfo.append("getVideoClickZoneSwitch->value:");
      paramAdvertisementInfo.append(j);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramAdvertisementInfo.toString());
    }
    int i = j;
    if (j == -1) {
      i = 0;
    }
    return i;
  }
  
  public static boolean g(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, 20) == 1;
  }
  
  public static boolean h(AdvertisementInfo paramAdvertisementInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isAmsSubcribeEnable->AdvertisementInfo:");
      localStringBuilder.append(paramAdvertisementInfo);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    boolean bool = false;
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 15);
    if (QLog.isColorLevel())
    {
      paramAdvertisementInfo = new StringBuilder();
      paramAdvertisementInfo.append("isAmsSubcribeEnable->value:");
      paramAdvertisementInfo.append(i);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramAdvertisementInfo.toString());
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean i(AdvertisementInfo paramAdvertisementInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isTelephoneComponent->AdData:");
      localStringBuilder.append(paramAdvertisementInfo);
      QLog.d("ReadInJoyAdSwitchUtil", 2, localStringBuilder.toString());
    }
    boolean bool = false;
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 18);
    if (QLog.isColorLevel())
    {
      paramAdvertisementInfo = new StringBuilder();
      paramAdvertisementInfo.append("isTelephoneComponent->value:");
      paramAdvertisementInfo.append(i);
      QLog.d("ReadInJoyAdSwitchUtil", 2, paramAdvertisementInfo.toString());
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean j(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = false;
    if (paramAdvertisementInfo == null) {
      return false;
    }
    if (b(paramAdvertisementInfo.mAdExtInfo, 16) == 1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil
 * JD-Core Version:    0.7.0.1
 */
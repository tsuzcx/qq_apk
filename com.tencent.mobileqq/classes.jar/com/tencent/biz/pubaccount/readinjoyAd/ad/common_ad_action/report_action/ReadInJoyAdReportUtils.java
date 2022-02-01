package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action;

import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.ReadInJoyCommonSoftAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.SoftAdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdTest;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoyAdReportUtils
{
  public static AdReportData a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, Integer paramInteger)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    paramInteger = new AdReportData().a(localQQAppInterface).a(BaseApplication.getContext()).a(paramInt2).b(paramInt1).b(paramInteger).a(paramAdvertisementInfo).d(NativeAdUtils.a(paramAdvertisementInfo));
    if (paramAdvertisementInfo.mReportDataJson != null) {
      paramInteger.c(paramAdvertisementInfo.mReportDataJson);
    }
    return paramInteger;
  }
  
  public static void a(ReportAction paramReportAction, Integer paramInteger, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramReportAction, paramInteger, paramAdvertisementInfo, paramInt1, paramInt2, paramInt3, false);
  }
  
  public static void a(ReportAction paramReportAction, Integer paramInteger, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    a(paramReportAction, paramInteger, paramAdvertisementInfo, paramInt1, paramInt2, paramInt3, paramBoolean, false);
  }
  
  public static void a(ReportAction paramReportAction, Integer paramInteger, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramReportAction, paramInteger, paramAdvertisementInfo, paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, null);
  }
  
  public static void a(ReportAction paramReportAction, Integer paramInteger, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, SoftAdReportData paramSoftAdReportData)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    if ((paramInteger.intValue() == 10) && (paramInt2 == 1)) {
      paramInt1 = 8;
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyAdReportUtils.1(paramAdvertisementInfo, paramInt2, paramInt3, paramBoolean1, paramInteger, paramReportAction, paramInt1, paramBoolean2, paramSoftAdReportData));
      return;
    }
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    a(null, Integer.valueOf(0), paramAdvertisementInfo, paramInt1, paramInt2, paramInt3, false);
  }
  
  public static void a(Integer paramInteger, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    a(null, paramInteger, paramAdvertisementInfo, paramInt1, paramInt2, paramInt3, false);
  }
  
  private static void b(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, Integer paramInteger, ReportAction paramReportAction, boolean paramBoolean2, SoftAdReportData paramSoftAdReportData)
  {
    int j = paramAdvertisementInfo.clickPos;
    paramInt1 = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramInt3 == 3)
    {
      localObject1 = null;
      paramInt1 = 2;
    }
    for (;;)
    {
      int i = ReadInJoyCommonSoftAdUtils.a(paramAdvertisementInfo);
      paramSoftAdReportData = ReadInJoyCommonSoftAdUtils.a(paramAdvertisementInfo, paramInt2, j, ReadInJoyCommonSoftAdUtils.a(paramAdvertisementInfo.downloadState, false), paramInt1, i, paramBoolean2, paramSoftAdReportData);
      paramInteger = a(paramAdvertisementInfo, 35, paramInt2, paramInteger).a(paramReportAction).e(paramSoftAdReportData).a((ActionEntity)localObject1);
      if (paramBoolean1) {}
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        NativeAdUtils.a(paramInteger.a(Integer.valueOf(paramInt1)).b(paramBoolean1));
        ReadInJoyAdLog.a("ReadInJoyAdReportUtils", "softAdReport: scene = " + paramInt3 + " advertisementInfo = " + paramAdvertisementInfo.toString());
        if (paramAdvertisementInfo.mAdvertisementSoftInfo != null) {
          break label387;
        }
        return;
        if (paramInt3 == 4)
        {
          localObject1 = ActionEntity.ArticleFloat;
          paramInt1 = 7;
          break;
        }
        if (paramInt3 != 5) {
          break label492;
        }
        if (paramAdvertisementInfo.mAdvertisementSoftInfo != null)
        {
          localObject1 = localObject2;
          if (paramBoolean2)
          {
            localObject1 = localObject2;
            if (paramInt2 == 2) {
              localObject1 = ActionEntity.VIDEO_SOFT_AD_GUIDE;
            }
          }
          if (paramBoolean2) {
            break label281;
          }
          if (!VideoFeedsSoftAdBarDelegateForAd.a(paramAdvertisementInfo)) {
            break label275;
          }
          paramInt1 = 10;
        }
        for (;;)
        {
          i = paramInt1;
          if (paramAdvertisementInfo.mAdvertisementSoftInfo == null) {
            break label486;
          }
          i = paramInt1;
          if (!VideoFeedsSoftAdTest.a(paramAdvertisementInfo.mAdvertisementSoftInfo)) {
            break label486;
          }
          i = paramInt1;
          if (paramSoftAdReportData == null) {
            break label486;
          }
          paramInt1 = paramSoftAdReportData.b;
          if ((!paramBoolean2) || (paramInt2 != 2) || (paramInt1 != 14)) {
            break label349;
          }
          localObject1 = ActionEntity.VIDEO_SOFT_AD_QUESTION_GUIDE;
          break;
          label275:
          paramInt1 = 8;
          continue;
          label281:
          if (paramAdvertisementInfo.mAdvertisementSoftInfo.c == 0)
          {
            paramInt1 = 13;
            localObject1 = ActionEntity.VIDEO_SOFT_AD_AMS_GUIDE;
          }
          else if ((paramAdvertisementInfo.mAdvertisementSoftInfo.C != null) && (paramAdvertisementInfo.mAdvertisementSoftInfo.C.equals("white")))
          {
            paramInt1 = 11;
            localObject1 = ActionEntity.VIDEO_SOFT_AD_WHITE_GUIDE;
          }
          else
          {
            paramInt1 = 12;
            localObject1 = ActionEntity.VIDEO_SOFT_AD_BLACK_GUIDE;
          }
        }
        label349:
        i = paramInt1;
        if (!paramBoolean2) {
          break label486;
        }
        i = paramInt1;
        if (paramInt2 != 2) {
          break label486;
        }
        i = paramInt1;
        if (paramInt1 != 14) {
          break label486;
        }
        localObject1 = ActionEntity.VIDEO_SOFT_AD_MOTIVE_GUIDE;
        break;
      }
      label387:
      paramReportAction = null;
      if (paramInt2 == 1)
      {
        paramInteger = paramReportAction;
        if (!paramAdvertisementInfo.mAdvertisementSoftInfo.a)
        {
          paramInteger = paramAdvertisementInfo.mAdvertisementSoftInfo.Q;
          paramAdvertisementInfo.mAdvertisementSoftInfo.a = true;
        }
      }
      for (;;)
      {
        ThreadManager.getSubThreadHandler().post(new ReadInJoyAdReportUtils.2(paramInteger));
        return;
        paramInteger = paramReportAction;
        if (paramInt2 == 2)
        {
          paramInteger = paramReportAction;
          if (!paramAdvertisementInfo.mAdvertisementSoftInfo.b)
          {
            paramInteger = paramAdvertisementInfo.mAdvertisementSoftInfo.R;
            paramAdvertisementInfo.mAdvertisementSoftInfo.b = true;
          }
        }
      }
      label486:
      paramInt1 = i;
      continue;
      label492:
      localObject1 = null;
      paramInt1 = 0;
    }
  }
  
  private static void c(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, boolean paramBoolean, Integer paramInteger, ReportAction paramReportAction)
  {
    int i = 2;
    long l1;
    long l2;
    label25:
    Object localObject;
    if (paramInt1 == 2)
    {
      l1 = 6L;
      if (!FastWeqAdUtils.b(paramAdvertisementInfo)) {
        break label157;
      }
      l2 = 3010304L;
      String str = GameComponentReport.a(FastWeqAdUtils.c(paramAdvertisementInfo), FastWeqAdUtils.b(paramAdvertisementInfo), paramAdvertisementInfo.downloadState);
      if (paramInt2 != 3) {
        break label165;
      }
      localObject = "2";
      label52:
      localObject = GameComponentReport.a(paramAdvertisementInfo, l2, l1, str, (String)localObject);
      paramInteger = a(paramAdvertisementInfo, 39, 119, paramInteger).a(paramReportAction).e((JSONObject)localObject);
      if (!paramBoolean) {
        break label173;
      }
    }
    label157:
    label165:
    label173:
    for (paramInt1 = i;; paramInt1 = 1)
    {
      NativeAdUtils.a(paramInteger.a(Integer.valueOf(paramInt1)).b(paramBoolean));
      ReadInJoyAdLog.a("ReadInJoyAdReportUtils", "gameAdReport: scene = " + paramInt2 + " advertisementInfo = " + paramAdvertisementInfo.toString());
      return;
      l1 = 9L;
      break;
      l2 = 3010204L;
      break label25;
      localObject = "1";
      break label52;
    }
  }
  
  private static void d(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, boolean paramBoolean, Integer paramInteger, ReportAction paramReportAction)
  {
    paramInteger = a(paramAdvertisementInfo, paramInt1, paramInt2, paramInteger).a(paramReportAction);
    if (paramBoolean) {}
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      NativeAdUtils.a(paramInteger.a(Integer.valueOf(paramInt1)).b(paramBoolean));
      ReadInJoyAdLog.a("ReadInJoyAdReportUtils", "normalAdReport: advertisementInfo = " + paramAdvertisementInfo.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils
 * JD-Core Version:    0.7.0.1
 */
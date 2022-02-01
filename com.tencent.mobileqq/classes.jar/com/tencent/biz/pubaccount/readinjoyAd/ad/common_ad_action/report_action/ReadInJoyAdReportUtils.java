package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action;

import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.ReadInJoyCommonSoftAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.SoftAdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdTest;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoyAdReportUtils
{
  public static AdReportData a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, Integer paramInteger)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    paramInteger = new AdReportData().a(localQQAppInterface).a(BaseApplication.getContext()).a(paramInt2).b(paramInt1).b(paramInteger).a(paramAdvertisementInfo).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdvertisementInfo));
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
    ThreadManager.getSubThreadHandler().post(new ReadInJoyAdReportUtils.1(paramAdvertisementInfo, paramInt2, paramInt3, paramBoolean1, paramInteger, paramReportAction, paramInt1, paramBoolean2, paramSoftAdReportData));
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
    Object localObject3 = null;
    Object localObject1;
    if (paramInt3 == 3)
    {
      if ((paramAdvertisementInfo.mAdvertisementSoftInfo != null) && (paramAdvertisementInfo.mAdvertisementSoftInfo.o == 3))
      {
        localObject1 = null;
        paramInt1 = 16;
      }
      else
      {
        localObject1 = null;
        paramInt1 = 2;
      }
    }
    else if (paramInt3 == 4)
    {
      localObject1 = ActionEntity.ArticleFloat;
      paramInt1 = 7;
    }
    else if (paramInt3 == 5)
    {
      if (paramAdvertisementInfo.mAdvertisementSoftInfo != null)
      {
        if ((paramBoolean2) && (paramInt2 == 2)) {
          localObject1 = ActionEntity.VIDEO_SOFT_AD_GUIDE;
        } else {
          localObject1 = null;
        }
        if (!paramBoolean2)
        {
          if (VideoFeedsSoftAdBarDelegateForAd.a(paramAdvertisementInfo)) {
            paramInt1 = 10;
          } else {
            paramInt1 = 8;
          }
        }
        else if (paramAdvertisementInfo.mAdvertisementSoftInfo.o == 0)
        {
          paramInt1 = 13;
          localObject1 = ActionEntity.VIDEO_SOFT_AD_AMS_GUIDE;
        }
        else if ((paramAdvertisementInfo.mAdvertisementSoftInfo.M != null) && (paramAdvertisementInfo.mAdvertisementSoftInfo.M.equals("white")))
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
      else
      {
        localObject1 = null;
        paramInt1 = 0;
      }
      i = paramInt1;
      Object localObject2 = localObject1;
      if (paramAdvertisementInfo.mAdvertisementSoftInfo != null)
      {
        i = paramInt1;
        localObject2 = localObject1;
        if (VideoFeedsSoftAdTest.a(paramAdvertisementInfo.mAdvertisementSoftInfo))
        {
          i = paramInt1;
          localObject2 = localObject1;
          if (paramSoftAdReportData != null)
          {
            paramInt1 = paramSoftAdReportData.b;
            if ((paramBoolean2) && (paramInt1 == 14))
            {
              localObject2 = ActionEntity.VIDEO_SOFT_AD_QUESTION_GUIDE;
              i = paramInt1;
            }
            else
            {
              i = paramInt1;
              localObject2 = localObject1;
              if (paramBoolean2)
              {
                i = paramInt1;
                localObject2 = localObject1;
                if (paramInt1 == 15)
                {
                  localObject2 = ActionEntity.VIDEO_SOFT_AD_MOTIVE_GUIDE;
                  i = paramInt1;
                }
              }
            }
          }
        }
      }
      paramInt1 = i;
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = null;
      paramInt1 = 0;
    }
    int i = ReadInJoyCommonSoftAdUtils.a(paramAdvertisementInfo);
    paramSoftAdReportData = ReadInJoyCommonSoftAdUtils.a(paramAdvertisementInfo, paramInt2, j, ReadInJoyCommonSoftAdUtils.a(paramAdvertisementInfo.downloadState, false), paramInt1, i, paramBoolean2, paramSoftAdReportData);
    paramInteger = a(paramAdvertisementInfo, 35, paramInt2, paramInteger).a(paramReportAction).e(paramSoftAdReportData).a((ActionEntity)localObject1);
    if (paramBoolean1) {
      paramInt1 = 2;
    } else {
      paramInt1 = 1;
    }
    paramInteger = paramInteger.a(Integer.valueOf(paramInt1)).b(paramBoolean1);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(paramInteger);
    paramInteger = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    paramReportAction = new StringBuilder();
    paramReportAction.append("softAdReport: scene = ");
    paramReportAction.append(paramInt3);
    paramReportAction.append(" advertisementInfo = ");
    paramReportAction.append(paramAdvertisementInfo.toString());
    paramInteger.d("ReadInJoyAdReportUtils", paramReportAction.toString());
    if (paramAdvertisementInfo.mAdvertisementSoftInfo == null) {
      return;
    }
    if (paramInt2 == 1)
    {
      paramInteger = localObject3;
      if (!paramAdvertisementInfo.mAdvertisementSoftInfo.a)
      {
        paramInteger = paramAdvertisementInfo.mAdvertisementSoftInfo.ab;
        paramAdvertisementInfo.mAdvertisementSoftInfo.a = true;
      }
    }
    else
    {
      paramInteger = localObject3;
      if (paramInt2 == 2)
      {
        paramInteger = localObject3;
        if (!paramAdvertisementInfo.mAdvertisementSoftInfo.b)
        {
          paramInteger = paramAdvertisementInfo.mAdvertisementSoftInfo.ac;
          paramAdvertisementInfo.mAdvertisementSoftInfo.b = true;
        }
      }
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyAdReportUtils.2(paramInteger));
  }
  
  private static void c(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, boolean paramBoolean, Integer paramInteger, ReportAction paramReportAction)
  {
    int i = 2;
    long l2;
    if (paramInt1 == 2) {
      l2 = 6L;
    } else {
      l2 = 9L;
    }
    if (paramAdvertisementInfo.clickPos == 8)
    {
      if (FastWeqAdUtils.d(paramAdvertisementInfo))
      {
        l1 = 3010205L;
      }
      else if (FastWeqAdUtils.b(paramAdvertisementInfo))
      {
        l1 = 3010305L;
      }
      else if (FastWeqAdUtils.f(paramAdvertisementInfo))
      {
        l1 = 3010405L;
      }
      else
      {
        if (!FastWeqAdUtils.e(paramAdvertisementInfo)) {
          break label145;
        }
        l1 = 3010505L;
      }
    }
    else
    {
      if (!FastWeqAdUtils.d(paramAdvertisementInfo)) {
        break label105;
      }
      l1 = 3010204L;
    }
    for (;;)
    {
      break label150;
      label105:
      if (FastWeqAdUtils.b(paramAdvertisementInfo))
      {
        l1 = 3010304L;
      }
      else
      {
        if ((FastWeqAdUtils.f(paramAdvertisementInfo)) || (!FastWeqAdUtils.e(paramAdvertisementInfo))) {
          break;
        }
        l1 = 3010504L;
      }
    }
    label145:
    long l1 = 3010404L;
    label150:
    String str = GameComponentReport.a(FastWeqAdUtils.d(paramAdvertisementInfo), FastWeqAdUtils.b(paramAdvertisementInfo), paramAdvertisementInfo.downloadState);
    if (paramInt2 == 3) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    Object localObject = GameComponentReport.a(paramAdvertisementInfo, l1, l2, str, (String)localObject);
    paramInteger = a(paramAdvertisementInfo, 39, 119, paramInteger).a(paramReportAction).e((JSONObject)localObject);
    if (paramBoolean) {
      paramInt1 = i;
    } else {
      paramInt1 = 1;
    }
    paramInteger = paramInteger.a(Integer.valueOf(paramInt1)).b(paramBoolean);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(paramInteger);
    paramInteger = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    paramReportAction = new StringBuilder();
    paramReportAction.append("gameAdReport: scene = ");
    paramReportAction.append(paramInt2);
    paramReportAction.append(" advertisementInfo = ");
    paramReportAction.append(paramAdvertisementInfo.toString());
    paramInteger.d("ReadInJoyAdReportUtils", paramReportAction.toString());
  }
  
  private static void d(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, boolean paramBoolean, Integer paramInteger, ReportAction paramReportAction)
  {
    int j = paramAdvertisementInfo.mCommentAdReportType;
    int i = 1;
    if (-1 != j) {
      if (paramAdvertisementInfo.mCommentAdReportType == 2) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
    paramInteger = a(paramAdvertisementInfo, paramInt1, paramInt2, paramInteger).a(paramReportAction);
    paramInt1 = i;
    if (paramBoolean) {
      paramInt1 = 2;
    }
    paramInteger = paramInteger.a(Integer.valueOf(paramInt1)).b(paramBoolean);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(paramInteger);
    paramInteger = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    paramReportAction = new StringBuilder();
    paramReportAction.append("normalAdReport: advertisementInfo = ");
    paramReportAction.append(paramAdvertisementInfo.toString());
    paramInteger.d("ReadInJoyAdReportUtils", paramReportAction.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils
 * JD-Core Version:    0.7.0.1
 */
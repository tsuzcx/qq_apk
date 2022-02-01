package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadClickState;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdDownloadReport;", "", "()V", "getApnType", "", "getClickFrom", "", "advertisementInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "getOrigin", "reportAdDownloadClick", "", "context", "Landroid/content/Context;", "state", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/DownloadClickState;", "adInfo", "ex5", "reportBeacon", "action", "downloadInfo", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "reportDownloadFinish", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJAdDownloadReport
{
  public static final RIJAdDownloadReport a = new RIJAdDownloadReport();
  
  static
  {
    UserAction.registerTunnel(new TunnelInfo("000000EYXY3ATYB3"));
  }
  
  private final int a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null) {
      paramAdvertisementInfo = Long.valueOf(paramAdvertisementInfo.mChannelID);
    } else {
      paramAdvertisementInfo = null;
    }
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.longValue() == 0L)) {
      return 1;
    }
    long l = 56;
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.longValue() == l)) {
      return 5;
    }
    return 3;
  }
  
  private final String a()
  {
    int i = NetworkUtil.getNetworkType((Context)BaseApplication.getContext());
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 6) {
                return "非wifi";
              }
              return "5G";
            }
            return "4G";
          }
          return "3G";
        }
        return "2G";
      }
      return "wifi";
    }
    return "other";
  }
  
  private final int b(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null) {
      paramAdvertisementInfo = Long.valueOf(paramAdvertisementInfo.mChannelID);
    } else {
      paramAdvertisementInfo = null;
    }
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.longValue() == 0L)) {
      return 3;
    }
    long l = 56;
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.longValue() == l)) {
      return 5;
    }
    return 1;
  }
  
  public final void a(@Nullable Context paramContext, @Nullable AdvertisementInfo paramAdvertisementInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "ex5");
    boolean bool = RIJAdDownloadExKt.e(paramAdvertisementInfo);
    Integer localInteger = Integer.valueOf(0);
    if ((!bool) && (!RIJAdDownloadExKt.g(paramAdvertisementInfo)))
    {
      if (RIJAdDownloadExKt.d(paramAdvertisementInfo))
      {
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.clickPos = 1;
        }
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.downloadState = 4;
        }
        ReadInJoyAdReportUtils.a(localInteger, paramAdvertisementInfo, 35, 1, a(paramAdvertisementInfo));
        return;
      }
      paramContext = new AdReportData().a(paramContext).a(5).b(b(paramAdvertisementInfo)).a(paramAdvertisementInfo).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdvertisementInfo, new HashMap()));
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(paramContext);
      return;
    }
    if (RIJAdDownloadExKt.e(paramAdvertisementInfo)) {
      paramContext = "2";
    } else {
      paramContext = "1";
    }
    long l;
    if (RIJAdDownloadExKt.e(paramAdvertisementInfo)) {
      l = 3010205L;
    } else {
      l = 3010307L;
    }
    GameComponentReport.a(localInteger, paramAdvertisementInfo, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdvertisementInfo), GameComponentReport.a(paramAdvertisementInfo, l, 9L, paramContext, paramString));
  }
  
  public final void a(@NotNull Context paramContext, @NotNull DownloadClickState paramDownloadClickState, @Nullable AdvertisementInfo paramAdvertisementInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramDownloadClickState, "state");
    Intrinsics.checkParameterIsNotNull(paramString, "ex5");
    int i = RIJAdDownloadReport.WhenMappings.a[paramDownloadClickState.ordinal()];
    long l = 3010205L;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            if ((!RIJAdDownloadExKt.e(paramAdvertisementInfo)) && (!RIJAdDownloadExKt.g(paramAdvertisementInfo)))
            {
              if (RIJAdDownloadExKt.d(paramAdvertisementInfo))
              {
                if (paramAdvertisementInfo != null) {
                  paramAdvertisementInfo.clickPos = 1;
                }
                if (paramAdvertisementInfo != null) {
                  paramAdvertisementInfo.downloadState = 6;
                }
                if (paramAdvertisementInfo != null) {
                  paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
                }
                ReadInJoyAdReportUtils.a(ReportAction.CLICK, Integer.valueOf(15), paramAdvertisementInfo, 35, 1, a(paramAdvertisementInfo));
                return;
              }
              paramContext = new AdReportData().a(paramContext).a(1).b(b(paramAdvertisementInfo)).b(Integer.valueOf(15)).a(paramAdvertisementInfo).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdvertisementInfo, new HashMap()));
              ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(paramContext);
              return;
            }
            if (RIJAdDownloadExKt.e(paramAdvertisementInfo)) {
              l = 3010205L;
            } else {
              l = 3010307L;
            }
            if (paramAdvertisementInfo != null) {
              paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
            }
            GameComponentReport.a(Integer.valueOf(15), paramAdvertisementInfo, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdvertisementInfo), GameComponentReport.a(paramAdvertisementInfo, l, 9L, "5", paramString));
            return;
          }
          if ((!RIJAdDownloadExKt.e(paramAdvertisementInfo)) && (!RIJAdDownloadExKt.g(paramAdvertisementInfo)))
          {
            if (RIJAdDownloadExKt.d(paramAdvertisementInfo))
            {
              if (paramAdvertisementInfo != null) {
                paramAdvertisementInfo.clickPos = 1;
              }
              if (paramAdvertisementInfo != null) {
                paramAdvertisementInfo.downloadState = 5;
              }
              if (paramAdvertisementInfo != null) {
                paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
              }
              ReadInJoyAdReportUtils.a(ReportAction.CLICK, Integer.valueOf(18), paramAdvertisementInfo, 35, 1, a(paramAdvertisementInfo));
              return;
            }
            paramContext = new AdReportData().a(paramContext).a(1).b(Integer.valueOf(18)).b(8).a(paramAdvertisementInfo).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdvertisementInfo, new HashMap()));
            ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(paramContext);
            return;
          }
          if (RIJAdDownloadExKt.e(paramAdvertisementInfo)) {
            l = 3010205L;
          } else {
            l = 3010307L;
          }
          if (paramAdvertisementInfo != null) {
            paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
          }
          GameComponentReport.a(Integer.valueOf(18), paramAdvertisementInfo, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdvertisementInfo), GameComponentReport.a(paramAdvertisementInfo, l, 9L, "6", paramString));
          return;
        }
        if ((!RIJAdDownloadExKt.e(paramAdvertisementInfo)) && (!RIJAdDownloadExKt.g(paramAdvertisementInfo)))
        {
          if (RIJAdDownloadExKt.d(paramAdvertisementInfo))
          {
            if (paramAdvertisementInfo != null) {
              paramAdvertisementInfo.clickPos = 1;
            }
            if (paramAdvertisementInfo != null) {
              paramAdvertisementInfo.downloadState = 3;
            }
            if (paramAdvertisementInfo != null) {
              paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
            }
            ReadInJoyAdReportUtils.a(ReportAction.CLICK, Integer.valueOf(14), paramAdvertisementInfo, 8, 1, a(paramAdvertisementInfo));
            return;
          }
          ReadInJoyAdReportUtils.a(ReportAction.CLICK, Integer.valueOf(14), paramAdvertisementInfo, 8, 1, a(paramAdvertisementInfo));
          return;
        }
        if (!RIJAdDownloadExKt.e(paramAdvertisementInfo)) {
          l = 3010307L;
        }
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
        }
        GameComponentReport.a(Integer.valueOf(14), paramAdvertisementInfo, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdvertisementInfo), GameComponentReport.a(paramAdvertisementInfo, l, 9L, "9", paramString));
        return;
      }
      if ((!RIJAdDownloadExKt.e(paramAdvertisementInfo)) && (!RIJAdDownloadExKt.g(paramAdvertisementInfo)))
      {
        if (RIJAdDownloadExKt.d(paramAdvertisementInfo))
        {
          if (paramAdvertisementInfo != null) {
            paramAdvertisementInfo.clickPos = 1;
          }
          if (paramAdvertisementInfo != null) {
            paramAdvertisementInfo.downloadState = 2;
          }
          if (paramAdvertisementInfo != null) {
            paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
          }
          ReadInJoyAdReportUtils.a(ReportAction.CLICK, Integer.valueOf(13), paramAdvertisementInfo, 8, 1, a(paramAdvertisementInfo));
          return;
        }
        ReadInJoyAdReportUtils.a(ReportAction.CLICK, Integer.valueOf(13), paramAdvertisementInfo, 8, 1, a(paramAdvertisementInfo));
        return;
      }
      if (!RIJAdDownloadExKt.e(paramAdvertisementInfo)) {
        l = 3010307L;
      }
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
      }
      GameComponentReport.a(Integer.valueOf(13), paramAdvertisementInfo, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdvertisementInfo), GameComponentReport.a(paramAdvertisementInfo, l, 9L, "8", paramString));
      return;
    }
    if ((!RIJAdDownloadExKt.e(paramAdvertisementInfo)) && (!RIJAdDownloadExKt.g(paramAdvertisementInfo)))
    {
      if (RIJAdDownloadExKt.d(paramAdvertisementInfo))
      {
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.clickPos = 1;
        }
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.downloadState = 1;
        }
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
        }
        ReadInJoyAdReportUtils.a(ReportAction.CLICK, Integer.valueOf(3), paramAdvertisementInfo, 35, 1, a(paramAdvertisementInfo));
        return;
      }
      ReadInJoyAdReportUtils.a(ReportAction.CLICK, Integer.valueOf(3), paramAdvertisementInfo, 20, 1, a(paramAdvertisementInfo));
      return;
    }
    if (RIJAdDownloadExKt.e(paramAdvertisementInfo)) {
      l = 3010205L;
    } else {
      l = 3010307L;
    }
    if (RIJAdDownloadExKt.e(paramAdvertisementInfo)) {
      paramContext = "1";
    } else {
      paramContext = "0";
    }
    if (paramAdvertisementInfo != null) {
      paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
    }
    GameComponentReport.a(Integer.valueOf(3), paramAdvertisementInfo, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdvertisementInfo), GameComponentReport.a(paramAdvertisementInfo, l, 9L, paramContext, paramString));
  }
  
  public final void a(@NotNull String paramString, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    HashMap localHashMap = new HashMap();
    String str1 = "";
    if (paramAdDownloadInfo != null)
    {
      localObject = paramAdDownloadInfo.a();
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    localHashMap.put("packageName", localObject);
    if (paramAdDownloadInfo != null)
    {
      localObject = paramAdDownloadInfo.c();
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    localHashMap.put("appId", localObject);
    Object localObject = str1;
    if (paramAdDownloadInfo != null)
    {
      String str2 = String.valueOf(paramAdDownloadInfo.a());
      localObject = str1;
      if (str2 != null) {
        localObject = str2;
      }
    }
    localHashMap.put("pkgSize", localObject);
    localHashMap.put("apnType", a.a());
    str1 = null;
    if (paramAdDownloadInfo != null) {
      localObject = Integer.valueOf(paramAdDownloadInfo.c());
    } else {
      localObject = null;
    }
    localHashMap.put("errorCode", String.valueOf(localObject));
    localHashMap.put("action", paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportDownloadBeacon: packageName = ");
    if (paramAdDownloadInfo != null) {
      paramAdDownloadInfo = paramAdDownloadInfo.a();
    } else {
      paramAdDownloadInfo = null;
    }
    ((StringBuilder)localObject).append(paramAdDownloadInfo);
    ((StringBuilder)localObject).append(" action = ");
    ((StringBuilder)localObject).append(paramString);
    ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", ((StringBuilder)localObject).toString());
    paramAdDownloadInfo = ((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
    paramString = str1;
    if (paramAdDownloadInfo != null) {
      paramString = paramAdDownloadInfo.getApplication();
    }
    paramString = StatisticCollector.getInstance((Context)paramString);
    paramAdDownloadInfo = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramAdDownloadInfo, "BaseApplicationImpl.getApplication()");
    paramAdDownloadInfo = paramAdDownloadInfo.getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(paramAdDownloadInfo, "BaseApplicationImpl.getApplication().runtime");
    paramString.collectPerformance("000000EYXY3ATYB3", paramAdDownloadInfo.getAccount(), "actKandianAdDownload", true, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadReport
 * JD-Core Version:    0.7.0.1
 */
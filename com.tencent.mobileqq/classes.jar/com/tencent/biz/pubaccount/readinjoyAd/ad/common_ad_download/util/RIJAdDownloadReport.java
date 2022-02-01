package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadClickState;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdDownloadReport;", "", "()V", "getApnType", "", "getClickFrom", "", "advertisementInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "getOrigin", "reportAdDownloadClick", "", "context", "Landroid/content/Context;", "state", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/DownloadClickState;", "adInfo", "ex5", "reportBeacon", "action", "downloadInfo", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "reportDownloadFinish", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJAdDownloadReport
{
  public static final RIJAdDownloadReport a = new RIJAdDownloadReport();
  
  static
  {
    UserAction.registerTunnel(new TunnelInfo("000000EYXY3ATYB3"));
  }
  
  private final int a(AdvertisementInfo paramAdvertisementInfo)
  {
    label16:
    long l;
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo = Long.valueOf(paramAdvertisementInfo.mChannelID);
      if (paramAdvertisementInfo != null) {
        break label31;
      }
      l = 56;
      if (paramAdvertisementInfo != null) {
        break label42;
      }
    }
    label31:
    label42:
    while (paramAdvertisementInfo.longValue() != l)
    {
      return 3;
      paramAdvertisementInfo = null;
      break;
      if (paramAdvertisementInfo.longValue() != 0L) {
        break label16;
      }
      return 1;
    }
    return 5;
  }
  
  private final String a()
  {
    switch (NetworkUtil.b((Context)BaseApplication.getContext()))
    {
    case 5: 
    default: 
      return "非wifi";
    case 1: 
      return "wifi";
    case 0: 
      return "other";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "5G";
  }
  
  private final int b(AdvertisementInfo paramAdvertisementInfo)
  {
    label16:
    long l;
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo = Long.valueOf(paramAdvertisementInfo.mChannelID);
      if (paramAdvertisementInfo != null) {
        break label31;
      }
      l = 56;
      if (paramAdvertisementInfo != null) {
        break label42;
      }
    }
    label31:
    label42:
    while (paramAdvertisementInfo.longValue() != l)
    {
      return 1;
      paramAdvertisementInfo = null;
      break;
      if (paramAdvertisementInfo.longValue() != 0L) {
        break label16;
      }
      return 3;
    }
    return 5;
  }
  
  public final void a(@Nullable Context paramContext, @Nullable AdvertisementInfo paramAdvertisementInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "ex5");
    if ((RIJAdDownloadExKt.e(paramAdvertisementInfo)) || (RIJAdDownloadExKt.g(paramAdvertisementInfo)))
    {
      if (RIJAdDownloadExKt.e(paramAdvertisementInfo))
      {
        paramContext = "2";
        if (!RIJAdDownloadExKt.e(paramAdvertisementInfo)) {
          break label72;
        }
      }
      label72:
      for (long l = 3010205L;; l = 3010307L)
      {
        GameComponentReport.a(Integer.valueOf(0), paramAdvertisementInfo, NativeAdUtils.a(paramAdvertisementInfo), GameComponentReport.a(paramAdvertisementInfo, l, 9L, paramContext, paramString));
        return;
        paramContext = "1";
        break;
      }
    }
    if (RIJAdDownloadExKt.d(paramAdvertisementInfo))
    {
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.clickPos = 1;
      }
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.downloadState = 4;
      }
      ReadInJoyAdReportUtils.a(Integer.valueOf(0), paramAdvertisementInfo, 35, 1, a(paramAdvertisementInfo));
      return;
    }
    NativeAdUtils.a(new AdReportData().a(paramContext).a(5).b(b(paramAdvertisementInfo)).a(paramAdvertisementInfo).d(NativeAdUtils.a(paramAdvertisementInfo, new HashMap())));
  }
  
  public final void a(@NotNull Context paramContext, @NotNull DownloadClickState paramDownloadClickState, @Nullable AdvertisementInfo paramAdvertisementInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramDownloadClickState, "state");
    Intrinsics.checkParameterIsNotNull(paramString, "ex5");
    long l;
    switch (RIJAdDownloadReport.WhenMappings.a[paramDownloadClickState.ordinal()])
    {
    default: 
      return;
    case 1: 
      if ((RIJAdDownloadExKt.e(paramAdvertisementInfo)) || (RIJAdDownloadExKt.g(paramAdvertisementInfo)))
      {
        if (RIJAdDownloadExKt.e(paramAdvertisementInfo))
        {
          l = 3010205L;
          if (!RIJAdDownloadExKt.e(paramAdvertisementInfo)) {
            break label141;
          }
        }
        for (paramContext = "1";; paramContext = "0")
        {
          if (paramAdvertisementInfo != null) {
            paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
          }
          GameComponentReport.a(Integer.valueOf(3), paramAdvertisementInfo, NativeAdUtils.a(paramAdvertisementInfo), GameComponentReport.a(paramAdvertisementInfo, l, 9L, paramContext, paramString));
          return;
          l = 3010307L;
          break;
        }
      }
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
    case 2: 
      if ((RIJAdDownloadExKt.e(paramAdvertisementInfo)) || (RIJAdDownloadExKt.g(paramAdvertisementInfo)))
      {
        if (RIJAdDownloadExKt.e(paramAdvertisementInfo)) {}
        for (l = 3010205L;; l = 3010307L)
        {
          if (paramAdvertisementInfo != null) {
            paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
          }
          GameComponentReport.a(Integer.valueOf(13), paramAdvertisementInfo, NativeAdUtils.a(paramAdvertisementInfo), GameComponentReport.a(paramAdvertisementInfo, l, 9L, "8", paramString));
          return;
        }
      }
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
    case 3: 
      if ((RIJAdDownloadExKt.e(paramAdvertisementInfo)) || (RIJAdDownloadExKt.g(paramAdvertisementInfo)))
      {
        if (RIJAdDownloadExKt.e(paramAdvertisementInfo)) {}
        for (l = 3010205L;; l = 3010307L)
        {
          if (paramAdvertisementInfo != null) {
            paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
          }
          GameComponentReport.a(Integer.valueOf(14), paramAdvertisementInfo, NativeAdUtils.a(paramAdvertisementInfo), GameComponentReport.a(paramAdvertisementInfo, l, 9L, "9", paramString));
          return;
        }
      }
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
    case 4: 
      label141:
      if ((RIJAdDownloadExKt.e(paramAdvertisementInfo)) || (RIJAdDownloadExKt.g(paramAdvertisementInfo)))
      {
        if (RIJAdDownloadExKt.e(paramAdvertisementInfo)) {}
        for (l = 3010205L;; l = 3010307L)
        {
          if (paramAdvertisementInfo != null) {
            paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
          }
          GameComponentReport.a(Integer.valueOf(18), paramAdvertisementInfo, NativeAdUtils.a(paramAdvertisementInfo), GameComponentReport.a(paramAdvertisementInfo, l, 9L, "6", paramString));
          return;
        }
      }
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
      NativeAdUtils.a(new AdReportData().a(paramContext).a(1).b(Integer.valueOf(18)).b(8).a(paramAdvertisementInfo).d(NativeAdUtils.a(paramAdvertisementInfo, new HashMap())));
      return;
    }
    if ((RIJAdDownloadExKt.e(paramAdvertisementInfo)) || (RIJAdDownloadExKt.g(paramAdvertisementInfo)))
    {
      if (RIJAdDownloadExKt.e(paramAdvertisementInfo)) {}
      for (l = 3010205L;; l = 3010307L)
      {
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
        }
        GameComponentReport.a(Integer.valueOf(15), paramAdvertisementInfo, NativeAdUtils.a(paramAdvertisementInfo), GameComponentReport.a(paramAdvertisementInfo, l, 9L, "5", paramString));
        return;
      }
    }
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
    NativeAdUtils.a(new AdReportData().a(paramContext).a(1).b(b(paramAdvertisementInfo)).b(Integer.valueOf(15)).a(paramAdvertisementInfo).d(NativeAdUtils.a(paramAdvertisementInfo, new HashMap())));
  }
  
  public final void a(@NotNull String paramString, @Nullable AdDownloadInfo paramAdDownloadInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    HashMap localHashMap = new HashMap();
    Object localObject;
    if (paramAdDownloadInfo != null)
    {
      localObject = paramAdDownloadInfo.a();
      if (localObject != null)
      {
        localHashMap.put("packageName", localObject);
        if (paramAdDownloadInfo == null) {
          break label255;
        }
        localObject = paramAdDownloadInfo.c();
        if (localObject == null) {
          break label255;
        }
        label51:
        localHashMap.put("appId", localObject);
        if (paramAdDownloadInfo == null) {
          break label262;
        }
        localObject = String.valueOf(paramAdDownloadInfo.a());
        if (localObject == null) {
          break label262;
        }
        label77:
        localHashMap.put("pkgSize", localObject);
        localHashMap.put("apnType", a.a());
        if (paramAdDownloadInfo == null) {
          break label269;
        }
        localObject = Integer.valueOf(paramAdDownloadInfo.c());
        label114:
        localHashMap.put("errorCode", String.valueOf(localObject));
        localHashMap.put("action", paramString);
        localObject = new StringBuilder().append("reportDownloadBeacon: packageName = ");
        if (paramAdDownloadInfo == null) {
          break label274;
        }
      }
    }
    label262:
    label269:
    label274:
    for (paramAdDownloadInfo = paramAdDownloadInfo.a();; paramAdDownloadInfo = null)
    {
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", paramAdDownloadInfo + " action = " + paramString);
      paramString = RIJQQAppInterfaceUtil.a();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "RIJQQAppInterfaceUtil.getQQApp()");
      paramString = StatisticCollector.getInstance((Context)paramString.getApplication());
      paramAdDownloadInfo = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(paramAdDownloadInfo, "BaseApplicationImpl.getApplication()");
      paramAdDownloadInfo = paramAdDownloadInfo.getRuntime();
      Intrinsics.checkExpressionValueIsNotNull(paramAdDownloadInfo, "BaseApplicationImpl.getApplication().runtime");
      paramString.collectPerformance("000000EYXY3ATYB3", paramAdDownloadInfo.getAccount(), "actKandianAdDownload", true, 0L, 0L, localHashMap, null);
      return;
      localObject = "";
      break;
      label255:
      localObject = "";
      break label51;
      localObject = "";
      break label77;
      localObject = null;
      break label114;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadReport
 * JD-Core Version:    0.7.0.1
 */
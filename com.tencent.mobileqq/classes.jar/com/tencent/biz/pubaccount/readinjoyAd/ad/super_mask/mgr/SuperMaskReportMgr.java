package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.SuperMaskExtKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJTransMergeKanDianReport;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskReportMgr;", "", "()V", "BID_TYPE", "", "CLICK_POS_AD_AREA", "", "DOWNLOAD_KEY", "FETCH_KEY", "NORMAL_TYPE", "SUPER_TYPE", "USE_KEY", "feedsExposeCache", "Ljava/util/concurrent/CopyOnWriteArraySet;", "strictExposeCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "bigTR5", "clearStrictExposeCache", "", "fillSuperMaskReportData", "advertisementInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "funcExtDataJson", "Lorg/json/JSONObject;", "funcExt", "type", "origin", "exposeMode", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCurrentAdShouldStrictExpose", "", "onPreloadAction", "adId", "action", "version", "onShowAction", "traceId", "adCount", "reportClick", "clickPos", "adInfo", "reportExpose", "reportSuperMaskAdEvent", "setCurrentAdShouldStrictExpose", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SuperMaskReportMgr
{
  public static final SuperMaskReportMgr a = new SuperMaskReportMgr();
  private static final AtomicBoolean b = new AtomicBoolean(false);
  private static final CopyOnWriteArraySet<String> c = new CopyOnWriteArraySet();
  
  static
  {
    UserAction.registerTunnel(new TunnelInfo("000000EYXY3ATYB3"));
  }
  
  private final String d()
  {
    try
    {
      String str = ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).bigTR5();
      return str;
    }
    catch (JSONException localJSONException)
    {
      label16:
      break label16;
    }
    return "";
  }
  
  public final void a()
  {
    b.compareAndSet(false, true);
  }
  
  public final void a(int paramInt, @Nullable Object paramObject)
  {
    if (!(paramObject instanceof AdvertisementInfo)) {
      localObject = null;
    } else {
      localObject = paramObject;
    }
    Object localObject = (AdvertisementInfo)localObject;
    if (localObject != null)
    {
      if (((AdvertisementInfo)localObject).mAdvertisementExtInfo != null) {
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(BaseApplication.getContext()).a(2).b(37).a((AdvertisementInfo)paramObject).e(new JSONObject()).a(Integer.valueOf(paramInt)));
      }
      if (paramInt == 2)
      {
        a(a, "successShowMask", null, 2, null);
        return;
      }
      a(a, "exposeMask", null, 2, null);
    }
  }
  
  public final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2)
  {
    if (!ReadInJoyAdUtils.l(paramAdvertisementInfo)) {
      return;
    }
    if (paramInt1 != 37) {
      return;
    }
    if (paramInt2 != 2)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009819", "0X8009819", 0, 0, "", "", "", d(), false);
      return;
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).reportReadinjoyADEvent(null, "0X8008C80", "0X8008C80", 0, 0, "", "", "", d());
  }
  
  public final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable JSONObject paramJSONObject1, @Nullable JSONObject paramJSONObject2, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Integer paramInteger3)
  {
    if ((paramAdvertisementInfo != null) && (paramJSONObject1 != null) && (paramJSONObject2 != null) && (paramInteger1 != null) && (paramInteger2 != null))
    {
      if (paramInteger3 == null) {
        return;
      }
      if (!ReadInJoyAdUtils.l(paramAdvertisementInfo)) {
        return;
      }
      if ((paramInteger2.intValue() != 37) && (paramInteger1.intValue() == 2) && (!c.contains(paramAdvertisementInfo.mAdTraceId)))
      {
        c.add(paramAdvertisementInfo.mAdTraceId);
        String str = paramAdvertisementInfo.mAdTraceId;
        Intrinsics.checkExpressionValueIsNotNull(str, "advertisementInfo.mAdTraceId");
        a("feedsMaskExpose", str);
      }
      if (paramInteger1.intValue() == 2)
      {
        SuperMaskExtKt.a(paramAdvertisementInfo, paramInteger2.intValue(), paramInteger3.intValue(), paramJSONObject1, paramJSONObject2);
        return;
      }
      SuperMaskExtKt.a(paramAdvertisementInfo, paramInteger1.intValue(), paramJSONObject1, paramJSONObject2);
    }
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "action");
    Intrinsics.checkParameterIsNotNull(paramString2, "traceId");
    b(paramString1, paramString2, -1);
  }
  
  public final void a(@Nullable String paramString1, @NotNull String paramString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "action");
    HashMap localHashMap = new HashMap();
    if (paramString1 != null) {
      localObject1 = paramString1;
    } else {
      localObject1 = "";
    }
    localHashMap.put("adId", localObject1);
    localHashMap.put("action", paramString2);
    Object localObject1 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
    localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication().runtime");
    localHashMap.put("lQQ", ((AppRuntime)localObject1).getAccount());
    localHashMap.put("version", String.valueOf(paramInt));
    localObject1 = StatisticCollector.getInstance(BaseApplication.getContext());
    Object localObject2 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.getApplication()");
    localObject2 = ((BaseApplicationImpl)localObject2).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.getApplication().runtime");
    ((StatisticCollector)localObject1).collectPerformance("000000EYXY3ATYB3", ((AppRuntime)localObject2).getAccount(), "actKandianAdResoucePreload", true, 0L, 0L, localHashMap, null);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[actKandianAdResoucePreload] action = ");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append("  adId = ");
    ((StringBuilder)localObject1).append(paramString1);
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", ((StringBuilder)localObject1).toString());
  }
  
  public final void b(int paramInt, @Nullable Object paramObject)
  {
    if (!(paramObject instanceof AdvertisementInfo)) {
      localObject = null;
    } else {
      localObject = paramObject;
    }
    Object localObject = (AdvertisementInfo)localObject;
    if ((localObject != null) && (((AdvertisementInfo)localObject).mAdvertisementExtInfo != null))
    {
      if (paramInt == 1)
      {
        com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil.a = true;
        return;
      }
      localObject = (ReportAction)null;
      ActionEntity localActionEntity = (ActionEntity)null;
      switch (paramInt)
      {
      default: 
        break;
      case 28: 
        localObject = ReportAction.CLICK;
        localActionEntity = ActionEntity.CANCEL_MUTE;
        break;
      case 27: 
        localObject = ReportAction.CLICK;
        localActionEntity = ActionEntity.MUTE;
        break;
      case 26: 
        localObject = ReportAction.CLOSE;
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(BaseApplication.getContext()).a(paramInt).b(37).a((ReportAction)localObject).a(localActionEntity).a((AdvertisementInfo)paramObject).e(new JSONObject()));
    }
  }
  
  public final void b(@NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "action");
    Intrinsics.checkParameterIsNotNull(paramString2, "traceId");
    Object localObject1 = QRoute.api(IRIJSuperMaskService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IRIJSuperMaskService::class.java)");
    localObject1 = ((IRIJSuperMaskService)localObject1).getAdData();
    boolean bool = localObject1 instanceof AdvertisementInfo;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localObject1;
    String str;
    if (localAdvertisementInfo != null)
    {
      str = String.valueOf(localAdvertisementInfo.mAdAid);
      if (str != null) {}
    }
    else
    {
      str = "";
    }
    if (ReadInJoyAdUtils.m(localAdvertisementInfo))
    {
      if (ReadInJoyAdUtils.n(localAdvertisementInfo)) {
        localObject1 = "2";
      } else {
        localObject1 = "1";
      }
    }
    else {
      localObject1 = "0";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("adId", str);
    localHashMap.put("action", paramString1);
    localHashMap.put("type", localObject1);
    localObject1 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
    localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication().runtime");
    localHashMap.put("lQQ", ((AppRuntime)localObject1).getAccount());
    if (paramInt >= 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramInt);
      localHashMap.put("adCount", ((StringBuilder)localObject1).toString());
    }
    if (localAdvertisementInfo != null) {
      localHashMap.put("traceId", localAdvertisementInfo.mAdTraceId);
    } else {
      localHashMap.put("traceId", paramString2);
    }
    localObject1 = ((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
    paramString2 = localObject2;
    if (localObject1 != null) {
      paramString2 = ((AppRuntime)localObject1).getApplication();
    }
    paramString2 = StatisticCollector.getInstance((Context)paramString2);
    localObject1 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
    localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication().runtime");
    paramString2.collectPerformance("000000EYXY3ATYB3", ((AppRuntime)localObject1).getAccount(), "actKandianAdSuperMask", true, 0L, 0L, localHashMap, null);
    paramString2 = new StringBuilder();
    paramString2.append("[actKandianAdSuperMask] action = ");
    paramString2.append(paramString1);
    paramString2.append("  adId = ");
    paramString2.append(str);
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", paramString2.toString());
  }
  
  public final boolean b()
  {
    return b.get();
  }
  
  public final void c()
  {
    b.compareAndSet(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.weishi_new.combo;

import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/WSFrameBeaconReport;", "", "()V", "createExpClickBuilder", "Lcom/tencent/biz/pubaccount/weishi_new/report/WSStatisticsReporter$Builder;", "sopName", "", "positionId", "createReportBuilder", "doReport", "", "builder", "eventName", "reportBottomBarClick", "msgNum", "", "actionId", "reportBottomBarExp", "reportDetailBtnClick", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSFrameBeaconReport
{
  public static final WSFrameBeaconReport a = new WSFrameBeaconReport();
  
  @JvmStatic
  private static final WSStatisticsReporter.Builder a(String paramString1, String paramString2)
  {
    paramString1 = b(paramString1).addParams("position", paramString2).addParams("feed_id", "").addParams("owner_id", "");
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "createReportBuilder(sopN…nstants.KEY_OWNER_ID, \"\")");
    return paramString1;
  }
  
  @JvmStatic
  public static final void a()
  {
    a(a("frame", "bottom_tab"), "gzh_exposure");
  }
  
  @JvmStatic
  public static final void a(int paramInt1, int paramInt2)
  {
    Object localObject = (Map)new HashMap();
    ((Map)localObject).put("red_num", String.valueOf(paramInt1));
    localObject = a("frame", "bottom_tab").addParams("action_id", String.valueOf(paramInt2)).addExtParams((Map)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "builder");
    a((WSStatisticsReporter.Builder)localObject, "gzh_click");
  }
  
  @JvmStatic
  private static final void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "sopName");
    paramString = a(paramString, "wesee_info").addParams("action_id", String.valueOf(1000001));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "builder");
    a(paramString, "gzh_click");
  }
  
  @JvmStatic
  private static final WSStatisticsReporter.Builder b(String paramString)
  {
    paramString = new WSStatisticsReporter.Builder().setSopName(paramString).setTestId(WeishiUtils.a(1));
    WSInitializeHelper localWSInitializeHelper = WSInitializeHelper.a();
    Intrinsics.checkExpressionValueIsNotNull(localWSInitializeHelper, "WSInitializeHelper.getInstance()");
    paramString = paramString.setPushId(localWSInitializeHelper.f()).setFlush(true);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "WSStatisticsReporter.Bui…          .setFlush(true)");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.WSFrameBeaconReport
 * JD-Core Version:    0.7.0.1
 */
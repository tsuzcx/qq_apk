package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.mobileqq.mini.notify.MiniAppNotify;
import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJMiniProgrameReporter;", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ReadInJoyGlobalReporter;", "()V", "FROM_PAGE_NATIVE_ARTICLE", "", "FROM_PAGE_TL", "REPORT_ACTION_NAME", "", "getREPORT_ACTION_NAME", "()Ljava/lang/String;", "fromPage", "getFromPage", "()I", "setFromPage", "(I)V", "miniAppNotifyListener", "Lcom/tencent/mobileqq/mini/notify/MiniAppNotify$IMiniAppNotifyListener;", "getMiniAppNotifyListener", "()Lcom/tencent/mobileqq/mini/notify/MiniAppNotify$IMiniAppNotifyListener;", "miniProgrameName", "getMiniProgrameName", "setMiniProgrameName", "(Ljava/lang/String;)V", "movieName", "getMovieName", "setMovieName", "rowKey", "getRowKey", "setRowKey", "uin", "getUin", "setUin", "clearMiniProgramInfo", "", "logEnterTimeAndReport", "event", "registerMiniAppListener", "report", "unRegisterMiniAppListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJMiniProgrameReporter
  extends ReadInJoyGlobalReporter
{
  public static final RIJMiniProgrameReporter a;
  @NotNull
  private static final MiniAppNotify.IMiniAppNotifyListener a;
  private static int b = 0;
  @NotNull
  private static final String f = "0X800B969";
  @Nullable
  private static String g;
  @Nullable
  private static String h;
  @Nullable
  private static String i;
  @Nullable
  private static String j;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokReportRIJMiniProgrameReporter = new RIJMiniProgrameReporter();
    f = "0X800B969";
    jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener = (MiniAppNotify.IMiniAppNotifyListener)RIJMiniProgrameReporter.miniAppNotifyListener.1.a;
  }
  
  public void a()
  {
    super.a();
    try
    {
      JSONObject localJSONObject = a();
      Intrinsics.checkExpressionValueIsNotNull(localJSONObject, "getReportR5()");
      localJSONObject.put("from_page", b);
      localJSONObject.put("rowkey", i);
      localJSONObject.put("mini_program_name", g);
      localJSONObject.put("movie_name", h);
      localJSONObject.put("duration", a());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, j, f, f, 0, 0, a(), "", "", localJSONObject.toString(), false);
      d();
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyGlobalReporter", 1, localException.getMessage());
    }
  }
  
  public final void a(int paramInt)
  {
    b = paramInt;
  }
  
  public final void a(@Nullable String paramString)
  {
    g = paramString;
  }
  
  public final void b()
  {
    MiniAppNotify.g.register(jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener);
  }
  
  public final void b(@Nullable String paramString)
  {
    h = paramString;
  }
  
  public final void c()
  {
    MiniAppNotify.g.remove(jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener);
  }
  
  public final void c(@Nullable String paramString)
  {
    i = paramString;
  }
  
  public final void d()
  {
    g = (String)null;
    h = (String)null;
    b = 0;
    i = (String)null;
  }
  
  public final void d(@Nullable String paramString)
  {
    j = paramString;
  }
  
  public final void e(@Nullable String paramString)
  {
    if (Intrinsics.areEqual("onResume", paramString))
    {
      k = RIJAppSetting.a();
      m = RIJKanDianFolderStatus.a;
      a(null, NetConnInfoCenter.getServerTimeMillis(), k, m);
    }
    while ((!Intrinsics.areEqual("onPause", paramString)) || (a() <= 0L))
    {
      int k;
      int m;
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJMiniProgrameReporter
 * JD-Core Version:    0.7.0.1
 */
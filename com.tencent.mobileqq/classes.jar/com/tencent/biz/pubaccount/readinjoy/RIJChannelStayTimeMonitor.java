package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.atlas.ReadInjoyAtlasReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotReporter;
import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotStore;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGroundCallback;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/RIJChannelStayTimeMonitor;", "", "()V", "CHANNEL_STAY_TIME", "", "REFRESH_TIME_LIMIT", "", "TAG", "channelEnterTimeMap", "", "", "getChannelEnterTimeMap", "()Ljava/util/Map;", "channelEnterTimeMap$delegate", "Lkotlin/Lazy;", "channelExitTimeMap", "getChannelExitTimeMap", "channelExitTimeMap$delegate", "currentChannel", "Lcom/tencent/biz/pubaccount/readinjoy/struct/TabChannelCoverInfo;", "currentChannelPos", "foreBackGroundCallback", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$ForeBackGroundCallback;", "endMonitor", "", "enterChannel", "channelId", "exitChannel", "pos", "channelVersion", "isChannelShow", "", "isLastExitChannelOverTimeLimit", "onAccountChanged", "onChannelChanged", "tabChannelCoverInfo", "curPos", "setChannelCityForLocalChannel", "builder", "Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;", "startMonitor", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelStayTimeMonitor
{
  private static int jdField_a_of_type_Int;
  private static final long jdField_a_of_type_Long = ReadInJoyHelper.d(ReadInJoyUtils.a());
  public static final RIJChannelStayTimeMonitor a;
  private static final ReadinjoySPEventReport.ForeBackGroundCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ForeBackGroundCallback = (ReadinjoySPEventReport.ForeBackGroundCallback)new RIJChannelStayTimeMonitor.foreBackGroundCallback.1();
  private static TabChannelCoverInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
  private static final Lazy jdField_a_of_type_KotlinLazy;
  private static final Lazy b;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJChannelStayTimeMonitor = new RIJChannelStayTimeMonitor();
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)RIJChannelStayTimeMonitor.channelEnterTimeMap.2.INSTANCE);
    b = LazyKt.lazy((Function0)RIJChannelStayTimeMonitor.channelExitTimeMap.2.INSTANCE);
  }
  
  private final Map<Integer, Long> a()
  {
    return (Map)jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final void a(RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder, int paramInt)
  {
    if (paramInt != 41695) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = ReadInJoyLogicEngine.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyLogicEngine.getInstance()");
        localObject = ((ReadInJoyLogicEngine)localObject).a();
      } while (localObject == null);
      localObject = ((SelectPositionModule)localObject).a();
    } while (localObject == null);
    paramReportR5Builder.i(((SelectPositionModule.PositionData)localObject).city);
    QLog.i("RIJChannelStayTimeMonitorImpl", 2, "setChannelCityForLocalChannel CHANNEL_ID_LOCAL r5Str = " + paramReportR5Builder.a());
  }
  
  private final Map<Integer, Long> b()
  {
    return (Map)b.getValue();
  }
  
  public final void a()
  {
    ReadinjoySPEventReport.ForeBackGround.a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ForeBackGroundCallback);
  }
  
  public final void a(int paramInt)
  {
    QLog.d("RIJChannelStayTimeMonitorImpl", 2, "enterChannel, channelID = " + paramInt);
    if (paramInt == -1) {
      return;
    }
    a().put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
    ReadInJoyGlobalReporter.c(paramInt);
    RIJXTabNormalRedDotReporter.a.a(true, paramInt, -1L, RIJXTabNormalRedDotStore.a.a(paramInt));
  }
  
  public final void a(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    QLog.d("RIJChannelStayTimeMonitorImpl", 2, "exitChannel, channelID = " + paramInt1);
    if (paramInt1 == -1) {}
    Long localLong;
    do
    {
      return;
      localLong = (Long)a().remove(Integer.valueOf(paramInt1));
    } while (localLong == null);
    long l = localLong.longValue();
    l = (System.currentTimeMillis() - l) / 1000;
    paramString = new RIJTransMergeKanDianReport.ReportR5Builder().b().f().a(paramInt1).b(paramInt2 + 1).h(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "r5Builder");
    a(paramString, paramInt1);
    b().put(Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis()));
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009733", "0X8009733", 0, 0, String.valueOf(l), "", "", paramString.a(), false);
    ReadInjoyAtlasReportUtils.a(paramInt1);
    RIJXTabNormalRedDotReporter.a.a(false, paramInt1, l, RIJXTabNormalRedDotStore.a.a(paramInt1));
  }
  
  public final void a(@NotNull TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramTabChannelCoverInfo, "tabChannelCoverInfo");
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo = paramTabChannelCoverInfo;
    jdField_a_of_type_Int = paramInt;
  }
  
  public final boolean a(int paramInt)
  {
    return a().get(Integer.valueOf(paramInt)) != null;
  }
  
  public final void b()
  {
    ReadinjoySPEventReport.ForeBackGround.b(jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ForeBackGroundCallback);
    a().clear();
    b().clear();
  }
  
  public final boolean b(int paramInt)
  {
    Long localLong = (Long)b().get(Integer.valueOf(paramInt));
    if (localLong != null)
    {
      long l = localLong.longValue();
      l = System.currentTimeMillis() - l;
      QLog.d("RIJChannelStayTimeMonitorImpl", 2, "refresh_time_limit = " + jdField_a_of_type_Long + ", channelId:" + paramInt + ", channelExitTime:" + l);
      if (l > jdField_a_of_type_Long) {
        return true;
      }
    }
    else
    {
      return true;
    }
    return false;
  }
  
  public final void c()
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo = (TabChannelCoverInfo)null;
    a().clear();
    b().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.RIJChannelStayTimeMonitor
 * JD-Core Version:    0.7.0.1
 */
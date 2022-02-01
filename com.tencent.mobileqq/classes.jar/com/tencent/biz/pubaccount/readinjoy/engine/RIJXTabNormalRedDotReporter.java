package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler.Companion;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/engine/RIJXTabNormalRedDotReporter;", "", "()V", "FADE_WAY", "", "FOLDER_STATUS", "RED_DOT_FADE_WAY_EXPIRED", "", "RED_DOT_FADE_WAY_USER_ACTION", "TAG", "operationBitmapMap", "", "buildCommonParams", "Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;", "info", "Lcom/tencent/biz/pubaccount/readinjoy/engine/RIJXTabRedDotInfo;", "get80aXTabRedDotStatus", "getOperationBitmap", "channelId", "report64eRealTimeAction", "", "action", "report80aOnChannelChanged", "enter", "", "currentChannelId", "channelStayTime", "", "redDotInfo", "reportClick", "reportDismiss", "type", "reportExposure", "reportExposureOnResume", "resetOperationBitmap", "set80aCommonParams", "attrs", "", "Ltencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList;", "set80aParamsOnEnterChannel", "set80aParamsOnExitChannel", "opBitmap", "setOperationBitmap", "operationBitFlag", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabNormalRedDotReporter
{
  public static final RIJXTabNormalRedDotReporter a;
  private static final Map<Integer, Integer> a;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineRIJXTabNormalRedDotReporter = new RIJXTabNormalRedDotReporter();
    jdField_a_of_type_JavaUtilMap = (Map)new HashMap();
  }
  
  private final int a(int paramInt)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  @JvmStatic
  private static final RIJTransMergeKanDianReport.ReportR5Builder a(RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    paramRIJXTabRedDotInfo = new RIJTransMergeKanDianReport.ReportR5Builder().f().a(paramRIJXTabRedDotInfo.getChannelId()).a("folder_status", paramRIJXTabRedDotInfo.getFolderStatus());
    Intrinsics.checkExpressionValueIsNotNull(paramRIJXTabRedDotInfo, "RIJTransMergeKanDianRepo…TATUS, info.folderStatus)");
    return paramRIJXTabRedDotInfo;
  }
  
  private final void a(int paramInt, RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    List localList = (List)new ArrayList();
    try
    {
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mOperation = paramInt;
      localReportInfo.mSourceArticleId = Long.parseLong(paramRIJXTabRedDotInfo.getArticleIds());
      localReportInfo.mAlgorithmId = Integer.parseInt(paramRIJXTabRedDotInfo.getAlgorithmIds());
      localReportInfo.mStrategyId = Integer.parseInt(paramRIJXTabRedDotInfo.getStrategyIds());
      localReportInfo.mUin = RIJQQAppInterfaceUtil.a();
      localReportInfo.mFolderStatus = Integer.parseInt(paramRIJXTabRedDotInfo.getFolderStatus());
      localReportInfo.mChannelId = paramRIJXTabRedDotInfo.getChannelId();
      localReportInfo.mOpSource = 19;
      localList.add(localReportInfo);
      new UserOperationModule(null, null, ReadInJoyMSFService.a(), null).b(localList);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("RIJXTabNormalRedDotReporter", 2, "report64eRealTimeAction failed--> action:" + paramInt + " info:" + paramRIJXTabRedDotInfo);
    }
  }
  
  @JvmStatic
  public static final void a(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    if (paramRIJXTabRedDotInfo.getExposureTime() != -1L) {
      return;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = a(paramRIJXTabRedDotInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800B982", localReportR5Builder.a());
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineRIJXTabNormalRedDotReporter.a(20, paramRIJXTabRedDotInfo);
    RIJXTabNormalRedDotStore.a.a(paramRIJXTabRedDotInfo.getChannelId());
  }
  
  @JvmStatic
  public static final void a(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    paramRIJXTabRedDotInfo = a(paramRIJXTabRedDotInfo).a("reddot_fade_way", paramInt);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800B984", paramRIJXTabRedDotInfo.a());
  }
  
  private final void a(List<oidb_cmd0x80a.AttributeList> paramList, int paramInt, long paramLong)
  {
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(5);
    localAttributeList.att_name.set("Time");
    localAttributeList.att_value.set(String.valueOf(paramLong));
    paramList.add(localAttributeList);
    localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(6);
    localAttributeList.att_name.set("OperationBitmap");
    localAttributeList.att_value.set(String.valueOf(paramInt));
    paramList.add(localAttributeList);
  }
  
  private final void a(List<oidb_cmd0x80a.AttributeList> paramList, int paramInt, RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("channelID");
    localAttributeList.att_value.set(String.valueOf(paramInt));
    paramList.add(localAttributeList);
    if (paramRIJXTabRedDotInfo != null)
    {
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(2);
      localAttributeList.att_name.set("FolderStatus");
      localAttributeList.att_value.set(paramRIJXTabRedDotInfo.getFolderStatus() + "");
      paramList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(3);
      localAttributeList.att_name.set("StrategyID");
      localAttributeList.att_value.set(paramRIJXTabRedDotInfo.getStrategyIds() + "");
      paramList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(4);
      localAttributeList.att_name.set("AlgorithmID");
      localAttributeList.att_value.set(paramRIJXTabRedDotInfo.getAlgorithmIds() + "");
      paramList.add(localAttributeList);
    }
  }
  
  private final void a(List<oidb_cmd0x80a.AttributeList> paramList, RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    if (paramRIJXTabRedDotInfo != null)
    {
      long l = (NetConnInfoCenter.getServerTimeMillis() - paramRIJXTabRedDotInfo.getExposureTime()) / 1000;
      paramRIJXTabRedDotInfo = new oidb_cmd0x80a.AttributeList();
      paramRIJXTabRedDotInfo.att_id.set(5);
      paramRIJXTabRedDotInfo.att_name.set("costtime");
      paramRIJXTabRedDotInfo.att_value.set(String.valueOf(l));
      paramList.add(paramRIJXTabRedDotInfo);
    }
  }
  
  @JvmStatic
  public static final void b()
  {
    Object localObject2 = (Iterable)RIJXTabNormalRedDotStore.a.a();
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label78:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((RIJXTabRedDotInfo)localObject3).getExposureTime() == -1L) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label78;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      a((RIJXTabRedDotInfo)((Iterator)localObject1).next());
    }
  }
  
  @JvmStatic
  public static final void b(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = a(paramRIJXTabRedDotInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800B983", localReportR5Builder.a());
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineRIJXTabNormalRedDotReporter.a(21, paramRIJXTabRedDotInfo);
  }
  
  @NotNull
  public final String a()
  {
    if (!RIJXTabConfigHandler.a.a().a()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = ((Iterable)RIJXTabConfigHandler.a.a().a()).iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (TabChannelCoverInfo)localIterator.next();
      localStringBuilder.append(((TabChannelCoverInfo)localObject).mChannelCoverId).append(":");
      if (RIJXTabNormalRedDotStore.a.a(((TabChannelCoverInfo)localObject).mChannelCoverId) != null) {}
      for (localObject = "1";; localObject = "0")
      {
        localStringBuilder.append((String)localObject).append("_");
        break;
      }
    }
    return StringsKt.removeSuffix((CharSequence)localStringBuilder, (CharSequence)"_").toString();
  }
  
  public final void a()
  {
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    if (localInteger != null) {}
    for (int i = localInteger.intValue();; i = 0)
    {
      jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Integer.valueOf(i | paramInt2));
      return;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, long paramLong, @Nullable RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    int i;
    ArrayList localArrayList;
    if (paramBoolean)
    {
      i = 42;
      localArrayList = new ArrayList();
      a((List)localArrayList, paramInt, paramRIJXTabRedDotInfo);
      if (!paramBoolean) {
        break label73;
      }
      a((List)localArrayList, paramRIJXTabRedDotInfo);
    }
    for (;;)
    {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPushEffectEvent(i, (List)localArrayList);
      return;
      i = 43;
      break;
      label73:
      a((List)localArrayList, a(paramInt), paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotReporter
 * JD-Core Version:    0.7.0.1
 */
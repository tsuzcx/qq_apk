package com.tencent.biz.pubaccount.readinjoy.reward.aidl;

import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/RIJAidlClientRedPacketModule;", "", "()V", "TAG", "", "value", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;", "currentTask", "currentTask$annotations", "getCurrentTask", "()Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;", "setCurrentTask", "(Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;)V", "dailyMissionCount", "", "dailyMissionCount$annotations", "getDailyMissionCount", "()I", "enable", "", "enable$annotations", "getEnable", "()Z", "isNowInKanDianTab", "isNowInKanDianTab$annotations", "lastTask", "lastTask$annotations", "getLastTask", "setLastTask", "maxTaskTimeForArticleInMs", "maxTaskTimeForArticleInMs$annotations", "getMaxTaskTimeForArticleInMs", "maxTaskTimeWhenArticleStationaryInMs", "maxTaskTimeWhenArticleStationaryInMs$annotations", "getMaxTaskTimeWhenArticleStationaryInMs", "missionCompletedTimeInMs", "missionCompletedTimeInMs$annotations", "getMissionCompletedTimeInMs", "rijAidlInterfaceForRewardTask", "Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/IRIJAidlInterfaceForRewardTask;", "getRijAidlInterfaceForRewardTask", "()Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/IRIJAidlInterfaceForRewardTask;", "getTaskProgress", "hasRead", "rowKey", "reportTaskCompleted", "", "type", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTaskRemoteRepo$IReportTaskProgressCallback;", "setRead", "taskCompletedToday", "updateTaskProgress", "timeInMx", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJAidlClientRedPacketModule
{
  public static final RIJAidlClientRedPacketModule a = new RIJAidlClientRedPacketModule();
  
  @JvmStatic
  public static final int a()
  {
    return ((Number)RIJAidlClientRewardTaskModuleKt.a((Function0)RIJAidlClientRedPacketModule.getTaskProgress.1.INSTANCE, Integer.valueOf(0))).intValue();
  }
  
  @Nullable
  public static final RIJRewardTask a()
  {
    return (RIJRewardTask)RIJAidlClientRewardTaskModuleKt.a((Function0)RIJAidlClientRedPacketModule.currentTask.2.INSTANCE, null);
  }
  
  private final IRIJAidlInterfaceForRewardTask a()
  {
    return (IRIJAidlInterfaceForRewardTask)RIJAidlClientRewardTaskModuleKt.a((Function0)RIJAidlClientRedPacketModule.rijAidlInterfaceForRewardTask.1.INSTANCE, null);
  }
  
  @JvmStatic
  public static final void a(int paramInt)
  {
    RIJAidlClientRewardTaskModuleKt.a((Function0)new RIJAidlClientRedPacketModule.updateTaskProgress.1(paramInt));
  }
  
  public static final void a(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    RIJAidlClientRewardTaskModuleKt.a((Function0)new RIJAidlClientRedPacketModule.currentTask.1(paramRIJRewardTask));
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    RIJAidlClientRewardTaskModuleKt.a((Function0)new RIJAidlClientRedPacketModule.setRead.1(paramString));
  }
  
  @JvmStatic
  public static final void a(@Nullable String paramString, int paramInt, @Nullable RIJRewardTaskRemoteRepo.IReportTaskProgressCallback paramIReportTaskProgressCallback)
  {
    RIJAidlClientRewardTaskModuleKt.a((Function0)new RIJAidlClientRedPacketModule.reportTaskCompleted.1(paramString, paramInt, paramIReportTaskProgressCallback));
  }
  
  public static final boolean a()
  {
    return ((Boolean)RIJAidlClientRewardTaskModuleKt.a((Function0)RIJAidlClientRedPacketModule.isNowInKanDianTab.1.INSTANCE, Boolean.valueOf(false))).booleanValue();
  }
  
  @JvmStatic
  public static final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    return ((Boolean)RIJAidlClientRewardTaskModuleKt.a((Function0)new RIJAidlClientRedPacketModule.hasRead.1(paramString), Boolean.valueOf(false))).booleanValue();
  }
  
  @JvmStatic
  public static final int b()
  {
    return ((Number)RIJAidlClientRewardTaskModuleKt.a((Function0)RIJAidlClientRedPacketModule.taskCompletedToday.1.INSTANCE, Integer.valueOf(0))).intValue();
  }
  
  @Nullable
  public static final RIJRewardTask b()
  {
    return (RIJRewardTask)RIJAidlClientRewardTaskModuleKt.a((Function0)RIJAidlClientRedPacketModule.lastTask.2.INSTANCE, null);
  }
  
  public static final void b(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    RIJAidlClientRewardTaskModuleKt.a((Function0)new RIJAidlClientRedPacketModule.lastTask.1(paramRIJRewardTask));
  }
  
  public static final boolean b()
  {
    return ((Boolean)RIJAidlClientRewardTaskModuleKt.a((Function0)RIJAidlClientRedPacketModule.enable.1.INSTANCE, Boolean.valueOf(false))).booleanValue();
  }
  
  public static final int c()
  {
    return ((Number)RIJAidlClientRewardTaskModuleKt.a((Function0)RIJAidlClientRedPacketModule.missionCompletedTimeInMs.1.INSTANCE, Integer.valueOf(0))).intValue();
  }
  
  public static final int d()
  {
    return ((Number)RIJAidlClientRewardTaskModuleKt.a((Function0)RIJAidlClientRedPacketModule.dailyMissionCount.1.INSTANCE, Integer.valueOf(0))).intValue();
  }
  
  public static final int e()
  {
    return ((Number)RIJAidlClientRewardTaskModuleKt.a((Function0)RIJAidlClientRedPacketModule.maxTaskTimeForArticleInMs.1.INSTANCE, Integer.valueOf(0))).intValue();
  }
  
  public static final int f()
  {
    return ((Number)RIJAidlClientRewardTaskModuleKt.a((Function0)RIJAidlClientRedPacketModule.maxTaskTimeWhenArticleStationaryInMs.1.INSTANCE, Integer.valueOf(0))).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.aidl.RIJAidlClientRedPacketModule
 * JD-Core Version:    0.7.0.1
 */
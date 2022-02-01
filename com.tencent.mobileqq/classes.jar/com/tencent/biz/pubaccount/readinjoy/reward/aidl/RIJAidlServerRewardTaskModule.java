package com.tencent.biz.pubaccount.readinjoy.reward.aidl;

import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskConfig;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import com.tencent.biz.pubaccount.readinjoy.reward.mvp.RIJRewardTaskTimingModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/RIJAidlServerRewardTaskModule;", "Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/IRIJAidlInterfaceForRewardTask$Stub;", "()V", "model", "Lcom/tencent/biz/pubaccount/readinjoy/reward/mvp/RIJRewardTaskTimingModel;", "getModel", "()Lcom/tencent/biz/pubaccount/readinjoy/reward/mvp/RIJRewardTaskTimingModel;", "model$delegate", "Lkotlin/Lazy;", "dailyMissionCount", "", "getCurrentTask", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;", "getLastTask", "getTaskProgress", "hasRead", "", "rowKey", "", "isEnable", "isNowInKanDianTab", "maxTaskTimeForArticleInMs", "maxTaskTimeWhenArticleStationaryInMs", "missionCompletedTimeInMs", "reportTaskCompleted", "", "type", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/IReportTaskProgressCallback;", "setCurrentTask", "task", "setLastTask", "setRead", "taskCompletedToday", "updateTaskProgress", "timeInMs", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJAidlServerRewardTaskModule
  extends IRIJAidlInterfaceForRewardTask.Stub
{
  private final Lazy a = LazyKt.lazy((Function0)RIJAidlServerRewardTaskModule.model.2.INSTANCE);
  
  private final RIJRewardTaskTimingModel a()
  {
    return (RIJRewardTaskTimingModel)this.a.getValue();
  }
  
  public int a()
  {
    return a().b();
  }
  
  @Nullable
  public RIJRewardTask a()
  {
    return a().a();
  }
  
  public void a(int paramInt)
  {
    a().a(paramInt);
  }
  
  public void a(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    a().a(paramRIJRewardTask);
  }
  
  public void a(@Nullable String paramString)
  {
    if (paramString != null) {
      a().a(paramString);
    }
  }
  
  public void a(@Nullable String paramString, int paramInt, @Nullable IReportTaskProgressCallback paramIReportTaskProgressCallback)
  {
    a().a(paramString, paramInt, (RIJRewardTaskRemoteRepo.IReportTaskProgressCallback)new RIJAidlServerRewardTaskModule.reportTaskCompleted.1(paramIReportTaskProgressCallback));
  }
  
  public boolean a()
  {
    return RIJXTabFrameUtils.a.a();
  }
  
  public boolean a(@Nullable String paramString)
  {
    if (paramString != null) {
      return a().a(paramString);
    }
    return false;
  }
  
  public int b()
  {
    return a().a();
  }
  
  @Nullable
  public RIJRewardTask b()
  {
    return a().b();
  }
  
  public void b(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    a().b(paramRIJRewardTask);
  }
  
  public boolean b()
  {
    return RIJRewardTaskConfig.a();
  }
  
  public int c()
  {
    return RIJRewardTaskConfig.a();
  }
  
  public int d()
  {
    return RIJRewardTaskConfig.b();
  }
  
  public int e()
  {
    return RIJRewardTaskConfig.c();
  }
  
  public int f()
  {
    return RIJRewardTaskConfig.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.aidl.RIJAidlServerRewardTaskModule
 * JD-Core Version:    0.7.0.1
 */
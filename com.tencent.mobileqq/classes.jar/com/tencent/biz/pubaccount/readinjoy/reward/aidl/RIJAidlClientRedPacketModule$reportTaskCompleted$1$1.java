package com.tencent.biz.pubaccount.readinjoy.reward.aidl;

import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/reward/aidl/RIJAidlClientRedPacketModule$reportTaskCompleted$1$1", "Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/IReportTaskProgressCallback$Stub;", "onReportFailed", "", "errorCode", "", "errorMsg", "", "onReportSucceed", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJAidlClientRedPacketModule$reportTaskCompleted$1$1
  extends IReportTaskProgressCallback.Stub
{
  public void a()
  {
    RIJRewardTaskRemoteRepo.IReportTaskProgressCallback localIReportTaskProgressCallback = this.a.$callback;
    if (localIReportTaskProgressCallback != null) {
      localIReportTaskProgressCallback.a();
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    RIJRewardTaskRemoteRepo.IReportTaskProgressCallback localIReportTaskProgressCallback = this.a.$callback;
    if (localIReportTaskProgressCallback != null) {
      localIReportTaskProgressCallback.a(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.aidl.RIJAidlClientRedPacketModule.reportTaskCompleted.1.1
 * JD-Core Version:    0.7.0.1
 */
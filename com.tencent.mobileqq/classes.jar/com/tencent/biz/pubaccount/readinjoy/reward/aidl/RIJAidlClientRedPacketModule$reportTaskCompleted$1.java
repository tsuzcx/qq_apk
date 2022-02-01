package com.tencent.biz.pubaccount.readinjoy.reward.aidl;

import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJAidlClientRedPacketModule$reportTaskCompleted$1
  extends Lambda
  implements Function0<Unit>
{
  RIJAidlClientRedPacketModule$reportTaskCompleted$1(String paramString, int paramInt, RIJRewardTaskRemoteRepo.IReportTaskProgressCallback paramIReportTaskProgressCallback)
  {
    super(0);
  }
  
  public final void invoke()
  {
    IRIJAidlInterfaceForRewardTask localIRIJAidlInterfaceForRewardTask = RIJAidlClientRedPacketModule.a(RIJAidlClientRedPacketModule.a);
    if (localIRIJAidlInterfaceForRewardTask != null) {
      localIRIJAidlInterfaceForRewardTask.a(this.$rowKey, this.$type, (IReportTaskProgressCallback)new RIJAidlClientRedPacketModule.reportTaskCompleted.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.aidl.RIJAidlClientRedPacketModule.reportTaskCompleted.1
 * JD-Core Version:    0.7.0.1
 */
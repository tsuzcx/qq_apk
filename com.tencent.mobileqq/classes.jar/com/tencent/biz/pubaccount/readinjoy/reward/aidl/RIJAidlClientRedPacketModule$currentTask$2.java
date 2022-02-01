package com.tencent.biz.pubaccount.readinjoy.reward.aidl;

import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;", "invoke"}, k=3, mv={1, 1, 16})
final class RIJAidlClientRedPacketModule$currentTask$2
  extends Lambda
  implements Function0<RIJRewardTask>
{
  public static final 2 INSTANCE = new 2();
  
  RIJAidlClientRedPacketModule$currentTask$2()
  {
    super(0);
  }
  
  @Nullable
  public final RIJRewardTask invoke()
  {
    IRIJAidlInterfaceForRewardTask localIRIJAidlInterfaceForRewardTask = RIJAidlClientRedPacketModule.a(RIJAidlClientRedPacketModule.a);
    if (localIRIJAidlInterfaceForRewardTask != null) {
      return localIRIJAidlInterfaceForRewardTask.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.aidl.RIJAidlClientRedPacketModule.currentTask.2
 * JD-Core Version:    0.7.0.1
 */
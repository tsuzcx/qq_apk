package com.tencent.biz.pubaccount.readinjoy.reward.mvp;

import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskLocalRepo;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import org.jetbrains.annotations.Nullable;

class RIJRewardTaskTimingModel$1
  implements RIJRewardTaskRemoteRepo.IReportTaskProgressCallback
{
  RIJRewardTaskTimingModel$1(RIJRewardTaskTimingModel paramRIJRewardTaskTimingModel, RIJRewardTaskRemoteRepo.IReportTaskProgressCallback paramIReportTaskProgressCallback) {}
  
  public void a()
  {
    int i = RIJRewardTaskLocalRepo.b().a();
    RIJRewardTaskLocalRepo.b().a(i + 1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskRemoteRepo$IReportTaskProgressCallback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskRemoteRepo$IReportTaskProgressCallback.a();
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskRemoteRepo$IReportTaskProgressCallback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskRemoteRepo$IReportTaskProgressCallback.a(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.mvp.RIJRewardTaskTimingModel.1
 * JD-Core Version:    0.7.0.1
 */
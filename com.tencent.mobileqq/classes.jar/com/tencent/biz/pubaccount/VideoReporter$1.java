package com.tencent.biz.pubaccount;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

final class VideoReporter$1
  implements Runnable
{
  VideoReporter$1(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData, int paramInt7, String paramString2, String paramString3) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ReadInJoyUtils.a();
    localReportInfo.mSource = 0;
    localReportInfo.mOpSource = this.jdField_a_of_type_Int;
    localReportInfo.mSourceArticleId = this.jdField_a_of_type_Long;
    localReportInfo.mInnerId = this.jdField_a_of_type_JavaLangString;
    localReportInfo.mChannelId = this.jdField_b_of_type_Int;
    localReportInfo.mAlgorithmId = this.jdField_c_of_type_Int;
    localReportInfo.mStrategyId = this.d;
    localReportInfo.mOperation = this.e;
    localReportInfo.mPlayTimeLength = this.f;
    localReportInfo.mVideoExtraRepoerData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReportInfo$VideoExtraRepoerData;
    localReportInfo.mColumnID = this.g;
    localReportInfo.videoReportInfo = this.jdField_b_of_type_JavaLangString;
    localReportInfo.firstVideoRowkey = this.jdField_c_of_type_JavaLangString;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("reportVideoUserOperationByOidbOfVideoFeedsmUin:").append(localReportInfo.mUin).append("; mSource:").append(localReportInfo.mSource).append("; mOpSource:").append(localReportInfo.mOpSource).append("; mSourceArticleId: ").append(localReportInfo.mSourceArticleId).append("; mInnerId:").append(localReportInfo.mInnerId).append("; mChannelId:").append(localReportInfo.mChannelId).append("; mAlgorithmId:").append(localReportInfo.mAlgorithmId).append("; mStrategyId:").append(localReportInfo.mStrategyId).append("; mOperation:").append(localReportInfo.mOperation).append("; mPlayTimeLength:").append(localReportInfo.mPlayTimeLength).append("; mColumnID:").append(localReportInfo.mColumnID).append("; videoReportInfo:").append(localReportInfo.videoReportInfo).append("; videoExtraRepoerData:");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReportInfo$VideoExtraRepoerData == null) {
        break label344;
      }
    }
    label344:
    for (String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReportInfo$VideoExtraRepoerData.toString();; str = "null")
    {
      QLog.d("VideoReporter", 2, str);
      localArrayList.add(localReportInfo);
      new UserOperationModule(null, null, ReadInJoyMSFService.a(), null).a(localArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoReporter.1
 * JD-Core Version:    0.7.0.1
 */
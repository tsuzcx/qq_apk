package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.upload.IVideoUploadListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class UploadVideoTaskStep$1
  implements IVideoUploadListener<String>
{
  UploadVideoTaskStep$1(UploadVideoTaskStep paramUploadVideoTaskStep, UgcVideo paramUgcVideo) {}
  
  public void a(int paramInt, @NotNull String paramString)
  {
    RIJUgcUtils.a("fail", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    String str = RIJUgcUtils.a(RIJQQAppInterfaceUtil.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo).a("errMsg", paramString).a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC66", str);
    QLog.e("RIJUGC.UploadVideoTaskStep", 1, "onFailed, errCode=" + paramInt + ", errMsg=" + paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_FAILED;
    UploadVideoTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadVideoTaskStep).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadVideoTaskStep.d();
    UploadVideoTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadVideoTaskStep, false);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    float f = (float)paramLong1 * 100.0F / (float)paramLong2;
    if ((f > this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.videoProgress) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status != UgcVideo.STATUS_PAUSE))
    {
      paramLong1 = System.currentTimeMillis();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSizeUpdateTime != 0L) && (paramLong1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSizeUpdateTime > 500L))
      {
        paramLong2 = ((f / 100.0F * (float)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fileSize) - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSize) * 1000L / (paramLong1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSizeUpdateTime);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.uploadSpeed = (RIJUgcUtils.a(paramLong2) + "/S");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSizeUpdateTime = paramLong1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSize = ((f / 100.0F * (float)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fileSize));
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.videoProgress = ((int)f);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_UPLOADING;
      if (QLog.isColorLevel()) {
        QLog.i("RIJUGC.UploadVideoTaskStep", 2, "videoProgress = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.videoProgress + ", speed=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.uploadSpeed);
      }
    }
  }
  
  public void a(@NotNull String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.videoUploadKey = paramString;
    UploadVideoTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadVideoTaskStep).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
  }
  
  public void b(String paramString)
  {
    RIJUgcUtils.a("success", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    String str = RIJUgcUtils.a(RIJQQAppInterfaceUtil.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo).a("from", Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fromForReport)).a("compress_time", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressTime)).a("upload_time", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.uploadTotalCostTime)).a("wait_time", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.userWaitingTotalCostTime)).a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC67", str);
    QLog.i("RIJUGC.UploadVideoTaskStep", 1, "upload success");
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.UploadVideoTaskStep", 2, "url=" + paramString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.url = paramString;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressProgress = 100;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.videoProgress = 100;
    if (UploadVideoTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadVideoTaskStep) != null) {
      UploadVideoTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadVideoTaskStep).a(2, true, true, null);
    }
    UploadVideoTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadVideoTaskStep).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadVideoTaskStep.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.UploadVideoTaskStep.1
 * JD-Core Version:    0.7.0.1
 */
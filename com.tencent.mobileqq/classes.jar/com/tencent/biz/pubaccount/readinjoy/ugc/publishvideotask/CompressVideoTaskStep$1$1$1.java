package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.video.videoconverter.VideoMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;

class CompressVideoTaskStep$1$1$1
  implements Runnable
{
  CompressVideoTaskStep$1$1$1(CompressVideoTaskStep.1.1 param1, String paramString) {}
  
  public void run()
  {
    long l2 = 0L;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject;
      if (bool)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressPath = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fileMd5 = this.jdField_a_of_type_JavaLangString;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo != null) {}
        for (long l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo.d;; l1 = 0L)
        {
          ((UgcVideo)localObject).fileSize = l1;
          if (!CompressVideoTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep)) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressProgress = 100;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressTime = 0L;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressTime = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.startCompressTime);
          }
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
          l1 = l2;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo != null) {
            l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo.b;
          }
          ((UgcVideo)localObject).bitrate = l1;
          CompressVideoTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
          if (CompressVideoTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep) != null) {
            CompressVideoTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep).a(1, bool, true, null);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep.d();
          return;
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int == 6) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_PAUSE;
      }
      for (;;)
      {
        CompressVideoTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep, false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressProgress = 0;
        localObject = RIJUgcUtils.a(RIJQQAppInterfaceUtil.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo).a("compress_time", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressTime)).a("error_code", Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int)).a();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC65", (String)localObject);
        break;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_FAILED;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
        ((UgcVideo)localObject).retryTime += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.CompressVideoTaskStep.1.1.1
 * JD-Core Version:    0.7.0.1
 */
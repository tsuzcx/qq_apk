package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import nrt;
import ors;
import orz;
import qok;
import quh;
import qui;
import quj;
import qun;
import ros;

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
      UgcVideo localUgcVideo;
      if (bool)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressPath = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fileMd5 = this.jdField_a_of_type_JavaLangString;
        localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Ros != null) {}
        for (long l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Ros.d;; l1 = 0L)
        {
          localUgcVideo.fileSize = l1;
          if (!quh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_Quh)) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressProgress = 100;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressTime = 0L;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressTime = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.startCompressTime);
          }
          localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
          l1 = l2;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Ros != null) {
            l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Ros.b;
          }
          localUgcVideo.bitrate = l1;
          quh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_Quh).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
          if (quh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_Quh) != null) {
            quh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_Quh).a(1, bool, true, null);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_Quh.d();
          return;
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int == 6) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_PAUSE;
      }
      for (;;)
      {
        quh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_Quh, false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressProgress = 0;
        nrt.a("0X800AC65", qok.a(ors.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo).a("compress_time", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressTime)).a("error_code", Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int)).a());
        break;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_FAILED;
        localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Qui.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
        localUgcVideo.retryTime += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.CompressVideoTaskStep.1.1.1
 * JD-Core Version:    0.7.0.1
 */
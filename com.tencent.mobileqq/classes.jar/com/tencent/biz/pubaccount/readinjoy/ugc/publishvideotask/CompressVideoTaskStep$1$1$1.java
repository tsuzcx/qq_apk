package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import ocd;
import ozs;
import paa;
import rab;
import rgi;
import rgj;
import rgk;
import rgo;
import scn;

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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressPath = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fileMd5 = this.jdField_a_of_type_JavaLangString;
        localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Scn != null) {}
        for (long l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Scn.d;; l1 = 0L)
        {
          localUgcVideo.fileSize = l1;
          if (!rgi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_Rgi)) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressProgress = 100;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressTime = 0L;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressTime = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.startCompressTime);
          }
          localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
          l1 = l2;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Scn != null) {
            l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Scn.b;
          }
          localUgcVideo.bitrate = l1;
          rgi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_Rgi).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
          if (rgi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_Rgi) != null) {
            rgi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_Rgi).a(1, bool, true, null);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_Rgi.d();
          return;
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int == 6) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_PAUSE;
      }
      for (;;)
      {
        rgi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_Rgi, false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressProgress = 0;
        ocd.a("0X800AC65", rab.a(ozs.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo).a("compress_time", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressTime)).a("error_code", Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int)).a());
        break;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_FAILED;
        localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Rgj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
        localUgcVideo.retryTime += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.CompressVideoTaskStep.1.1.1
 * JD-Core Version:    0.7.0.1
 */
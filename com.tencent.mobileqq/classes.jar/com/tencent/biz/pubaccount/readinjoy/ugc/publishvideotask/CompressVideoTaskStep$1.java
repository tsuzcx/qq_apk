package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.video.videoconverter.VideoCompressTask.VideoCompressTaskListener;
import com.tencent.biz.pubaccount.readinjoy.video.videoconverter.VideoMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

class CompressVideoTaskStep$1
  implements VideoCompressTask.VideoCompressTaskListener
{
  CompressVideoTaskStep$1(CompressVideoTaskStep paramCompressVideoTaskStep, UgcVideo paramUgcVideo) {}
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.CompressVideoTaskStep", 2, "onCompressProgress, progress=" + paramFloat);
    }
    if (!CompressVideoTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep))
    {
      if (paramFloat > this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressProgress) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressProgress = ((int)paramFloat);
      }
      if (CompressVideoTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep) != null) {
        CompressVideoTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskCompressVideoTaskStep).a(1, true, false, null);
      }
    }
  }
  
  public void a(int paramInt, String paramString, VideoMediaInfo paramVideoMediaInfo)
  {
    ThreadManagerV2.excute(new CompressVideoTaskStep.1.1(this, paramInt, paramString, paramVideoMediaInfo), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.CompressVideoTaskStep.1
 * JD-Core Version:    0.7.0.1
 */
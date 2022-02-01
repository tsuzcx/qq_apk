package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.upload.IImageUploadListener;
import org.jetbrains.annotations.NotNull;

class UploadCoverTaskStep$1
  implements IImageUploadListener
{
  UploadCoverTaskStep$1(UploadCoverTaskStep paramUploadCoverTaskStep, UgcVideo paramUgcVideo) {}
  
  public void a(int paramInt, @NotNull String paramString)
  {
    QLog.e("RIJUGC.UploadCoverTaskStep", 1, "upload cover fail, errCode=" + paramInt + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status != UgcVideo.STATUS_PAUSE)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_FAILED;
      if (UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadCoverTaskStep) != null) {
        UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadCoverTaskStep).a(3, false, false, paramString);
      }
      UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadCoverTaskStep).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadCoverTaskStep.d();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status != UgcVideo.STATUS_PAUSE)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverProgress = ((int)((float)paramLong1 * 100.0F / (float)paramLong2));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_UPLOADING;
      if (UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadCoverTaskStep) != null) {
        UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadCoverTaskStep).a(3, true, false, null);
      }
      if (QLog.isColorLevel()) {
        QLog.i("RIJUGC.UploadCoverTaskStep", 0, "coverProgress =" + paramLong1);
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("RIJUGC.UploadCoverTaskStep", 1, "upload cover success");
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.UploadCoverTaskStep", 0, "upload cover url=" + paramString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverUrl = paramString;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status != UgcVideo.STATUS_PAUSE)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverProgress = 100;
      if (UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadCoverTaskStep) != null) {
        UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadCoverTaskStep).a(3, true, true, null);
      }
    }
    UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadCoverTaskStep).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskUploadCoverTaskStep.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.UploadCoverTaskStep.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.PublishVideoHelper.IPublishVideoCallback;
import java.util.List;

class PublishTaskStep$1
  implements PublishVideoHelper.IPublishVideoCallback
{
  PublishTaskStep$1(PublishTaskStep paramPublishTaskStep, UgcVideo paramUgcVideo) {}
  
  public void a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.rowkey = ((String)paramList.get(0));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverProgress = 100;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.videoProgress = 100;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressProgress = 100;
    }
    PublishTaskStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskPublishTaskStep, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.PublishTaskStep.1
 * JD-Core Version:    0.7.0.1
 */
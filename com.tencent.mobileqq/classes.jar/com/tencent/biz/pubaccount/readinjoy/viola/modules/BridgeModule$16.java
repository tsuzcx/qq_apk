package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.IGetAllUploadStatusVideosCallback;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class BridgeModule$16
  implements RIJUgcVideoPublishManager.IGetAllUploadStatusVideosCallback
{
  BridgeModule$16(BridgeModule paramBridgeModule, UgcVideo paramUgcVideo, String paramString) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    BridgeModule.access$1600(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId, paramList, this.jdField_a_of_type_JavaLangString, 0, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.16
 * JD-Core Version:    0.7.0.1
 */
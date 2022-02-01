package com.tencent.biz.pubaccount.readinjoy.viola.utils;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.IGetAllUploadStatusVideosCallback;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.jetbrains.annotations.NotNull;

final class ViolaBizUtils$6
  implements RIJUgcVideoPublishManager.IGetAllUploadStatusVideosCallback
{
  ViolaBizUtils$6(BridgeModule paramBridgeModule, long paramLong, String paramString) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    if (!paramList.isEmpty()) {
      ViolaBizUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_a_of_type_Long, paramList, this.jdField_a_of_type_JavaLangString, 0, "");
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(ViolaBizUtils.jdField_a_of_type_JavaLangString, 2, "getUploadingVideoList,ugcVideoList.isEmpty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils.6
 * JD-Core Version:    0.7.0.1
 */
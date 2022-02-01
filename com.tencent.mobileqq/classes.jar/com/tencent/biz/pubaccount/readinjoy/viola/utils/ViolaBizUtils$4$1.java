package com.tencent.biz.pubaccount.readinjoy.viola.utils;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils.IUploadActionCallback;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ViolaBizUtils$4$1
  implements RIJUgcUtils.IUploadActionCallback
{
  ViolaBizUtils$4$1(ViolaBizUtils.4 param4, UgcVideo paramUgcVideo, List paramList) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RIJUgcVideoPublishManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaUtilsViolaBizUtils$4.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo, true);
      ViolaBizUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaUtilsViolaBizUtils$4.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaUtilsViolaBizUtils$4.jdField_b_of_type_Int, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaUtilsViolaBizUtils$4.jdField_b_of_type_JavaLangString, 0, "");
    }
    for (;;)
    {
      QLog.i(ViolaBizUtils.a, 1, "showMobileNetworkDialog, isContinue=" + paramBoolean);
      return;
      ViolaBizUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaUtilsViolaBizUtils$4.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaUtilsViolaBizUtils$4.jdField_b_of_type_Int, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaUtilsViolaBizUtils$4.jdField_b_of_type_JavaLangString, -2, "cancel upload by user on mobile net");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils.4.1
 * JD-Core Version:    0.7.0.1
 */
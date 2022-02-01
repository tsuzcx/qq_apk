package com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix;

import com.tencent.biz.pubaccount.readinjoy.biu.RIJNewBiuCardTransformManager;
import com.tencent.biz.pubaccount.readinjoy.biu.RIJNewBiuCardTransformManager.BiuInfo;
import com.tencent.qphone.base.util.QLog;

class RIJBiuAndCommentMixDataManager$1
  implements Runnable
{
  RIJBiuAndCommentMixDataManager$1(RIJBiuAndCommentMixDataManager paramRIJBiuAndCommentMixDataManager, RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData, int paramInt) {}
  
  public void run()
  {
    if (RIJBiuAndCommentMixDataManager.a(this.this$0) != null)
    {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend callBack to mBiuAndCommentListener");
      RIJBiuAndCommentMixDataManager.a(this.this$0).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentRespData);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentRespData.c() == 1))
      {
        RIJNewBiuCardTransformManager.BiuInfo localBiuInfo = RIJNewBiuCardTransformManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentRespData, false);
        RIJNewBiuCardTransformManager.a().a(localBiuInfo);
      }
      return;
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend dataManager is destory");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager.1
 * JD-Core Version:    0.7.0.1
 */
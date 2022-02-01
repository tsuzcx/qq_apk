package com.tencent.biz.pubaccount.readinjoy.model.handler;

import com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadDataModule.PreloadCache;
import com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadExposeReport;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class RIJGetArticleListHandler$3
  implements Runnable
{
  RIJGetArticleListHandler$3(RIJGetArticleListHandler paramRIJGetArticleListHandler, long paramLong1, long paramLong2, FeedsPreloadDataModule.PreloadCache paramPreloadCache, long paramLong3) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QLog.d("RIJGetArticleListHandler", 2, new Object[] { "feedsPreload, loadingTime = ", Long.valueOf(this.jdField_a_of_type_Long) });
    QLog.d("RIJGetArticleListHandler", 2, new Object[] { "feedsPreload, schedule cost = ", Long.valueOf(l - this.b) });
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttributes().put("hitFeedsPreloadCache", Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttributes().put("feedsRequestBeginTime", Long.valueOf(this.c));
    RIJGetArticleListHandler.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.jdField_a_of_type_ArrayOfByte);
    FeedsPreloadExposeReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPreloadFeedsPreloadDataModule$PreloadCache.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJGetArticleListHandler.3
 * JD-Core Version:    0.7.0.1
 */
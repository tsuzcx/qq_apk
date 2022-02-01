package com.tencent.biz.pubaccount.readinjoy.model.handler;

import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import qit;
import qkp;
import qkt;

public class RIJGetArticleListHandler$3
  implements Runnable
{
  public RIJGetArticleListHandler$3(qit paramqit, long paramLong1, long paramLong2, qkp paramqkp, long paramLong3) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QLog.d("RIJGetArticleListHandler", 2, new Object[] { "feedsPreload, loadingTime = ", Long.valueOf(this.jdField_a_of_type_Long) });
    QLog.d("RIJGetArticleListHandler", 2, new Object[] { "feedsPreload, schedule cost = ", Long.valueOf(l - this.b) });
    this.jdField_a_of_type_Qkp.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttributes().put("hitFeedsPreloadCache", Boolean.valueOf(true));
    this.jdField_a_of_type_Qkp.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttributes().put("feedsRequestBeginTime", Long.valueOf(this.c));
    qit.a(this.this$0, this.jdField_a_of_type_Qkp.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_Qkp.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Qkp.jdField_a_of_type_Int, this.jdField_a_of_type_Qkp.jdField_b_of_type_Int, this.jdField_a_of_type_Qkp.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_Qkp.jdField_a_of_type_Boolean, this.jdField_a_of_type_Qkp.jdField_b_of_type_Boolean, this.jdField_a_of_type_Qkp.jdField_a_of_type_ArrayOfByte);
    qkt.a(this.jdField_a_of_type_Qkp.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Qkp.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJGetArticleListHandler.3
 * JD-Core Version:    0.7.0.1
 */
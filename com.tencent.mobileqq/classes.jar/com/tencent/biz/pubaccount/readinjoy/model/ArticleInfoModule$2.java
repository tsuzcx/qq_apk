package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import ptv;
import pyk;
import pyo;

public class ArticleInfoModule$2
  implements Runnable
{
  public ArticleInfoModule$2(ptv paramptv, long paramLong1, long paramLong2, pyk parampyk, long paramLong3) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QLog.d("ArticleInfoModule", 2, new Object[] { "feedsPreload, loadingTime = ", Long.valueOf(this.jdField_a_of_type_Long) });
    QLog.d("ArticleInfoModule", 2, new Object[] { "feedsPreload, schedule cost = ", Long.valueOf(l - this.b) });
    this.jdField_a_of_type_Pyk.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttributes().put("hitFeedsPreloadCache", Boolean.valueOf(true));
    this.jdField_a_of_type_Pyk.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttributes().put("feedsRequestBeginTime", Long.valueOf(this.c));
    ptv.a(this.this$0, this.jdField_a_of_type_Pyk.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_Pyk.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Pyk.jdField_a_of_type_Int, this.jdField_a_of_type_Pyk.jdField_b_of_type_Int, this.jdField_a_of_type_Pyk.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_Pyk.jdField_a_of_type_Boolean, this.jdField_a_of_type_Pyk.jdField_b_of_type_Boolean, this.jdField_a_of_type_Pyk.jdField_a_of_type_ArrayOfByte);
    pyo.a(this.jdField_a_of_type_Pyk.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Pyk.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.2
 * JD-Core Version:    0.7.0.1
 */
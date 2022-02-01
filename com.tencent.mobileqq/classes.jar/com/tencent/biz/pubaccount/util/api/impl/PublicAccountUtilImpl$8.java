package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;

class PublicAccountUtilImpl$8
  extends NewPublicAccountObserver.ResponseResultListener
{
  PublicAccountUtilImpl$8(PublicAccountUtilImpl paramPublicAccountUtilImpl, PublicAccountObserver paramPublicAccountObserver, String paramString, AppInterface paramAppInterface, Context paramContext) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, true, this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountUtilImpl.sendDetailInfoRequest(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
    }
    PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695222);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.8
 * JD-Core Version:    0.7.0.1
 */
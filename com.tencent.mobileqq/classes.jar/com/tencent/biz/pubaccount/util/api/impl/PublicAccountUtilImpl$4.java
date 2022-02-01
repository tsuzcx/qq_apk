package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;

class PublicAccountUtilImpl$4
  extends NewPublicAccountObserver.ResponseResultListener
{
  PublicAccountUtilImpl$4(PublicAccountUtilImpl paramPublicAccountUtilImpl, IPublicAccountObserver paramIPublicAccountObserver, String paramString, AppInterface paramAppInterface, Context paramContext, int paramInt, boolean paramBoolean) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(Object paramObject)
  {
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
    if (paramObject != null) {
      paramObject.onUpdate(101, true, this.jdField_a_of_type_JavaLangString);
    }
    PublicAccountUtilImpl.access$200(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
    if (paramObject != null) {
      paramObject.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Boolean) {
      PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695217);
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.4
 * JD-Core Version:    0.7.0.1
 */
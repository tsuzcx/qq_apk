package com.tencent.biz.pubaccount.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class PublicAccountJavascriptInterfaceImpl$10
{
  PublicAccountJavascriptInterfaceImpl$10(PublicAccountJavascriptInterfaceImpl paramPublicAccountJavascriptInterfaceImpl, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString, long paramLong) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-3", "{}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new PublicAccountJavascriptInterfaceImpl.TimedOnLocationListener(this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl, 0, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.10
 * JD-Core Version:    0.7.0.1
 */
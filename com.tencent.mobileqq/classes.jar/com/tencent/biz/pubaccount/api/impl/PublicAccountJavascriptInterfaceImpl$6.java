package com.tencent.biz.pubaccount.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class PublicAccountJavascriptInterfaceImpl$6
{
  PublicAccountJavascriptInterfaceImpl$6(PublicAccountJavascriptInterfaceImpl paramPublicAccountJavascriptInterfaceImpl, String paramString, long paramLong) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-3", "{}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new PublicAccountJavascriptInterfaceImpl.TimedOnLocationListener(this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl, 0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long));
    if (QLog.isColorLevel()) {
      QLog.d("PAjs.location", 2, "SosoInterface.startLocation");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.6
 * JD-Core Version:    0.7.0.1
 */
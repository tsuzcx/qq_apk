package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class BridgeModule$2
  implements INetInfoHandler
{
  BridgeModule$2(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgeModule", 2, "INetInfoHandler onNetNone2Wifi():NET_NONE");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getNetType(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgeModule", 2, "INetInfoHandler onNetNone2Wifi():NET_WIFI,ssid=" + paramString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getNetType(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgeModule", 2, "INetInfoHandler onNetNone2Wifi():NET_XG,ssid=" + paramString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getNetType(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgeModule", 2, "INetInfoHandler onNetNone2Wifi():NET_WIFI,ssid=" + paramString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getNetType(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgeModule", 2, "INetInfoHandler onNetNone2Wifi():NET_XG,ssid=" + paramString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getNetType(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgeModule", 2, "INetInfoHandler onNetNone2Wifi():NET_NONE");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getNetType(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.2
 * JD-Core Version:    0.7.0.1
 */
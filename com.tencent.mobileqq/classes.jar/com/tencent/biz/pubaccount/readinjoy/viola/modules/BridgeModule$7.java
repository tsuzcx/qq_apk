package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.mobileqq.WebSsoBody.WebSsoControlData;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeModule$7
  implements BusinessObserver
{
  BridgeModule$7(BridgeModule paramBridgeModule, String paramString1, String paramString2, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    if (paramBoolean) {
      try
      {
        Object localObject2 = paramBundle.getByteArray("data");
        if (localObject2 != null)
        {
          localObject1 = new WebSsoBody.WebSsoResponseBody();
          ((WebSsoBody.WebSsoResponseBody)localObject1).mergeFrom((byte[])localObject2);
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("data", ((WebSsoBody.WebSsoResponseBody)localObject1).data.get());
          ((JSONObject)localObject2).put("retcode", ((WebSsoBody.WebSsoResponseBody)localObject1).ret.get());
          ((JSONObject)localObject2).put("cret", 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localObject2);
          if (((WebSsoBody.WebSsoControlData)((WebSsoBody.WebSsoResponseBody)localObject1).controlData.get()).frequency.has()) {
            BridgeModule.access$102(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, ((WebSsoBody.WebSsoControlData)((WebSsoBody.WebSsoResponseBody)localObject1).controlData.get()).frequency.get());
          }
          if (((WebSsoBody.WebSsoControlData)((WebSsoBody.WebSsoResponseBody)localObject1).controlData.get()).packageSize.has()) {
            BridgeModule.access$202(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, ((WebSsoBody.WebSsoControlData)((WebSsoBody.WebSsoResponseBody)localObject1).controlData.get()).packageSize.get());
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          BridgeModuleHelper.a((WebSsoBody.WebSsoResponseBody)localObject1, paramBundle);
          return;
        }
        QLog.e("BridgeModule", 1, "request web sso success, but byte data is null, cmd: " + this.b);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle = new JSONObject();
        try
        {
          paramBundle.put("cret", 2);
          return;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      }
    }
    try
    {
      if ((ViolaBaseView.a) && (paramBundle.containsKey("data_error_code")) && (paramBundle.getInt("data_error_code") == 1002)) {
        BridgeModule.ssoTimeOutRecordStr = BridgeModule.ssoTimeOutRecordStr + paramBundle.getString("cmd") + "\n";
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("cret", 1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localObject1);
      BridgeModuleHelper.a(paramBundle);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("BridgeModule", 2, "sendRequest failed when time out :" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.7
 * JD-Core Version:    0.7.0.1
 */
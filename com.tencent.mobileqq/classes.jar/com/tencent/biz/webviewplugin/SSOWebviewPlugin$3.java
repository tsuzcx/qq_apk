package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoControlData;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

class SSOWebviewPlugin$3
  implements BusinessObserver
{
  SSOWebviewPlugin$3(SSOWebviewPlugin paramSSOWebviewPlugin, String paramString1, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
        localWebSsoResponseBody.mergeFrom(paramBundle);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", localWebSsoResponseBody.data.get());
        localJSONObject.put("retcode", localWebSsoResponseBody.ret.get());
        localJSONObject.put("cret", 0);
        this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        if (((WebSsoBody.WebSsoControlData)localWebSsoResponseBody.controlData.get()).frequency.has()) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.a = ((WebSsoBody.WebSsoControlData)localWebSsoResponseBody.controlData.get()).frequency.get();
        }
        if (((WebSsoBody.WebSsoControlData)localWebSsoResponseBody.controlData.get()).packageSize.has()) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.b = ((WebSsoBody.WebSsoControlData)localWebSsoResponseBody.controlData.get()).packageSize.get();
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("SSOWebviewPlugin", 2, String.format("onReceive cmd=%s %b frequency=%d result=%s", new Object[] { this.b, Boolean.valueOf(((WebSsoBody.WebSsoControlData)localWebSsoResponseBody.controlData.get()).frequency.has()), Integer.valueOf(this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.a), localJSONObject }));
        }
      }
      if (!QLog.isColorLevel()) {
        break label426;
      }
      if (paramBundle == null) {
        break label431;
      }
      paramBoolean = true;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        continue;
        paramBoolean = false;
      }
    }
    QLog.i("SSOWebviewPlugin", 2, String.format("onReceive data!=null[%b]", new Object[] { Boolean.valueOf(paramBoolean) }));
    return;
    paramBundle = new JSONObject();
    paramBundle.put("cret", 1);
    this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
    if (QLog.isColorLevel())
    {
      QLog.d("SSOWebviewPlugin", 2, new Object[] { "onReceive type:", Integer.valueOf(paramInt), " isSuccess:", Boolean.valueOf(paramBoolean) });
      return;
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("cret", 2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
    }
    label426:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.SSOWebviewPlugin.3
 * JD-Core Version:    0.7.0.1
 */
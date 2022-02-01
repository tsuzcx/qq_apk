package com.tencent.gdtad.jsbridge;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONObject;

class GdtGetUserInfoHandler$1
  implements TroopMemberApiClient.Callback
{
  GdtGetUserInfoHandler$1(GdtGetUserInfoHandler paramGdtGetUserInfoHandler, GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String[] paramArrayOfString, TroopMemberApiClient paramTroopMemberApiClient) {}
  
  public void callback(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("phone");
    String str2 = paramBundle.getString("name");
    String str3 = paramBundle.getString("city");
    String str4 = paramBundle.getString("area");
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("phone", str1);
      paramBundle.put("name", str2);
      paramBundle.put("city", str3);
      paramBundle.put("area", str4);
      paramBundle = paramBundle.toString();
      GdtLog.a("GdtGetUserInfoHandler", "handleJsCallRequest() called with: webPlugin = [" + this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdWebPlugin + "], callback = [" + this.jdField_a_of_type_JavaLangString + "], args = [" + this.jdField_a_of_type_ArrayOfJavaLangString + "], result = [" + paramBundle + "]");
      this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdWebPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        GdtLog.d("GdtGetUserInfoHandler", localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */
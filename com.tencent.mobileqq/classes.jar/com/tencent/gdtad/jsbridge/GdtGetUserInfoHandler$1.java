package com.tencent.gdtad.jsbridge;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import org.json.JSONObject;

class GdtGetUserInfoHandler$1
  implements ITroopMemberApiClientApi.Callback
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
    }
    catch (Exception localException)
    {
      GdtLog.d("GdtGetUserInfoHandler", localException.toString());
    }
    paramBundle = paramBundle.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleJsCallRequest() called with: webPlugin = [");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdWebPlugin);
    localStringBuilder.append("], callback = [");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("], args = [");
    localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangString);
    localStringBuilder.append("], result = [");
    localStringBuilder.append(paramBundle);
    localStringBuilder.append("]");
    GdtLog.a("GdtGetUserInfoHandler", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdWebPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */
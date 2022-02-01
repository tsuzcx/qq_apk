package com.tencent.biz.pubaccount.readinjoy.plugin;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyWebviewPlugin$4
  implements TroopMemberApiClient.Callback
{
  ReadInJoyWebviewPlugin$4(ReadInJoyWebviewPlugin paramReadInJoyWebviewPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("ReadInJoyWebviewPlugin", 4, "receive notifyLoadSkin callback resp:" + paramBundle.toString());
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramBundle = localJSONObject.put("retCode", paramBundle.getInt("retCode")).put("skinId", "" + paramBundle.getString("skinId")).put("rate", paramBundle.getInt("rate"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoyWebviewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException paramBundle)
    {
      QLog.w("ReadInJoyWebviewPlugin", 1, "notifyLoadSkin error " + paramBundle.toString());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoyWebviewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"retCode\":-1}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.plugin.ReadInJoyWebviewPlugin.4
 * JD-Core Version:    0.7.0.1
 */
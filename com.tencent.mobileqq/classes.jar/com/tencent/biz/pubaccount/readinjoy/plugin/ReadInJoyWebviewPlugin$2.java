package com.tencent.biz.pubaccount.readinjoy.plugin;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyWebviewPlugin$2
  implements TroopMemberApiClient.Callback
{
  ReadInJoyWebviewPlugin$2(ReadInJoyWebviewPlugin paramReadInJoyWebviewPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("ALD_CONFIG_RESULT", "");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("value", paramBundle);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoyWebviewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyWebviewPlugin", 2, "Error in value:" + paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.plugin.ReadInJoyWebviewPlugin.2
 * JD-Core Version:    0.7.0.1
 */
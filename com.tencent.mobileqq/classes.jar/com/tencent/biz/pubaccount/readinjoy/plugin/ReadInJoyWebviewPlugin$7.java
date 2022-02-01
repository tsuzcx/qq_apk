package com.tencent.biz.pubaccount.readinjoy.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;

class ReadInJoyWebviewPlugin$7
  implements TroopMemberApiClient.Callback
{
  ReadInJoyWebviewPlugin$7(ReadInJoyWebviewPlugin paramReadInJoyWebviewPlugin, int paramInt, Intent paramIntent, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("BUNDLE_KEY_JS_OBJ", "");
    if (ReadInJoyWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoyWebviewPlugin, paramBundle, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentIntent)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoyWebviewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.plugin.ReadInJoyWebviewPlugin.7
 * JD-Core Version:    0.7.0.1
 */
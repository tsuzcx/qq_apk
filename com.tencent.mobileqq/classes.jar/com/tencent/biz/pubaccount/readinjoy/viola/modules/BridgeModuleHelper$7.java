package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

final class BridgeModuleHelper$7
  implements View.OnClickListener
{
  BridgeModuleHelper$7(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("timestamp", System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localJSONObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("BridgeModuleHelper", 1, "[setTitleClickListener]: " + localJSONException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModuleHelper.7
 * JD-Core Version:    0.7.0.1
 */
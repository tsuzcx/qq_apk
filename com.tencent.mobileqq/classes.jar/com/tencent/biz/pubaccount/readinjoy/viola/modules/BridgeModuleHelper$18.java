package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

final class BridgeModuleHelper$18
  implements View.OnClickListener
{
  BridgeModuleHelper$18(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, new JSONObject());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModuleHelper.18
 * JD-Core Version:    0.7.0.1
 */
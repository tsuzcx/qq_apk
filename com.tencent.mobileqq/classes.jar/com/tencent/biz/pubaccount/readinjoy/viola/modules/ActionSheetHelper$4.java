package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class ActionSheetHelper$4
  implements DialogInterface.OnCancelListener
{
  ActionSheetHelper$4(ActionSheetHelper paramActionSheetHelper, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("index", ActionSheetHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesActionSheetHelper));
      paramDialogInterface.put("type", 1);
      if (ActionSheetHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesActionSheetHelper) != null) {
        ((BridgeModule)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesActionSheetHelper).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramDialogInterface);
      }
      return;
    }
    catch (JSONException paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.ActionSheetHelper.4
 * JD-Core Version:    0.7.0.1
 */
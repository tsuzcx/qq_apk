package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeModule$6
  implements DialogInterface.OnDismissListener
{
  BridgeModule$6(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("type", -1);
      paramDialogInterface.put("action", "close");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, paramDialogInterface);
      }
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      QLog.e("BridgeModule", 2, QLog.getStackTraceString(paramDialogInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.6
 * JD-Core Version:    0.7.0.1
 */
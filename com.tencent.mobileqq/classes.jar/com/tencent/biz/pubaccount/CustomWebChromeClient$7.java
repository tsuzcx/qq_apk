package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.smtt.export.external.interfaces.JsResult;

class CustomWebChromeClient$7
  implements DialogInterface.OnCancelListener
{
  CustomWebChromeClient$7(CustomWebChromeClient paramCustomWebChromeClient, JsResult paramJsResult, Context paramContext) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesJsResult.cancel();
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient.a > 2) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebChromeClient.7
 * JD-Core Version:    0.7.0.1
 */
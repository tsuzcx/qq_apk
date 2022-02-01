package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.smtt.export.external.interfaces.JsResult;

class CustomWebChromeClient$5
  implements DialogInterface.OnClickListener
{
  CustomWebChromeClient$5(CustomWebChromeClient paramCustomWebChromeClient, JsResult paramJsResult, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesJsResult.cancel();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebChromeClient.5
 * JD-Core Version:    0.7.0.1
 */
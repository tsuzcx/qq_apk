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
    this.a.cancel();
    if (this.c.c > 2) {
      ((Activity)this.b).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebChromeClient.7
 * JD-Core Version:    0.7.0.1
 */
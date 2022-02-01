package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.smtt.export.external.interfaces.JsResult;

class CustomWebChromeClient$9
  implements DialogInterface.OnClickListener
{
  CustomWebChromeClient$9(CustomWebChromeClient paramCustomWebChromeClient, JsResult paramJsResult, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.cancel();
    ((Activity)this.b).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebChromeClient.9
 * JD-Core Version:    0.7.0.1
 */
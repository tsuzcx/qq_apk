package com.tencent.biz.pubaccount.api.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class PublicAccountJavascriptInterfaceImpl$9
  implements DialogInterface.OnCancelListener
{
  PublicAccountJavascriptInterfaceImpl$9(PublicAccountJavascriptInterfaceImpl paramPublicAccountJavascriptInterfaceImpl, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.b.callJs(this.a, new String[] { "-3", "{}" });
    this.b.hasAsked = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.9
 * JD-Core Version:    0.7.0.1
 */
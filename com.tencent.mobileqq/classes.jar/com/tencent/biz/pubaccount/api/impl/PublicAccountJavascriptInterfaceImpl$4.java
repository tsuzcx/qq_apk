package com.tencent.biz.pubaccount.api.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class PublicAccountJavascriptInterfaceImpl$4
  implements DialogInterface.OnClickListener
{
  PublicAccountJavascriptInterfaceImpl$4(PublicAccountJavascriptInterfaceImpl paramPublicAccountJavascriptInterfaceImpl, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.b.callJs(this.a, new String[] { "-3", "{}" });
    this.b.hasAsked = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.4
 * JD-Core Version:    0.7.0.1
 */
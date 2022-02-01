package com.tencent.biz.pubaccount.api.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.smtt.sdk.WebView;

class PublicAccountJavascriptInterfaceImpl$11
  implements DialogInterface.OnClickListener
{
  PublicAccountJavascriptInterfaceImpl$11(PublicAccountJavascriptInterfaceImpl paramPublicAccountJavascriptInterfaceImpl, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.mRuntime.a();
    if (paramDialogInterface == null) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        paramDialogInterface.loadUrl("javascript:" + this.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (paramInt != 1);
    paramDialogInterface.loadUrl("javascript:" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.11
 * JD-Core Version:    0.7.0.1
 */
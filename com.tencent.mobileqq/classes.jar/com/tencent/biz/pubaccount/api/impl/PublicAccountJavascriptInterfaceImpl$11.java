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
    paramDialogInterface = this.c.mRuntime.a();
    if (paramDialogInterface == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:");
      localStringBuilder.append(this.a);
      paramDialogInterface.loadUrl(localStringBuilder.toString());
      return;
    }
    if (paramInt == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:");
      localStringBuilder.append(this.b);
      paramDialogInterface.loadUrl(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.11
 * JD-Core Version:    0.7.0.1
 */
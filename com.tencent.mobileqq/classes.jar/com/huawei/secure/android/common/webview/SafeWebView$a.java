package com.huawei.secure.android.common.webview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

class SafeWebView$a
  implements DialogInterface.OnClickListener
{
  private final SslErrorHandler L;
  
  SafeWebView$a(SslErrorHandler paramSslErrorHandler)
  {
    this.L = paramSslErrorHandler;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.L.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.webview.SafeWebView.a
 * JD-Core Version:    0.7.0.1
 */
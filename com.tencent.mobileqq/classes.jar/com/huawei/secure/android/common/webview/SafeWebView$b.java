package com.huawei.secure.android.common.webview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

class SafeWebView$b
  implements DialogInterface.OnClickListener
{
  private final SslErrorHandler N;
  
  SafeWebView$b(SslErrorHandler paramSslErrorHandler)
  {
    this.N = paramSslErrorHandler;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.N.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.webview.SafeWebView.b
 * JD-Core Version:    0.7.0.1
 */
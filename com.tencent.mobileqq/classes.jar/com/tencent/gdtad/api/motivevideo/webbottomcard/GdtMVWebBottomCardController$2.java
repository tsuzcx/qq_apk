package com.tencent.gdtad.api.motivevideo.webbottomcard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.smtt.sdk.WebView;

class GdtMVWebBottomCardController$2
  extends GdtWebViewBuilder
{
  GdtMVWebBottomCardController$2(GdtMVWebBottomCardController paramGdtMVWebBottomCardController, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    this.a.a.a();
    c();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.webbottomcard.GdtMVWebBottomCardController.2
 * JD-Core Version:    0.7.0.1
 */
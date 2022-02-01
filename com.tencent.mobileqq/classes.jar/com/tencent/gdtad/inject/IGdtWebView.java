package com.tencent.gdtad.inject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.smtt.sdk.WebView;

public abstract interface IGdtWebView
{
  public abstract void a();
  
  public abstract void a(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface, IGdtWebViewListener paramIGdtWebViewListener);
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void a(Bundle paramBundle, AppInterface paramAppInterface, Intent paramIntent);
  
  public abstract void a(WebView paramWebView);
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.inject.IGdtWebView
 * JD-Core Version:    0.7.0.1
 */
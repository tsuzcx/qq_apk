package com.tencent.ilive.litepages.room.webmodule;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.litepages.room.webmodule.js.AppJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.js.MiscJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.js.RecordJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.js.UIJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.LiteJsModuleProvider;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LiteWebViewClient
  extends WebViewClient
{
  public static final String TAG = "LiteLiveWebViewClient";
  private Context mActivityContext;
  private JsBizAdapter mJsBizAdapter;
  private LiteJsModuleProvider mLiteJsModuleProvider;
  
  public LiteWebViewClient(WebView paramWebView, View paramView, Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    this.mActivityContext = paramContext;
    this.mJsBizAdapter = paramJsBizAdapter;
    this.mLiteJsModuleProvider = new LiteJsModuleProvider();
    paramWebView = new AppJavascriptInterface(paramContext, paramView, paramJsBizAdapter);
    paramView = new RecordJavascriptInterface(paramContext, paramJsBizAdapter);
    UIJavascriptInterface localUIJavascriptInterface = new UIJavascriptInterface(paramContext, paramJsBizAdapter);
    paramContext = new MiscJavascriptInterface(paramContext, paramJsBizAdapter);
    this.mLiteJsModuleProvider.registerJsModule(paramWebView);
    this.mLiteJsModuleProvider.registerJsModule(paramView);
    this.mLiteJsModuleProvider.registerJsModule(localUIJavascriptInterface);
    this.mLiteJsModuleProvider.registerJsModule(paramContext);
  }
  
  public void onDestroy()
  {
    if (this.mLiteJsModuleProvider != null) {
      this.mLiteJsModuleProvider.removeAllJsModule();
    }
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.mJsBizAdapter != null) && (this.mJsBizAdapter.getLogger() != null)) {
      this.mJsBizAdapter.getLogger().i("LiteLiveWebViewClient", "shouldOverrideUrlLoading url = " + paramString, new Object[0]);
    }
    if (paramString.startsWith("jsbridge://"))
    {
      paramString = Uri.parse(paramString);
      paramWebView = new HashMap();
      Object localObject = paramString.getQueryParameterNames().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        paramWebView.put(str, paramString.getQueryParameter(str));
      }
      localObject = paramString.getAuthority();
      paramString = paramString.getPath();
      paramString = paramString.substring(1, paramString.length());
      if (this.mLiteJsModuleProvider != null) {
        this.mLiteJsModuleProvider.callFunction((String)localObject, paramString, paramWebView);
      }
      return true;
    }
    paramWebView = new Intent("android.intent.action.VIEW");
    paramWebView.setData(Uri.parse(paramString));
    paramWebView.setPackage(this.mActivityContext.getPackageName());
    this.mActivityContext.startActivity(paramWebView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.LiteWebViewClient
 * JD-Core Version:    0.7.0.1
 */
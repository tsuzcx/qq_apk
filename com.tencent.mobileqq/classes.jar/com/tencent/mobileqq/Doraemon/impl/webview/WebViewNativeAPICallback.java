package com.tencent.mobileqq.Doraemon.impl.webview;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.Doraemon.APICallback;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebViewNativeAPICallback
  implements APICallback
{
  private WeakReference<CustomWebView> a;
  private String b;
  
  public WebViewNativeAPICallback(CustomWebView paramCustomWebView, JSONObject paramJSONObject)
  {
    this.a = new WeakReference(paramCustomWebView);
    this.b = paramJSONObject.optString("__nativeAPICallID__");
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.b))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.a.get();
      if (localCustomWebView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['");
        localStringBuilder.append(this.b);
        localStringBuilder.append("', 4]);");
        localCustomWebView.callJs(localStringBuilder.toString());
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.a.get();
      if (localCustomWebView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['");
        localStringBuilder.append(this.b);
        localStringBuilder.append("', 1, ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]);");
        localCustomWebView.callJs(localStringBuilder.toString());
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.a.get();
      if (localCustomWebView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['");
        localStringBuilder.append(this.b);
        localStringBuilder.append("', 3, ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", '");
        localStringBuilder.append(paramString);
        localStringBuilder.append("']);");
        localCustomWebView.callJs(localStringBuilder.toString());
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.a.get();
      if (localCustomWebView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['");
        localStringBuilder.append(this.b);
        localStringBuilder.append("', 2, ");
        localStringBuilder.append(paramJSONObject.toString());
        localStringBuilder.append("]);");
        localCustomWebView.callJs(localStringBuilder.toString());
      }
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.a.get();
      if (localCustomWebView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['");
        localStringBuilder.append(this.b);
        localStringBuilder.append("', 5, ");
        localStringBuilder.append(paramJSONObject.toString());
        localStringBuilder.append("]);");
        localCustomWebView.callJs(localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.webview.WebViewNativeAPICallback
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.Doraemon.impl.webview;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.Doraemon.APICallback;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebViewNativeAPICallback
  implements APICallback
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<CustomWebView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public WebViewNativeAPICallback(CustomWebView paramCustomWebView, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCustomWebView);
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("__nativeAPICallID__");
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localCustomWebView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("', 4]);");
        localCustomWebView.callJs(localStringBuilder.toString());
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localCustomWebView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("', 1, ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]);");
        localCustomWebView.callJs(localStringBuilder.toString());
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localCustomWebView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
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
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localCustomWebView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("', 2, ");
        localStringBuilder.append(paramJSONObject.toString());
        localStringBuilder.append("]);");
        localCustomWebView.callJs(localStringBuilder.toString());
      }
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localCustomWebView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("', 5, ");
        localStringBuilder.append(paramJSONObject.toString());
        localStringBuilder.append("]);");
        localCustomWebView.callJs(localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.webview.WebViewNativeAPICallback
 * JD-Core Version:    0.7.0.1
 */
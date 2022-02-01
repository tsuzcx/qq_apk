package com.tencent.mobileqq.Doraemon;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.Doraemon.impl.webview.WebViewDoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.impl.webview.WebViewNativeAPICallback;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.nativeapi.INativeApiMangerInjector;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeApiManagerImpl
  implements INativeApiMangerInjector
{
  private static boolean jdField_a_of_type_Boolean = false;
  private LruCache<String, WebViewDoraemonAPIManager> jdField_a_of_type_AndroidUtilLruCache;
  
  public DoraemonAPIManager a(String paramString)
  {
    paramString = DoraemonUtil.a(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeApiManagerImpl", 2, "invalid native api call, url is illegal");
      }
      return null;
    }
    LruCache localLruCache = this.jdField_a_of_type_AndroidUtilLruCache;
    if (localLruCache == null) {
      return null;
    }
    return (DoraemonAPIManager)localLruCache.get(paramString);
  }
  
  public void a()
  {
    LruCache localLruCache = this.jdField_a_of_type_AndroidUtilLruCache;
    if (localLruCache != null) {
      localLruCache.evictAll();
    }
  }
  
  public boolean a(CustomWebView paramCustomWebView, String paramString, Activity paramActivity)
  {
    String str2 = paramCustomWebView.getUrl();
    int i = paramString.indexOf('?');
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeApiManagerImpl", 2, "invalid native api call, '?' request");
      }
      return true;
    }
    String str1 = paramString.substring(12, i);
    if (!paramString.startsWith("p=", i + 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeApiManagerImpl", 2, "invalid native api call, param key not found");
      }
      return true;
    }
    paramString = URLDecoder.decode(paramString.substring(i + 3));
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      WebViewNativeAPICallback localWebViewNativeAPICallback = new WebViewNativeAPICallback(paramCustomWebView, localJSONObject);
      str2 = DoraemonUtil.a(str2);
      if (TextUtils.isEmpty(str2))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("NativeApiManagerImpl", 2, "invalid native api call, url is illegal");
          return true;
        }
      }
      else
      {
        if (this.jdField_a_of_type_AndroidUtilLruCache == null)
        {
          if (!jdField_a_of_type_Boolean)
          {
            jdField_a_of_type_Boolean = true;
            ((IDoraemonService)QRoute.api(IDoraemonService.class)).prepare();
          }
          this.jdField_a_of_type_AndroidUtilLruCache = new NativeApiManagerImpl.1(this, 2);
        }
        paramString = (WebViewDoraemonAPIManager)this.jdField_a_of_type_AndroidUtilLruCache.get(str2);
        if ("config".equals(str1))
        {
          paramCustomWebView = paramString;
          if (paramString == null)
          {
            paramCustomWebView = localJSONObject.optString("appid");
            paramString = new Bundle();
            paramString.putString("urlSummary", str2);
            paramString = (WebViewDoraemonAPIManager)((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager(paramActivity, 0, paramCustomWebView, paramString);
            paramCustomWebView = paramString;
            if (paramString != null)
            {
              paramCustomWebView = localJSONObject.optString("state");
              paramActivity = localJSONObject.optString("redirect_uri");
              if ((!TextUtils.isEmpty(paramCustomWebView)) && (!TextUtils.isEmpty(paramActivity)))
              {
                paramString.b = true;
                paramString.d = paramCustomWebView;
                paramString.e = paramActivity;
              }
              this.jdField_a_of_type_AndroidUtilLruCache.put(str2, paramString);
              paramCustomWebView = paramString;
            }
          }
          if (paramCustomWebView != null)
          {
            paramCustomWebView.a(str1, localJSONObject, localWebViewNativeAPICallback);
            return true;
          }
          if (QLog.isColorLevel()) {
            QLog.d("NativeApiManagerImpl", 2, "apimgr create fail");
          }
          DoraemonUtil.a(localWebViewNativeAPICallback, 11);
          return true;
        }
        if ((paramString != null) && (paramString.b()))
        {
          paramString.a(str1, localJSONObject, localWebViewNativeAPICallback);
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NativeApiManagerImpl", 2, "apimgr not verified");
        }
        DoraemonUtil.a(localWebViewNativeAPICallback, 10);
        return true;
      }
    }
    catch (JSONException paramCustomWebView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeApiManagerImpl", 2, "invalid native api call, parse param error", paramCustomWebView);
      }
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.NativeApiManagerImpl
 * JD-Core Version:    0.7.0.1
 */
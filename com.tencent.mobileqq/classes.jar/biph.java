import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.util.ArrayList;
import java.util.Iterator;

final class biph
  extends ProxyWebViewClientExtension
{
  ArrayMap<String, Object> jdField_a_of_type_AndroidSupportV4UtilArrayMap;
  bioe jdField_a_of_type_Bioe;
  final TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  
  public biph(bipd parambipd, TouchWebView paramTouchWebView, bioe parambioe)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
    this.jdField_a_of_type_Bioe = parambioe;
  }
  
  void a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
    if (localWebViewPluginEngine != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap == null) {
        this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(4);
      }
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("performanceData", paramObject1);
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("requestData", paramObject2);
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("responseData", paramObject3);
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("errorCode", paramObject4);
      localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 64L, this.jdField_a_of_type_AndroidSupportV4UtilArrayMap);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("WebCoreDump", 2, "No JS plugin engine to web core dump");
  }
  
  public void computeScroll(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.computeScroll(paramView);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView.dispatchTouchEvent(paramMotionEvent, paramView);
  }
  
  public void onFakeLoginRecognised(Bundle paramBundle)
  {
    super.onFakeLoginRecognised(paramBundle);
    boolean bool1;
    String str2;
    boolean bool2;
    boolean bool3;
    StringBuilder localStringBuilder;
    try
    {
      localObject = (ArrayList)paramBundle.get("recognised-text");
      bool1 = paramBundle.getBoolean("virtual-keyboard", false);
      str2 = paramBundle.getString("normal-input-value-change");
      bool2 = paramBundle.getBoolean("password-start-input", false);
      bool3 = paramBundle.getBoolean("password-input-show", false);
      localStringBuilder = new StringBuilder(128);
      if (localObject != null)
      {
        paramBundle = ((ArrayList)localObject).iterator();
        while (paramBundle.hasNext())
        {
          localStringBuilder.append((String)paramBundle.next()).append(",");
          continue;
          return;
        }
      }
    }
    catch (Throwable paramBundle)
    {
      QLog.e("WebLog_WebViewWrapper", 2, "onFakeLoginRecognised ", paramBundle);
    }
    paramBundle = "";
    String str1 = "";
    if (this.jdField_a_of_type_Bipd.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      paramBundle = this.jdField_a_of_type_Bipd.jdField_a_of_type_ComTencentBizUiTouchWebView.getOriginalUrl();
      str1 = this.jdField_a_of_type_Bipd.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
      biqx.a(paramBundle, str1, localStringBuilder.toString(), str2, bool2, bool3, bool1);
    }
    String str3;
    if (((localObject != null) && (((ArrayList)localObject).size() > 0)) || (bool1) || (!TextUtils.isEmpty(str2)))
    {
      str3 = this.jdField_a_of_type_Bipd.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      if (this.jdField_a_of_type_Bipd.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
        break label321;
      }
    }
    label321:
    for (Object localObject = this.jdField_a_of_type_Bipd.jdField_a_of_type_ComTencentBizUiTouchWebView.getTitle();; localObject = "")
    {
      biqx.a(paramBundle, str1, (String)localObject, str3);
      localStringBuilder.append(" hasVirtualKB:").append(bool1);
      localStringBuilder.append(" inputText:").append(str2);
      localStringBuilder.append(" passwdTyped:").append(bool2);
      localStringBuilder.append(" showPasswdInput:").append(bool3);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "onFakeLoginRecognised ", localStringBuilder.toString() });
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView.onInterceptTouchEvent(paramMotionEvent, paramView);
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Bioe != null) {
      return this.jdField_a_of_type_Bioe.handlerMiscCallback(paramString, paramBundle);
    }
    return null;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if ((paramString.equalsIgnoreCase("onReportResourceInfo")) || (paramString.equalsIgnoreCase("onResourcesPerformance"))) {
      a(paramObject1, paramObject2, paramObject3, paramObject4);
    }
    return null;
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
  }
  
  public void onPrefetchResourceHit(boolean paramBoolean)
  {
    QLog.i("WebLog_WebViewWrapper", 1, "now prefetchResource is hit: " + paramBoolean);
  }
  
  public void onPreloadCallback(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Bioe != null) {
      this.jdField_a_of_type_Bioe.handlePreloadCallback(paramInt, paramString);
    }
  }
  
  public void onResponseReceived(WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    a(null, paramWebResourceRequest, paramWebResourceResponse, Integer.valueOf(paramInt));
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView.onTouchEvent(paramMotionEvent, paramView);
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    
    if (this.jdField_a_of_type_Bioe != null) {
      this.jdField_a_of_type_Bioe.onUrlChange(paramString1, paramString2);
    }
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biph
 * JD-Core Version:    0.7.0.1
 */
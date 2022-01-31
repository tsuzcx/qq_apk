import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;

final class beaf
  extends ProxyWebViewClientExtension
{
  private ArrayMap<String, Object> jdField_a_of_type_AndroidSupportV4UtilArrayMap;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  
  public beaf(beaa parambeaa, TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
  }
  
  private void a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
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
      if (QLog.isColorLevel()) {
        QLog.i("WebCoreDump", 2, "Take web core dump for " + ndq.b(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), new String[0]));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("WebCoreDump", 2, "No JS plugin engine to handle web core dump");
  }
  
  public void computeScroll(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.computeScroll(paramView);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView.dispatchTouchEvent(paramMotionEvent, paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView.onInterceptTouchEvent(paramMotionEvent, paramView);
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    this.jdField_a_of_type_Beaa.onMiscCallBack(paramString, paramBundle);
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
    if (QLog.isColorLevel()) {
      QLog.i("AbsWebView", 2, "onUrlChange detect 302 url: " + paramString2);
    }
    SwiftBrowserCookieMonster.d();
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beaf
 * JD-Core Version:    0.7.0.1
 */
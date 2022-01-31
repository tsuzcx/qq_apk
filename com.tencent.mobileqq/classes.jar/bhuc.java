import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class bhuc
  extends bcal
  implements bcbj
{
  public static final WebAccelerateHelper.CommonJsPluginFactory a;
  protected Intent a;
  private bhue jdField_a_of_type_Bhue;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqWebprocessWebAccelerateHelper$CommonJsPluginFactory = new bhud();
  }
  
  public bhuc(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    super.doOnResume();
  }
  
  public void a(bhue parambhue)
  {
    this.jdField_a_of_type_Bhue = parambhue;
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    this.mWebview = paramTouchWebView;
  }
  
  public void a(String paramString)
  {
    if (this.mWebview != null) {
      this.mWebview.callJs(paramString);
    }
  }
  
  public void b()
  {
    super.doOnPause();
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    if (this.mPluginList == null) {
      this.mPluginList = new ArrayList();
    }
    this.mPluginList.add(new bhrc());
  }
  
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout() {}
  
  public void buildTitleBar() {}
  
  public final void buildWebView(AppInterface paramAppInterface)
  {
    super.buildBaseWebView(paramAppInterface);
    onWebViewReady();
  }
  
  public void c()
  {
    try
    {
      super.doOnDestroy();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected WebAccelerateHelper.CommonJsPluginFactory myCommonJsPlugins()
  {
    if (this.jdField_a_of_type_Boolean) {
      return jdField_a_of_type_ComTencentMobileqqWebprocessWebAccelerateHelper$CommonJsPluginFactory;
    }
    return new WebAccelerateHelper.CommonJsPluginFactory();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.jdField_a_of_type_Bhue != null) {}
    try
    {
      this.jdField_a_of_type_Bhue.a();
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Bhue != null) {}
    try
    {
      this.jdField_a_of_type_Bhue.a(paramInt, paramString1, paramString2);
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public void onWebViewReady() {}
  
  public void preInitWebviewPlugin()
  {
    super.preInitPluginEngine();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneWebViewBaseBuilder", 2, "loadUrl in shouldOverrideUrlLoading url=" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {
      return true;
    }
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhuc
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.webviewplugin;

import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.CheckOfflineCallback;
import com.tencent.qphone.base.util.QLog;

class OfflinePlugin$4
  implements SwiftBrowserOfflineHandler.CheckOfflineCallback
{
  OfflinePlugin$4(OfflinePlugin paramOfflinePlugin, long paramLong, String paramString) {}
  
  public void onCheckOfflineFinish(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.c = ((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCheckOfflineFinish, cost: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.c);
      ((StringBuilder)localObject).append(", url: ");
      ((StringBuilder)localObject).append(Util.b(this.jdField_a_of_type_JavaLangString, new String[0]));
      QLog.i("OfflinePluginQQ", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a(this.jdField_a_of_type_JavaLangString, paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.mRuntime.a();
    if (localObject != null)
    {
      ((CustomWebView)localObject).loadUrlOriginal(this.jdField_a_of_type_JavaLangString);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("error!!!! webview is null, now can not loadUrl ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.e("OfflinePluginQQ", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.4
 * JD-Core Version:    0.7.0.1
 */
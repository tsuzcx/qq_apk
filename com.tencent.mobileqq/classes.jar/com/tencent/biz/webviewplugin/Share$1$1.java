package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler;
import com.tencent.qphone.base.util.QLog;

class Share$1$1
  implements Runnable
{
  Share$1$1(Share.1 param1, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter paramSwiftBrowserComponentProviderSupporter) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WebView screenshot START. shareUrl=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizWebviewpluginShare$1.a);
      QLog.e("shareWebPage", 2, localStringBuilder.toString());
    }
    ((SwiftBrowserMiscHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentProviderSupporter.getComponentProvider().a(32)).a(270, 270, new Share.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.1.1
 * JD-Core Version:    0.7.0.1
 */
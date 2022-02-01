package com.tencent.comic.hippy.view;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;

class HippyWebViewModule$MyHippyWebUiInterface
  implements WebUiBaseInterface, WebViewPluginContainer
{
  HippyWebViewModule$MyHippyWebUiInterface(HippyWebViewModule paramHippyWebViewModule) {}
  
  public int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    HippyWebViewModule.access$000(this.this$0).startActivity(paramIntent);
    return 0;
  }
  
  public int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.hippy.view.HippyWebViewModule.MyHippyWebUiInterface
 * JD-Core Version:    0.7.0.1
 */
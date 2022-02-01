package com.tencent.biz.webviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils;

class ReadInJoyWebRenderPlugin$1
  implements Runnable
{
  ReadInJoyWebRenderPlugin$1(ReadInJoyWebRenderPlugin paramReadInJoyWebRenderPlugin) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(ReadInJoyWebRenderPlugin.a(this.this$0))) {
      SwiftOfflineDataUtils.a(ReadInJoyWebRenderPlugin.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ReadInJoyWebRenderPlugin.1
 * JD-Core Version:    0.7.0.1
 */
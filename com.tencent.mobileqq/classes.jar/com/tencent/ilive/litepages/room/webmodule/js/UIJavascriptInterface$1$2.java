package com.tencent.ilive.litepages.room.webmodule.js;

import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;

class UIJavascriptInterface$1$2
  implements MediaScannerConnection.OnScanCompletedListener
{
  UIJavascriptInterface$1$2(UIJavascriptInterface.1 param1) {}
  
  public void onScanCompleted(String paramString, Uri paramUri)
  {
    UIJavascriptInterface localUIJavascriptInterface = this.this$1.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyAndRefresh: path = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", uri = ");
    localStringBuilder.append(paramUri);
    UIJavascriptInterface.access$300(localUIJavascriptInterface, "UIJavascriptInterface", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.UIJavascriptInterface.1.2
 * JD-Core Version:    0.7.0.1
 */
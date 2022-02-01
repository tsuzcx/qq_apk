package com.qflutter.resource_loader;

import android.os.Handler;
import io.flutter.plugin.common.MethodChannel.Result;

class QFlutterResourceLoader$2
  implements Runnable
{
  QFlutterResourceLoader$2(QFlutterResourceLoader paramQFlutterResourceLoader, String paramString, MethodChannel.Result paramResult) {}
  
  public void run()
  {
    NativeImageReplyInfo localNativeImageReplyInfo = QFlutterResourceLoader.access$200(this.this$0, this.val$nativeImageID);
    if ((QFlutterResourceLoader.access$100(this.this$0).getUiThreadHandler() != null) && (localNativeImageReplyInfo != null)) {
      QFlutterResourceLoader.access$100(this.this$0).getUiThreadHandler().post(new QFlutterResourceLoader.2.1(this, localNativeImageReplyInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.resource_loader.QFlutterResourceLoader.2
 * JD-Core Version:    0.7.0.1
 */
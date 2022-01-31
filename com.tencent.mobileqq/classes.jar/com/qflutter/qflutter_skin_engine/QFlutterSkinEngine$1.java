package com.qflutter.qflutter_skin_engine;

import android.os.Handler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;

class QFlutterSkinEngine$1
  implements Runnable
{
  QFlutterSkinEngine$1(QFlutterSkinEngine paramQFlutterSkinEngine, MethodChannel.Result paramResult) {}
  
  public void run()
  {
    Map localMap = QFlutterSkinEngine.access$000(this.this$0);
    if ((QFlutterSkinEngine.access$100(this.this$0).getUiThreadHandler() != null) && (localMap != null)) {
      QFlutterSkinEngine.access$100(this.this$0).getUiThreadHandler().post(new QFlutterSkinEngine.1.1(this, localMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qflutter.qflutter_skin_engine.QFlutterSkinEngine.1
 * JD-Core Version:    0.7.0.1
 */
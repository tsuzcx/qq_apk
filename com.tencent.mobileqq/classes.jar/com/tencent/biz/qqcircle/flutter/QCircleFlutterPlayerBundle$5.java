package com.tencent.biz.qqcircle.flutter;

import com.qflutter.vistaplayer.VistaPlayerEvent;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;

class QCircleFlutterPlayerBundle$5
  implements Runnable
{
  QCircleFlutterPlayerBundle$5(QCircleFlutterPlayerBundle paramQCircleFlutterPlayerBundle) {}
  
  public void run()
  {
    if (this.this$0.c == null) {
      return;
    }
    VistaPlayerEvent.sendCompletionEvent(this.this$0.c.id());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QCircleFlutterPlayerBundle.5
 * JD-Core Version:    0.7.0.1
 */
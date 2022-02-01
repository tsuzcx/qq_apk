package com.tencent.biz.qqcircle.flutter;

import com.qflutter.vistaplayer.VistaPlayerEvent;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;

class QCircleFlutterPlayerBundle$2
  implements Runnable
{
  QCircleFlutterPlayerBundle$2(QCircleFlutterPlayerBundle paramQCircleFlutterPlayerBundle) {}
  
  public void run()
  {
    if (this.this$0.c != null) {
      VistaPlayerEvent.sendFirstFrameRenderedEvent(this.this$0.c.id());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QCircleFlutterPlayerBundle.2
 * JD-Core Version:    0.7.0.1
 */
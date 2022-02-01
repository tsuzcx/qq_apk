package com.tencent.biz.qqcircle.flutter;

import com.qflutter.vistaplayer.VistaPlayerEvent;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;

class QCircleFlutterPlayerBundle$3
  implements Runnable
{
  QCircleFlutterPlayerBundle$3(QCircleFlutterPlayerBundle paramQCircleFlutterPlayerBundle, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    if (this.this$0.c == null) {
      return;
    }
    VistaPlayerEvent.sendPreparedEvent(this.this$0.c.id(), this.a, (int)this.b, (int)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QCircleFlutterPlayerBundle.3
 * JD-Core Version:    0.7.0.1
 */
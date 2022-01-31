package com.idlefish.flutterboost.containers;

import android.os.Handler;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoost.ConfigBuilder;
import com.idlefish.flutterboost.Platform;
import io.flutter.embedding.engine.renderer.OnFirstFrameRenderedListener;
import java.util.Date;

class FlutterSplashView$2
  implements OnFirstFrameRenderedListener
{
  int i = 0;
  
  FlutterSplashView$2(FlutterSplashView paramFlutterSplashView) {}
  
  public void onFirstFrameRendered()
  {
    if (FlutterBoost.instance().platform().whenEngineStart() == FlutterBoost.ConfigBuilder.FLUTTER_ACTIVITY_CREATED)
    {
      l1 = new Date().getTime();
      l2 = FlutterBoost.instance().getFlutterPostFrameCallTime();
      if ((l2 != 0L) && (l1 - l2 > 800L)) {
        if (FlutterSplashView.access$100(this.this$0) != null) {
          FlutterSplashView.access$200(this.this$0);
        }
      }
    }
    while (FlutterSplashView.access$100(this.this$0) == null)
    {
      long l1;
      long l2;
      return;
      FlutterSplashView.access$400(this.this$0).postDelayed(new FlutterSplashView.2.1(this), 200L);
      return;
    }
    FlutterSplashView.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.containers.FlutterSplashView.2
 * JD-Core Version:    0.7.0.1
 */
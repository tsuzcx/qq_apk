package com.idlefish.flutterboost.containers;

import androidx.annotation.NonNull;
import com.idlefish.flutterboost.XFlutterView;
import io.flutter.embedding.android.FlutterView.FlutterEngineAttachmentListener;
import io.flutter.embedding.engine.FlutterEngine;

class FlutterSplashView$1
  implements FlutterView.FlutterEngineAttachmentListener
{
  FlutterSplashView$1(FlutterSplashView paramFlutterSplashView) {}
  
  public void onFlutterEngineAttachedToFlutterView(@NonNull FlutterEngine paramFlutterEngine)
  {
    FlutterSplashView.access$000(this.this$0).removeFlutterEngineAttachmentListener(this);
  }
  
  public void onFlutterEngineDetachedFromFlutterView() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.containers.FlutterSplashView.1
 * JD-Core Version:    0.7.0.1
 */
package com.example.tissue;

import android.content.Context;
import android.util.AttributeSet;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.StringCodec;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;

final class Flutter$1
  extends FlutterView
{
  private final BasicMessageChannel<String> lifecycleMessages = new BasicMessageChannel(this, "flutter/lifecycle", StringCodec.INSTANCE);
  
  Flutter$1(Context paramContext, AttributeSet paramAttributeSet, FlutterNativeView paramFlutterNativeView)
  {
    super(paramContext, paramAttributeSet, paramFlutterNativeView);
  }
  
  public void onFirstFrame()
  {
    super.onFirstFrame();
    setAlpha(1.0F);
  }
  
  public void onPostResume()
  {
    this.lifecycleMessages.send("AppLifecycleState.resumed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.Flutter.1
 * JD-Core Version:    0.7.0.1
 */
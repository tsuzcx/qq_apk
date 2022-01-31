package com.example.tissue;

import android.app.Activity;
import android.content.Context;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;

public final class Flutter
{
  public static FlutterView createView(Activity paramActivity, String paramString)
  {
    FlutterMain.startInitialization(paramActivity.getApplicationContext());
    FlutterMain.ensureInitializationComplete(paramActivity.getApplicationContext(), null);
    paramActivity = new Flutter.1(paramActivity, null, new FlutterNativeView(paramActivity));
    if (paramString != null) {
      paramActivity.setInitialRoute(paramString);
    }
    paramActivity.setAlpha(0.0F);
    return paramActivity;
  }
  
  public static void startInitialization(Context paramContext)
  {
    FlutterMain.startInitialization(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.Flutter
 * JD-Core Version:    0.7.0.1
 */
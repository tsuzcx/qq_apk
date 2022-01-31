package com.example.tissue;

import android.os.Bundle;
import io.flutter.app.FlutterActivity;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity
  extends FlutterActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    GeneratedPluginRegistrant.registerWith(this);
    ApiBridge.getInstance().init(getApplicationContext(), getFlutterView());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.MainActivity
 * JD-Core Version:    0.7.0.1
 */
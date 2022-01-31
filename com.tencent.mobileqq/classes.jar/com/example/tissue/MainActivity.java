package com.example.tissue;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;
import java.util.HashMap;
import java.util.Map;

public class MainActivity
  extends FlutterActivity
{
  public static final String MINI_PROGRAM_NAME = "OPEN_MINIPROGRAM_NAME";
  public static final String MINI_PROGRAM_NAME_QIANDAO = "QIANDAO";
  BasicMessageChannel channel;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    GeneratedPluginRegistrant.registerWith(this);
    ApiBridge.getInstance().init(getApplicationContext(), getFlutterView());
    paramBundle = getIntent().getStringExtra("OPEN_MINIPROGRAM_NAME");
    if ((!TextUtils.isEmpty(paramBundle)) && (paramBundle.equals("QIANDAO"))) {
      ApiBridge.getInstance().setBridgeReadyListener(new MainActivity.1(this));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.channel != null)
    {
      HashMap localHashMap = new HashMap();
      new HashMap();
      localHashMap.put("appPtr", Integer.valueOf(1));
      localHashMap.put("method", "appClose");
      this.channel.send(localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.MainActivity
 * JD-Core Version:    0.7.0.1
 */
package com.example.tissue;

import io.flutter.plugin.common.BasicMessageChannel;
import java.util.HashMap;
import java.util.Map;

class MainActivity$1
  implements ApiBridge.BridgeReadyListener
{
  MainActivity$1(MainActivity paramMainActivity) {}
  
  public void onBridgeReady(BasicMessageChannel paramBasicMessageChannel)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("appPtr", Integer.valueOf(1));
    localHashMap1.put("method", "appLaunch");
    localHashMap2.put("appName", "miniProgram");
    localHashMap2.put("apkgUnpackPath", "/sdcard/miniProgram");
    localHashMap1.put("data", localHashMap2);
    paramBasicMessageChannel.send(localHashMap1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.MainActivity.1
 * JD-Core Version:    0.7.0.1
 */
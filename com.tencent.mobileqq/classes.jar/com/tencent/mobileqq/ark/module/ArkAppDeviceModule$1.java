package com.tencent.mobileqq.ark.module;

import java.util.HashMap;

class ArkAppDeviceModule$1
  extends HashMap<String, ArkAppDeviceModule.DeviceMethodWrap>
{
  ArkAppDeviceModule$1(ArkAppDeviceModule paramArkAppDeviceModule)
  {
    put("GetModelName", ArkAppDeviceModule.a(this.this$0));
    put("GetScreenWidth", ArkAppDeviceModule.a(this.this$0));
    put("GetScreenHeight", ArkAppDeviceModule.a(this.this$0));
    put("GetPixelRatio", ArkAppDeviceModule.a(this.this$0));
    put("GetConnectionType", ArkAppDeviceModule.b(this.this$0));
    put("AttachEvent", ArkAppDeviceModule.c(this.this$0));
    put("DetachEvent", ArkAppDeviceModule.c(this.this$0));
    put("ScanCode", ArkAppDeviceModule.d(this.this$0));
    put("GetIdentifier", ArkAppDeviceModule.a(this.this$0));
    put("GetCurrentPosition", ArkAppDeviceModule.c(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppDeviceModule.1
 * JD-Core Version:    0.7.0.1
 */
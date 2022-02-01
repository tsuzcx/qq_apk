package com.tencent.mobileqq.activity.aio.voicetextpanel.controller;

import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class VoiceTextSttProcessController$1
  implements INetInfoHandler
{
  VoiceTextSttProcessController$1(VoiceTextSttProcessController paramVoiceTextSttProcessController) {}
  
  public void onNetMobile2None()
  {
    VoiceTextSttProcessController.b(this.a).post(new VoiceTextSttProcessController.1.1(this));
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    VoiceTextSttProcessController.b(this.a).post(new VoiceTextSttProcessController.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController.1
 * JD-Core Version:    0.7.0.1
 */
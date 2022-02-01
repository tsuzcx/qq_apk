package com.tencent.mobileqq.activity.aio.voicetextpanel.controller;

import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextSttListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.SttResultBean;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class VoiceTextSttQueryController$2
  implements Runnable
{
  VoiceTextSttQueryController$2(VoiceTextSttQueryController paramVoiceTextSttQueryController, String paramString) {}
  
  public void run()
  {
    List localList = VoiceTextSttQueryController.f(this.this$0);
    if ((localList != null) && (!localList.isEmpty()))
    {
      VoiceTextSttQueryController.a(this.this$0).set(localList.size());
      VoiceTextSttQueryController.a(this.this$0, new SttResultBean[localList.size()]);
      VoiceTextSttQueryController.a(this.this$0, this.a, localList);
      return;
    }
    if (VoiceTextSttQueryController.c(this.this$0) != null) {
      VoiceTextSttQueryController.c(this.this$0).c();
    }
    VoiceTextSttQueryController.g(this.this$0).set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttQueryController.2
 * JD-Core Version:    0.7.0.1
 */
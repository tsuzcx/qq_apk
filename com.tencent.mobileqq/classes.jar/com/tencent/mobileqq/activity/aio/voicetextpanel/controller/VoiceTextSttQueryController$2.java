package com.tencent.mobileqq.activity.aio.voicetextpanel.controller;

import ahsc;
import ahsf;
import ahsh;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class VoiceTextSttQueryController$2
  implements Runnable
{
  public VoiceTextSttQueryController$2(ahsc paramahsc, String paramString) {}
  
  public void run()
  {
    List localList = ahsc.b(this.this$0);
    if ((localList == null) || (localList.isEmpty()))
    {
      if (ahsc.a(this.this$0) != null) {
        ahsc.a(this.this$0).c();
      }
      ahsc.a(this.this$0).set(true);
      return;
    }
    ahsc.a(this.this$0).set(localList.size());
    ahsc.a(this.this$0, new ahsh[localList.size()]);
    ahsc.a(this.this$0, this.a, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttQueryController.2
 * JD-Core Version:    0.7.0.1
 */
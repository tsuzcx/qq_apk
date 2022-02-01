package com.tencent.mobileqq.activity.aio.voicetextpanel.controller;

import aixr;
import aixu;
import aixw;
import aiyv;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class VoiceTextSttQueryController$2
  implements Runnable
{
  public VoiceTextSttQueryController$2(aixr paramaixr, String paramString) {}
  
  public void run()
  {
    aixr.a(this.this$0);
    if (aixr.a(this.this$0).a.size() == 0)
    {
      if (aixr.a(this.this$0) != null) {
        aixr.a(this.this$0).c();
      }
      aixr.a(this.this$0).set(true);
      return;
    }
    aixr.a(this.this$0).set(aixr.a(this.this$0).a.size());
    aixr.a(this.this$0, new aixw[aixr.a(this.this$0).a.size()]);
    aixr.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttQueryController.2
 * JD-Core Version:    0.7.0.1
 */
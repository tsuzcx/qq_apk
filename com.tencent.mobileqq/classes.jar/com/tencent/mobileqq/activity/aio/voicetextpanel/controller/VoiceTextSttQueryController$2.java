package com.tencent.mobileqq.activity.aio.voicetextpanel.controller;

import ainb;
import aine;
import aing;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class VoiceTextSttQueryController$2
  implements Runnable
{
  public VoiceTextSttQueryController$2(ainb paramainb, String paramString) {}
  
  public void run()
  {
    List localList = ainb.b(this.this$0);
    if ((localList == null) || (localList.isEmpty()))
    {
      if (ainb.a(this.this$0) != null) {
        ainb.a(this.this$0).c();
      }
      ainb.a(this.this$0).set(true);
      return;
    }
    ainb.a(this.this$0).set(localList.size());
    ainb.a(this.this$0, new aing[localList.size()]);
    ainb.a(this.this$0, this.a, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttQueryController.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ar.codeEngine;

import alji;
import alju;

public class MiniCodeController$2
  implements Runnable
{
  public MiniCodeController$2(alji paramalji) {}
  
  public void run()
  {
    long l1 = alju.a("report_tag_detect_supporttype", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      alju.b(alji.a(this.this$0), -1);
      alju.a("report_tag_detect_supporttype", l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniCodeController.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ar.codeEngine;

import amzy;
import anak;

public class MiniCodeController$2
  implements Runnable
{
  public MiniCodeController$2(amzy paramamzy) {}
  
  public void run()
  {
    long l1 = anak.a("report_tag_detect_supporttype", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      anak.b(amzy.a(this.this$0), -1);
      anak.a("report_tag_detect_supporttype", l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniCodeController.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ar.codeEngine;

import aneh;
import anet;

public class MiniCodeController$1
  implements Runnable
{
  public MiniCodeController$1(aneh paramaneh, int paramInt, long paramLong) {}
  
  public void run()
  {
    long l1 = anet.a("report_tag_detect_supporttype", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      anet.b(aneh.a(this.this$0), this.jdField_a_of_type_Int);
      anet.a("report_tag_detect_supporttype", l2);
    }
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long < 15000L) && (l2 - anet.a("report_tag_detect_init_internal_cost", 0L) > 86400000L))
    {
      anet.e(aneh.a(this.this$0), (int)this.jdField_a_of_type_Long);
      anet.a("report_tag_detect_init_internal_cost", l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniCodeController.1
 * JD-Core Version:    0.7.0.1
 */
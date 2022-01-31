package com.tencent.mobileqq.ar.codeEngine;

import akux;
import akvj;

public class MiniCodeController$1
  implements Runnable
{
  public MiniCodeController$1(akux paramakux, int paramInt, long paramLong) {}
  
  public void run()
  {
    long l1 = akvj.a("report_tag_detect_supporttype", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      akvj.b(akux.a(this.this$0), this.jdField_a_of_type_Int);
      akvj.a("report_tag_detect_supporttype", l2);
    }
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long < 15000L) && (l2 - akvj.a("report_tag_detect_init_internal_cost", 0L) > 86400000L))
    {
      akvj.e(akux.a(this.this$0), (int)this.jdField_a_of_type_Long);
      akvj.a("report_tag_detect_init_internal_cost", l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniCodeController.1
 * JD-Core Version:    0.7.0.1
 */
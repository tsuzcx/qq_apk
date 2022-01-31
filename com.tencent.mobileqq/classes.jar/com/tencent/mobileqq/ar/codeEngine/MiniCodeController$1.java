package com.tencent.mobileqq.ar.codeEngine;

import aljj;
import aljv;

public class MiniCodeController$1
  implements Runnable
{
  public MiniCodeController$1(aljj paramaljj, int paramInt, long paramLong) {}
  
  public void run()
  {
    long l1 = aljv.a("report_tag_detect_supporttype", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      aljv.b(aljj.a(this.this$0), this.jdField_a_of_type_Int);
      aljv.a("report_tag_detect_supporttype", l2);
    }
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long < 15000L) && (l2 - aljv.a("report_tag_detect_init_internal_cost", 0L) > 86400000L))
    {
      aljv.e(aljj.a(this.this$0), (int)this.jdField_a_of_type_Long);
      aljv.a("report_tag_detect_init_internal_cost", l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniCodeController.1
 * JD-Core Version:    0.7.0.1
 */
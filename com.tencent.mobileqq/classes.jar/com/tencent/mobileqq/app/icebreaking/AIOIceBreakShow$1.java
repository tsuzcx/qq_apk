package com.tencent.mobileqq.app.icebreaking;

import amjx;
import amka;
import com.tencent.qphone.base.util.QLog;

class AIOIceBreakShow$1
  implements Runnable
{
  AIOIceBreakShow$1(AIOIceBreakShow paramAIOIceBreakShow, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      AIOIceBreakShow.a(this.this$0).d(this.jdField_a_of_type_JavaLangString);
      AIOIceBreakShow.a(this.this$0).c();
    }
    for (;;)
    {
      QLog.d("AIOIceBreakShow", 1, String.format("markEnteredFlag, type = %s, uin = %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
      return;
      if (amka.d(this.jdField_a_of_type_Int))
      {
        AIOIceBreakShow.a(this.this$0).b(this.jdField_a_of_type_JavaLangString);
        AIOIceBreakShow.a(this.this$0).d();
      }
      else
      {
        AIOIceBreakShow.a(this.this$0).c(this.jdField_a_of_type_JavaLangString);
        AIOIceBreakShow.a(this.this$0).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.icebreaking.AIOIceBreakShow.1
 * JD-Core Version:    0.7.0.1
 */
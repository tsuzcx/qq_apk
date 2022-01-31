package com.tencent.mobileqq.app.icebreaking;

import ajzc;
import ajzj;
import ajzm;
import com.tencent.qphone.base.util.QLog;

public class AIOIceBreakShow$2
  implements Runnable
{
  public AIOIceBreakShow$2(ajzc paramajzc, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      ajzc.a(this.this$0).d(this.jdField_a_of_type_JavaLangString);
      ajzc.a(this.this$0).c();
    }
    for (;;)
    {
      QLog.d("AIOIceBreakShow", 1, String.format("markEnteredFlag, type = %s, uin = %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
      return;
      if (ajzm.d(this.jdField_a_of_type_Int))
      {
        ajzc.a(this.this$0).b(this.jdField_a_of_type_JavaLangString);
        ajzc.a(this.this$0).d();
      }
      else
      {
        ajzc.a(this.this$0).c(this.jdField_a_of_type_JavaLangString);
        ajzc.a(this.this$0).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.icebreaking.AIOIceBreakShow.2
 * JD-Core Version:    0.7.0.1
 */
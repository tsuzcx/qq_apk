package com.tencent.mobileqq.app.icebreaking;

import akno;
import aknv;
import akny;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class AIOIceBreakShow$1
  implements Runnable
{
  public AIOIceBreakShow$1(akno paramakno, int paramInt, String paramString) {}
  
  public void run()
  {
    aknv localaknv = (aknv)akno.a(this.this$0).a.getManager(285);
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label75;
      }
      localaknv.f(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      QLog.d("AIOIceBreakShow", 1, String.format("removeDelay, type = %s, uin = %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
      return;
      label75:
      if (akny.d(this.jdField_a_of_type_Int)) {
        localaknv.g(this.jdField_a_of_type_JavaLangString);
      } else {
        localaknv.d(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.icebreaking.AIOIceBreakShow.1
 * JD-Core Version:    0.7.0.1
 */
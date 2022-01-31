package com.tencent.mobileqq.app.icebreaking;

import aknn;
import aknu;
import aknx;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class AIOIceBreakShow$1
  implements Runnable
{
  public AIOIceBreakShow$1(aknn paramaknn, int paramInt, String paramString) {}
  
  public void run()
  {
    aknu localaknu = (aknu)aknn.a(this.this$0).a.getManager(285);
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label75;
      }
      localaknu.f(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      QLog.d("AIOIceBreakShow", 1, String.format("removeDelay, type = %s, uin = %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
      return;
      label75:
      if (aknx.d(this.jdField_a_of_type_Int)) {
        localaknu.g(this.jdField_a_of_type_JavaLangString);
      } else {
        localaknu.d(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.icebreaking.AIOIceBreakShow.1
 * JD-Core Version:    0.7.0.1
 */
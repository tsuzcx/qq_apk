package com.tencent.mobileqq.app.icebreaking;

import amjx;
import amka;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class AIOIceBreakShow$RemoveRunnable
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  
  public AIOIceBreakShow$RemoveRunnable(AIOIceBreakShow paramAIOIceBreakShow, int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    amjx localamjx = (amjx)AIOIceBreakShow.a(this.this$0).a.getManager(285);
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label75;
      }
      localamjx.f(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      QLog.d("AIOIceBreakShow", 1, String.format("removeDelay, type = %s, uin = %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
      return;
      label75:
      if (amka.d(this.jdField_a_of_type_Int)) {
        localamjx.g(this.jdField_a_of_type_JavaLangString);
      } else {
        localamjx.d(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.icebreaking.AIOIceBreakShow.RemoveRunnable
 * JD-Core Version:    0.7.0.1
 */
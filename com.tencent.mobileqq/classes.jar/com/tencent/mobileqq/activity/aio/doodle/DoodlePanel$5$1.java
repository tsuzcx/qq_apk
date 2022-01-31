package com.tencent.mobileqq.activity.aio.doodle;

import aevq;
import aycc;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;

public class DoodlePanel$5$1
  implements Runnable
{
  public DoodlePanel$5$1(aevq paramaevq, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aevq.a.d();
    if (this.jdField_a_of_type_Int == aycc.d)
    {
      this.jdField_a_of_type_Aevq.a.c();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Aevq.a.getContext(), 2131689946, 0).b(DoodlePanel.a(this.jdField_a_of_type_Aevq.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel.5.1
 * JD-Core Version:    0.7.0.1
 */
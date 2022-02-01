package com.tencent.mobileqq.activity.aio.doodle;

import agps;
import bbxm;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;

public class DoodlePanel$5$1
  implements Runnable
{
  public DoodlePanel$5$1(agps paramagps, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Agps.a.d();
    if (this.jdField_a_of_type_Int == bbxm.d)
    {
      this.jdField_a_of_type_Agps.a.c();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Agps.a.getContext(), 2131689851, 0).b(DoodlePanel.a(this.jdField_a_of_type_Agps.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel.5.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.doodle;

import agcq;
import bbxw;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;

public class DoodlePanel$5$1
  implements Runnable
{
  public DoodlePanel$5$1(agcq paramagcq, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Agcq.a.d();
    if (this.jdField_a_of_type_Int == bbxw.d)
    {
      this.jdField_a_of_type_Agcq.a.c();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Agcq.a.getContext(), 2131689892, 0).b(DoodlePanel.a(this.jdField_a_of_type_Agcq.a).getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel.5.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.doodle;

import aflm;
import barh;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;

public class DoodlePanel$5$1
  implements Runnable
{
  public DoodlePanel$5$1(aflm paramaflm, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aflm.a.d();
    if (this.jdField_a_of_type_Int == barh.d)
    {
      this.jdField_a_of_type_Aflm.a.c();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Aflm.a.getContext(), 2131689863, 0).b(DoodlePanel.a(this.jdField_a_of_type_Aflm.a).getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel.5.1
 * JD-Core Version:    0.7.0.1
 */
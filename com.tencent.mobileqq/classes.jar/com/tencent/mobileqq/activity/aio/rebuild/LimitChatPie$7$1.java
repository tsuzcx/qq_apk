package com.tencent.mobileqq.activity.aio.rebuild;

import agse;
import agsm;
import aqcl;
import aqhi;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class LimitChatPie$7$1
  implements Runnable
{
  public LimitChatPie$7$1(agsm paramagsm, int paramInt, aqcl paramaqcl) {}
  
  public void run()
  {
    aqhi.a(this.jdField_a_of_type_Agsm.a.a, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aqcl);
    ThreadManager.getUIHandler().post(new LimitChatPie.7.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.7.1
 * JD-Core Version:    0.7.0.1
 */
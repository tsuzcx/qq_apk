package com.tencent.mobileqq.activity.aio.rebuild;

import agnp;
import agnx;
import apyc;
import aqcz;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class LimitChatPie$7$1
  implements Runnable
{
  public LimitChatPie$7$1(agnx paramagnx, int paramInt, apyc paramapyc) {}
  
  public void run()
  {
    aqcz.a(this.jdField_a_of_type_Agnx.a.a, this.jdField_a_of_type_Int, this.jdField_a_of_type_Apyc);
    ThreadManager.getUIHandler().post(new LimitChatPie.7.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.7.1
 * JD-Core Version:    0.7.0.1
 */
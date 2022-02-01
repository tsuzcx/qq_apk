package com.tencent.mobileqq.activity.aio.rebuild;

import aicl;
import aict;
import ashh;
import asml;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class LimitChatPie$7$1
  implements Runnable
{
  public LimitChatPie$7$1(aict paramaict, int paramInt, ashh paramashh) {}
  
  public void run()
  {
    asml.a(this.jdField_a_of_type_Aict.a.a, this.jdField_a_of_type_Int, this.jdField_a_of_type_Ashh);
    ThreadManager.getUIHandler().post(new LimitChatPie.7.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.7.1
 * JD-Core Version:    0.7.0.1
 */
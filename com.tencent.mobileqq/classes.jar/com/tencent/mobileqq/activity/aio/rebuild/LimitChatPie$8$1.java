package com.tencent.mobileqq.activity.aio.rebuild;

import ahhp;
import ahhy;
import ariy;
import aros;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class LimitChatPie$8$1
  implements Runnable
{
  public LimitChatPie$8$1(ahhy paramahhy, int paramInt, ariy paramariy) {}
  
  public void run()
  {
    aros.a(this.jdField_a_of_type_Ahhy.a.app, this.jdField_a_of_type_Int, this.jdField_a_of_type_Ariy);
    ThreadManager.getUIHandler().post(new LimitChatPie.8.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.8.1
 * JD-Core Version:    0.7.0.1
 */
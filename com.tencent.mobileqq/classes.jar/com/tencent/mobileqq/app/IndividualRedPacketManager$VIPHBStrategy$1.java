package com.tencent.mobileqq.app;

import ajzd;
import ajzh;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;

public class IndividualRedPacketManager$VIPHBStrategy$1
  implements Runnable
{
  public IndividualRedPacketManager$VIPHBStrategy$1(ajzh paramajzh, ajzd paramajzd, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      ajzd.a(ajzh.a(this.this$0), this.jdField_a_of_type_Ajzd, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(ajzd.b(), 1, "dealRedPacketToShow failed", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.VIPHBStrategy.1
 * JD-Core Version:    0.7.0.1
 */
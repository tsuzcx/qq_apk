package com.tencent.mobileqq.app;

import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;

class IndividualRedPacketManager$VIPHBStrategy$1
  implements Runnable
{
  IndividualRedPacketManager$VIPHBStrategy$1(IndividualRedPacketManager.VIPHBStrategy paramVIPHBStrategy, IndividualRedPacketManager paramIndividualRedPacketManager, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      IndividualRedPacketManager.a(IndividualRedPacketManager.VIPHBStrategy.a(this.this$0), this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(IndividualRedPacketManager.b(), 1, "dealRedPacketToShow failed", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.VIPHBStrategy.1
 * JD-Core Version:    0.7.0.1
 */
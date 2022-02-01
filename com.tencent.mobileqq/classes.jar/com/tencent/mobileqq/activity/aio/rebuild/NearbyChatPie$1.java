package com.tencent.mobileqq.activity.aio.rebuild;

import aean;
import aimx;
import anum;
import anyw;
import bhsr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class NearbyChatPie$1
  implements Runnable
{
  public NearbyChatPie$1(aimx paramaimx) {}
  
  public void run()
  {
    try
    {
      Card localCard = ((anyw)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (localCard == null)
      {
        if (bhsr.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
          ((anum)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (byte)1, 0);
        }
      }
      else if ((localCard != null) && (localCard.strCertificationInfo != null) && (!localCard.strCertificationInfo.equals("")))
      {
        aean.f(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.1
 * JD-Core Version:    0.7.0.1
 */
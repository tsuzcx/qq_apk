package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.SharedPreUtils;

class TroopRequestActivity$2$1
  implements Runnable
{
  TroopRequestActivity$2$1(TroopRequestActivity.2 param2, Card paramCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$2.this$0.isFinishing()) {}
    CardHandler localCardHandler;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$2.this$0, this.jdField_a_of_type_ComTencentMobileqqDataCard);
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel > 0));
      localCardHandler = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$2.this$0.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    } while (localCardHandler == null);
    byte b = (byte)SharedPreUtils.X(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$2.this$0.getApplication(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$2.this$0.app.getCurrentAccountUin());
    localCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$2.this$0.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$2.this$0.b, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", 1L, 10004, new byte[] { 0 }, b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.2.1
 * JD-Core Version:    0.7.0.1
 */
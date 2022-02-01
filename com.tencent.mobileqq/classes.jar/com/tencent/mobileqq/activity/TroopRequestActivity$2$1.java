package com.tencent.mobileqq.activity;

import amov;
import bfyz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

class TroopRequestActivity$2$1
  implements Runnable
{
  TroopRequestActivity$2$1(TroopRequestActivity.2 param2, Card paramCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$2.this$0.isFinishing()) {}
    amov localamov;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$2.this$0, this.jdField_a_of_type_ComTencentMobileqqDataCard);
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel > 0));
      localamov = (amov)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$2.this$0.app.getBusinessHandler(2);
    } while (localamov == null);
    byte b = (byte)bfyz.X(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$2.this$0.getApplication(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$2.this$0.app.getCurrentAccountUin());
    localamov.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$2.this$0.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$2.this$0.b, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", 1L, 10004, new byte[] { 0 }, b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.2.1
 * JD-Core Version:    0.7.0.1
 */
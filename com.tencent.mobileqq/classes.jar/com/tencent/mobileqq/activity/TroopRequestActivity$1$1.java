package com.tencent.mobileqq.activity;

import ajfi;
import baig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

class TroopRequestActivity$1$1
  implements Runnable
{
  TroopRequestActivity$1$1(TroopRequestActivity.1 param1, Card paramCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$1.this$0.isFinishing()) {}
    ajfi localajfi;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$1.this$0, this.jdField_a_of_type_ComTencentMobileqqDataCard);
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel > 0));
      localajfi = (ajfi)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$1.this$0.app.a(2);
    } while (localajfi == null);
    byte b = (byte)baig.W(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$1.this$0.getApplication(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$1.this$0.app.getCurrentAccountUin());
    localajfi.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$1.this$0.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$1.this$0.b, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", 1L, 10004, new byte[] { 0 }, b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.1.1
 * JD-Core Version:    0.7.0.1
 */
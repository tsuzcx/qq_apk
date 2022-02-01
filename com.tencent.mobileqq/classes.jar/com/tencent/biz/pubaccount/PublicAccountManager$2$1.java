package com.tencent.biz.pubaccount;

import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import mqq.observer.BusinessObserver;
import ocw;
import odd;

public class PublicAccountManager$2$1
  implements Runnable
{
  public PublicAccountManager$2$1(odd paramodd, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    this.jdField_a_of_type_Odd.jdField_a_of_type_Ocw.a(this.jdField_a_of_type_Odd.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Odd.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountMenuResponse);
    if (this.jdField_a_of_type_Odd.jdField_a_of_type_MqqObserverBusinessObserver != null) {
      this.jdField_a_of_type_Odd.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountManager.2.1
 * JD-Core Version:    0.7.0.1
 */
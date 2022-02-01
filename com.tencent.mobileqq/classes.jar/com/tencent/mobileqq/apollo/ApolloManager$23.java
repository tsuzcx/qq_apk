package com.tencent.mobileqq.apollo;

import amme;
import ammx;
import amvg;
import amvj;
import amvp;
import anka;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

public class ApolloManager$23
  implements Runnable
{
  public ApolloManager$23(amme paramamme, ApolloActionData paramApolloActionData, amvj paramamvj, long paramLong) {}
  
  public void run()
  {
    if (amme.a().contains(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId))) {
      QLog.d("ApolloManager", 1, "handleCMSPlayerGetFrame has get, return," + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
    }
    do
    {
      return;
      amme.a().add(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId));
      if (!this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData)) {
        break;
      }
    } while (this.jdField_a_of_type_Amvj == null);
    this.jdField_a_of_type_Amvj.a(true, null, null);
    return;
    String str = this.this$0.a().getAccount();
    new amvg(anka.a, anka.a).a(new amvp(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, str), amme.a(this.this$0), new ammx(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, this.jdField_a_of_type_Amvj, this.jdField_a_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.23
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.aioChannel;

import amwp;
import anbd;
import ande;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;

public class ApolloCmdChannel$8$1
  extends IApolloRunnableTask
{
  public ApolloCmdChannel$8$1(amwp paramamwp, String paramString) {}
  
  public String a()
  {
    return "getOpenApiNick";
  }
  
  public void run()
  {
    if ((anbd.a() != null) && (anbd.a().a())) {
      this.jdField_a_of_type_Amwp.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.nativeOpenApiGetNickCallBack(this.jdField_a_of_type_Amwp.jdField_a_of_type_Long, this.jdField_a_of_type_Amwp.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.8.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.utils.ApolloHttpProgressCallback;
import com.tencent.mobileqq.apollo.utils.ApolloHttpResponseCallback;
import com.tencent.mobileqq.apollo.utils.ApolloHttpUtil;

final class ApolloRender$13
  implements Runnable
{
  ApolloRender$13(String paramString1, String paramString2, String[] paramArrayOfString, byte[] paramArrayOfByte, ApolloHttpResponseCallback paramApolloHttpResponseCallback, ApolloHttpProgressCallback paramApolloHttpProgressCallback1, ApolloHttpProgressCallback paramApolloHttpProgressCallback2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString.startsWith("http://stubcmshow.qq.com/cm3d/")) || (this.jdField_a_of_type_JavaLangString.startsWith("https://stubcmshow.qq.com/cm3d/")))
    {
      ApolloHttpUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloHttpResponseCallback, this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloHttpProgressCallback, this.jdField_b_of_type_ComTencentMobileqqApolloUtilsApolloHttpProgressCallback);
      return;
    }
    ApolloHttpUtil.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloHttpResponseCallback, this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloHttpProgressCallback, this.jdField_b_of_type_ComTencentMobileqqApolloUtilsApolloHttpProgressCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.13
 * JD-Core Version:    0.7.0.1
 */
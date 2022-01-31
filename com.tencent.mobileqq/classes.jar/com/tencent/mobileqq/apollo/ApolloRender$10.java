package com.tencent.mobileqq.apollo;

import alfq;
import alft;

final class ApolloRender$10
  implements Runnable
{
  ApolloRender$10(String paramString1, String paramString2, String[] paramArrayOfString, alfq paramalfq, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString.toUpperCase();
    if (str.equals("GET")) {
      alft.a(this.b, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Alfq);
    }
    while (!str.equals("POST")) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      alft.a(this.b, this.c, this.d, this.e, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Alfq);
      return;
    }
    alft.a(this.b, this.c, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Alfq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.10
 * JD-Core Version:    0.7.0.1
 */
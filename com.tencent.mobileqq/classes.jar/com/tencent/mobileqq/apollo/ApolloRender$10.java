package com.tencent.mobileqq.apollo;

import ajod;
import ajog;

final class ApolloRender$10
  implements Runnable
{
  ApolloRender$10(String paramString1, String paramString2, String[] paramArrayOfString, ajod paramajod, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString.toUpperCase();
    if (str.equals("GET")) {
      ajog.a(this.b, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Ajod);
    }
    while (!str.equals("POST")) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      ajog.a(this.b, this.c, this.d, this.e, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Ajod);
      return;
    }
    ajog.a(this.b, this.c, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Ajod);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.10
 * JD-Core Version:    0.7.0.1
 */
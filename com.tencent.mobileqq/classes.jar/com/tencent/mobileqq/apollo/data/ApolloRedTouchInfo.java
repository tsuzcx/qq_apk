package com.tencent.mobileqq.apollo.data;

public class ApolloRedTouchInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[").append("actionId: ").append(this.jdField_a_of_type_Int).append(",Ts: ").append(this.jdField_b_of_type_Int).append(",text=").append(this.jdField_a_of_type_JavaLangString).append(",url=").append(this.jdField_b_of_type_JavaLangString).append(",path=").append(this.c);
    localStringBuilder.append(" ]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.data.ApolloRedTouchInfo
 * JD-Core Version:    0.7.0.1
 */
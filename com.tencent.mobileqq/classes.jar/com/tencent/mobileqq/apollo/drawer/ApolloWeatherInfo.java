package com.tencent.mobileqq.apollo.drawer;

public class ApolloWeatherInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("bubbleText:").append(this.jdField_b_of_type_JavaLangString).append(",actionId").append(this.a).append(",expts").append(this.jdField_b_of_type_Int).append(",description").append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.ApolloWeatherInfo
 * JD-Core Version:    0.7.0.1
 */
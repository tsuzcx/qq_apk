package com.tencent.mobileqq.apollo.view;

import com.tencent.qphone.base.util.QLog;

public class ApolloPanel$GameMsgInfo
{
  public long b;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public int h = 3;
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gameId:").append(this.jdField_e_of_type_Int).append(",roomId:").append(this.b).append(",actionId:").append(this.jdField_f_of_type_Int).append(",gameName:").append(this.jdField_e_of_type_JavaLangString).append(",wording:").append(",imgType:");
      QLog.d("ApolloPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    this.jdField_e_of_type_Int = 0;
    this.b = 0L;
    this.g = 0;
    this.jdField_e_of_type_JavaLangString = "";
    this.d = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.h = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo
 * JD-Core Version:    0.7.0.1
 */
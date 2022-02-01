package com.tencent.avgame.gameroom.festivalstage.questionoption;

public class QuestionOptionInfo
{
  private String a;
  private int b;
  
  QuestionOptionInfo()
  {
    this.b = -1;
    this.a = "";
  }
  
  QuestionOptionInfo(int paramInt, String paramString)
  {
    this.b = paramInt;
    this.a = paramString;
  }
  
  public String a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ar.arengine;

public class SearchQuestionResult
{
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SearchQuestionResult{errCode=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", errMsg='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", questionId=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", questionText='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", questionUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.SearchQuestionResult
 * JD-Core Version:    0.7.0.1
 */
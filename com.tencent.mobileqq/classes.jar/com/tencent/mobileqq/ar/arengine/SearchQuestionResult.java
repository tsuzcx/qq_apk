package com.tencent.mobileqq.ar.arengine;

public class SearchQuestionResult
{
  public int a;
  public String b;
  public long c;
  public String d;
  public String e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SearchQuestionResult{errCode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", errMsg='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", questionId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", questionText='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", questionUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.SearchQuestionResult
 * JD-Core Version:    0.7.0.1
 */
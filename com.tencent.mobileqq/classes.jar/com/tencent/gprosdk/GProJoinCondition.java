package com.tencent.gprosdk;

public final class GProJoinCondition
{
  final GProAccountCondition mAccountCondition;
  
  public GProJoinCondition(GProAccountCondition paramGProAccountCondition)
  {
    this.mAccountCondition = paramGProAccountCondition;
  }
  
  public GProAccountCondition getAccountCondition()
  {
    return this.mAccountCondition;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProJoinCondition{mAccountCondition=");
    localStringBuilder.append(this.mAccountCondition);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProJoinCondition
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app.db;

public class CompetitionThreadInfo
{
  public final long a;
  public final String a;
  public final long b;
  
  CompetitionThreadInfo(long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof CompetitionThreadInfo)) {
      return ((CompetitionThreadInfo)paramObject).jdField_a_of_type_Long == this.jdField_a_of_type_Long;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompetitionThreadInfo{threadId=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", threadName='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", enterTime=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.db.CompetitionThreadInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app.db;

public class CompetitionThreadInfo
{
  public final long a;
  public final String b;
  public final long c;
  
  CompetitionThreadInfo(long paramLong1, String paramString, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramString;
    this.c = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof CompetitionThreadInfo)) {
      return ((CompetitionThreadInfo)paramObject).a == this.a;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompetitionThreadInfo{threadId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", threadName='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", enterTime=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.db.CompetitionThreadInfo
 * JD-Core Version:    0.7.0.1
 */
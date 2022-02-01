package com.tencent.biz.qqcircle.publish.task.report;

public class TaskReportInfo$MediaReportInfo
{
  public int a;
  public String b;
  public long c;
  public long d;
  public long e;
  public long f;
  
  public TaskReportInfo$MediaReportInfo(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public long a()
  {
    long l3 = this.e;
    long l2 = 0L;
    long l1 = l2;
    if (l3 != 0L)
    {
      long l4 = this.f;
      l1 = l2;
      if (l4 != 0L) {
        l1 = l4 - l3;
      }
    }
    return l1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuilder.append(a());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.task.report.TaskReportInfo.MediaReportInfo
 * JD-Core Version:    0.7.0.1
 */
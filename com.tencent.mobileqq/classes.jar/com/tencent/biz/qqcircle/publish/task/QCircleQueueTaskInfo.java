package com.tencent.biz.qqcircle.publish.task;

public class QCircleQueueTaskInfo
{
  public String a;
  public String b;
  public int c;
  public long d;
  public long e;
  public int f;
  public boolean g;
  public String h;
  public boolean i;
  public int j;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleQueueTaskInfo [title=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", detail=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", state=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", recvDataSize=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", totalSize=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", progress=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", showVideoPreview=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", leftCount=");
    localStringBuilder.append(this.j);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.task.QCircleQueueTaskInfo
 * JD-Core Version:    0.7.0.1
 */
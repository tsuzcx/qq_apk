package com.tencent.mobileqq.ar;

public class ArDownloadDPC
{
  public int a = 3;
  public int b = 3;
  public int c = 1000;
  public int d = 1;
  public int e = 1;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ArDownloadDPC{");
    localStringBuilder.append("networkControl=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", dailyRetryTimes=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", countRetryTimes=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", entranceControl=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", autoPreDownload=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArDownloadDPC
 * JD-Core Version:    0.7.0.1
 */
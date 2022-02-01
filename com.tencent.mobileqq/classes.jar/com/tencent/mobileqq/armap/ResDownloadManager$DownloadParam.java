package com.tencent.mobileqq.armap;

public class ResDownloadManager$DownloadParam
{
  public int a = 0;
  public String b;
  public String c;
  public String d;
  public int e = 0;
  public boolean f = false;
  public boolean g = true;
  public Object h;
  public ResDownloadManager.IResDownloadListener i = null;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|_DownloadParam_start");
    localStringBuilder.append("|");
    localStringBuilder.append(" type:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append(" md5:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append(" endFix:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuilder.append(" retryCount:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("|");
    localStringBuilder.append(" needUnzip:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuilder.append(" needVerify:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("|");
    localStringBuilder.append(" url:");
    localStringBuilder.append(this.b);
    if (this.h != null)
    {
      localStringBuilder.append("|");
      localStringBuilder.append(" userData:");
      localStringBuilder.append(this.h);
    }
    localStringBuilder.append("|end");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ResDownloadManager.DownloadParam
 * JD-Core Version:    0.7.0.1
 */
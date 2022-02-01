package com.tencent.biz.qqstory.model.pendant;

public class FileDownloadTask$Progress
{
  public final FileDownloadTask.Input a;
  public final long b;
  public final long c;
  
  public FileDownloadTask$Progress(FileDownloadTask.Input paramInput, long paramLong1, long paramLong2)
  {
    this.a = paramInput;
    this.b = paramLong1;
    this.c = paramLong2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Progress{intput=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", downloadBytes=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", totalBytes=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Progress
 * JD-Core Version:    0.7.0.1
 */
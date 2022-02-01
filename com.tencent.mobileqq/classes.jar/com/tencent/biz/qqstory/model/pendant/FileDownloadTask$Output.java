package com.tencent.biz.qqstory.model.pendant;

public class FileDownloadTask$Output
{
  public final FileDownloadTask.Input a;
  public final int b;
  public final String c;
  
  public FileDownloadTask$Output(FileDownloadTask.Input paramInput, int paramInt, String paramString)
  {
    this.a = paramInput;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Output{intput=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", errorCode=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", errorMessage='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Output
 * JD-Core Version:    0.7.0.1
 */
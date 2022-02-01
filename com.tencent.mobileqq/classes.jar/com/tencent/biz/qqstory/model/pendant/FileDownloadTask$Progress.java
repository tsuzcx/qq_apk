package com.tencent.biz.qqstory.model.pendant;

public class FileDownloadTask$Progress
{
  public final long a;
  public final FileDownloadTask.Input a;
  public final long b;
  
  public FileDownloadTask$Progress(FileDownloadTask.Input paramInput, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input = paramInput;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Progress{intput=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input);
    localStringBuilder.append(", downloadBytes=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", totalBytes=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Progress
 * JD-Core Version:    0.7.0.1
 */
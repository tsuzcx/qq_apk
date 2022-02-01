package com.tencent.biz.qqstory.model.pendant;

public class FileDownloadTask$Output
{
  public final int a;
  public final FileDownloadTask.Input a;
  public final String a;
  
  public FileDownloadTask$Output(FileDownloadTask.Input paramInput, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input = paramInput;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Output{intput=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input);
    localStringBuilder.append(", errorCode=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", errorMessage='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Output
 * JD-Core Version:    0.7.0.1
 */
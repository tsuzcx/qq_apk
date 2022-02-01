package com.tencent.mobileqq.armap;

public class ResDownloadManager$DownloadParam
{
  public int a;
  public ResDownloadManager.IResDownloadListener a;
  public Object a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public String c;
  
  public ResDownloadManager$DownloadParam()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|_DownloadParam_start");
    localStringBuilder.append("|");
    localStringBuilder.append(" type:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(" md5:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append(" endFix:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append(" retryCount:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(" needUnzip:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("|");
    localStringBuilder.append(" needVerify:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("|");
    localStringBuilder.append(" url:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      localStringBuilder.append("|");
      localStringBuilder.append(" userData:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangObject);
    }
    localStringBuilder.append("|end");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ResDownloadManager.DownloadParam
 * JD-Core Version:    0.7.0.1
 */
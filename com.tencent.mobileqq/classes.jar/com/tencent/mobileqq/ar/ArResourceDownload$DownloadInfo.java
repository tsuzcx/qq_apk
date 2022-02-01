package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.transfile.HttpNetReq;

public class ArResourceDownload$DownloadInfo
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  String c;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("DownloadInfo{");
    localStringBuffer.append("type=");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", url='");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", md5='");
    localStringBuffer.append(this.jdField_b_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", fileName='");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append(", fileSize=");
    localStringBuffer.append(this.jdField_a_of_type_Long);
    localStringBuffer.append(", downloadSize=");
    localStringBuffer.append(this.jdField_b_of_type_Long);
    localStringBuffer.append(", req=");
    localStringBuffer.append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArResourceDownload.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */
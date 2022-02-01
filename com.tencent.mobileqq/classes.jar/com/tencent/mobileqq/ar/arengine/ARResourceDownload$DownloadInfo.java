package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.transfile.HttpNetReq;

public class ARResourceDownload$DownloadInfo
{
  public int a;
  public long a;
  public HttpNetReq a;
  public String a;
  public boolean a;
  public String b = "";
  public String c = "";
  
  public ARResourceDownload$DownloadInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("DownloadInfo{");
    localStringBuffer.append("type=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", url='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", md5='").append(this.b).append('\'');
    localStringBuffer.append(", fileName='").append(this.c).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARResourceDownload.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.transfile.HttpNetReq;

public class ARPreSoResourceDownload$DownloadInfo
{
  public int a;
  public long a;
  public HttpNetReq a;
  public String a;
  public boolean a;
  public String b = "";
  public String c = "";
  public String d;
  
  public ARPreSoResourceDownload$DownloadInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("DownloadInfo{");
    localStringBuffer.append("type=");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", url='");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", md5='");
    localStringBuffer.append(this.b);
    localStringBuffer.append('\'');
    localStringBuffer.append(", fileName='");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */
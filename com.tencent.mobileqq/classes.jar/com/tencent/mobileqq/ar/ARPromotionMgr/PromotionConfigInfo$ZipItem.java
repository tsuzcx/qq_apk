package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.qphone.base.util.QLog;

public class PromotionConfigInfo$ZipItem
{
  public final int a;
  long jdField_a_of_type_Long = 0L;
  ResDownloadManager.IResDownloadListener jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener = null;
  Object jdField_a_of_type_JavaLangObject = new Object();
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = 1;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = 0L;
  String jdField_c_of_type_JavaLangString = null;
  int jdField_d_of_type_Int = -1;
  String jdField_d_of_type_JavaLangString = null;
  final String e;
  
  public PromotionConfigInfo$ZipItem(String paramString, int paramInt)
  {
    this.e = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_c_of_type_Int == 1) {
        return;
      }
      if (this.jdField_c_of_type_Int == -1)
      {
        String str = PromotionConfigInfo.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearDownladFlag, ZipItem[");
        localStringBuilder.append(this);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      a(0);
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      return;
    }
  }
  
  void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_Int = paramInt;
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", id[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], index[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("], net_type[");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("], url[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("], md5[");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("], zipFilePath[");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("], unzipDirPath[");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("], callByPreDownload[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("], downloadType[");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.ZipItem
 * JD-Core Version:    0.7.0.1
 */
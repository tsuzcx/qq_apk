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
      if (this.jdField_c_of_type_Int == -1) {
        QLog.w(PromotionConfigInfo.TAG, 1, "clearDownladFlag, ZipItem[" + this + "]");
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
    return this.jdField_a_of_type_Int + ", id[" + this.e + "], index[" + this.jdField_a_of_type_Int + "], net_type[" + this.jdField_b_of_type_Int + "], url[" + this.jdField_a_of_type_JavaLangString + "], md5[" + this.jdField_b_of_type_JavaLangString + "], zipFilePath[" + this.jdField_c_of_type_JavaLangString + "], unzipDirPath[" + this.jdField_d_of_type_JavaLangString + "], callByPreDownload[" + this.jdField_a_of_type_Boolean + "], downloadType[" + this.jdField_c_of_type_Int + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.ZipItem
 * JD-Core Version:    0.7.0.1
 */
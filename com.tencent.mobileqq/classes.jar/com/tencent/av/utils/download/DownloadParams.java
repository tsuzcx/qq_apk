package com.tencent.av.utils.download;

import java.util.HashMap;

public class DownloadParams
{
  public int a;
  public DownloadResult a;
  public String a;
  public HashMap<String, String> a;
  public int b;
  public int c = 60000;
  
  public DownloadParams()
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_b_of_type_Int = 5000;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mUrl = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",mConnectionTimeout = ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",mSocketTimeout = ");
    localStringBuilder.append(this.c);
    if (this.jdField_a_of_type_ComTencentAvUtilsDownloadDownloadResult != null)
    {
      localStringBuilder.append(",mResult.mIsSucc = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUtilsDownloadDownloadResult.jdField_a_of_type_Boolean);
      localStringBuilder.append(",mResult.mFileLength = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUtilsDownloadDownloadResult.jdField_a_of_type_Long);
      localStringBuilder.append(",mResult.mErrCode = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUtilsDownloadDownloadResult.jdField_a_of_type_Int);
      localStringBuilder.append(",mResult.mErrStr = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUtilsDownloadDownloadResult.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(",mResult.mTryCount = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUtilsDownloadDownloadResult.jdField_b_of_type_Int);
      localStringBuilder.append(",mResult.mCostTime = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUtilsDownloadDownloadResult.jdField_b_of_type_Long);
      localStringBuilder.append("ms");
    }
    else
    {
      localStringBuilder.append(",mResult = null");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.download.DownloadParams
 * JD-Core Version:    0.7.0.1
 */
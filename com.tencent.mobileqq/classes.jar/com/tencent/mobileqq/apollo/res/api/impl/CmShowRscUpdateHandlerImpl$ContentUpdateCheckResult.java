package com.tencent.mobileqq.apollo.res.api.impl;

import android.text.TextUtils;
import java.io.File;

public class CmShowRscUpdateHandlerImpl$ContentUpdateCheckResult
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  
  public static String a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    if (paramString1.endsWith("/"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramLong);
      localStringBuilder.append("/");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("/");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static boolean a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (100 == paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/rsc_jsonConfig/");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString2);
      return new File(localStringBuilder.toString()).exists();
    }
    return false;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    if (100 == this.jdField_a_of_type_Int)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/rsc_jsonConfig/");
      localStringBuilder.append(a());
      localStringBuilder.append(File.separator);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String c()
  {
    if (100 == this.jdField_a_of_type_Int)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b());
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(".zip");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String d()
  {
    if (100 == this.jdField_a_of_type_Int)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b());
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("_patch.zip");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String e()
  {
    if (100 == this.jdField_a_of_type_Int)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b());
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append(".zip");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ContentUpdateCheckResult{");
    localStringBuffer.append("mBuzId=");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", mItemId=");
    localStringBuffer.append(this.jdField_a_of_type_Long);
    localStringBuffer.append(", mName='");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mVersion=");
    localStringBuffer.append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", mOldVersion=");
    localStringBuffer.append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", mDownloadFileUrl='");
    localStringBuffer.append(this.jdField_b_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mIsPatch=");
    localStringBuffer.append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append(", mPatchData=");
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      localStringBuffer.append("null");
    }
    else
    {
      localStringBuffer.append("mPatchData:");
      localStringBuffer.append(this.jdField_a_of_type_ArrayOfByte);
    }
    localStringBuffer.append(", mPatchSize=");
    localStringBuffer.append(this.jdField_b_of_type_Long);
    localStringBuffer.append(", mDownloadPatchFileUrl='");
    localStringBuffer.append(this.jdField_c_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mMd5='");
    localStringBuffer.append(this.jdField_d_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mDownloadFileName='");
    localStringBuffer.append(this.jdField_e_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mDownloadPatchFileName='");
    localStringBuffer.append(this.jdField_f_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mFlagWriteIntervalTs=");
    localStringBuffer.append(this.jdField_b_of_type_Boolean);
    localStringBuffer.append(", mCheckServerInterval=");
    localStringBuffer.append(this.jdField_d_of_type_Int);
    localStringBuffer.append(", mCheckRequestId=");
    localStringBuffer.append(this.jdField_e_of_type_Int);
    localStringBuffer.append(", mDomainId=");
    localStringBuffer.append(this.jdField_f_of_type_Int);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult
 * JD-Core Version:    0.7.0.1
 */
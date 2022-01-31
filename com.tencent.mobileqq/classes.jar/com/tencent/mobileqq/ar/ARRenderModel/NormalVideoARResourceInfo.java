package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.ARVideoLayout;
import com.tencent.mobileqq.ar.keying.KeyingParams;

public class NormalVideoARResourceInfo
  extends ARRenderResourceInfo
{
  public ArCloudConfigInfo.ARVideoLayout a;
  public KeyingParams a;
  public String b;
  public int d;
  public int e = 1;
  
  public NormalVideoARResourceInfo(String paramString1, int paramInt1, int paramInt2, int paramInt3, KeyingParams paramKeyingParams, ArCloudConfigInfo.ARVideoLayout paramARVideoLayout, String paramString2, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString1, paramInt1, paramInt2, paramInt5, paramFloat1, paramFloat2, paramFloat3);
    this.d = paramInt3;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.e = paramInt4;
    this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams = paramKeyingParams;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout = paramARVideoLayout;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("NormalVideoARResourceInfo{");
    localStringBuilder.append("key=").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", arType=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", trackMode=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mRealRenderType=").append(this.d);
    localStringBuilder.append(", mKeyingParams='").append(this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams).append('\'');
    localStringBuilder.append(", mVideoPath='").append(this.jdField_b_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", mLayout='").append(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.NormalVideoARResourceInfo
 * JD-Core Version:    0.7.0.1
 */
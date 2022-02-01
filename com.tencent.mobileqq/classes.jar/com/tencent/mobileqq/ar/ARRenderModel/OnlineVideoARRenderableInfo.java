package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.ARVideoLayout;
import com.tencent.mobileqq.ar.keying.KeyingParams;

public class OnlineVideoARRenderableInfo
  extends ARRenderResourceInfo
{
  public ArCloudConfigInfo.ARVideoLayout a;
  public KeyingParams a;
  public boolean a;
  public long b;
  public String b;
  public int d;
  public int e = 1;
  
  public OnlineVideoARRenderableInfo(String paramString1, int paramInt1, int paramInt2, int paramInt3, KeyingParams paramKeyingParams, ArCloudConfigInfo.ARVideoLayout paramARVideoLayout, String paramString2, long paramLong, boolean paramBoolean, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString1, paramInt1, paramInt2, paramInt5, paramFloat1, paramFloat2, paramFloat3);
    this.d = paramInt3;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.e = paramInt4;
    this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams = paramKeyingParams;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout = paramARVideoLayout;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("OnlineVideoARRenderableInfo{");
    localStringBuilder.append("key=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", trackMode=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mRealRenderType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mKeyingParams='");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoUrl='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoSize='");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLayout='");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isSoftPlay='");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderableInfo
 * JD-Core Version:    0.7.0.1
 */
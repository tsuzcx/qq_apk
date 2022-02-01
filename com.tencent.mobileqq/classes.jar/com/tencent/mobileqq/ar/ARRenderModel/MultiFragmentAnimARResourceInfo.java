package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class MultiFragmentAnimARResourceInfo
  extends ARRenderResourceInfo
{
  public ArCloudConfigInfo a;
  
  public MultiFragmentAnimARResourceInfo(String paramString, int paramInt1, int paramInt2, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MultiFragmentAnimARResourceInfo{");
    localStringBuilder.append("key=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", trackMode=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", arResourceInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimARResourceInfo
 * JD-Core Version:    0.7.0.1
 */
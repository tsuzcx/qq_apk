package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.ARVideoLayout;

public class GeneralARResourceInfo
  extends ARRenderResourceInfo
{
  public ArCloudConfigInfo.ARVideoLayout a;
  public String b;
  public String c;
  public String d;
  
  public GeneralARResourceInfo(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, ArCloudConfigInfo.ARVideoLayout paramARVideoLayout, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString1, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout = paramARVideoLayout;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("GeneralAR_3D_ResourceInfo{");
    localStringBuilder.append("key=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", trackMode=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mLuaScriptPath=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", mResourceDirPath='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMusicPath='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLayout='");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.GeneralARResourceInfo
 * JD-Core Version:    0.7.0.1
 */
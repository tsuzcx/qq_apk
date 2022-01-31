package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class Interactive3DResourceInfo
  extends ARRenderResourceInfo
{
  public ArCloudConfigInfo a;
  public String b;
  public String c;
  public String d;
  
  public Interactive3DResourceInfo(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString1, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("GeneralAR_3D_ResourceInfo{");
    localStringBuilder.append("key=").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", arType=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", trackMode=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mLuaScriptPath=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", mResourceDirPath='").append(this.c).append('\'');
    localStringBuilder.append(", mMusicPath='").append(this.d).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.Interactive3DResourceInfo
 * JD-Core Version:    0.7.0.1
 */
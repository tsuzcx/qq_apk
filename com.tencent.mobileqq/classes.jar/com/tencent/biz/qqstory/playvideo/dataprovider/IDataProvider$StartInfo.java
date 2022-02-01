package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.Nullable;

public class IDataProvider$StartInfo
{
  public IDataProvider.GroupId a;
  @Nullable
  public IDataProvider.GroupInfo a;
  @Nullable
  public String a;
  @Nullable
  public String b;
  
  public IDataProvider$StartInfo(@Nullable IDataProvider.GroupId paramGroupId, @Nullable String paramString1, @Nullable String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = paramGroupId;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public IDataProvider$StartInfo(StartInfo paramStartInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = paramStartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
    this.jdField_a_of_type_JavaLangString = paramStartInfo.jdField_a_of_type_JavaLangString;
    this.b = paramStartInfo.b;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo = paramStartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StartInfo{mGroupId=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.StartInfo
 * JD-Core Version:    0.7.0.1
 */
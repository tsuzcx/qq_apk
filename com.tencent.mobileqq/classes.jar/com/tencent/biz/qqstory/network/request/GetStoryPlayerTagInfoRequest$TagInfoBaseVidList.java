package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.takevideo.tag.CompInfoBase;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;

public class GetStoryPlayerTagInfoRequest$TagInfoBaseVidList
{
  public final CompInfoBase a;
  public final TagItem.TagInfoBase a;
  public final String a;
  public final String b;
  
  public GetStoryPlayerTagInfoRequest$TagInfoBaseVidList(String paramString1, TagItem.TagInfoBase paramTagInfoBase, CompInfoBase paramCompInfoBase, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase = paramTagInfoBase;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagCompInfoBase = paramCompInfoBase;
    this.b = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TagInfoBaseVidList{vid='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", tagInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase);
    localStringBuilder.append(", comInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagCompInfoBase);
    localStringBuilder.append(", extCfgInfo=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest.TagInfoBaseVidList
 * JD-Core Version:    0.7.0.1
 */
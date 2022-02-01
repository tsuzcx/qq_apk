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
    return "TagInfoBaseVidList{vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", tagInfo=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase + ", comInfo=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagCompInfoBase + ", extCfgInfo=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest.TagInfoBaseVidList
 * JD-Core Version:    0.7.0.1
 */
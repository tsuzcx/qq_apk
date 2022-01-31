package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;

public class GetStoryPlayerTagInfoRequest$TagInfoBaseVidList
{
  public final TagItem.TagInfoBase a;
  public final String a;
  
  public GetStoryPlayerTagInfoRequest$TagInfoBaseVidList(String paramString, TagItem.TagInfoBase paramTagInfoBase)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase = paramTagInfoBase;
  }
  
  public String toString()
  {
    return "TagInfoBaseVidList{vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", tagInfo=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest.TagInfoBaseVidList
 * JD-Core Version:    0.7.0.1
 */
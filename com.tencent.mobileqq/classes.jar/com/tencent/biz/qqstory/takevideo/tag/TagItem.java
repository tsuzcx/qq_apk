package com.tencent.biz.qqstory.takevideo.tag;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagItem;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONException;
import org.json.JSONObject;

public class TagItem
{
  public final int a;
  public final TagItem.TagInfoBase a;
  public final String a;
  
  public TagItem(qqstory_struct.TagItem paramTagItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase = new TagItem.TagInfoBase((qqstory_struct.TagInfoBase)paramTagItem.base_info.get());
    this.jdField_a_of_type_Int = paramTagItem.join_count.get();
    this.jdField_a_of_type_JavaLangString = paramTagItem.wording.get();
  }
  
  public TagItem(TagItem.TagInfoBase paramTagInfoBase, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase = paramTagInfoBase;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String a()
  {
    Object localObject = new JSONObject();
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase == null) {
        return null;
      }
      ((JSONObject)localObject).put("tag_id", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase.jdField_a_of_type_Long);
      ((JSONObject)localObject).put("tag_name", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("tag_desc", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase.b);
      ((JSONObject)localObject).put("tag_type", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("join_count", this.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("wording", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("one_page", 1);
      ((JSONObject)localObject).put("src_type", "web");
      ((JSONObject)localObject).put("version", 1);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (TagItem)paramObject;
      TagItem.TagInfoBase localTagInfoBase = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase;
      if (localTagInfoBase != null) {
        return localTagInfoBase.equals(paramObject.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase);
      }
      return paramObject.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    TagItem.TagInfoBase localTagInfoBase = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase;
    if (localTagInfoBase != null) {
      return localTagInfoBase.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TagItem{tagInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase);
    localStringBuilder.append(", joinCount=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", wording='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tag.TagItem
 * JD-Core Version:    0.7.0.1
 */
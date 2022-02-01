package com.tencent.biz.qqstory.takevideo.tag;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagItem;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONException;
import org.json.JSONObject;

public class TagItem
{
  public final TagItem.TagInfoBase a;
  public final int b;
  public final String c;
  
  public TagItem(qqstory_struct.TagItem paramTagItem)
  {
    this.a = new TagItem.TagInfoBase((qqstory_struct.TagInfoBase)paramTagItem.base_info.get());
    this.b = paramTagItem.join_count.get();
    this.c = paramTagItem.wording.get();
  }
  
  public TagItem(TagItem.TagInfoBase paramTagInfoBase, int paramInt, String paramString)
  {
    this.a = paramTagInfoBase;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public String a()
  {
    Object localObject = new JSONObject();
    try
    {
      if (this.a == null) {
        return null;
      }
      ((JSONObject)localObject).put("tag_id", this.a.a);
      ((JSONObject)localObject).put("tag_name", this.a.b);
      ((JSONObject)localObject).put("tag_desc", this.a.c);
      ((JSONObject)localObject).put("tag_type", this.a.d);
      ((JSONObject)localObject).put("join_count", this.b);
      ((JSONObject)localObject).put("wording", this.c);
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
      TagItem.TagInfoBase localTagInfoBase = this.a;
      if (localTagInfoBase != null) {
        return localTagInfoBase.equals(paramObject.a);
      }
      return paramObject.a == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    TagItem.TagInfoBase localTagInfoBase = this.a;
    if (localTagInfoBase != null) {
      return localTagInfoBase.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TagItem{tagInfo=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", joinCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", wording='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tag.TagItem
 * JD-Core Version:    0.7.0.1
 */
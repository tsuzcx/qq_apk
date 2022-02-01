package com.tencent.biz.qqstory.playmode.util;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import org.json.JSONException;
import org.json.JSONObject;

public class MsgTabVideoData
{
  public long a;
  public StoryVideoItem a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  
  public MsgTabVideoData()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("feedId", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("didRead", this.jdField_a_of_type_Boolean);
      localJSONObject.put("vid", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("videoIndex", this.jdField_a_of_type_Long);
      localJSONObject.put("isLocal", this.jdField_b_of_type_Boolean);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public void a(@NonNull JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("didRead");
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("feedId");
      this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("vid");
      this.jdField_a_of_type_Long = paramJSONObject.optLong("videoIndex");
      this.jdField_b_of_type_Boolean = paramJSONObject.getBoolean("isLocal");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgTabVideoData{didRead=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoIndex='");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append('\'');
    localStringBuilder.append(", storyVideoItem=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    localStringBuilder.append(", isLocal=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.MsgTabVideoData
 * JD-Core Version:    0.7.0.1
 */
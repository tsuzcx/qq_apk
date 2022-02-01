package com.tencent.biz.qqstory.playmode.util;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import org.json.JSONException;
import org.json.JSONObject;

public class MsgTabVideoData
{
  public boolean a;
  public String b;
  public String c;
  public long d;
  public StoryVideoItem e;
  public boolean f = false;
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("feedId", this.b);
      localJSONObject.put("didRead", this.a);
      localJSONObject.put("vid", this.c);
      localJSONObject.put("videoIndex", this.d);
      localJSONObject.put("isLocal", this.f);
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
      this.a = paramJSONObject.getBoolean("didRead");
      this.b = paramJSONObject.getString("feedId");
      this.c = paramJSONObject.getString("vid");
      this.d = paramJSONObject.optLong("videoIndex");
      this.f = paramJSONObject.getBoolean("isLocal");
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
    localStringBuilder.append(this.a);
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoIndex='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", storyVideoItem=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", isLocal=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.MsgTabVideoData
 * JD-Core Version:    0.7.0.1
 */
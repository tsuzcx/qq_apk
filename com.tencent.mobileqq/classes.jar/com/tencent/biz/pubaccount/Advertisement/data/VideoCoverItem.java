package com.tencent.biz.pubaccount.Advertisement.data;

import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.Video;

public class VideoCoverItem
{
  public int a;
  public String b;
  public String c;
  public Object d;
  
  public VideoCoverItem() {}
  
  public VideoCoverItem(int paramInt, String paramString1, String paramString2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public static VideoCoverItem a(int paramInt, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      VideoCoverItem localVideoCoverItem = new VideoCoverItem();
      localVideoCoverItem.a = paramInt;
      localVideoCoverItem.b = paramJSONObject.getString("str_cover");
      localVideoCoverItem.c = paramJSONObject.getString("str_src");
      return localVideoCoverItem;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static VideoCoverItem a(int paramInt, submsgtype0xf9.Video paramVideo)
  {
    if (paramVideo == null) {
      return null;
    }
    try
    {
      VideoCoverItem localVideoCoverItem = new VideoCoverItem();
      localVideoCoverItem.c = paramVideo.str_src.get();
      localVideoCoverItem.b = paramVideo.str_cover.get();
      localVideoCoverItem.a = paramInt;
      return localVideoCoverItem;
    }
    catch (Exception paramVideo)
    {
      paramVideo.printStackTrace();
    }
    return null;
  }
  
  public static VideoCoverItem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      VideoCoverItem localVideoCoverItem = new VideoCoverItem();
      localVideoCoverItem.a = paramJSONObject.getInt("index");
      localVideoCoverItem.b = paramJSONObject.getString("cover");
      localVideoCoverItem.c = paramJSONObject.getString("src");
      return localVideoCoverItem;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", this.a);
      localJSONObject.put("cover", this.b);
      localJSONObject.put("src", this.c);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mVideoSrc ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" mVideoCoverPic ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" mVideoIndex ");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqstory.model.item;

import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.Column;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoGameInfo
{
  @JsonORM.Column(a="gametype")
  public int a;
  @JsonORM.Column(a="gameid")
  public String b;
  @JsonORM.Column(a="name")
  public String c;
  @JsonORM.Column(a="result")
  public String d;
  
  public static VideoGameInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (VideoGameInfo)JsonORM.a(new JSONObject(paramString), VideoGameInfo.class);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (JsonORM.JsonParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.VideoGameInfo
 * JD-Core Version:    0.7.0.1
 */
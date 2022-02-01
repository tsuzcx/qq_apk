package com.tencent.biz.subscribe.transition;

import org.json.JSONException;
import org.json.JSONObject;

public class TransitionAnimHelper$TransAnimParam
{
  public String a;
  int b;
  int c;
  private final String d = "image_url";
  private final String e = "image_width";
  private final String f = "image_height";
  
  public TransitionAnimHelper$TransAnimParam() {}
  
  public TransitionAnimHelper$TransAnimParam(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("image_url", this.a);
      localJSONObject.put("image_width", this.b);
      localJSONObject.put("image_height", this.c);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.a = paramString.getString("image_url");
      this.b = paramString.getInt("image_width");
      this.c = paramString.getInt("image_height");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.transition.TransitionAnimHelper.TransAnimParam
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.springfestival.config;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpringFestivalRedpacketPreloadConfBean
{
  public JSONArray a = new JSONArray();
  
  public static SpringFestivalRedpacketPreloadConfBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    SpringFestivalRedpacketPreloadConfBean localSpringFestivalRedpacketPreloadConfBean = new SpringFestivalRedpacketPreloadConfBean();
    localSpringFestivalRedpacketPreloadConfBean.a = a(new JSONObject(paramString));
    return localSpringFestivalRedpacketPreloadConfBean;
  }
  
  private static JSONArray a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = new JSONArray();
    paramJSONObject = paramJSONObject.optJSONArray("module_config");
    int i = 0;
    while (i < paramJSONObject.length())
    {
      localJSONArray.put(paramJSONObject.optJSONObject(i));
      i += 1;
    }
    return localJSONArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketPreloadConfBean
 * JD-Core Version:    0.7.0.1
 */
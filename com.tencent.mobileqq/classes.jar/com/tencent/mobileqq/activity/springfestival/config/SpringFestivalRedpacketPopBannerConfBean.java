package com.tencent.mobileqq.activity.springfestival.config;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpringFestivalRedpacketPopBannerConfBean
{
  public JSONArray a = new JSONArray();
  
  public static SpringFestivalRedpacketPopBannerConfBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    SpringFestivalRedpacketPopBannerConfBean localSpringFestivalRedpacketPopBannerConfBean = new SpringFestivalRedpacketPopBannerConfBean();
    localSpringFestivalRedpacketPopBannerConfBean.a = a(new JSONObject(paramString));
    return localSpringFestivalRedpacketPopBannerConfBean;
  }
  
  private static JSONArray a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = new JSONArray();
    paramJSONObject = paramJSONObject.optJSONArray("PopBannerList");
    int i = 0;
    while (i < paramJSONObject.length())
    {
      localJSONArray.put(paramJSONObject.optJSONObject(i));
      i += 1;
    }
    return localJSONArray;
  }
  
  public boolean a()
  {
    return (this.a == null) || (this.a.length() == 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SpringFestivalRedpacketPopBannerConfBean{allConfigJa=");
    if (this.a == null) {}
    for (String str = "null";; str = this.a.toString()) {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketPopBannerConfBean
 * JD-Core Version:    0.7.0.1
 */
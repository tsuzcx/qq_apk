package com.tencent.biz.pubaccount.readinjoy.atlas;

import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONException;
import org.json.JSONObject;

public class AtlasCommonR5Builder
{
  private JSONObject a = new JSONObject();
  
  public AtlasCommonR5Builder a()
  {
    try
    {
      this.a.put("network", GalleryReportedUtils.a(BaseApplicationImpl.getApplication().getApplicationContext()));
      this.a.put("version", VideoReporter.a);
      this.a.put("os", "1");
      this.a.put("uin", ReadInJoyUtils.a());
      this.a.put("city", GalleryReportedUtils.b());
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public AtlasCommonR5Builder a(int paramInt)
  {
    int i = 0;
    if (paramInt == 41516) {
      i = 3;
    }
    for (;;)
    {
      try
      {
        this.a.put("source", i);
        return this;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (paramInt == 41522) {
        i = 16;
      }
    }
    return this;
  }
  
  public String a()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.atlas.AtlasCommonR5Builder
 * JD-Core Version:    0.7.0.1
 */
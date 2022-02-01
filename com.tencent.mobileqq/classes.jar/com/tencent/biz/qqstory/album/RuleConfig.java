package com.tencent.biz.qqstory.album;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class RuleConfig
{
  public int a;
  public String b;
  public int c;
  public List<String> d;
  public int e;
  public String f;
  
  public RuleConfig(int paramInt)
  {
    this.a = paramInt;
  }
  
  public RuleConfig a(JSONObject paramJSONObject, int paramInt)
  {
    this.b = paramJSONObject.optString("transId", "");
    this.e = paramJSONObject.optInt("min_limit", paramInt);
    this.f = paramJSONObject.optString("wording");
    this.c = paramJSONObject.optInt("text_id", -1);
    paramJSONObject = paramJSONObject.optJSONArray("transList");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      this.d = new ArrayList();
      paramInt = 0;
      while (paramInt < paramJSONObject.length())
      {
        this.d.add(paramJSONObject.getString(paramInt));
        paramInt += 1;
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.RuleConfig
 * JD-Core Version:    0.7.0.1
 */
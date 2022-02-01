package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import org.json.JSONObject;

public class AdPKImageData
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public AdPKImageData(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.a = paramJSONObject.optString("dest_url");
      this.b = paramJSONObject.optString("rl");
      this.c = paramJSONObject.optString("button_txt");
      this.d = paramJSONObject.optString("button_bg");
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AdPKImageData{");
    localStringBuilder.append("destUrl=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",rl=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",buttonTxt=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",buttonBg=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdPKImageData
 * JD-Core Version:    0.7.0.1
 */
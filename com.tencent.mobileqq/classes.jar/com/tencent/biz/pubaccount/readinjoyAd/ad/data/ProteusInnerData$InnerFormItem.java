package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class ProteusInnerData$InnerFormItem
{
  public int a = 0;
  public Pattern b = null;
  public String c = "";
  public String d = "";
  public String e = "";
  public JSONObject f = null;
  
  public ProteusInnerData$InnerFormItem(ProteusInnerData paramProteusInnerData, int paramInt, String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, Pattern paramPattern)
  {
    this.a = paramInt;
    if (!TextUtils.isEmpty(paramString1)) {
      this.c = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.d = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      this.e = paramString3;
    }
    if (paramJSONObject != null) {
      this.f = paramJSONObject;
    }
    if (paramPattern != null) {
      this.b = paramPattern;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InnerFormItem[");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData.InnerFormItem
 * JD-Core Version:    0.7.0.1
 */
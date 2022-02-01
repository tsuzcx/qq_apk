package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class ProteusInnerData$InnerFormItem
{
  public int a;
  public String a;
  public Pattern a;
  public JSONObject a;
  public String b = "";
  public String c = "";
  
  public ProteusInnerData$InnerFormItem(ProteusInnerData paramProteusInnerData, int paramInt, String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, Pattern paramPattern)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilRegexPattern = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    this.jdField_a_of_type_Int = paramInt;
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_JavaLangString = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.b = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      this.c = paramString3;
    }
    if (paramJSONObject != null) {
      this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    }
    if (paramPattern != null) {
      this.jdField_a_of_type_JavaUtilRegexPattern = paramPattern;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InnerFormItem[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData.InnerFormItem
 * JD-Core Version:    0.7.0.1
 */
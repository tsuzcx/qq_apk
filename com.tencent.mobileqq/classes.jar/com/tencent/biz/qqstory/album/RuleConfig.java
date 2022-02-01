package com.tencent.biz.qqstory.album;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class RuleConfig
{
  public int a;
  public String a;
  public List<String> a;
  public int b;
  public String b;
  public int c;
  
  public RuleConfig(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public RuleConfig a(JSONObject paramJSONObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("transId", "");
    this.c = paramJSONObject.optInt("min_limit", paramInt);
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("wording");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("text_id", -1);
    paramJSONObject = paramJSONObject.optJSONArray("transList");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramInt = 0;
      while (paramInt < paramJSONObject.length())
      {
        this.jdField_a_of_type_JavaUtilList.add(paramJSONObject.getString(paramInt));
        paramInt += 1;
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.RuleConfig
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import org.json.JSONException;
import org.json.JSONObject;

public class NearbyActivity$TabInfo
  implements Comparable
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e;
  
  public int a(TabInfo paramTabInfo)
  {
    return this.jdField_a_of_type_Int - paramTabInfo.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return "android:switcher:" + 2131365206 + ":" + this.jdField_a_of_type_Int;
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangString = paramString.optString("tabName");
      this.jdField_b_of_type_JavaLangString = paramString.optString("tabUrl");
      this.jdField_a_of_type_Int = paramString.optInt("tabIndex");
      this.jdField_b_of_type_Int = paramString.optInt("tabType");
      this.c = paramString.optInt("disableScroll");
      this.d = paramString.optInt("needLoc");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tabName", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("tabUrl", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("tabIndex", this.jdField_a_of_type_Int);
      localJSONObject.put("tabType", this.jdField_b_of_type_Int);
      localJSONObject.put("disableScroll", this.c);
      localJSONObject.put("needLoc", this.d);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.TabInfo
 * JD-Core Version:    0.7.0.1
 */
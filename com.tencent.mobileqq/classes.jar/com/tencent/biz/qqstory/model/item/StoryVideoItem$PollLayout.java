package com.tencent.biz.qqstory.model.item;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StoryVideoItem$PollLayout
{
  public final int a;
  private final String a;
  public final String[] a;
  public final int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public final int i;
  
  private StoryVideoItem$PollLayout(JSONObject paramJSONObject)
  {
    int k;
    try
    {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.toString();
      this.jdField_a_of_type_Int = paramJSONObject.getInt("v");
      this.b = paramJSONObject.getInt("id");
      this.i = paramJSONObject.getJSONObject("a").getInt("r");
      JSONArray localJSONArray = paramJSONObject.getJSONObject("a").getJSONArray("ss");
      this.c = localJSONArray.getInt(0);
      this.d = localJSONArray.getInt(1);
      localJSONArray = paramJSONObject.getJSONObject("a").getJSONArray("ls");
      this.e = localJSONArray.getInt(0);
      this.f = localJSONArray.getInt(1);
      localJSONArray = paramJSONObject.getJSONObject("a").getJSONArray("lp");
      this.g = localJSONArray.getInt(0);
      this.h = localJSONArray.getInt(1);
      paramJSONObject = paramJSONObject.getJSONObject("a").getJSONArray("c");
      k = paramJSONObject.length();
      if (k < 1) {
        throw new IllegalArgumentException("content length should more than 1");
      }
    }
    catch (JSONException paramJSONObject)
    {
      throw new IllegalArgumentException(paramJSONObject);
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[k];
    while (j < k)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString[j] = paramJSONObject.optString(j, "(NULL)");
      j += 1;
    }
  }
  
  public static PollLayout a(@Nullable String paramString)
  {
    try
    {
      paramString = a(new JSONObject(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      SLog.a("StoryVideoItem.PollLayout", "fromJson()", paramString);
      return null;
    }
    catch (NullPointerException paramString)
    {
      SLog.a("StoryVideoItem.PollLayout", "fromJson()", paramString);
    }
    return null;
  }
  
  public static PollLayout a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = new PollLayout(paramJSONObject);
      return paramJSONObject;
    }
    catch (IllegalArgumentException paramJSONObject)
    {
      SLog.a("StoryVideoItem.PollLayout", "fromJson()", paramJSONObject);
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String toString()
  {
    return "PollLayout{version=" + this.jdField_a_of_type_Int + ", id=" + this.b + ", screenWidth=" + this.c + ", screenHeight=" + this.d + ", layoutWidth=" + this.e + ", layoutHeight=" + this.f + ", layoutCenterX=" + this.g + ", layoutCenterY=" + this.h + ", rotation=" + this.i + ", contents=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout
 * JD-Core Version:    0.7.0.1
 */
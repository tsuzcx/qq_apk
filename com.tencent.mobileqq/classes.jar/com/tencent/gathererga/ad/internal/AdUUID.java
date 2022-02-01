package com.tencent.gathererga.ad.internal;

import android.text.TextUtils;
import com.tencent.gathererga.core.internal.util.GLog;
import org.json.JSONObject;

public final class AdUUID
{
  private int jdField_a_of_type_Int = -2147483648;
  private long jdField_a_of_type_Long = -2147483648L;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  private JSONObject a()
  {
    if (!a())
    {
      GLog.d("toJSONObject error");
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("v", this.jdField_a_of_type_Int);
      localJSONObject.put("u", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("t", this.jdField_a_of_type_Long);
      localJSONObject.put("m", this.b);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      GLog.b("toJSONObject", localThrowable);
    }
    return null;
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Int != -2147483648) && (this.jdField_a_of_type_Long != -2147483648L) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b));
  }
  
  public String toString()
  {
    JSONObject localJSONObject = a();
    if ((localJSONObject != null) && (!JSONObject.NULL.equals(localJSONObject))) {
      return localJSONObject.toString();
    }
    GLog.d("toString error");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.ad.internal.AdUUID
 * JD-Core Version:    0.7.0.1
 */
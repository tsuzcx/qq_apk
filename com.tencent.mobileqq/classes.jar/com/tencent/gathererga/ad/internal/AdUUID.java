package com.tencent.gathererga.ad.internal;

import android.text.TextUtils;
import com.tencent.gathererga.core.internal.util.GLog;
import org.json.JSONObject;

public final class AdUUID
{
  private int a = -2147483648;
  private long b = -2147483648L;
  private String c;
  private String d;
  
  private JSONObject a()
  {
    if (!b())
    {
      GLog.d("toJSONObject error");
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("v", this.a);
      localJSONObject.put("u", this.c);
      localJSONObject.put("t", this.b);
      localJSONObject.put("m", this.d);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      GLog.b("toJSONObject", localThrowable);
    }
    return null;
  }
  
  private boolean b()
  {
    return (this.a != -2147483648) && (this.b != -2147483648L) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.d));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.ad.internal.AdUUID
 * JD-Core Version:    0.7.0.1
 */
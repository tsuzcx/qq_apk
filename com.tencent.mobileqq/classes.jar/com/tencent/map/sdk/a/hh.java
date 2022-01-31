package com.tencent.map.sdk.a;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;

public final class hh
{
  public int a;
  public int b;
  public JSONArray c;
  public String[] d;
  
  public hh(int paramInt1, int paramInt2, JSONArray paramJSONArray)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramJSONArray;
    if (this.c == null)
    {
      this.d = null;
      return;
    }
    paramInt2 = this.c.length();
    this.d = new String[paramInt2];
    paramInt1 = 0;
    while (paramInt1 < paramInt2) {
      try
      {
        this.d[paramInt1] = this.c.getString(paramInt1);
        paramInt1 += 1;
      }
      catch (JSONException paramJSONArray)
      {
        this.d = null;
        or.b(Log.getStackTraceString(paramJSONArray));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.hh
 * JD-Core Version:    0.7.0.1
 */
package com.huawei.agconnect.config.a;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

class d
  implements b
{
  private final JSONObject a = a(paramInputStream);
  
  d(InputStream paramInputStream) {}
  
  private JSONObject a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream = new JSONObject(h.a(paramInputStream, "UTF-8"));
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      Log.e("InputStreamReader", "IOException when reading the 'Config' from InputStream.");
      return new JSONObject();
    }
    catch (JSONException paramInputStream)
    {
      for (;;)
      {
        Log.e("InputStreamReader", "JSONException when reading the 'Config' from InputStream.");
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (paramString1.endsWith("/")) {}
    for (;;)
    {
      return paramString2;
      String[] arrayOfString = paramString1.split("/");
      try
      {
        JSONObject localJSONObject = this.a;
        int i = 1;
        while (i < arrayOfString.length)
        {
          if (i == arrayOfString.length - 1) {
            return localJSONObject.get(arrayOfString[i]).toString();
          }
          localJSONObject = localJSONObject.getJSONObject(arrayOfString[i]);
          i += 1;
        }
        return paramString2;
      }
      catch (JSONException localJSONException)
      {
        Log.w("InputStreamReader", "JSONException when reading 'path': " + paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.config.a.d
 * JD-Core Version:    0.7.0.1
 */
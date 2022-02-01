package com.huawei.agconnect.config.a;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

class f
  implements d
{
  private final JSONObject a = a(paramInputStream);
  
  f(InputStream paramInputStream) {}
  
  private JSONObject a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream = new JSONObject(j.a(paramInputStream, "UTF-8"));
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      break label26;
    }
    catch (JSONException paramInputStream)
    {
      label20:
      break label20;
    }
    paramInputStream = "JSONException when reading the 'Config' from InputStream.";
    break label29;
    label26:
    paramInputStream = "IOException when reading the 'Config' from InputStream.";
    label29:
    Log.e("InputStreamReader", paramInputStream);
    return new JSONObject();
  }
  
  public String getString(String paramString1, String paramString2)
  {
    if (paramString1.endsWith("/")) {
      return paramString2;
    }
    String[] arrayOfString = paramString1.split("/");
    try
    {
      localObject = this.a;
      int i = 1;
      while (i < arrayOfString.length)
      {
        if (i == arrayOfString.length - 1) {
          return ((JSONObject)localObject).get(arrayOfString[i]).toString();
        }
        localObject = ((JSONObject)localObject).getJSONObject(arrayOfString[i]);
        i += 1;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      label74:
      break label74;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("JSONException when reading 'path': ");
    ((StringBuilder)localObject).append(paramString1);
    Log.w("InputStreamReader", ((StringBuilder)localObject).toString());
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.agconnect.config.a.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;
import org.json.JSONException;
import org.json.JSONObject;

public final class ArkAppCacheMgr$ArkDescIconInfo
{
  public String iconPath;
  public String name;
  
  public static ArkDescIconInfo fromJson(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject != null) {
        paramString = new ArkDescIconInfo();
      }
      label46:
      return null;
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        paramString.name = localJSONObject.optString("name");
        paramString.iconPath = localJSONObject.optString("iconPath");
        return paramString;
      }
      catch (JSONException localJSONException2)
      {
        break label46;
      }
      localJSONException1 = localJSONException1;
      paramString = null;
      ArkAppCacheMgr.access$000().logI("ArkApp.ArkAppCacheMgr", "fromJson exception." + localJSONException1.getMessage());
      return paramString;
    }
  }
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.name);
      localJSONObject.put("iconPath", this.iconPath);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ArkAppCacheMgr.access$000().logI("ArkApp.ArkAppCacheMgr", "exception." + localJSONException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCacheMgr.ArkDescIconInfo
 * JD-Core Version:    0.7.0.1
 */
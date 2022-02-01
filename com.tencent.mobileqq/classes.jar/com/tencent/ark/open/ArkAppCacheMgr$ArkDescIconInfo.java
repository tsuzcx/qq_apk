package com.tencent.ark.open;

import com.tencent.ark.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public final class ArkAppCacheMgr$ArkDescIconInfo
{
  public String iconPath;
  public String name;
  
  public static ArkDescIconInfo fromJson(String paramString)
  {
    ArkDescIconInfo localArkDescIconInfo;
    try
    {
      paramString = new JSONObject(paramString);
      localArkDescIconInfo = new ArkDescIconInfo();
      try
      {
        localArkDescIconInfo.name = paramString.optString("name");
        localArkDescIconInfo.iconPath = paramString.optString("iconPath");
        return localArkDescIconInfo;
      }
      catch (JSONException paramString) {}
      localStringBuilder = new StringBuilder();
    }
    catch (JSONException paramString)
    {
      localArkDescIconInfo = null;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("fromJson exception.");
    localStringBuilder.append(paramString.getMessage());
    Logger.logI("ArkApp.ArkAppCacheMgr", localStringBuilder.toString());
    return localArkDescIconInfo;
  }
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.name);
      localJSONObject.put("iconPath", this.iconPath);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception.");
      localStringBuilder.append(localJSONException.getMessage());
      Logger.logI("ArkApp.ArkAppCacheMgr", localStringBuilder.toString());
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCacheMgr.ArkDescIconInfo
 * JD-Core Version:    0.7.0.1
 */
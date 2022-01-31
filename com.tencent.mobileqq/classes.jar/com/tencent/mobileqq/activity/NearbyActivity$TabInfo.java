package com.tencent.mobileqq.activity;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyActivity$TabInfo
  implements Serializable, Comparable<TabInfo>
{
  public static final int TAB_HOT_CHAT = 3;
  public static final int TAB_NEARBY = 1;
  public static final int TAB_NEARBY_HYBRID = 5;
  public static final int TAB_NEARBY_MSG = 6;
  public static final int TAB_NEARBY_YULIAO = 7;
  public static final int TAB_NOW = 2;
  public static final int TAB_WEB = 4;
  public int autoEnter;
  public int disableScroll;
  public int needLoc;
  public int reportId;
  public int tabIndex;
  public String tabName;
  public int tabType;
  public String tabUrl;
  
  public int compareTo(TabInfo paramTabInfo)
  {
    return this.tabIndex - paramTabInfo.tabIndex;
  }
  
  public void fromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.tabName = paramString.optString("tabName");
      this.tabUrl = paramString.optString("tabUrl");
      this.tabIndex = paramString.optInt("tabIndex");
      this.tabType = paramString.optInt("tabType");
      this.disableScroll = paramString.optInt("disableScroll");
      this.needLoc = paramString.optInt("needLoc");
      this.reportId = paramString.optInt("reportId");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String getTabTag()
  {
    return "android:switcher:" + 2131380045 + ":" + this.tabIndex;
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tabName", this.tabName);
      localJSONObject.put("tabUrl", this.tabUrl);
      localJSONObject.put("tabIndex", this.tabIndex);
      localJSONObject.put("tabType", this.tabType);
      localJSONObject.put("disableScroll", this.disableScroll);
      localJSONObject.put("needLoc", this.needLoc);
      localJSONObject.put("reportId", this.reportId);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.TabInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.contact.connections;

import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionsTabInfo
{
  public int a;
  public int b;
  public String c;
  public String d;
  public String e;
  public boolean f;
  
  public static ConnectionsTabInfo a(JSONObject paramJSONObject)
  {
    ConnectionsTabInfo localConnectionsTabInfo = new ConnectionsTabInfo();
    if (paramJSONObject != null)
    {
      localConnectionsTabInfo.a = paramJSONObject.optInt("tab_id", -1);
      localConnectionsTabInfo.b = paramJSONObject.optInt("recommend_count", 0);
      localConnectionsTabInfo.c = paramJSONObject.optString("tab_name");
      localConnectionsTabInfo.d = paramJSONObject.optString("icon_url_select");
      localConnectionsTabInfo.e = paramJSONObject.optString("icon_url_unselect");
    }
    return localConnectionsTabInfo;
  }
  
  public static JSONObject a(ConnectionsTabInfo paramConnectionsTabInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramConnectionsTabInfo != null) {}
    try
    {
      localJSONObject.put("tab_id", paramConnectionsTabInfo.a);
      localJSONObject.put("recommend_count", paramConnectionsTabInfo.b);
      localJSONObject.put("tab_name", paramConnectionsTabInfo.c);
      localJSONObject.put("icon_url_select", paramConnectionsTabInfo.d);
      localJSONObject.put("icon_url_unselect", paramConnectionsTabInfo.e);
      return localJSONObject;
    }
    catch (JSONException paramConnectionsTabInfo) {}
    return localJSONObject;
  }
  
  public static ConnectionsTabInfo b(ConnectionsTabInfo paramConnectionsTabInfo)
  {
    ConnectionsTabInfo localConnectionsTabInfo = new ConnectionsTabInfo();
    if (paramConnectionsTabInfo != null)
    {
      localConnectionsTabInfo.a = paramConnectionsTabInfo.a;
      localConnectionsTabInfo.c = paramConnectionsTabInfo.c;
      localConnectionsTabInfo.b = paramConnectionsTabInfo.b;
      localConnectionsTabInfo.d = paramConnectionsTabInfo.d;
      localConnectionsTabInfo.e = paramConnectionsTabInfo.e;
    }
    return localConnectionsTabInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ConnectionsTabInfo)) {
      return this.a == ((ConnectionsTabInfo)paramObject).a;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tab_id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" recommend_count=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" tab_name=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" icon_url_select=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" icon_url_unselect=");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo
 * JD-Core Version:    0.7.0.1
 */
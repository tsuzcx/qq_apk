package com.tencent.mobileqq.activity.contact.connections;

import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionsTabInfo
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public static ConnectionsTabInfo a(ConnectionsTabInfo paramConnectionsTabInfo)
  {
    ConnectionsTabInfo localConnectionsTabInfo = new ConnectionsTabInfo();
    if (paramConnectionsTabInfo != null)
    {
      localConnectionsTabInfo.jdField_a_of_type_Int = paramConnectionsTabInfo.jdField_a_of_type_Int;
      localConnectionsTabInfo.jdField_a_of_type_JavaLangString = paramConnectionsTabInfo.jdField_a_of_type_JavaLangString;
      localConnectionsTabInfo.jdField_b_of_type_Int = paramConnectionsTabInfo.jdField_b_of_type_Int;
      localConnectionsTabInfo.jdField_b_of_type_JavaLangString = paramConnectionsTabInfo.jdField_b_of_type_JavaLangString;
      localConnectionsTabInfo.c = paramConnectionsTabInfo.c;
    }
    return localConnectionsTabInfo;
  }
  
  public static ConnectionsTabInfo a(JSONObject paramJSONObject)
  {
    ConnectionsTabInfo localConnectionsTabInfo = new ConnectionsTabInfo();
    if (paramJSONObject != null)
    {
      localConnectionsTabInfo.jdField_a_of_type_Int = paramJSONObject.optInt("tab_id", -1);
      localConnectionsTabInfo.jdField_b_of_type_Int = paramJSONObject.optInt("recommend_count", 0);
      localConnectionsTabInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("tab_name");
      localConnectionsTabInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_url_select");
      localConnectionsTabInfo.c = paramJSONObject.optString("icon_url_unselect");
    }
    return localConnectionsTabInfo;
  }
  
  public static JSONObject a(ConnectionsTabInfo paramConnectionsTabInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramConnectionsTabInfo != null) {}
    try
    {
      localJSONObject.put("tab_id", paramConnectionsTabInfo.jdField_a_of_type_Int);
      localJSONObject.put("recommend_count", paramConnectionsTabInfo.jdField_b_of_type_Int);
      localJSONObject.put("tab_name", paramConnectionsTabInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("icon_url_select", paramConnectionsTabInfo.jdField_b_of_type_JavaLangString);
      localJSONObject.put("icon_url_unselect", paramConnectionsTabInfo.c);
      return localJSONObject;
    }
    catch (JSONException paramConnectionsTabInfo) {}
    return localJSONObject;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ConnectionsTabInfo)) {
      return this.jdField_a_of_type_Int == ((ConnectionsTabInfo)paramObject).jdField_a_of_type_Int;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    return "tab_id=" + this.jdField_a_of_type_Int + " recommend_count=" + this.jdField_b_of_type_Int + " tab_name=" + this.jdField_a_of_type_JavaLangString + " icon_url_select=" + this.jdField_b_of_type_JavaLangString + " icon_url_unselect=" + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo
 * JD-Core Version:    0.7.0.1
 */
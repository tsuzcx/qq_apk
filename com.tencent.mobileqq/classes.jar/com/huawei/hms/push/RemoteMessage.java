package com.huawei.hms.push;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class RemoteMessage
  implements Parcelable
{
  public static final Parcelable.Creator<RemoteMessage> CREATOR = new RemoteMessage.1();
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_NORMAL = 2;
  public static final int PRIORITY_UNKNOWN = 0;
  private static final String[] a = new String[0];
  private static final int[] b = new int[0];
  private static final long[] c = new long[0];
  private static final HashMap<String, Object> d = new HashMap(6);
  private static final HashMap<String, Object> e;
  private static final HashMap<String, Object> f;
  private static final HashMap<String, Object> g;
  private static final HashMap<String, Object> h;
  private Bundle i;
  private RemoteMessage.Notification j;
  
  static
  {
    d.put("from", "");
    d.put("collapseKey", "");
    d.put("sendTime", "");
    d.put("ttl", Integer.valueOf(86400));
    d.put("urgency", Integer.valueOf(2));
    d.put("oriUrgency", Integer.valueOf(2));
    d.put("sendMode", Integer.valueOf(0));
    d.put("receiptMode", Integer.valueOf(0));
    e = new HashMap(8);
    e.put("title_loc_key", "");
    e.put("body_loc_key", "");
    e.put("notifyIcon", "");
    e.put("title_loc_args", a);
    e.put("body_loc_args", a);
    e.put("ticker", "");
    e.put("notifyTitle", "");
    e.put("content", "");
    f = new HashMap(8);
    f.put("icon", "");
    f.put("color", "");
    f.put("sound", "");
    f.put("defaultLightSettings", Integer.valueOf(1));
    f.put("lightSettings", b);
    f.put("defaultSound", Integer.valueOf(1));
    f.put("defaultVibrateTimings", Integer.valueOf(1));
    f.put("vibrateTimings", c);
    g = new HashMap(8);
    g.put("tag", "");
    g.put("when", "");
    g.put("localOnly", Integer.valueOf(1));
    g.put("badgeSetNum", "");
    g.put("priority", "");
    g.put("autoCancel", Integer.valueOf(1));
    g.put("visibility", "");
    g.put("channelId", "");
    h = new HashMap(3);
    h.put("acn", "");
    h.put("intentUri", "");
    h.put("url", "");
  }
  
  public RemoteMessage(Bundle paramBundle)
  {
    this.i = a(paramBundle);
  }
  
  public RemoteMessage(Parcel paramParcel)
  {
    this.i = paramParcel.readBundle();
    this.j = ((RemoteMessage.Notification)paramParcel.readSerializable());
  }
  
  private Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject1 = b(paramBundle);
    JSONObject localJSONObject2 = a(localJSONObject1);
    String str1 = JsonUtil.getString(localJSONObject2, "data", null);
    localBundle.putString("device_token", paramBundle.getString("device_token"));
    JSONObject localJSONObject3 = b(localJSONObject2);
    JSONObject localJSONObject4 = c(localJSONObject3);
    JSONObject localJSONObject5 = d(localJSONObject3);
    if ((paramBundle.getInt("inputType") == 1) && (w.a(localJSONObject2, localJSONObject3, str1)))
    {
      localBundle.putString("data", aa.a(paramBundle.getByteArray("message_body")));
      return localBundle;
    }
    String str2 = paramBundle.getString("to");
    paramBundle = paramBundle.getString("message_type");
    String str3 = JsonUtil.getString(localJSONObject2, "msgId", null);
    localBundle.putString("to", str2);
    localBundle.putString("data", str1);
    localBundle.putString("msgId", str3);
    localBundle.putString("message_type", paramBundle);
    JsonUtil.transferJsonObjectToBundle(localJSONObject1, localBundle, d);
    localBundle.putBundle("notification", a(localJSONObject1, localJSONObject2, localJSONObject3, localJSONObject4, localJSONObject5));
    return localBundle;
  }
  
  private Bundle a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3, JSONObject paramJSONObject4, JSONObject paramJSONObject5)
  {
    Bundle localBundle = new Bundle();
    JsonUtil.transferJsonObjectToBundle(paramJSONObject3, localBundle, e);
    JsonUtil.transferJsonObjectToBundle(paramJSONObject4, localBundle, f);
    JsonUtil.transferJsonObjectToBundle(paramJSONObject1, localBundle, g);
    JsonUtil.transferJsonObjectToBundle(paramJSONObject5, localBundle, h);
    localBundle.putInt("notifyId", JsonUtil.getInt(paramJSONObject2, "notifyId", 0));
    return localBundle;
  }
  
  private static JSONObject a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optJSONObject("msgContent");
    }
    return null;
  }
  
  private static JSONObject b(Bundle paramBundle)
  {
    try
    {
      paramBundle = new JSONObject(aa.a(paramBundle.getByteArray("message_body")));
      return paramBundle;
    }
    catch (JSONException paramBundle)
    {
      HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
    }
    return null;
  }
  
  private static JSONObject b(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optJSONObject("psContent");
    }
    return null;
  }
  
  private static JSONObject c(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optJSONObject("notifyDetail");
    }
    return null;
  }
  
  private static JSONObject d(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optJSONObject("param");
    }
    return null;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public String getCollapseKey()
  {
    return this.i.getString("collapseKey");
  }
  
  public String getData()
  {
    return this.i.getString("data");
  }
  
  public Map<String, String> getDataOfMap()
  {
    localHashMap = new HashMap();
    Object localObject = this.i.getString("data");
    if ((localObject != null) && (!((String)localObject).trim().isEmpty())) {
      try
      {
        localObject = new JSONObject((String)localObject);
        Iterator localIterator = ((JSONObject)localObject).keys();
        while (localIterator.hasNext())
        {
          String str = String.valueOf(localIterator.next());
          localHashMap.put(str, String.valueOf(((JSONObject)localObject).get(str)));
        }
        return localHashMap;
      }
      catch (JSONException localJSONException)
      {
        HMSLog.w("RemoteMessage", "JSONException: get data from map failed");
      }
    }
  }
  
  public String getFrom()
  {
    return this.i.getString("from");
  }
  
  public String getMessageId()
  {
    return this.i.getString("msgId");
  }
  
  public String getMessageType()
  {
    return this.i.getString("message_type");
  }
  
  public RemoteMessage.Notification getNotification()
  {
    Bundle localBundle = this.i.getBundle("notification");
    if ((this.j == null) && (localBundle != null)) {
      this.j = new RemoteMessage.Notification(localBundle, null);
    }
    if (this.j == null) {
      this.j = new RemoteMessage.Notification(new Bundle(), null);
    }
    return this.j;
  }
  
  public int getOriginalUrgency()
  {
    int m = this.i.getInt("oriUrgency");
    int k = m;
    if (m != 1)
    {
      k = m;
      if (m != 2) {
        k = 0;
      }
    }
    return k;
  }
  
  public int getReceiptMode()
  {
    return this.i.getInt("receiptMode");
  }
  
  public int getSendMode()
  {
    return this.i.getInt("sendMode");
  }
  
  public long getSentTime()
  {
    long l = 0L;
    try
    {
      String str = this.i.getString("sendTime");
      if (!TextUtils.isEmpty(str)) {
        l = Long.parseLong(str);
      }
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
    }
    return 0L;
  }
  
  public String getTo()
  {
    return this.i.getString("to");
  }
  
  public String getToken()
  {
    return this.i.getString("device_token");
  }
  
  public int getTtl()
  {
    return this.i.getInt("ttl");
  }
  
  public int getUrgency()
  {
    int m = this.i.getInt("urgency");
    int k = m;
    if (m != 1)
    {
      k = m;
      if (m != 2) {
        k = 0;
      }
    }
    return k;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.i);
    paramParcel.writeSerializable(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.RemoteMessage
 * JD-Core Version:    0.7.0.1
 */
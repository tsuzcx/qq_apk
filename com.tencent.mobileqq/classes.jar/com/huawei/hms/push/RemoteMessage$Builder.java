package com.huawei.hms.push;

import android.os.Bundle;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteMessage$Builder
{
  public final Bundle a = new Bundle();
  public final Map<String, String> b = new HashMap();
  
  public RemoteMessage$Builder(String paramString)
  {
    this.a.putString("to", paramString);
  }
  
  public Builder addData(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      this.b.put(paramString1, paramString2);
      return this;
    }
    throw new IllegalArgumentException("add data failed, key is null.");
  }
  
  public RemoteMessage build()
  {
    Object localObject1 = new Bundle();
    Object localObject2 = new JSONObject();
    try
    {
      localObject3 = this.b.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        ((JSONObject)localObject2).put((String)((Map.Entry)localObject4).getKey(), ((Map.Entry)localObject4).getValue());
      }
    }
    catch (JSONException localJSONException1)
    {
      Object localObject3;
      Object localObject4;
      JSONObject localJSONObject;
      int i;
      label275:
      break label292;
    }
    try
    {
      localObject3 = ((JSONObject)localObject2).toString();
      localObject4 = new JSONObject();
      ((JSONObject)localObject4).put("collapseKey", this.a.getString("collapseKey"));
      ((JSONObject)localObject4).put("ttl", this.a.getInt("ttl"));
      ((JSONObject)localObject4).put("sendMode", this.a.getInt("sendMode"));
      ((JSONObject)localObject4).put("receiptMode", this.a.getInt("receiptMode"));
      localJSONObject = new JSONObject();
      i = ((JSONObject)localObject2).length();
      if (i != 0) {
        localJSONObject.put("data", localObject3);
      }
      localJSONObject.put("msgId", this.a.getString("msgId"));
      ((JSONObject)localObject4).put("msgContent", localJSONObject);
      localObject2 = ((JSONObject)localObject4).toString().getBytes(w.a);
      ((Bundle)localObject1).putByteArray("message_body", (byte[])localObject2);
      ((Bundle)localObject1).putString("to", this.a.getString("to"));
      ((Bundle)localObject1).putString("message_type", this.a.getString("message_type"));
      return new RemoteMessage((Bundle)localObject1);
    }
    catch (JSONException localJSONException2)
    {
      break label275;
    }
    HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
    throw new PushException("send message failed");
    label292:
    HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
    localObject1 = new PushException("send message failed");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public Builder clearData()
  {
    this.b.clear();
    return this;
  }
  
  public Builder setCollapseKey(String paramString)
  {
    this.a.putString("collapseKey", paramString);
    return this;
  }
  
  public Builder setData(Map<String, String> paramMap)
  {
    this.b.clear();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.b.put(localEntry.getKey(), localEntry.getValue());
    }
    return this;
  }
  
  public Builder setMessageId(String paramString)
  {
    this.a.putString("msgId", paramString);
    return this;
  }
  
  public Builder setMessageType(String paramString)
  {
    this.a.putString("message_type", paramString);
    return this;
  }
  
  public Builder setReceiptMode(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 0)) {
      throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
    }
    this.a.putInt("receiptMode", paramInt);
    return this;
  }
  
  public Builder setSendMode(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("send mode can only be 0 or 1.");
    }
    this.a.putInt("sendMode", paramInt);
    return this;
  }
  
  public Builder setTtl(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 1296000))
    {
      this.a.putInt("ttl", paramInt);
      return this;
    }
    throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.RemoteMessage.Builder
 * JD-Core Version:    0.7.0.1
 */
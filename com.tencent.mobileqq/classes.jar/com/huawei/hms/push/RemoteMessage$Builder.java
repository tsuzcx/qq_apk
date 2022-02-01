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
  private final Bundle a = new Bundle();
  private final Map<String, String> b = new HashMap();
  
  public RemoteMessage$Builder(String paramString)
  {
    this.a.putString("to", paramString);
  }
  
  public Builder addData(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("add data failed, key is null.");
    }
    this.b.put(paramString1, paramString2);
    return this;
  }
  
  public RemoteMessage build()
  {
    Bundle localBundle = new Bundle();
    localJSONObject1 = new JSONObject();
    try
    {
      Object localObject1 = this.b.entrySet().iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localJSONObject1.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
      try
      {
        localObject1 = this.a.getString("msgId");
        localObject2 = localJSONObject1.toString();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("collapseKey", this.a.getString("collapseKey"));
        localJSONObject2.put("ttl", this.a.getInt("ttl"));
        localJSONObject2.put("sendMode", this.a.getInt("sendMode"));
        localJSONObject2.put("receiptMode", this.a.getInt("receiptMode"));
        JSONObject localJSONObject3 = new JSONObject();
        if (localJSONObject1.length() != 0) {
          localJSONObject3.put("data", localObject2);
        }
        localJSONObject3.put("msgId", localObject1);
        localJSONObject2.put("msgContent", localJSONObject3);
        localJSONException1.putByteArray("message_body", localJSONObject2.toString().getBytes(ab.a));
        localJSONException1.putString("to", this.a.getString("to"));
        localJSONException1.putString("message_type", this.a.getString("message_type"));
        return new RemoteMessage(localJSONException1);
      }
      catch (JSONException localJSONException2)
      {
        HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
        throw new PushException("send message failed");
      }
    }
    catch (JSONException localJSONException1)
    {
      HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
      throw new PushException("send message failed");
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
    if ((paramInt < 1) || (paramInt > 1296000)) {
      throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
    }
    this.a.putInt("ttl", paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.RemoteMessage.Builder
 * JD-Core Version:    0.7.0.1
 */
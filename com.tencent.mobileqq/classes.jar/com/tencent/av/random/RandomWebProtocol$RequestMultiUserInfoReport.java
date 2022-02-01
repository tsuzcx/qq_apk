package com.tencent.av.random;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class RandomWebProtocol$RequestMultiUserInfoReport
  extends RandomWebProtocol.RequestMultiReport
{
  List<Long> a;
  int c;
  
  JSONObject a(JSONObject paramJSONObject)
  {
    if (this.a != null)
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        localJSONArray.put(ChatActivityUtils.b(RandomWebProtocol.a(), String.valueOf(localLong)));
      }
      paramJSONObject.put("peer_enuins", localJSONArray);
    }
    paramJSONObject.put("ret", this.c);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.RequestMultiUserInfoReport
 * JD-Core Version:    0.7.0.1
 */
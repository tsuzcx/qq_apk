package com.tencent.map.sdk.a;

import android.os.Handler;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cl
  extends cj
{
  ck a = new ck("HttpSchedulerHandler");
  
  public final void a()
  {
    ac.h().post(new cm(this, null, null));
  }
  
  public final void a(cf paramcf)
  {
    try
    {
      localJSONObject1 = new JSONObject();
      localObject1 = this.a;
      ao.e();
      localObject1 = ((ck)localObject1).a(ao.b());
      if (dg.a((byte[])localObject1)) {
        break label332;
      }
      localObject1 = new JSONObject(new String((byte[])localObject1));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject1;
        Object localObject1;
        Object localObject3;
        continue;
        label332:
        Object localObject2 = null;
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((JSONObject)localObject1).optJSONObject("resultMap");
      if (localObject1 != null)
      {
        localObject3 = ((JSONObject)localObject1).keys();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray(str);
          if (localJSONArray != null)
          {
            JSONObject localJSONObject2 = new JSONObject();
            int i = 0;
            while (i < localJSONArray.length())
            {
              JSONObject localJSONObject3 = localJSONArray.getJSONObject(i);
              localJSONObject2.put(localJSONObject3.optString("unit"), localJSONObject3.optString("schedulecode"));
              i += 1;
            }
            localJSONObject1.put(str, localJSONObject2);
          }
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ac.c());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    for (localObject3 = new JSONObject();; localObject3 = new JSONObject())
    {
      localJSONObject1.put((String)localObject1, localObject3);
      break;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ac.c());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    paramcf.a.put("directScheduleCodes", localJSONObject1);
    return;
    try
    {
      localObject1 = new JSONObject();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(ac.c());
      ((JSONObject)localObject1).put(((StringBuilder)localObject3).toString(), new JSONObject());
      paramcf.a.put("directScheduleCodes", localObject1);
      return;
    }
    catch (Exception paramcf)
    {
      paramcf.printStackTrace();
      return;
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("AccessScheduleRsp");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.toString();
        if (!dg.a(paramJSONObject))
        {
          paramJSONObject = paramJSONObject.getBytes();
          if (!dg.a(paramJSONObject))
          {
            String str = ao.b();
            this.a.a(str, paramJSONObject);
            ac.h().post(new cm(this, str, paramJSONObject));
          }
        }
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public final String c()
  {
    return "accessscheduler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.cl
 * JD-Core Version:    0.7.0.1
 */
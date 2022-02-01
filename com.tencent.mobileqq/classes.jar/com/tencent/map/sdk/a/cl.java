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
      localJSONObject2 = new JSONObject();
      Object localObject = this.a;
      ao.e();
      localObject = ((ck)localObject).a(ao.b());
      if (!dg.a((byte[])localObject))
      {
        localObject = new JSONObject(new String((byte[])localObject));
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optJSONObject("resultMap");
          if (localObject != null)
          {
            Iterator localIterator = ((JSONObject)localObject).keys();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray(str);
              if (localJSONArray != null)
              {
                JSONObject localJSONObject3 = new JSONObject();
                int i = 0;
                while (i < localJSONArray.length())
                {
                  JSONObject localJSONObject4 = localJSONArray.getJSONObject(i);
                  localJSONObject3.put(localJSONObject4.optString("unit"), localJSONObject4.optString("schedulecode"));
                  i += 1;
                }
                localJSONObject2.put(str, localJSONObject3);
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          localJSONObject1 = new JSONObject();
          localJSONObject1.put(ac.c(), new JSONObject());
          paramcf.a.put("directScheduleCodes", localJSONObject1);
          return;
        }
        catch (Exception paramcf)
        {
          JSONObject localJSONObject2;
          paramcf.printStackTrace();
          return;
        }
        localJSONObject2.put(ac.c(), new JSONObject());
        paramcf.a.put("directScheduleCodes", localJSONObject2);
        return;
        localJSONObject2.put(ac.c(), new JSONObject());
        continue;
        JSONObject localJSONObject1 = null;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.cl
 * JD-Core Version:    0.7.0.1
 */
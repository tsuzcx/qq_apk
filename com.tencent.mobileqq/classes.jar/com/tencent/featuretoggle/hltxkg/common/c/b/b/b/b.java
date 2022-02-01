package com.tencent.featuretoggle.hltxkg.common.c.b.b.b;

import android.os.Handler;
import com.tencent.featuretoggle.hltxkg.common.a.e;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends com.tencent.featuretoggle.hltxkg.common.c.b.b.b
{
  private a a = new a("HttpSchedulerHandler");
  
  public final void a()
  {
    com.tencent.featuretoggle.hltxkg.common.a.i().post(new c(this, null, null));
  }
  
  public final void a(com.tencent.featuretoggle.hltxkg.common.c.b.b.a parama)
  {
    try
    {
      localJSONObject1 = new JSONObject();
      localObject1 = this.a;
      e.d();
      localObject1 = ((a)localObject1).a(e.b());
      if (com.tencent.featuretoggle.hltxkg.common.e.c.a((byte[])localObject1)) {
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
      ((StringBuilder)localObject1).append(com.tencent.featuretoggle.hltxkg.common.a.c());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    for (localObject3 = new JSONObject();; localObject3 = new JSONObject())
    {
      localJSONObject1.put((String)localObject1, localObject3);
      break;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(com.tencent.featuretoggle.hltxkg.common.a.c());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    parama.a.put("directScheduleCodes", localJSONObject1);
    return;
    try
    {
      localObject1 = new JSONObject();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(com.tencent.featuretoggle.hltxkg.common.a.c());
      ((JSONObject)localObject1).put(((StringBuilder)localObject3).toString(), new JSONObject());
      parama.a.put("directScheduleCodes", localObject1);
      return;
    }
    catch (Exception parama)
    {
      parama.printStackTrace();
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
        if (!com.tencent.featuretoggle.hltxkg.common.e.c.a(paramJSONObject))
        {
          paramJSONObject = paramJSONObject.getBytes();
          if (!com.tencent.featuretoggle.hltxkg.common.e.c.a(paramJSONObject))
          {
            String str = e.b();
            this.a.a(str, paramJSONObject);
            com.tencent.featuretoggle.hltxkg.common.a.i().post(new c(this, str, paramJSONObject));
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
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.b.b.b.b
 * JD-Core Version:    0.7.0.1
 */
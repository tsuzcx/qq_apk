package c.t.m.g;

import android.os.Handler;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bt
  extends br
{
  bs a = new bs("HttpSchedulerHandler");
  
  public final void a()
  {
    m.j().post(new bu(this, null, null));
  }
  
  public final void a(bn parambn)
  {
    try
    {
      localJSONObject2 = new JSONObject();
      Object localObject = this.a;
      x.e();
      localObject = ((bs)localObject).a(x.b());
      if (!cn.a((byte[])localObject))
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
          localJSONObject1.put(m.c(), new JSONObject());
          parambn.a.put("directScheduleCodes", localJSONObject1);
          return;
        }
        catch (Exception parambn)
        {
          JSONObject localJSONObject2;
          parambn.printStackTrace();
          return;
        }
        localJSONObject2.put(m.c(), new JSONObject());
        parambn.a.put("directScheduleCodes", localJSONObject2);
        return;
        localJSONObject2.put(m.c(), new JSONObject());
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
        if (!cn.a(paramJSONObject))
        {
          paramJSONObject = paramJSONObject.getBytes();
          if (!cn.a(paramJSONObject))
          {
            String str = x.b();
            this.a.a(str, paramJSONObject);
            m.j().post(new bu(this, str, paramJSONObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.bt
 * JD-Core Version:    0.7.0.1
 */
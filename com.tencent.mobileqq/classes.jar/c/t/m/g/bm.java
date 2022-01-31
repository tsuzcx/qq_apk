package c.t.m.g;

import android.os.Handler;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bm
  extends bk
{
  bl a = new bl("HttpSchedulerHandler");
  
  public final void a()
  {
    l.j().post(new bn(this, null, null));
  }
  
  public final void a(bg parambg)
  {
    try
    {
      localJSONObject2 = new JSONObject();
      Object localObject = this.a;
      o.e();
      localObject = ((bl)localObject).a(o.b());
      if (!ch.a((byte[])localObject))
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
          localJSONObject1.put(l.c(), new JSONObject());
          parambg.a.put("directScheduleCodes", localJSONObject1);
          return;
        }
        catch (Exception parambg)
        {
          JSONObject localJSONObject2;
          parambg.printStackTrace();
          return;
        }
        localJSONObject2.put(l.c(), new JSONObject());
        parambg.a.put("directScheduleCodes", localJSONObject2);
        return;
        localJSONObject2.put(l.c(), new JSONObject());
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
        if (!ch.a(paramJSONObject))
        {
          paramJSONObject = paramJSONObject.getBytes();
          if (!ch.a(paramJSONObject))
          {
            String str = o.b();
            this.a.a(str, paramJSONObject);
            l.j().post(new bn(this, str, paramJSONObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.bm
 * JD-Core Version:    0.7.0.1
 */
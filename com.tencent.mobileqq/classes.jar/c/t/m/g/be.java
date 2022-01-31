package c.t.m.g;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class be
  extends bd
  implements w
{
  bs a = new bs("HttpSchedulerClient");
  u b;
  
  static void a(u paramu, JSONArray paramJSONArray)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramJSONArray.length())
        {
          localObject = paramJSONArray.getJSONObject(i);
          JSONArray localJSONArray1 = ((JSONObject)localObject).optJSONArray("domains");
          localJSONArray2 = ((JSONObject)localObject).optJSONArray("resultlist");
          String str1 = ((JSONObject)localObject).optString("schedulecode");
          localObject = ((JSONObject)localObject).optString("httpsport");
          if ((localJSONArray1 != null) && (localJSONArray2 != null))
          {
            j = 0;
            if (j < localJSONArray1.length()) {
              localv = new v(localJSONArray1.getString(j), str1);
            }
          }
        }
      }
      catch (Exception paramu)
      {
        Object localObject;
        JSONArray localJSONArray2;
        int j;
        v localv;
        String str2;
        n localn;
        paramu.printStackTrace();
      }
      try
      {
        localv.d = Integer.parseInt((String)localObject);
        k = 0;
      }
      catch (Throwable localThrowable)
      {
        continue;
        k += 1;
        continue;
      }
      if (k < localJSONArray2.length())
      {
        str2 = localJSONArray2.getString(k);
        localn = new n();
        if (!localn.a(str2)) {
          break label200;
        }
        localv.c.add(localn);
        break label200;
      }
      paramu.b.put(localv.a, localv);
      j += 1;
      continue;
      i += 1;
    }
  }
  
  public final List<v> a()
  {
    if ((this.b != null) && (this.b.a.equals(x.b())))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.b.b.entrySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Map.Entry)localIterator.next()).getValue());
      }
      return localArrayList;
    }
    m.j().post(new bf(this));
    return null;
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.a.a(paramString1, paramArrayOfByte);
    m.j().post(new bf(this));
  }
  
  public final String b()
  {
    return "accessscheduler";
  }
  
  public final void c()
  {
    cg.d().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.be
 * JD-Core Version:    0.7.0.1
 */
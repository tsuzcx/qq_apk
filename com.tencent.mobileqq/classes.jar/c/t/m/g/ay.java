package c.t.m.g;

import android.os.Handler;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ay
  extends ax
  implements r
{
  bl a = new bl("HttpSchedulerClient");
  p b;
  
  static void a(p paramp, JSONArray paramJSONArray)
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
              localq = new q(localJSONArray1.getString(j), str1);
            }
          }
        }
      }
      catch (Exception paramp)
      {
        Object localObject;
        JSONArray localJSONArray2;
        int j;
        q localq;
        String str2;
        m localm;
        paramp.printStackTrace();
      }
      try
      {
        localq.d = Integer.parseInt((String)localObject);
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
        localm = new m();
        if (!localm.a(str2)) {
          break label200;
        }
        localq.c.add(localm);
        break label200;
      }
      paramp.b.put(localq.a, localq);
      j += 1;
      continue;
      i += 1;
    }
  }
  
  public final q a(String paramString)
  {
    if (this.b != null)
    {
      if (this.b.a.equals(o.b())) {
        return (q)this.b.b.get(paramString);
      }
      l.j().post(new az(this));
    }
    return null;
  }
  
  public final String a()
  {
    return "accessscheduler";
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.a.a(paramString1, paramArrayOfByte);
    l.j().post(new az(this));
  }
  
  public final void a_()
  {
    by.c().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ay
 * JD-Core Version:    0.7.0.1
 */
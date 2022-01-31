package c.t.m.g;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

final class bf
  implements Runnable
{
  bf(be parambe) {}
  
  public final void run()
  {
    Object localObject1 = x.b();
    be localbe = this.a;
    Object localObject2 = this.a.a.a((String)localObject1);
    try
    {
      Iterator localIterator;
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!cn.a((byte[])localObject2)))
      {
        localObject2 = new JSONObject(new String((byte[])localObject2));
        localObject1 = new u((String)localObject1);
        ((JSONObject)localObject2).getString("ipInfo");
        localObject2 = ((JSONObject)localObject2).optJSONObject("resultMap");
        if (localObject2 != null) {
          localIterator = ((JSONObject)localObject2).keys();
        }
      }
      else
      {
        while (localIterator.hasNext())
        {
          JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray((String)localIterator.next());
          if (localJSONArray != null)
          {
            be.a((u)localObject1, localJSONArray);
            continue;
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    localThrowable.b = ((u)localObject1);
    p.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.bf
 * JD-Core Version:    0.7.0.1
 */
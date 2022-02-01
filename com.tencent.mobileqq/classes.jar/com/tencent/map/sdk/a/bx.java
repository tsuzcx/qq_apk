package com.tencent.map.sdk.a;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

final class bx
  implements Runnable
{
  bx(bw parambw) {}
  
  public final void run()
  {
    Object localObject1 = ao.b();
    bw localbw = this.a;
    Object localObject2 = localbw.a.a((String)localObject1);
    try
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!dg.a((byte[])localObject2)))
      {
        localObject2 = new JSONObject(new String((byte[])localObject2));
        localObject1 = new ak((String)localObject1);
        ((JSONObject)localObject2).getString("ipInfo");
        localObject2 = ((JSONObject)localObject2).optJSONObject("resultMap");
        if (localObject2 != null)
        {
          Iterator localIterator = ((JSONObject)localObject2).keys();
          while (localIterator.hasNext())
          {
            JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray((String)localIterator.next());
            if (localJSONArray != null) {
              bw.a((ak)localObject1, localJSONArray);
            }
          }
        }
        localbw.b = ((ak)localObject1);
        af.c();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.bx
 * JD-Core Version:    0.7.0.1
 */
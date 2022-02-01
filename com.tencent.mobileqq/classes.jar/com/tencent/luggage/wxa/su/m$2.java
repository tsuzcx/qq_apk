package com.tencent.luggage.wxa.su;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.xweb.util.h;
import org.xwalk.core.Log;

class m$2
  implements ValueCallback<Pair<Integer, String>>
{
  m$2(m paramm) {}
  
  public void a(Pair<Integer, String> paramPair)
  {
    int i = ((Integer)paramPair.first).intValue();
    if (i != 0) {
      if (i != 1) {
        return;
      }
    }
    try
    {
      localObject2 = ((String)paramPair.second).split(":");
      if (localObject2.length != 2) {
        break label254;
      }
      i = Integer.parseInt(localObject2[0]);
      localObject1 = localObject2[1];
      if ((i == 17565) || (i == 17564))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.a.e());
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(localObject2[1]);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      h.a(i, (String)localObject1);
      return;
    }
    catch (Exception localException1)
    {
      Object localObject2;
      Object localObject1;
      label116:
      break label116;
    }
    localObject1 = this.a.a();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("setKVLog parse error: ");
    ((StringBuilder)localObject2).append((String)paramPair.second);
    Log.e((String)localObject1, ((StringBuilder)localObject2).toString());
    return;
    try
    {
      localObject1 = ((String)paramPair.second).split(":");
      if (localObject1.length != 3) {
        break label254;
      }
      h.a(Long.parseLong(localObject1[0]), Integer.parseInt(localObject1[1]), Integer.parseInt(localObject1[2]));
      return;
    }
    catch (Exception localException2)
    {
      label207:
      break label207;
    }
    localObject1 = this.a.a();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("idkeyReport parse error: ");
    ((StringBuilder)localObject2).append((String)paramPair.second);
    Log.e((String)localObject1, ((StringBuilder)localObject2).toString());
    label254:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.su.m.2
 * JD-Core Version:    0.7.0.1
 */
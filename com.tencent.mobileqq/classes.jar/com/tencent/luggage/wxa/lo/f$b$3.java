package com.tencent.luggage.wxa.lo;

import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.d.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

class f$b$3
  implements d.a<int[]>
{
  f$b$3(f.b paramb) {}
  
  public void a(boolean paramBoolean, int[] paramArrayOfInt)
  {
    f.b.b(this.a).b();
    if (!paramBoolean)
    {
      this.a.a("fail cancel");
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      JSONArray localJSONArray = new JSONArray();
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(paramArrayOfInt[i]);
        i += 1;
      }
      paramArrayOfInt = new HashMap(1);
      paramArrayOfInt.put("current", localJSONArray);
      this.a.a("ok", paramArrayOfInt);
      return;
    }
    this.a.a("fail error result");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.f.b.3
 * JD-Core Version:    0.7.0.1
 */
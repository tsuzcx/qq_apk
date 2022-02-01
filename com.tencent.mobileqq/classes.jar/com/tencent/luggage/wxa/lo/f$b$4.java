package com.tencent.luggage.wxa.lo;

import com.tencent.mm.plugin.appbrand.widget.picker.d.b;
import java.util.HashMap;
import java.util.Map;

class f$b$4
  implements d.b<int[]>
{
  f$b$4(f.b paramb) {}
  
  public void a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[0];
    int j = paramArrayOfInt[1];
    paramArrayOfInt = new f.a(null);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("errMsg", "ok");
    localHashMap.put("column", Integer.valueOf(i));
    localHashMap.put("current", Integer.valueOf(j));
    paramArrayOfInt.b(localHashMap);
    this.a.a(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.f.b.4
 * JD-Core Version:    0.7.0.1
 */
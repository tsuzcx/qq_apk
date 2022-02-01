package com.tencent.luggage.wxa.ex;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.map.geolocation.sapp.internal.LocationLogCallback;

class a$1
  implements LocationLogCallback
{
  a$1(a parama) {}
  
  public void onLog(int paramInt, String paramString1, String paramString2, @Nullable Throwable paramThrowable)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
              return;
            }
            if (paramThrowable != null) {
              paramThrowable = paramThrowable.getMessage();
            } else {
              paramThrowable = "";
            }
            o.b("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s th:%s", new Object[] { paramString1, paramString2, paramThrowable });
            return;
          }
          o.c("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
          return;
        }
        o.d("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
        return;
      }
      o.e("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
      return;
    }
    o.f("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", new Object[] { paramString1, paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ex.a.1
 * JD-Core Version:    0.7.0.1
 */
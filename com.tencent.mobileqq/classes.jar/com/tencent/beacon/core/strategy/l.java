package com.tencent.beacon.core.strategy;

import android.content.Context;
import com.tencent.beacon.core.d.m;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.info.b;
import com.tencent.beacon.core.info.e;
import com.tencent.beacon.core.info.g;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.beacon.qimei.QimeiSDK;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class l
  extends com.tencent.beacon.core.d.a
{
  public l(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    super(paramContext, paramInt1, paramInt2, paramString);
  }
  
  public void a(boolean paramBoolean) {}
  
  public RequestPackage f()
  {
    Object localObject1 = g.b(this.c);
    Object localObject2 = "".getBytes(Charset.forName("UTF-8"));
    int i = c();
    label559:
    for (;;)
    {
      try
      {
        localObject2 = m.a(i, (b)localObject1, (byte[])localObject2, -1, -1, this.f);
        HashMap localHashMap;
        if ((localObject2 != null) && (c() == 100))
        {
          localHashMap = new HashMap();
          Object localObject3 = new StringBuilder();
          localHashMap.put("A1", "" + UserAction.getUserID(null));
          localObject3 = com.tencent.beacon.core.info.c.a(((b)localObject1).c());
          Object localObject4 = new StringBuilder();
          localHashMap.put("A2", "" + ((com.tencent.beacon.core.info.c)localObject3).c());
          localObject4 = new StringBuilder();
          localHashMap.put("A4", "" + ((com.tencent.beacon.core.info.c)localObject3).e());
          localObject4 = new StringBuilder();
          localHashMap.put("A6", "" + ((com.tencent.beacon.core.info.c)localObject3).f());
          localObject4 = new StringBuilder();
          localHashMap.put("A7", "" + ((com.tencent.beacon.core.info.c)localObject3).a());
          localObject4 = QimeiSDK.getInstance().getQimei(this.c);
          if ((localObject4 != null) && (((Qimei)localObject4).getQimeiMap() != null)) {
            localHashMap.putAll(((Qimei)localObject4).getQimeiMap());
          }
          localObject4 = new StringBuilder();
          localHashMap.put("A23", "" + ((g)localObject1).b(null));
          localObject4 = new StringBuilder();
          localHashMap.put("A31", "" + ((com.tencent.beacon.core.info.c)localObject3).b());
          localHashMap.put("A33", e.d(((b)localObject1).c()).k(((b)localObject1).c()));
          boolean bool = com.tencent.beacon.core.info.a.h(((b)localObject1).c());
          if (bool)
          {
            localHashMap.put("A66", "F");
            localObject3 = new StringBuilder();
            localHashMap.put("A67", "" + com.tencent.beacon.core.info.a.c(((b)localObject1).c()));
            localObject3 = new StringBuilder();
            localHashMap.put("A68", "" + com.tencent.beacon.core.info.a.b(((b)localObject1).c()));
            bool = com.tencent.beacon.core.info.a.f;
            if (!bool) {
              break label559;
            }
            localObject1 = "Y";
            localHashMap.put("A85", localObject1);
            ((RequestPackage)localObject2).reserved = com.tencent.beacon.core.e.c.a(localHashMap);
          }
        }
        else
        {
          return localObject2;
        }
        localHashMap.put("A66", "B");
        continue;
        String str = "N";
      }
      catch (Throwable localThrowable)
      {
        d.a(localThrowable);
        d.b("[event] encode empty package failed", new Object[0]);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.l
 * JD-Core Version:    0.7.0.1
 */
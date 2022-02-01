package com.tencent.map.sdk.a;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class af
{
  public static String a;
  private static at b = new at();
  private static String c = "halley-cloud-AccessIpMgr";
  private static Map<Integer, af.a> d = new ConcurrentHashMap();
  private static Map<String, af.a> e = new ConcurrentHashMap();
  
  public static al a(String paramString)
  {
    Object localObject1 = (af.a)e.get(paramString);
    if (localObject1 != null)
    {
      localObject2 = new al(((af.a)localObject1).b, ((af.a)localObject1).e);
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((af.a)localObject1).d);
      ((al)localObject2).c = localArrayList;
      if (!((al)localObject2).c.isEmpty()) {
        return localObject2;
      }
    }
    localObject1 = new ad(paramString);
    ((ad)localObject1).e = 3;
    paramString = new al(paramString, "");
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    paramString.c = ((List)localObject2);
    return paramString;
  }
  
  public static void a()
  {
    ac.h().post(new aj());
  }
  
  public static void a(String paramString, ad paramad, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 >= 500))
    {
      paramString = (af.a)e.get(paramString);
      if (paramString != null) {
        paramString.b(paramad);
      }
    }
  }
  
  public static void b()
  {
    cy.d().f();
  }
  
  public static void c()
  {
    Object localObject1 = cy.d().f().a();
    int i;
    label45:
    al localal;
    af.a locala;
    if (localObject1 != null) {
      if (as.a("app_schdule_use_ipv6", 0, 1, 1) == 1)
      {
        i = 1;
        e.clear();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label271;
        }
        localal = (al)((Iterator)localObject1).next();
        locala = new af.a(a);
        locala.b = localal.a;
        locala.e = localal.b;
        if (!locala.e.startsWith("bottom")) {
          break label272;
        }
      }
    }
    label271:
    label272:
    for (int j = 1;; j = 0)
    {
      Object localObject2 = localal.c.iterator();
      label120:
      while (((Iterator)localObject2).hasNext())
      {
        ad localad = (ad)((Iterator)localObject2).next();
        if ((i != 0) || (!localad.c())) {
          if (ao.h() == 1) {
            if (localad.c()) {
              break;
            }
          } else {
            for (;;)
            {
              if (j != 0) {
                localad.e = 5;
              }
              locala.a(localad);
              break label120;
              i = 0;
              break;
              if (ao.h() == 3) {
                if (!localad.c()) {
                  break label120;
                }
              }
            }
          }
        }
      }
      localObject2 = new ad(localal.a);
      ((ad)localObject2).e = 3;
      locala.a((ad)localObject2);
      Collections.sort(locala.d, new an());
      e.put(localal.a, locala);
      break label45;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.af
 * JD-Core Version:    0.7.0.1
 */
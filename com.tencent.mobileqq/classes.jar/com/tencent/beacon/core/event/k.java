package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.a.a.a;
import com.tencent.beacon.core.d.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class k
{
  public static int a(Context paramContext, String paramString)
  {
    com.tencent.beacon.core.d.b.b("[db] start", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.beacon.core.d.b.d("[db] context is null.", new Object[0]);
      return -1;
    }
    return com.tencent.beacon.core.a.a.b.b(paramContext, paramString, new int[] { 1, 2, 3, 4 });
  }
  
  public static int a(Context paramContext, String paramString, Long[] paramArrayOfLong)
  {
    com.tencent.beacon.core.d.b.b("[db] start", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.beacon.core.d.b.d("[db] have null args!", new Object[0]);
      return -1;
    }
    com.tencent.beacon.core.d.b.b("[db] end", new Object[0]);
    return com.tencent.beacon.core.a.a.b.a(paramContext, paramString, paramArrayOfLong);
  }
  
  public static List<RDBean> a(Context paramContext, String paramString, int paramInt)
  {
    com.tencent.beacon.core.d.b.b("[db] start", new Object[0]);
    if (paramContext == null) {
      com.tencent.beacon.core.d.b.d("[db] have null args!", new Object[0]);
    }
    List localList;
    do
    {
      return null;
      localList = com.tencent.beacon.core.a.a.b.a(paramContext, paramString, new int[] { 1, 2, 3, 4 }, paramInt);
    } while ((localList == null) || (localList.size() <= 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = localList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      a locala = (a)((Iterator)localObject1).next();
      try
      {
        Object localObject2 = i.a(locala.e);
        if ((localObject2 != null) && (RDBean.class.isInstance(localObject2)))
        {
          localObject2 = (RDBean)RDBean.class.cast(localObject2);
          ((RDBean)localObject2).setCid(locala.a);
          localArrayList.add(localObject2);
          ((Iterator)localObject1).remove();
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.core.d.b.a(localThrowable);
        com.tencent.beacon.core.d.b.d("[db] query have error!", new Object[0]);
      }
    }
    if (localList.size() > 0)
    {
      com.tencent.beacon.core.d.b.c("[db] there are error data ,should be remove " + localList.size(), new Object[0]);
      localObject1 = new Long[localList.size()];
      paramInt = 0;
      while (paramInt < localList.size())
      {
        localObject1[paramInt] = Long.valueOf(((a)localList.get(paramInt)).a);
        paramInt += 1;
      }
      com.tencent.beacon.core.a.a.b.a(paramContext, paramString, (Long[])localObject1);
    }
    com.tencent.beacon.core.d.b.b("[db] end", new Object[0]);
    return localArrayList;
  }
  
  public static Long[] a(Context paramContext, String paramString, List<RDBean> paramList)
  {
    com.tencent.beacon.core.d.b.b("[db] start", new Object[0]);
    if ((paramContext == null) || (paramList == null))
    {
      com.tencent.beacon.core.d.b.d("[db] have null args!", new Object[0]);
      return null;
    }
    int m = paramList.size();
    if (m == 0)
    {
      com.tencent.beacon.core.d.b.d("[db] insert list size(0) return.", new Object[0]);
      return null;
    }
    Long[] arrayOfLong = new Long[m];
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    if (k < m)
    {
      RDBean localRDBean = (RDBean)paramList.get(k);
      if (localRDBean == null) {
        com.tencent.beacon.core.d.b.c("[db] bean is null!", new Object[0]);
      }
      for (;;)
      {
        k += 1;
        break;
        int j;
        if (localRDBean.getTP().equals("UA"))
        {
          i = 1;
          j = 3;
        }
        for (;;)
        {
          try
          {
            localArrayList.add(new a(i, j, localRDBean.getTM(), i.a(localRDBean)));
          }
          catch (Throwable localThrowable)
          {
            com.tencent.beacon.core.d.b.a(localThrowable);
          }
          break;
          if (localThrowable.getTP().equals("IP"))
          {
            i = 2;
            j = 0;
          }
          else if (localThrowable.getTP().equals("DN"))
          {
            i = 3;
            j = 0;
          }
          else
          {
            if (!localThrowable.getTP().equals("HO")) {
              break label236;
            }
            i = 4;
            j = 0;
          }
        }
        label236:
        com.tencent.beacon.core.d.b.c("[db] bean's type is error!", new Object[0]);
      }
    }
    if (!com.tencent.beacon.core.a.a.b.a(paramContext, paramString, localArrayList)) {
      return null;
    }
    paramContext = localArrayList.iterator();
    int i = 0;
    while (paramContext.hasNext())
    {
      paramString = (a)paramContext.next();
      if (i < m) {
        arrayOfLong[i] = Long.valueOf(paramString.a);
      }
      i += 1;
    }
    return arrayOfLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.k
 * JD-Core Version:    0.7.0.1
 */
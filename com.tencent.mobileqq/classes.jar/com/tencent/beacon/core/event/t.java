package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.a.a.a;
import com.tencent.beacon.core.e.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class t
{
  public static int a(Context paramContext, String paramString)
  {
    d.a("[db] start", new Object[0]);
    if (paramContext == null)
    {
      d.b("[db] context is null.", new Object[0]);
      return -1;
    }
    return com.tencent.beacon.core.a.a.b.b(paramContext, paramString, new int[] { 1, 2, 3, 4 }, -1L, 9223372036854775807L);
  }
  
  public static int a(Context paramContext, String paramString, Long[] paramArrayOfLong)
  {
    d.a("[db] start", new Object[0]);
    if (paramContext == null)
    {
      d.b("[db] have null args!", new Object[0]);
      return -1;
    }
    d.a("[db] end", new Object[0]);
    return com.tencent.beacon.core.a.a.b.a(paramContext, paramString, paramArrayOfLong);
  }
  
  public static int a(Context paramContext, String paramString, String[] paramArrayOfString, long paramLong1, long paramLong2)
  {
    int j = 0;
    d.a("[db] start", new Object[0]);
    if (paramArrayOfString == null)
    {
      paramArrayOfString = new int[4];
      paramArrayOfString[0] = 1;
      paramArrayOfString[1] = 2;
      paramArrayOfString[2] = 3;
      paramArrayOfString[3] = 4;
      return com.tencent.beacon.core.a.a.b.a(paramContext, paramString, paramArrayOfString, paramLong1, paramLong2);
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i].equals("UA")) {
        localArrayList.add(Integer.valueOf(1));
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramArrayOfString[i].equals("DN")) {
          localArrayList.add(Integer.valueOf(3));
        } else if (paramArrayOfString[i].equals("IP")) {
          localArrayList.add(Integer.valueOf(2));
        } else if (paramArrayOfString[i].equals("HO")) {
          localArrayList.add(Integer.valueOf(4));
        }
      }
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    i = j;
    for (;;)
    {
      paramArrayOfString = arrayOfInt;
      if (i >= localArrayList.size()) {
        break;
      }
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
  }
  
  public static List<RDBean> a(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    d.a("[db] start", new Object[0]);
    if (paramContext == null)
    {
      d.b("[db] have null args!", new Object[0]);
      return null;
    }
    if (paramArrayOfString == null)
    {
      paramArrayOfString = new int[4];
      paramArrayOfString[0] = 1;
      paramArrayOfString[1] = 2;
      paramArrayOfString[2] = 3;
      paramArrayOfString[3] = 4;
      paramArrayOfString = com.tencent.beacon.core.a.a.b.a(paramContext, paramString, paramArrayOfString, 1, 2, paramInt);
      if ((paramArrayOfString == null) || (paramArrayOfString.size() <= 0)) {
        return null;
      }
    }
    else
    {
      localObject2 = new ArrayList();
      int i = 0;
      if (i < paramArrayOfString.length)
      {
        if (paramArrayOfString[i].equals("UA")) {
          ((ArrayList)localObject2).add(Integer.valueOf(1));
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramArrayOfString[i].equals("DN")) {
            ((ArrayList)localObject2).add(Integer.valueOf(3));
          } else if (paramArrayOfString[i].equals("IP")) {
            ((ArrayList)localObject2).add(Integer.valueOf(2));
          } else if (paramArrayOfString[i].equals("HO")) {
            ((ArrayList)localObject2).add(Integer.valueOf(4));
          }
        }
      }
      localObject1 = new int[((ArrayList)localObject2).size()];
      i = 0;
      for (;;)
      {
        paramArrayOfString = (String[])localObject1;
        if (i >= ((ArrayList)localObject2).size()) {
          break;
        }
        localObject1[i] = ((Integer)((ArrayList)localObject2).get(i)).intValue();
        i += 1;
      }
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = paramArrayOfString.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      a locala = (a)((Iterator)localObject2).next();
      try
      {
        Object localObject3 = com.tencent.beacon.core.e.b.a(locala.e);
        if ((localObject3 != null) && (RDBean.class.isInstance(localObject3)))
        {
          localObject3 = (RDBean)RDBean.class.cast(localObject3);
          ((RDBean)localObject3).setCid(locala.a);
          ((ArrayList)localObject1).add(localObject3);
          ((Iterator)localObject2).remove();
        }
      }
      catch (Throwable localThrowable)
      {
        d.a(localThrowable);
        d.b("[db] query have error!", new Object[0]);
      }
    }
    if (paramArrayOfString.size() > 0)
    {
      d.i("[db] there are error data ,should be remove " + paramArrayOfString.size(), new Object[0]);
      localObject2 = new Long[paramArrayOfString.size()];
      paramInt = 0;
      while (paramInt < paramArrayOfString.size())
      {
        localObject2[paramInt] = Long.valueOf(((a)paramArrayOfString.get(paramInt)).a);
        paramInt += 1;
      }
      com.tencent.beacon.core.a.a.b.a(paramContext, paramString, (Long[])localObject2);
    }
    d.a("[db] end", new Object[0]);
    return localObject1;
  }
  
  public static Long[] a(Context paramContext, String paramString, List<RDBean> paramList)
  {
    d.a("[db] start", new Object[0]);
    if ((paramContext == null) || (paramList == null))
    {
      d.b("[db] have null args!", new Object[0]);
      return null;
    }
    int m = paramList.size();
    if (m == 0)
    {
      d.b("[db] insert list size(0) return.", new Object[0]);
      return null;
    }
    Long[] arrayOfLong = new Long[m];
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    if (k < m)
    {
      RDBean localRDBean = (RDBean)paramList.get(k);
      if (localRDBean == null) {
        d.i("[db] bean is null!", new Object[0]);
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
            localArrayList.add(new a(i, j, localRDBean.getTM(), com.tencent.beacon.core.e.b.a(localRDBean)));
          }
          catch (Throwable localThrowable)
          {
            d.b("[db] bean: %s add to analyticsList error!", new Object[] { localRDBean.getEN() });
            d.a(localThrowable);
          }
          break;
          if (localRDBean.getTP().equals("IP"))
          {
            i = 2;
            j = 0;
          }
          else if (localRDBean.getTP().equals("DN"))
          {
            i = 3;
            j = 0;
          }
          else
          {
            if (!localRDBean.getTP().equals("HO")) {
              break label253;
            }
            i = 4;
            j = 0;
          }
        }
        label253:
        d.i("[db] bean's type is error!", new Object[0]);
      }
    }
    if (!com.tencent.beacon.core.a.a.b.a(paramContext, paramString, localArrayList))
    {
      d.a("[db] AnalyticsDAO.insert beans fail!", new Object[0]);
      return null;
    }
    d.a("[db] AnalyticsDAO.insert beans success!", new Object[0]);
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
 * Qualified Name:     com.tencent.beacon.core.event.t
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app.asyncdb.cache;

import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.data.RoamDate;
import com.tencent.mobileqq.data.RoamMessagePreloadInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class RoamDateCache
  extends FullCache
{
  public RoamDateCache(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramQQAppInterface, paramDBDelayManager, RoamDate.class);
  }
  
  private String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public RoamDate a(String paramString, int paramInt1, int paramInt2)
  {
    return (RoamDate)findCache(b(paramString, paramInt1, paramInt2));
  }
  
  public RoamDate a(String paramString1, String paramString2)
  {
    return (RoamDate)findCache(b(paramString1, paramString2));
  }
  
  public RoamMessagePreloadInfo a(String paramString, Calendar paramCalendar, int paramInt)
  {
    RoamMessagePreloadInfo localRoamMessagePreloadInfo = new RoamMessagePreloadInfo();
    localRoamMessagePreloadInfo.preloadType = paramInt;
    List localList = f();
    if (paramInt == 0)
    {
      if (!c(paramString, paramCalendar, localList)) {
        paramCalendar = null;
      }
      localRoamMessagePreloadInfo.curday = paramCalendar;
    }
    else if (paramInt == 1)
    {
      localRoamMessagePreloadInfo.curday = a(paramString, paramCalendar, localList);
    }
    else if (paramInt == 2)
    {
      localRoamMessagePreloadInfo.curday = b(paramString, paramCalendar, localList);
    }
    if ((localRoamMessagePreloadInfo.curday != null) && (paramInt != 0))
    {
      localRoamMessagePreloadInfo.previousday = a(paramString, localRoamMessagePreloadInfo.curday, localList);
      localRoamMessagePreloadInfo.nextday = b(paramString, localRoamMessagePreloadInfo.curday, localList);
    }
    return localRoamMessagePreloadInfo;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append('-');
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  public Calendar a(String paramString, Calendar paramCalendar, List<Map.Entry<String, Entity>> paramList)
  {
    if (paramList == null) {
      paramList = f();
    }
    if (!paramList.isEmpty())
    {
      int j = paramCalendar.get(1);
      int k = paramCalendar.get(2);
      int i1 = paramCalendar.get(5);
      int i = 0;
      while (i < paramList.size())
      {
        if (((String)((Map.Entry)paramList.get(i)).getKey()).equals(b(paramString, j, k + 1))) {
          break label107;
        }
        i += 1;
      }
      i = 0;
      label107:
      paramString = null;
      j = i;
      int m;
      for (k = 0;; k = m)
      {
        paramCalendar = paramString;
        if (j < 0) {
          break;
        }
        RoamDate localRoamDate = (RoamDate)((Map.Entry)paramList.get(j)).getValue();
        if (j == i)
        {
          n = i1 - 2;
          for (;;)
          {
            paramCalendar = paramString;
            m = k;
            if (n < 0) {
              break label365;
            }
            if (a(localRoamDate, n))
            {
              paramString = Calendar.getInstance();
              paramString.set(11, 0);
              paramString.set(12, 0);
              paramString.set(13, 0);
              paramString.set(14, 0);
              paramString.set(1, localRoamDate.getYear());
              paramString.set(2, localRoamDate.getMonth() - 1);
              paramString.set(5, n + 1);
              break;
            }
            n -= 1;
          }
        }
        int n = localRoamDate.getDays() - 1;
        for (;;)
        {
          paramCalendar = paramString;
          m = k;
          if (n < 0) {
            break;
          }
          if (a(localRoamDate, n))
          {
            paramString = Calendar.getInstance();
            paramString.set(11, 0);
            paramString.set(12, 0);
            paramString.set(13, 0);
            paramString.set(14, 0);
            paramString.set(1, localRoamDate.getYear());
            paramString.set(2, localRoamDate.getMonth() - 1);
            paramString.set(5, n + 1);
            m = 1;
            paramCalendar = paramString;
            break;
          }
          n -= 1;
        }
        label365:
        if (m != 0) {
          return paramCalendar;
        }
        j -= 1;
        paramString = paramCalendar;
      }
    }
    paramCalendar = null;
    return paramCalendar;
  }
  
  public void a()
  {
    this.cacheMap.clear();
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RoamDate localRoamDate = a(String.valueOf(paramLong), paramInt1, paramInt2);
    if (localRoamDate == null) {
      localRoamDate = new RoamDate(String.valueOf(paramLong), a(paramInt1, paramInt2), paramInt3, paramInt4);
    } else {
      localRoamDate.setSerindex(paramInt3, paramInt4);
    }
    a(localRoamDate);
  }
  
  public void a(RoamDate paramRoamDate)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveRoamDate roamDate = ");
      localStringBuilder.append(paramRoamDate);
      QLog.d("Q.db.Cache.RoamDateCache", 2, localStringBuilder.toString());
    }
    addCache(paramRoamDate);
    this.proxyManager.transSaveToDatabase();
  }
  
  public void a(String paramString)
  {
    Object localObject = this.a.getEntityManagerFactory().createEntityManager();
    int i = 0;
    paramString = ((EntityManager)localObject).query(RoamDate.class, false, "uin=?", new String[] { paramString }, null, null, null, null);
    ((EntityManager)localObject).close();
    if (paramString != null)
    {
      a();
      localObject = paramString.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RoamDate localRoamDate = (RoamDate)((Iterator)localObject).next();
        this.cacheMap.put(getKey(localRoamDate), localRoamDate);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doInit size = ");
      if (paramString != null) {
        i = paramString.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("Q.db.Cache.RoamDateCache", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.cacheMap != null) && (!this.cacheMap.isEmpty()))
    {
      paramString = new ArrayList();
      Iterator localIterator = this.cacheMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)((Map.Entry)localIterator.next()).getKey();
        Object localObject = str.split("&")[1];
        paramInt3 = Integer.parseInt(localObject.split("-")[0]);
        paramInt4 = Integer.parseInt(localObject.split("-")[1]);
        if ((paramInt3 < paramInt1) || ((paramInt3 == paramInt1) && (paramInt4 < paramInt2)))
        {
          paramString.add(str);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("clipRoamDate key=");
            ((StringBuilder)localObject).append(str);
            QLog.d("Q.db.Cache.RoamDateCache", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      if (!paramString.isEmpty())
      {
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          b((String)paramString.next());
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis((paramLong + 5L) * 1000L);
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2) + 1;
    int k = ((Calendar)localObject).get(5);
    RoamDate localRoamDate = a(paramString, i, j);
    localObject = localRoamDate;
    if (localRoamDate == null) {
      localObject = new RoamDate(paramString, a(i, j));
    }
    ((RoamDate)localObject).setSerState(k - 1, paramInt);
    a((RoamDate)localObject);
  }
  
  public boolean a(RoamDate paramRoamDate, int paramInt)
  {
    return (paramRoamDate.getSerState(paramInt) == 2) || (paramRoamDate.getLocState(paramInt) == 3);
  }
  
  public String b(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&");
    localStringBuilder.append(a(paramInt1, paramInt2));
    return localStringBuilder.toString();
  }
  
  public Calendar b(String paramString, Calendar paramCalendar, List<Map.Entry<String, Entity>> paramList)
  {
    if (paramList == null) {
      paramList = f();
    }
    if (!paramList.isEmpty())
    {
      int j = paramCalendar.get(1);
      int k = paramCalendar.get(2);
      int i1 = paramCalendar.get(5);
      int i = 0;
      while (i < paramList.size())
      {
        if (((String)((Map.Entry)paramList.get(i)).getKey()).equals(b(paramString, j, k + 1))) {
          break label107;
        }
        i += 1;
      }
      i = 0;
      label107:
      paramString = null;
      int m = i;
      j = 0;
      for (;;)
      {
        paramCalendar = paramString;
        if (m >= paramList.size()) {
          break;
        }
        RoamDate localRoamDate = (RoamDate)((Map.Entry)paramList.get(m)).getValue();
        if (m == i)
        {
          n = i1;
          for (;;)
          {
            paramCalendar = paramString;
            k = j;
            if (n >= localRoamDate.getDays()) {
              break;
            }
            if (a(localRoamDate, n))
            {
              paramCalendar = Calendar.getInstance();
              paramCalendar.set(11, 0);
              paramCalendar.set(12, 0);
              paramCalendar.set(13, 0);
              paramCalendar.set(14, 0);
              paramCalendar.set(1, localRoamDate.getYear());
              paramCalendar.set(2, localRoamDate.getMonth() - 1);
              paramCalendar.set(5, n + 1);
              k = 1;
              break;
            }
            n += 1;
          }
        }
        int n = 0;
        for (;;)
        {
          paramCalendar = paramString;
          k = j;
          if (n >= localRoamDate.getDays()) {
            break;
          }
          if (a(localRoamDate, n))
          {
            paramString = Calendar.getInstance();
            paramString.set(11, 0);
            paramString.set(12, 0);
            paramString.set(13, 0);
            paramString.set(14, 0);
            paramString.set(1, localRoamDate.getYear());
            paramString.set(2, localRoamDate.getMonth() - 1);
            paramString.set(5, n + 1);
            j = 1;
            break label380;
          }
          n += 1;
        }
        j = k;
        paramString = paramCalendar;
        label380:
        if (j != 0) {
          return paramString;
        }
        m += 1;
      }
    }
    paramCalendar = null;
    return paramCalendar;
  }
  
  public void b()
  {
    Iterator localIterator = this.cacheMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      b((RoamDate)((Map.Entry)localIterator.next()).getValue());
    }
  }
  
  public void b(RoamDate paramRoamDate)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeRoamDate roamDate = ");
      localStringBuilder.append(paramRoamDate);
      QLog.d("Q.db.Cache.RoamDateCache", 2, localStringBuilder.toString());
    }
    removeCache(paramRoamDate);
    this.proxyManager.transSaveToDatabase();
  }
  
  public void b(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null)
    {
      if (paramString.length != 2) {
        return;
      }
      paramString = a(paramString[0], paramString[1]);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeRoamDate roamDate = ");
        localStringBuilder.append(paramString);
        QLog.d("Q.db.Cache.RoamDateCache", 2, localStringBuilder.toString());
      }
      removeCache(paramString);
      this.proxyManager.transSaveToDatabase();
    }
  }
  
  public void b(String paramString, long paramLong, int paramInt)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis((paramLong + 5L) * 1000L);
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2) + 1;
    int k = ((Calendar)localObject).get(5);
    localObject = a(paramString, i, j);
    if (localObject != null)
    {
      ((RoamDate)localObject).setLocState(k - 1, paramInt);
      a((RoamDate)localObject);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateRoamDateLocIndex error roam not found uin = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" year = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" month = ");
    ((StringBuilder)localObject).append(j);
    QLog.e("Q.roammsg.MessageRoamManager", 1, ((StringBuilder)localObject).toString());
  }
  
  public void c()
  {
    Iterator localIterator = this.cacheMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      RoamDate localRoamDate = (RoamDate)((Map.Entry)localIterator.next()).getValue();
      localRoamDate.clearLocState();
      a(localRoamDate);
    }
  }
  
  public boolean c(String paramString, Calendar paramCalendar, List<Map.Entry<String, Entity>> paramList)
  {
    if (!paramList.isEmpty())
    {
      int j = paramCalendar.get(1);
      int k = paramCalendar.get(2);
      int m = paramCalendar.get(5);
      int i = 0;
      while (i < paramList.size())
      {
        if ((((String)((Map.Entry)paramList.get(i)).getKey()).equals(b(paramString, j, k + 1))) && (a((RoamDate)((Map.Entry)paramList.get(i)).getValue(), m - 1))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public String[] c(String paramString)
  {
    return paramString.split("\\&");
  }
  
  public void d()
  {
    Iterator localIterator = this.cacheMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      RoamDate localRoamDate = (RoamDate)((Map.Entry)localIterator.next()).getValue();
      localRoamDate.clearSerState();
      a(localRoamDate);
    }
  }
  
  protected void destroy() {}
  
  public Pair<Calendar, Calendar> e()
  {
    Object localObject2 = f();
    if (!((List)localObject2).isEmpty())
    {
      Object localObject1 = (RoamDate)((Map.Entry)((List)localObject2).get(0)).getValue();
      localObject2 = (RoamDate)((Map.Entry)((List)localObject2).get(((List)localObject2).size() - 1)).getValue();
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      localCalendar.set(1, ((RoamDate)localObject1).getYear());
      localCalendar.set(2, ((RoamDate)localObject1).getMonth() - 1);
      int i = 0;
      while ((i < ((RoamDate)localObject1).getDays()) && (!a((RoamDate)localObject1, i))) {
        i += 1;
      }
      localCalendar.set(5, i + 1);
      localObject1 = Calendar.getInstance();
      ((Calendar)localObject1).set(11, 0);
      ((Calendar)localObject1).set(12, 0);
      ((Calendar)localObject1).set(13, 0);
      ((Calendar)localObject1).set(14, 0);
      ((Calendar)localObject1).set(1, ((RoamDate)localObject2).getYear());
      ((Calendar)localObject1).set(2, ((RoamDate)localObject2).getMonth() - 1);
      i = ((RoamDate)localObject2).getDays() - 1;
      while ((i >= 0) && (!a((RoamDate)localObject2, i))) {
        i -= 1;
      }
      ((Calendar)localObject1).set(5, i + 1);
      return new Pair(localCalendar, localObject1);
    }
    return null;
  }
  
  public List<Map.Entry<String, Entity>> f()
  {
    ArrayList localArrayList = new ArrayList(this.cacheMap.entrySet());
    Collections.sort(localArrayList, new RoamDateCache.1(this));
    return localArrayList;
  }
  
  protected String getKey(Entity paramEntity)
  {
    paramEntity = (RoamDate)paramEntity;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEntity.uin);
    localStringBuilder.append("&");
    localStringBuilder.append(paramEntity.date);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache
 * JD-Core Version:    0.7.0.1
 */
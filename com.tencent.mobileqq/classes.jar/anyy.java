import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.data.RoamDate;
import com.tencent.mobileqq.data.RoamMessagePreloadInfo;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
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

public class anyy
  extends FullCache
{
  public anyy(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramQQAppInterface, paramDBDelayManager, RoamDate.class);
  }
  
  private String a(String paramString1, String paramString2)
  {
    return paramString1 + "&" + paramString2;
  }
  
  public Pair<Calendar, Calendar> a()
  {
    Object localObject2 = a();
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
      if ((i >= ((RoamDate)localObject1).getDays()) || (a((RoamDate)localObject1, i)))
      {
        localCalendar.set(5, i + 1);
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).set(11, 0);
        ((Calendar)localObject1).set(12, 0);
        ((Calendar)localObject1).set(13, 0);
        ((Calendar)localObject1).set(14, 0);
        ((Calendar)localObject1).set(1, ((RoamDate)localObject2).getYear());
        ((Calendar)localObject1).set(2, ((RoamDate)localObject2).getMonth() - 1);
        i = ((RoamDate)localObject2).getDays() - 1;
      }
      for (;;)
      {
        if ((i < 0) || (a((RoamDate)localObject2, i)))
        {
          ((Calendar)localObject1).set(5, i + 1);
          return new Pair(localCalendar, localObject1);
          i += 1;
          break;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public RoamDate a(String paramString, int paramInt1, int paramInt2)
  {
    return (RoamDate)findCache(a(paramString, paramInt1, paramInt2));
  }
  
  public RoamDate a(String paramString1, String paramString2)
  {
    return (RoamDate)findCache(a(paramString1, paramString2));
  }
  
  public RoamMessagePreloadInfo a(String paramString, Calendar paramCalendar, int paramInt)
  {
    RoamMessagePreloadInfo localRoamMessagePreloadInfo = new RoamMessagePreloadInfo();
    localRoamMessagePreloadInfo.preloadType = paramInt;
    List localList = a();
    if (paramInt == 0) {
      if (a(paramString, paramCalendar, localList)) {
        localRoamMessagePreloadInfo.curday = paramCalendar;
      }
    }
    for (;;)
    {
      if ((localRoamMessagePreloadInfo.curday != null) && (paramInt != 0))
      {
        localRoamMessagePreloadInfo.previousday = a(paramString, localRoamMessagePreloadInfo.curday, localList);
        localRoamMessagePreloadInfo.nextday = b(paramString, localRoamMessagePreloadInfo.curday, localList);
      }
      return localRoamMessagePreloadInfo;
      paramCalendar = null;
      break;
      if (paramInt == 1) {
        localRoamMessagePreloadInfo.curday = a(paramString, paramCalendar, localList);
      } else if (paramInt == 2) {
        localRoamMessagePreloadInfo.curday = b(paramString, paramCalendar, localList);
      }
    }
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return paramInt1 + '-' + paramInt2;
  }
  
  public String a(String paramString, int paramInt1, int paramInt2)
  {
    return paramString + "&" + a(paramInt1, paramInt2);
  }
  
  public Calendar a(String paramString, Calendar paramCalendar, List<Map.Entry<String, Entity>> paramList)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = paramList;
    if (paramList == null) {
      localObject1 = a();
    }
    paramList = localObject3;
    int j;
    int k;
    int i1;
    int i;
    if (!((List)localObject1).isEmpty())
    {
      j = paramCalendar.get(1);
      k = paramCalendar.get(2);
      i1 = paramCalendar.get(5);
      i = 0;
      if (i >= ((List)localObject1).size()) {
        break label391;
      }
      if (!((String)((Map.Entry)((List)localObject1).get(i)).getKey()).equals(a(paramString, j, k + 1))) {
        break label250;
      }
    }
    for (;;)
    {
      j = 0;
      int m = i;
      paramString = localObject2;
      label115:
      paramList = paramString;
      if (m >= 0)
      {
        paramList = (RoamDate)((Map.Entry)((List)localObject1).get(m)).getValue();
        if (m != i) {
          break label268;
        }
        k = i1 - 2;
        label156:
        if (k < 0) {
          break label388;
        }
        if (!a(paramList, k)) {
          break label259;
        }
        paramString = Calendar.getInstance();
        paramString.set(11, 0);
        paramString.set(12, 0);
        paramString.set(13, 0);
        paramString.set(14, 0);
        paramString.set(1, paramList.getYear());
        paramString.set(2, paramList.getMonth() - 1);
        paramString.set(5, k + 1);
        j = 1;
      }
      label259:
      label388:
      for (;;)
      {
        paramCalendar = paramString;
        k = j;
        if (k != 0)
        {
          paramList = paramCalendar;
          return paramList;
          label250:
          i += 1;
          break;
          k -= 1;
          break label156;
          label268:
          int n = paramList.getDays() - 1;
          for (;;)
          {
            k = j;
            paramCalendar = paramString;
            if (n < 0) {
              break;
            }
            if (a(paramList, n))
            {
              paramCalendar = Calendar.getInstance();
              paramCalendar.set(11, 0);
              paramCalendar.set(12, 0);
              paramCalendar.set(13, 0);
              paramCalendar.set(14, 0);
              paramCalendar.set(1, paramList.getYear());
              paramCalendar.set(2, paramList.getMonth() - 1);
              paramCalendar.set(5, n + 1);
              k = 1;
              break;
            }
            n -= 1;
          }
        }
        m -= 1;
        j = k;
        paramString = paramCalendar;
        break label115;
      }
      label391:
      i = 0;
    }
  }
  
  public List<Map.Entry<String, Entity>> a()
  {
    ArrayList localArrayList = new ArrayList(this.cacheMap.entrySet());
    Collections.sort(localArrayList, new anyz(this));
    return localArrayList;
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
    }
    for (;;)
    {
      a(localRoamDate);
      return;
      localRoamDate.setSerindex(paramInt3, paramInt4);
    }
  }
  
  public void a(RoamDate paramRoamDate)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RoamDateCache", 2, "saveRoamDate roamDate = " + paramRoamDate);
    }
    addCache(paramRoamDate);
    this.proxyManager.transSaveToDatabase();
  }
  
  public void a(String paramString)
  {
    int i = 0;
    Object localObject = this.app.getEntityManagerFactory().createEntityManager();
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
      localObject = new StringBuilder().append("doInit size = ");
      if (paramString != null) {
        break label132;
      }
    }
    for (;;)
    {
      QLog.d("Q.db.Cache.RoamDateCache", 2, i);
      return;
      label132:
      i = paramString.size();
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
        String str1 = (String)((Map.Entry)localIterator.next()).getKey();
        String str2 = str1.split("&")[1];
        paramInt3 = Integer.parseInt(str2.split("-")[0]);
        paramInt4 = Integer.parseInt(str2.split("-")[1]);
        if ((paramInt3 < paramInt1) || ((paramInt3 == paramInt1) && (paramInt4 < paramInt2)))
        {
          paramString.add(str1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RoamDateCache", 2, "clipRoamDate key=" + str1);
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
    ((Calendar)localObject).setTimeInMillis((5L + paramLong) * 1000L);
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
  
  public boolean a(String paramString, Calendar paramCalendar, List<Map.Entry<String, Entity>> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int k;
    int m;
    int i;
    if (!paramList.isEmpty())
    {
      j = paramCalendar.get(1);
      k = paramCalendar.get(2);
      m = paramCalendar.get(5);
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramList.size())
      {
        if ((((String)((Map.Entry)paramList.get(i)).getKey()).equals(a(paramString, j, k + 1))) && (a((RoamDate)((Map.Entry)paramList.get(i)).getValue(), m - 1))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public String[] a(String paramString)
  {
    return paramString.split("\\&");
  }
  
  public Calendar b(String paramString, Calendar paramCalendar, List<Map.Entry<String, Entity>> paramList)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = paramList;
    if (paramList == null) {
      localObject1 = a();
    }
    paramList = localObject3;
    int j;
    int k;
    int i1;
    int i;
    if (!((List)localObject1).isEmpty())
    {
      j = paramCalendar.get(1);
      k = paramCalendar.get(2);
      i1 = paramCalendar.get(5);
      i = 0;
      if (i >= ((List)localObject1).size()) {
        break label399;
      }
      if (!((String)((Map.Entry)((List)localObject1).get(i)).getKey()).equals(a(paramString, j, k + 1))) {
        break label259;
      }
    }
    for (;;)
    {
      j = 0;
      int m = i;
      paramString = localObject2;
      label115:
      paramList = paramString;
      if (m < ((List)localObject1).size())
      {
        paramList = (RoamDate)((Map.Entry)((List)localObject1).get(m)).getValue();
        if (m != i) {
          break label277;
        }
        k = i1;
        label161:
        if (k >= paramList.getDays()) {
          break label396;
        }
        if (!a(paramList, k)) {
          break label268;
        }
        paramString = Calendar.getInstance();
        paramString.set(11, 0);
        paramString.set(12, 0);
        paramString.set(13, 0);
        paramString.set(14, 0);
        paramString.set(1, paramList.getYear());
        paramString.set(2, paramList.getMonth() - 1);
        paramString.set(5, k + 1);
        j = 1;
      }
      label259:
      label268:
      label396:
      for (;;)
      {
        paramCalendar = paramString;
        k = j;
        if (k != 0)
        {
          paramList = paramCalendar;
          return paramList;
          i += 1;
          break;
          k += 1;
          break label161;
          label277:
          int n = 0;
          for (;;)
          {
            k = j;
            paramCalendar = paramString;
            if (n >= paramList.getDays()) {
              break;
            }
            if (a(paramList, n))
            {
              paramCalendar = Calendar.getInstance();
              paramCalendar.set(11, 0);
              paramCalendar.set(12, 0);
              paramCalendar.set(13, 0);
              paramCalendar.set(14, 0);
              paramCalendar.set(1, paramList.getYear());
              paramCalendar.set(2, paramList.getMonth() - 1);
              paramCalendar.set(5, n + 1);
              k = 1;
              break;
            }
            n += 1;
          }
        }
        m += 1;
        j = k;
        paramString = paramCalendar;
        break label115;
      }
      label399:
      i = 0;
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RoamDateCache", 2, "removeRoamDate roamDate = " + paramRoamDate);
    }
    removeCache(paramRoamDate);
    this.proxyManager.transSaveToDatabase();
  }
  
  public void b(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (paramString.length != 2)) {
      return;
    }
    paramString = a(paramString[0], paramString[1]);
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RoamDateCache", 2, "removeRoamDate roamDate = " + paramString);
    }
    removeCache(paramString);
    this.proxyManager.transSaveToDatabase();
  }
  
  public void b(String paramString, long paramLong, int paramInt)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis((5L + paramLong) * 1000L);
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
    QLog.e("Q.roammsg.MessageRoamManager", 1, "updateRoamDateLocIndex error roam not found uin = " + paramString + " year = " + i + " month = " + j);
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
  
  public void destroy() {}
  
  public String getKey(Entity paramEntity)
  {
    paramEntity = (RoamDate)paramEntity;
    return paramEntity.uin + "&" + paramEntity.date;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyy
 * JD-Core Version:    0.7.0.1
 */
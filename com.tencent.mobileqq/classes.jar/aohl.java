import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopStatisticsInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class aohl
  extends FullCache
{
  public aohl(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramQQAppInterface, paramDBDelayManager, TroopStatisticsInfo.class);
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    long l = System.currentTimeMillis();
    if (l - azkc.a(azkq.a, 0L) > 604800000L) {}
    for (;;)
    {
      try
      {
        azkc.a(azkq.a, l);
        paramQQAppInterface.drop(TroopStatisticsInfo.class);
        this.cacheMap.clear();
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.TroopStatisticsCache", 2, "doInit record time over 7 days, drop table");
        }
        return;
        paramDBDelayManager = paramQQAppInterface.query(TroopStatisticsInfo.class);
        if (paramDBDelayManager != null)
        {
          this.cacheMap.clear();
          localObject = paramDBDelayManager.iterator();
          if (((Iterator)localObject).hasNext())
          {
            TroopStatisticsInfo localTroopStatisticsInfo = (TroopStatisticsInfo)((Iterator)localObject).next();
            this.cacheMap.put(getKey(localTroopStatisticsInfo), localTroopStatisticsInfo);
            continue;
          }
        }
      }
      catch (Exception paramDBDelayManager)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.db.Cache.TroopStatisticsCache", 2, paramDBDelayManager.getMessage());
        }
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        Object localObject = new StringBuilder().append("doInit size = ");
        if (paramDBDelayManager == null)
        {
          i = 0;
          QLog.d("Q.db.Cache.TroopStatisticsCache", 2, i);
          continue;
        }
      }
      finally
      {
        paramQQAppInterface.close();
      }
      int i = paramDBDelayManager.size();
    }
  }
  
  public TroopStatisticsInfo a(String paramString)
  {
    if ((this.cacheMap == null) || (paramString == null)) {
      return null;
    }
    return (TroopStatisticsInfo)this.cacheMap.get(paramString);
  }
  
  public void destroy() {}
  
  public String getKey(Entity paramEntity)
  {
    return ((TroopStatisticsInfo)paramEntity).troopUin;
  }
  
  public void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aohl
 * JD-Core Version:    0.7.0.1
 */
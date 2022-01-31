import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopStatisticsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class amhc
  extends amgw
{
  public amhc(QQAppInterface paramQQAppInterface, amgv paramamgv)
  {
    super(paramQQAppInterface, paramamgv, TroopStatisticsInfo.class);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    long l = System.currentTimeMillis();
    if (l - awji.a(awjx.b, 0L) > 604800000L) {}
    for (;;)
    {
      try
      {
        awji.a(awjx.b, l);
        paramQQAppInterface.a(TroopStatisticsInfo.class);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.TroopStatisticsCache", 2, "doInit record time over 7 days, drop table");
        }
        return;
        paramamgv = paramQQAppInterface.a(TroopStatisticsInfo.class);
        if (paramamgv != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          localObject = paramamgv.iterator();
          if (((Iterator)localObject).hasNext())
          {
            TroopStatisticsInfo localTroopStatisticsInfo = (TroopStatisticsInfo)((Iterator)localObject).next();
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(localTroopStatisticsInfo), localTroopStatisticsInfo);
            continue;
          }
        }
      }
      catch (Exception paramamgv)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.db.Cache.TroopStatisticsCache", 2, paramamgv.getMessage());
        }
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        Object localObject = new StringBuilder().append("doInit size = ");
        if (paramamgv == null)
        {
          i = 0;
          QLog.d("Q.db.Cache.TroopStatisticsCache", 2, i);
          continue;
        }
      }
      finally
      {
        paramQQAppInterface.a();
      }
      int i = paramamgv.size();
    }
  }
  
  public TroopStatisticsInfo a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (paramString == null)) {
      return null;
    }
    return (TroopStatisticsInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  protected String a(awge paramawge)
  {
    return ((TroopStatisticsInfo)paramawge).troopUin;
  }
  
  protected void a() {}
  
  protected void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhc
 * JD-Core Version:    0.7.0.1
 */
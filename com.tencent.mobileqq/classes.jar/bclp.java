import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class bclp
{
  public static List<TroopFileTansferItemEntity> a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    TroopFileTansferItemEntity localTroopFileTansferItemEntity = new TroopFileTansferItemEntity();
    localTroopFileTansferItemEntity.troopuin = paramLong;
    return paramQQAppInterface.a(TroopFileTansferItemEntity.class, "select * from " + localTroopFileTansferItemEntity.getTableName() + " where troopuin = ?", new String[] { "" + paramLong });
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Map<UUID, ? extends awge> paramMap, long paramLong)
  {
    if (paramMap == null) {
      QLog.e("SerializableManager", 4, "bad Entity Param");
    }
    Object localObject;
    do
    {
      return false;
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject = new TroopFileTansferItemEntity();
      ((TroopFileTansferItemEntity)localObject).troopuin = paramLong;
    } while (!paramQQAppInterface.a(((TroopFileTansferItemEntity)localObject).getTableName()));
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      localObject = (awge)paramMap.next();
      ((TroopFileTansferItemEntity)localObject).troopuin = paramLong;
      ((awge)localObject).setStatus(1000);
      paramQQAppInterface.a((awge)localObject);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclp
 * JD-Core Version:    0.7.0.1
 */
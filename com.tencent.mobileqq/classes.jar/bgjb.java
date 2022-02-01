import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

public class bgjb
{
  public static Map<Long, bgjb> a;
  public long a;
  public Map<String, TroopFileData> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public bgjb(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static bgjb a(long paramLong)
  {
    try
    {
      bgjb localbgjb2 = (bgjb)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      bgjb localbgjb1 = localbgjb2;
      if (localbgjb2 == null)
      {
        localbgjb1 = new bgjb(paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localbgjb1);
      }
      return localbgjb1;
    }
    finally {}
  }
  
  public TroopFileData a(QQAppInterface paramQQAppInterface, String paramString)
  {
    TroopFileData localTroopFileData1 = null;
    try
    {
      if (this.b != null) {
        localTroopFileData1 = (TroopFileData)this.b.get(paramString);
      }
      TroopFileData localTroopFileData2 = localTroopFileData1;
      if (localTroopFileData1 == null)
      {
        paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        localTroopFileData2 = (TroopFileData)paramQQAppInterface.find(TroopFileData.class, paramString);
        paramQQAppInterface.close();
      }
      return localTroopFileData2;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, TroopFileData paramTroopFileData)
  {
    try
    {
      if (this.b != null) {
        this.b.put(paramTroopFileData.fileUrl, paramTroopFileData);
      }
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramQQAppInterface.persist(paramTroopFileData);
      paramQQAppInterface.close();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjb
 * JD-Core Version:    0.7.0.1
 */